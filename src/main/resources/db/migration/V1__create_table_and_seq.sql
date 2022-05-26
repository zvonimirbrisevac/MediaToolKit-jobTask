CREATE TABLE IF NOT EXISTS request_info (
    id                   BIGSERIAL PRIMARY KEY,
    request_timestamp    TIMESTAMP(2),
    request_ip           VARCHAR(15),
    searched_ip          VARCHAR(15)
);


CREATE SEQUENCE IF NOT EXISTS request_seq;
