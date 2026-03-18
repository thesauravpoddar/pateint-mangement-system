-- Ensure the 'patient' table exists
CREATE TABLE IF NOT EXISTS patient
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   TIMESTAMP           NOT NULL,
    registered_date TIMESTAMP           NOT NULL
);

-- Insert well-known UUIDs for specific patients
INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'Patient 1',
       'patient1@example.com',
       'Springfield',
       '1985-06-15 00:00:00',
       '2024-01-10 00:00:00'
WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Patient 2',
       'patient2@example.com',
       'Shelbyville',
       '1990-09-23 00:00:00',
       '2023-12-01 00:00:00'
WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Patient 3',
       'patient3@example.com',
       'Capital City',
       '1978-03-12 00:00:00',
       '2022-06-20 00:00:00'
WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Patient 4',
       'patient4@example.com',
       'Springfield',
       '1982-11-30 00:00:00',
       '2023-05-14 00:00:00'
WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Patient 5',
       'patient5@example.com',
       'Shelbyville',
       '1995-02-05 00:00:00',
       '2024-03-01 00:00:00'
WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174004');

-- Insert well-known UUIDs for specific patients
INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174005',
       'Patient 6',
       'patient6@example.com',
       'Springfield',
       '1988-07-25 00:00:00',
       '2024-02-15 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174005');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174006',
       'Patient 7',
       'patient7@example.com',
       'Shelbyville',
       '1992-04-18 00:00:00',
       '2023-08-25 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174006');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174007',
       'Patient 8',
       'patient8@example.com',
       'Capital City',
       '1975-01-11 00:00:00',
       '2022-10-10 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174007');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174008',
       'Patient 9',
       'patient9@example.com',
       'Springfield',
       '1989-09-02 00:00:00',
       '2024-04-20 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174008');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174009',
       'Patient 10',
       'patient10@example.com',
       'Shelbyville',
       '1993-11-15 00:00:00',
       '2023-06-30 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174009');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174010',
       'Patient 11',
       'patient11@example.com',
       'Capital City',
       '1980-08-09 00:00:00',
       '2023-01-22 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174010');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174011',
       'Patient 12',
       'patient12@example.com',
       'Springfield',
       '1984-05-03 00:00:00',
       '2024-05-12 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174011');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174012',
       'Patient 13',
       'patient13@example.com',
       'Shelbyville',
       '1991-12-25 00:00:00',
       '2022-11-11 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174012');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174013',
       'Patient 14',
       'patient14@example.com',
       'Capital City',
       '1976-06-08 00:00:00',
       '2023-09-19 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174013');

INSERT INTO patient (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174014',
       'Patient 15',
       'patient15@example.com',
       'Springfield',
       '1987-10-17 00:00:00',
       '2024-03-29 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174014');
