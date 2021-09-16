create schema if not exists address;

CREATE TABLE address.address
(
    id bigint NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    complement character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    latitude double precision,
    longitude double precision,
    neighbourdhood character varying(255) COLLATE pg_catalog."default",
    "number" integer,
    state character varying(255) COLLATE pg_catalog."default",
    street_name character varying(255) COLLATE pg_catalog."default",
    zipcode integer,
    CONSTRAINT address_pkey PRIMARY KEY (id)
)