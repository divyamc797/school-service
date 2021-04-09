insert into user(id, name, password)
values (10000000001, 'divya', '$2b$10$w/aiI9xXdVdMdpyxOpXbFucj.J2Kxi6GEEq/6tuU8JaihbSIxgb/e');

insert into user(id, name, password)
values (10000000002, 'bhanu', '$2b$10$w/aiI9xXdVdMdpyxOpXbFucj.J2Kxi6GEEq/6tuU8JaihbSIxgb/e');

insert into role(id, role, user_id)
values (10000000003, 'student_admin', 10000000001);

insert into role(id, role, user_id)
values (10000000004, 'teacher_admin', 10000000002);