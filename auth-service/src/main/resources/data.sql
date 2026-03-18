-- Ensure the 'users' table exists
CREATE TABLE IF NOT EXISTS "users" (
                                       id VARCHAR(255) PRIMARY KEY,
                                       email VARCHAR(255) UNIQUE NOT NULL,
                                       password VARCHAR(255) NOT NULL,
                                       role VARCHAR(50) NOT NULL,
                                       created_at TIMESTAMP NOT NULL
);

-- Insert the user if no existing user with the same id or email exists
INSERT INTO "users" (id, email, password, role, created_at)
SELECT 'auth-user-223e4567-e89b-12d3-a456-426614174006', 'system.admin@example.com',
        '$2b$12$7hoRZfJrRKD2nIm2vHLs7OBETy.LWenXXMLKf99W8M4PUwO6KB7fu', 'ADMIN', '2026-03-15 00:00:00'
WHERE NOT EXISTS (
    SELECT 1
    FROM "users"
    WHERE id = 'auth-user-223e4567-e89b-12d3-a456-426614174006'
       OR email = 'system.admin@example.com'
);
