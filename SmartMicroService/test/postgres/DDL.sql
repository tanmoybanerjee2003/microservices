-- create a test user
CREATE ROLE user1 WITH
	LOGIN
	NOSUPERUSER
	NOCREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'user1';
COMMENT ON ROLE user1 IS 'User1 for testing micro services';

-- create schema for SmartMicroService
CREATE SCHEMA smart_ms AUTHORIZATION postgres;
GRANT ALL ON SCHEMA smart_ms TO postgres;

-- point to this new schema now
SET search_path TO smart_ms;

-- create tables
CREATE TABLE tbl_user (
	tbl_user_id numeric(19, 2) NOT NULL,
	first_name varchar(255) NOT NULL,
	middle_name varchar(255) NULL,
	last_name varchar(255) NULL,
	CONSTRAINT tbl_user_pk PRIMARY KEY (tbl_user_id)
);

ALTER TABLE tbl_user OWNER TO postgres;
GRANT ALL ON TABLE tbl_user TO postgres;

CREATE SEQUENCE IF NOT EXISTS tbl_user_seq START WITH 0 MINVALUE 0;

CREATE TABLE tbl_tenant (
	tenant_id VARCHAR(255) NOT NULL,
	ds_jndi VARCHAR(255) NULL,
	ds_provider_url VARCHAR(255) NULL,
	ds_init_ctx_factory VARCHAR(255) NULL,
	ds_url VARCHAR(255) NULL,
	ds_user VARCHAR(255) NULL,
	ds_password VARCHAR(255) NULL,
	ds_driver_class VARCHAR(255) NULL,
	ds_type int4 NOT NULL,
	CONSTRAINT tbl_tenant_pk PRIMARY KEY (tenant_id)
);

ALTER TABLE tbl_tenant OWNER TO postgres;
GRANT ALL ON TABLE tbl_tenant TO postgres;

-- Give required permissions to test user
GRANT USAGE ON SCHEMA "smart_ms" TO user1;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA "smart_ms" TO user1;