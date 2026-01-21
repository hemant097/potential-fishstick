-- default data to be entered into db everytime my application is started

--for ProductEntity
INSERT INTO week3db.product_table
(created_at, price, quantity, updated_at,sku, product_title, sin)
VALUES
    ('2026-01-01', 510.5, 11, '2026-01-15','HONEYVEDAFENNEL', 'HoneyVeda Fennel Honey', 'HVFH'),
    ('2026-01-02', 475.5, 11, '2026-01-15','HONEYVEDAJAMUN', 'HoneyVeda Jamun Honey', 'HVJH'),
    ('2026-01-03', 470.5, 37, '2026-01-15','HONEYVEDAFEUCALYPTUS', 'HoneyVeda Eucalyptus Honey', 'HVEH'),
    ('2026-01-04', 495, 11, '2026-01-15','HONEYVEDAFWF', 'HoneyVeda Wild Forest Honey', 'HVWH'),
    ('2025-11-22', 400.5, 25, '2026-01-15','BHARATJAMUN', 'Bharat Jamun Honey', 'BHYDJ'),
    ('2024-12-08', 435, 45, '2026-01-15','BHARATKASHMIR', 'Bharat Honey Kashmir', 'BHYDK'),

    ('2025-12-10', 1999.0, 5, '2026-01-15', 'ELECHEADSET', 'Wireless Headset', 'WH01'),
    ('2025-12-10', 765, 8, '2026-01-15', 'ELECMOUSE', 'Bluetooth Mouse', 'BM01'),
    ('2025-12-12', 2799.0, 5, '2026-01-15', 'ELECKEYBOARD', 'Mechanical Keyboard', 'MK01'),
    ('2025-12-12', 2499.0, 10, '2026-01-15', 'ELECSPEAKER', 'Portable Speaker', 'PS01'),

    ('2025-11-01', 7999.0, 2, '2026-01-15', 'FURTABLE', 'Wooden Dining Table', 'WDT'),
    ('2025-11-01', 14000.0, 4, '2026-01-15', 'FURDESK', 'Office Desk', 'OD01'),
    ('2025-11-05', 6999.0, 2, '2026-01-15', 'FURCHAIR', 'Ergonomic Chair', 'EC01'),
    ('2025-11-05', 5499.0, 6, '2026-01-15', 'FURSTOOL', 'Wooden Stool', 'WS01'),

    ('2025-10-15', 299.0, 50, '2026-01-15', 'MEDPARA', 'Paracetamol Tablets', 'PT01'),
    ('2025-10-15', 297.0, 100, '2026-01-15', 'MEDVITC', 'Vitamin C Tablets', 'VC01'),
    ('2025-10-20', 399.0, 50, '2026-01-15', 'MEDZINC', 'Zinc Supplements', 'ZS01'),
    ('2025-10-20', 399.0, 75, '2026-01-15', 'MEDIRON', 'Iron Capsules', 'IC01'),

    ('2025-09-01', 120.0, 200, '2026-01-15', 'GROSRICE', 'Basmati Rice 1kg', 'BR1'),
    ('2025-09-01', 120.0, 150, '2026-01-15', 'GROSFLOUR', 'Wheat Flour 1kg', 'WF1'),
    ('2025-09-05', 180.0, 100, '2026-01-15', 'GROSOIL', 'Cooking Oil 1L', 'CO1'),
    ('2025-09-05', 180.0, 120, '2026-01-15', 'GROSSUGAR', 'Organic Sugar', 'OS1'),

    ('2026-02-01', 999.0, 12, '2026-01-15', 'ELECPOWER', 'Power Bank', 'PB01'),
    ('2026-02-01', 999.0, 12, '2026-01-15', 'ELECCABLE', 'USB-C Cable', 'UC01'),
    ('2026-02-03', 1499.0, 8, '2026-01-15', 'ELECCHARGER', 'Fast Charger', 'FC01'),
    ('2026-02-03', 1499.0, 5, '2026-01-15', 'ELECEARBUDS', 'Wireless Earbuds', 'WE01'),

    ('2024-12-01', 349.0, 30, '2026-01-15', 'MEDCOUGH', 'Cough Syrup', 'CS01'),
    ('2024-12-01', 349.0, 30, '2026-01-15', 'MEDCOLD', 'Cold Relief Syrup', 'CR01'),
    ('2024-12-05', 279.0, 40, '2026-01-15', 'MEDPAIN', 'Pain Relief Gel', 'PRG'),

    ('2026-03-10', 8999.0, 1, '2026-01-15', 'FURBED', 'Queen Size Bed', 'QB01'),
    ('2026-03-10', 8999.0, 1, '2026-01-15', 'FURSOFA', '2-Seater Sofa', 'SF01'),

    ('2025-08-15', 599.0, 25, '2026-01-15', 'HONEYMULTI', 'Multiflora Honey', 'HMH'),
    ('2025-08-15', 599.0, 25, '2026-01-15', 'HONEYORGANIC', 'Organic Raw Honey', 'ORH'),

    ('2025-07-01', 89.0, 300, '2026-01-15', 'GROSTEASALT', 'Rock Salt', 'RS01'),
    ('2025-07-01', 89.0, 300, '2026-01-15', 'GROSTEASUGAR', 'Brown Sugar', 'BS01'),

    ('2026-01-20', 1299.0, 7, '2026-01-15', 'ELECWIFI', 'WiFi Router', 'WR01'),
    ('2026-01-20', 1299.0, 9, '2026-01-15', 'ELECEXTENDER', 'WiFi Extender', 'WE02'),

    ('2025-06-01', 459.0, 60, '2026-01-15', 'MEDHERBAL', 'Herbal Tonic', 'HT01'),
    ('2025-06-01', 459.0, 60, '2026-01-15', 'MEDAYUR', 'Ayurvedic Syrup', 'AS01');

--for PatientEntity
INSERT INTO week3db.patients
(created_at, email, blood_group, dob, first_name, last_name)
VALUES
    ('2026-01-01', 'aarav@gmail.com',    'AB_POSITIVE', '1997-02-12', 'Aarav',   'Gupta'),
    ('2026-01-02', 'isha@gmail.com',     'A_POSITIVE',  '1998-05-21', 'Isha',    'Sharma'),
    ('2026-01-03', 'rohan@gmail.com',    'B_NEGATIVE',  '1996-11-10', 'Rohan',   'Mehta'),
    ('2026-01-04', 'neha@gmail.com',     'O_POSITIVE',  '1999-03-08', 'Neha',    'Verma'),
    ('2026-01-05', 'vikram@gmail.com',   'A_NEGATIVE',  '1995-07-15', 'Vikram',  'Singh'),
    ('2026-01-06', 'pooja@gmail.com',    'AB_NEGATIVE', '1997-01-30', 'Pooja',   'Nair'),
    ('2026-01-07', 'aman@gmail.com',     'B_POSITIVE',  '1998-09-12', 'Aman',    'Khan'),
    ('2026-01-08', 'kavya@gmail.com',    'O_NEGATIVE',  '2000-04-19', 'Kavya',   'Reddy'),
    ('2026-01-09', 'rahul@gmail.com',    'A_POSITIVE',  '1994-12-25', 'Rahul',   'Malhotra'),
    ('2026-01-10', 'simran@gmail.com',   'B_NEGATIVE',  '1996-06-05', 'Simran',  'Kaur'),
    ('2026-01-11', 'aditya@gmail.com',   'O_POSITIVE',  '1997-08-17', 'Aditya',  'Joshi'),
    ('2026-01-12', 'meera@gmail.com',    'AB_POSITIVE', '1999-10-09', 'Meera',   'Iyer'),
    ('2026-01-13', 'karan@gmail.com',    'A_NEGATIVE',  '1995-02-14', 'Karan',   'Bansal'),
    ('2026-01-14', 'anjali@gmail.com',   'B_POSITIVE',  '1998-01-27', 'Anjali',  'Chopra'),
    ('2026-01-15', 'suresh@gmail.com',   'O_NEGATIVE',  '1993-05-03', 'Suresh',  'Patel');

--for doctors
INSERT INTO week3db.doctors
(name, expertise,email)
VALUES
    ('Dr AK Singh','Pulmonary','aksingh@gmail.com'),
    ('Dr Nirmal Pandey','Neurosurgeon','nirmal@nirmal.com'),
    ('Dr IN Vajpayee','Neurosurgeon','invajpayee@gmail.com');
