insert into user(id, name, password)
values (10000000001, 'divya', '$2b$10$w/aiI9xXdVdMdpyxOpXbFucj.J2Kxi6GEEq/6tuU8JaihbSIxgb/e');
insert into role(id, role, user_id)
values (10000000002, 'admin', 10000000001);