-- Archivo V1__Create_tables.sql para Flyway
CREATE TABLE technician (
                            id UUID PRIMARY KEY,
                            name VARCHAR(30) NOT NULL
);

CREATE TABLE service (
                         id UUID PRIMARY KEY,
                         address VARCHAR(30) NOT NULL,
                         description VARCHAR(100),
                         start_date_time TIMESTAMP NOT NULL,
                         end_date_time TIMESTAMP NOT NULL,
                         technician_id UUID NOT NULL,
                         FOREIGN KEY (technician_id) REFERENCES technician(id)
);
