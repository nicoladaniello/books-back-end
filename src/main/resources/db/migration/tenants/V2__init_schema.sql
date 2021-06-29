ALTER TABLE period
ADD UNIQUE (name);

ALTER TABLE supplier
ADD UNIQUE (name);


/**
 * Update to PeriodSummary VIEW.
 * Use IFNULL(0) for all currency columns.
 */
CREATE OR REPLACE VIEW PeriodSummary AS
SELECT t.id,
    IFNULL(SUM(i.amount), 0) AS total_due_amount,
    IFNULL(SUM(i.total_paid_amount), 0) AS total_paid_amount,
    IFNULL((SUM(i.amount) - SUM(i.total_paid_amount)), 0) AS outstanding_amount
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
GROUP BY t.id;




/**
 * Period invoice summary.
 * For each period get all the invoices that have been received in that period,
 * and all the invoice previous to that period that have not been paid in full.
 */
CREATE VIEW IF NOT EXISTS PeriodInvoiceSummary AS
SELECT t.id AS period_id,
    i.id,
    i.dated,
    i.amount,
    total_paid_amount
FROM `period` t
    INNER JOIN (
        SELECT i.id,
            i.dated,
            i.amount,
            IFNULL(SUM(p.amount), 0) AS total_paid_amount
        FROM invoice i
            INNER JOIN payment p ON i.id = p.invoice_id
        GROUP BY i.id
    ) i ON (
        (
            i.dated >= t.start_date
            AND i.dated <= t.end_date
        )
        OR (
            i.dated < t.start_date
            AND i.total_paid_amount < i.amount
        )
    )
GROUP BY t.id,
    i.id;
/**
 * Drop total_outstanding_amount column for better performance.
 */
CREATE OR REPLACE VIEW SupplierSummary AS
SELECT t.id AS period_id,
    s.id AS supplier_id,
    s.`name` AS supplier_name,
    SUM(i.amount) AS total_due_amount,
    SUM(i.total_paid_amount) AS total_paid_amount
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