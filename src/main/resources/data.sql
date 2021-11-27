INSERT INTO role(id, name)
VALUES (1, 'ROLE_REGISTER'),
       (2, 'ROLE_MECHANIC'),
       (3, 'ROLE_ADMIN'),
       (4, 'ROLE_BACKOFFICE');

INSERT INTO `eindopdracht`.`app_user` (id, email, password, username)
VALUES (10001, "reg@reg.com", "$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq", "reg"),
       (10002, "mech@mech.com", "$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq", "mech"),
       (10003, "admin@admin.com", "$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq", "admin"),
       (10004, "back@back.com", "$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq", "back"),
       (10005, "super@super.com", "$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq", "super");

INSERT INTO `eindopdracht`.`user_role` (user_id, role_id)
VALUES (10001, 1),
       (10002, 2),
       (10003, 3),
       (10004, 4),
       (10005, 1),
       (10005, 2),
       (10005, 3),
       (10005, 4);
