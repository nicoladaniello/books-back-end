create table period (
    id bigint not null,
    name varchar(255),
    start_date date,
    end_date date,
    created date,
    modified date,
    primary key (id)
);
create table supplier (
    id bigint not null,
    name varchar(255) not null,
    address varchar(255),
    phone varchar(255),
    tax_code varchar(255),
    vat_number varchar(255),
    email varchar(255),
    created date,
    modified date,
    primary key (id),
    unique (name)
);
create table invoice (
    id bigint not null,
    supplier_id bigint not null,
    dated date,
    amount decimal(19, 2),
    description varchar(255),
    created date,
    modified date,
    primary key (id),
    foreign key (supplier_id) references supplier(id) on delete cascade
);
create table payment (
    id bigint not null,
    invoice_id bigint not null,
    dated date,
    amount decimal(19, 2),
    description varchar(255),
    created date,
    modified date,
    primary key (id),
    foreign key (invoice_id) references invoice(id) on delete cascade
);
CREATE SEQUENCE transactions_sequence START WITH 1 INCREMENT BY 10;
CREATE SEQUENCE suppliers_sequence START WITH 1 INCREMENT BY 10;
CREATE SEQUENCE periods_sequence START WITH 1 INCREMENT BY 10;


CREATE VIEW SupplierSummary AS
SELECT t.id AS period_id,
    s.id AS supplier_id,
    s.`name` AS supplier_name,
    SUM(i.amount) AS total_due_amount,
    SUM(i.total_paid_amount) AS total_paid_amount,
    (SUM(i.amount) - SUM(i.total_paid_amount)) AS outstanding_amount
FROM supplier s
    CROSS JOIN `period` t
    INNER JOIN (
        SELECT i.period_id,
            i.id,
            i.supplier_id,
            i.dated,
            i.outstanding_amount_before_period AS amount,
            i.total_paid_this_period AS total_paid_amount,
            i.outstanding_amount_this_period as outstanding_amount
        FROM (
                SELECT t.id AS period_id,
                    i.id,
                    i.supplier_id,
                    i.dated,
                    (i.amount - IFNULL(SUM(p.amount), 0)) AS outstanding_amount_before_period,
                    IFNULL(SUM(pp.amount), 0) AS total_paid_this_period,
                    (
                        (i.amount - IFNULL(SUM(p.amount), 0)) - IFNULL(SUM(pp.amount), 0)
                    ) AS outstanding_amount_this_period
                FROM period t
                    INNER JOIN invoice i ON i.dated < t.start_date
                    LEFT JOIN payment p ON p.invoice_id = i.id
                    AND p.dated < t.start_date
                    LEFT JOIN payment pp ON pp.invoice_id = i.id
                    AND pp.dated >= t.start_date
                GROUP BY t.id,
                    i.id
            ) AS i
        WHERE i.outstanding_amount_before_period > 0
        UNION
        SELECT t.id AS period_id,
            i.id,
            i.supplier_id,
            i.dated,
            i.amount,
            IFNULL(SUM(p.amount), 0) AS total_paid_amount,
            (i.amount - IFNULL(SUM(p.amount), 0)) AS outstanding_amount
        FROM period t
            INNER JOIN invoice i ON i.dated >= t.start_date
            AND i.dated <= t.end_date
            LEFT JOIN payment p ON p.invoice_id = i.id
            AND p.dated >= t.start_date
            AND p.dated <= t.end_date
        GROUP BY t.id,
            i.id
    ) AS i ON i.supplier_id = s.id
    AND i.period_id = t.id
GROUP BY t.id,
    s.id;




CREATE VIEW PeriodSummary AS
SELECT t.id,
    SUM(i.amount) AS total_due_amount,
    SUM(i.total_paid_amount) AS total_paid_amount,
    (SUM(i.amount) - SUM(i.total_paid_amount)) AS outstanding_amount
FROM period t
    INNER JOIN (
        SELECT i.period_id,
            i.id,
            i.supplier_id,
            i.dated,
            i.outstanding_amount_before_period AS amount,
            i.total_paid_this_period AS total_paid_amount,
            i.outstanding_amount_this_period as outstanding_amount
        FROM (
                SELECT t.id AS period_id,
                    i.id,
                    i.supplier_id,
                    i.dated,
                    (i.amount - IFNULL(SUM(p.amount), 0)) AS outstanding_amount_before_period,
                    IFNULL(SUM(pp.amount), 0) AS total_paid_this_period,
                    (
                        (i.amount - IFNULL(SUM(p.amount), 0)) - IFNULL(SUM(pp.amount), 0)
                    ) AS outstanding_amount_this_period
                FROM period t
                    INNER JOIN invoice i ON i.dated < t.start_date
                    LEFT JOIN payment p ON p.invoice_id = i.id
                    AND p.dated < t.start_date
                    LEFT JOIN payment pp ON pp.invoice_id = i.id
                    AND pp.dated >= t.start_date
                GROUP BY t.id,
                    i.id
            ) AS i
        WHERE i.outstanding_amount_before_period > 0
        UNION
        SELECT t.id AS period_id,
            i.id,
            i.supplier_id,
            i.dated,
            i.amount,
            IFNULL(SUM(p.amount), 0) AS total_paid_amount,
            (i.amount - IFNULL(SUM(p.amount), 0)) AS outstanding_amount
        FROM period t
            INNER JOIN invoice i ON i.dated >= t.start_date
            AND i.dated <= t.end_date
            LEFT JOIN payment p ON p.invoice_id = i.id
            AND p.dated >= t.start_date
            AND p.dated <= t.end_date
        GROUP BY t.id,
            i.id
    ) AS i ON i.period_id = t.id
GROUP BY t.id