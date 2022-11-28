INSERT INTO users (id, login, password, first_name, last_name, role, status)
VALUES (1, 'admin', '$2a$12$nkFRhKWoojrfqBmH4cIoeewcqLYnNGnEaB8vLHAUuBoOXrX02NWLO', 'Главный', 'Главный', 'ADMIN', 'ACTIVE');

INSERT INTO users (id, login, password, first_name, last_name, role, status)
VALUES (2, 'user', '$2a$12$Hl4NLRAnYgGcg6QBJdud8.rwUYUiDdOfCqm88J8Vww533fnO.YKyG', 'Пользователь', 'Фамилия', 'USER', 'ACTIVE');

COMMIT;
