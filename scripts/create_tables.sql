create sequence settingseq start 1 increment 1;
create sequence queryseq start 293930 increment 1;

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

create table query_types
(
    query_type int4 not null,
    name_query varchar(255),
    print_file varchar(255),
    primary key (query_type)
);

create table query_types_params
(
    id_param        varchar(255) not null,
    parent_id_param varchar(255) not null,
    query_type      int4         not null,
    is_obligatory   int4,
    name_param      varchar(255),
    type_param      varchar(255),
    primary key (id_param, parent_id_param, query_type));

create table queries
(
    query_id    int8 not null,
    last_status int4,
    query_date  timestamp,
    query_type  int4,
    primary key (query_id)
);

create table query_input_params
(
    num_param   int8 not null,
    query_id    int8 not null,
    name_param  varchar(255),
    ncycle      int4 not null,
    value_param varchar(255),
    primary key (num_param, query_id)
);


alter table if exists queries
    add constraint FKq1e0wyxb5yua2ph2merq5jo4f
    foreign key (query_type)
    references query_types;

alter table if exists query_types_params
    add constraint FKdxnddcmvb4wuxgftl74ibevtr
    foreign key (query_type)
    references query_types;

alter table if exists query_input_params
    add constraint FKo3xoj8wdjdblm8v7dg7pykqdy
    foreign key (query_id)
    references queries;

create index query_date_index on queries (query_date);
create index query_type_index on queries (query_type);
create index query_input_index on query_input_params (query_id, name_param);

create table users
(
    id int not null,
    login varchar(30) not null,
    password varchar(200) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    role varchar(100) not null,
    status varchar(20) not null
);

create unique index users_id_uindex
	on users (id);

create unique index users_login_uindex
	on users (login);

alter table users
    add constraint users_pk
        primary key (id);



