insert into account (id, username, password, enabled, account_expired, account_locked, credentials_expired,
                     creation_date)
values ('1', 'admin', '$2a$10$7X5kgMO5uAqeWBoQmKuDZeGNBwZV6mq8966G13AdmTlob2gjcuFVa', true, false, false, false,
        '2020-12-08 16:37:00');
insert into role (id, role_name)
values ('1', 'ROLE_ADMIN'),
       ('2', 'ROLE_USER');
insert into user_roles (user_id, role_id)
values ('1', '1');
