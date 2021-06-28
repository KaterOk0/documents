create sequence settingseq start 1 increment 1;

create table settings
(
    id           int8 not null,
    is_open      numeric(1)
        CONSTRAINT boolean_1_or_0 CHECK (is_open = 0 OR is_open = 1),
    setting_code int8 not null,
    setting_date timestamp,
    setting_name varchar(255),
    value        varchar(255),
    primary key (id)
);

