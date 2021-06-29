INSERT INTO "Ristorante L'Aragosta".PERIOD
VALUES (
        1,
        'Anno 2019',
        '2019-01-01',
        '2019-12-31',
        '2021-01-20',
        null
    ),
    (
        2,
        'Anno 2020',
        '2020-01-01',
        '2020-12-31',
        '2021-01-20',
        null
    ),
    (
        3,
        'Anno 2021',
        '2021-01-01',
        '2021-12-31',
        '2021-01-20',
        null
    );
INSERT INTO "Ristorante L'Aragosta".SUPPLIER
VALUES (
        1,
        'Fornitore 1',
        'Via Amendola 1, La Maddalena, Sardegna, Italia 07024',
        '0789123456',
        'T0001',
        'V0001',
        'email@fornitore1.com',
        '2021-01-20',
        null
    ),
    (
        2,
        'Fornitore 2',
        'Via Amendola 2, La Maddalena, Sardegna, Italia 07024',
        '0789223456',
        'T0002',
        'V0002',
        'email@fornitore2.com',
        '2021-01-20',
        null
    ),
    (
        3,
        'Fornitore 3',
        'Via Amendola 3, La Maddalena, Sardegna, Italia 07024',
        '0789323456',
        'T0003',
        'V0003',
        'email@fornitore3.com',
        '2021-01-20',
        null
    ),
    (
        4,
        'Fornitore 4',
        'Via Amendola 4, La Maddalena, Sardegna, Italia 07024',
        '0789423456',
        'T0004',
        'V0004',
        'email@fornitore4.com',
        '2021-01-20',
        null
    ),
    (
        5,
        'Fornitore 5',
        'Via Amendola 5, La Maddalena, Sardegna, Italia 07024',
        '0789523456',
        'T0005',
        'V0005',
        'email@fornitore5.com',
        '2021-01-20',
        null
    ),
    (
        6,
        'Fornitore 6',
        'Via Amendola 6, La Maddalena, Sardegna, Italia 07024',
        '0789623456',
        'T0006',
        'V0006',
        'email@fornitore6.com',
        '2021-01-20',
        null
    );
INSERT INTO "Ristorante L'Aragosta".INVOICE
VALUES (
        1,
        1,
        '2019-01-01',
        100.00,
        'Fattura 190101F1',
        '2021-01-20',
        null
    ),
    (
        2,
        1,
        '2019-01-03',
        150.00,
        'Fattura 190103F1',
        '2021-01-20',
        null
    ),
    (
        3,
        1,
        '2020-07-15',
        78.50,
        'Fattura 200715F1',
        '2021-01-20',
        null
    ),
    (
        4,
        2,
        '2019-10-11',
        580.75,
        'Fattura 191011F2',
        '2021-01-20',
        null
    ),
    (
        5,
        2,
        '2020-01-08',
        80.50,
        'Fattura 200108F2',
        '2021-01-20',
        null
    ),
    (
        6,
        3,
        '2021-01-1',
        1070.20,
        'Fattura 210101F3',
        '2021-01-20',
        null
    ),
    (
        7,
        3,
        '2021-01-04',
        200.50,
        'Fattura 210104F3',
        '2021-01-20',
        null
    ),
    (
        8,
        3,
        '2021-01-11',
        700.00,
        'Fattura 210111F3',
        '2021-01-20',
        null
    ),
    (
        9,
        4,
        '2021-01-20',
        120000.50,
        'Fattura 210120F4',
        '2021-01-20',
        null
    );
INSERT INTO "Ristorante L'Aragosta".PAYMENT
VALUES (
        1,
        1,
        '2019-01-03',
        90.00,
        'Pagamento 1 x fattura 190101F1',
        '2021-01-20',
        null
    ),
    (
        2,
        1,
        '2020-01-01',
        10.00,
        'Pagamento 2 x fattura 190101F1',
        '2021-01-20',
        null
    ),
    (
        3,
        2,
        '2019-12-31',
        150.00,
        'Pagamento 1 x fattura 190103F1',
        '2021-01-20',
        null
    ),
    (
        4,
        3,
        '2021-01-01',
        50.00,
        'Pagamento 1 x fattura 200715F1',
        '2021-01-20',
        null
    ),
    (
        5,
        4,
        '2019-10-11',
        300.75,
        'Pagamento 1 x fattura 191011F2',
        '2021-01-20',
        null
    ),
    (
        6,
        4,
        '2020-01-01',
        80.00,
        'Pagamento 2 x fattura 191011F2',
        '2021-01-20',
        null
    ),
    (
        7,
        5,
        '2020-08-08',
        80.50,
        'Pagamento 1 x fattura 200108F2',
        '2021-01-20',
        null
    );