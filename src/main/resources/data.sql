
INSERT INTO role(id, name)
VALUES (100001, 'ROLE_REGISTER'),
       (100002, 'ROLE_MECHANIC'),
       (100003, 'ROLE_ADMIN'),
       (100004, 'ROLE_BACKOFFICE');

INSERT INTO app_user(id, email, password, username)
VALUES (100001, 'reg@reg.com', '$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq', 'reg'),
       (100002, 'mech@mech.com', '$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq', 'mech'),
       (100003, 'admin@admin.com', '$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq', 'admin'),
       (100004, 'back@back.com', '$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq', 'back'),
       (100005, 'super@super.com', '$2a$10$d34QwfgwtA//54.kotJ0mOrbmUTdh9/kGs1KTBk838WwGzNci2oDq', 'super');

INSERT INTO user_role(user_id, role_id)
VALUES (100001, 100001),
       (100002, 100002),
       (100003, 100003),
       (100004, 100004),
       (100005, 100001),
       (100005, 100002),
       (100005, 100003),
       (100005, 100004);

INSERT INTO service_item(id, description, name, sell_price)
VALUES (200001, 'Left Tire Change', 'Tire Change', '25'),
       (200002, 'Oil refresh', 'Oil refresh', '50'),
       (200003, 'Deep clean of the entire car', 'Deep clean', '75'),
       (200004, 'Check all tires on pressure and cracks', 'Tire check', '75');

INSERT INTO customer(id, address, email, name, place, telephone, zipcode)
VALUES (300001, 'Framboos straat 1', 'cust1@cust.com', 'Customer 1', 'Amsterdam', '030-1234567', '1111 AA'),
       (300002, 'Appel dreef  2', 'cust2@cust.com', 'Customer 2', 'New York', '030-7654321', '2222 BB'),
       (300003, 'Aarbei weg 3', 'cust3@cust.com', 'Customer 3', 'Madrid', '030-9876543', '3333 CC'),
       (300004, 'Ananas laan 4', 'cust4@cust.com', 'Customer 4', 'Berlijn', '030-3456789', '4444 DD'),
       (300005, 'Braam straat 5', 'cust5@cust.com', 'Customer 5', 'Cairo', '030-3456789', '4444 EE'),
       (300006, 'Dadel dreef 6', 'cust6@cust.com', 'Customer 6', 'Kabul', '030-3456789', '4444 FF'),
       (300007, 'Kaki weg 7', 'cust7@cust.com', 'Customer 7', 'Londen', '030-3456789', '4444 GG'),
       (300008, 'Banaan laan 8', 'cust8@cust.com', 'Customer 8', 'Singapore', '030-3456789', '4444 HH'),
       (300009, 'Druif straat 9', 'cust9@cust.com', 'Customer 9', 'Parijs', '030-3456789', '4444 II'),
       (300010, 'Mandarijn dreef 10', 'cust10@cust.com', 'Customer 10', 'Kingston', '030-3456789', '4444 JJ'),
       (300011, 'Sinaasappel weg 11', 'cust11@cust.com', 'Customer 11', 'Vancouver', '030-3456789', '4444 KK'),
       (300012, 'Peer laan 12', 'cust12@cust.com', 'Customer 12', 'Washington D.C.', '030-3456789', '4444 LL'),
       (300013, 'Kers straat 13', 'cust13@cust.com', 'Customer 13', 'Warschau', '030-3456789', '4444 MM'),
       (300014, 'Moerbes dreef 14', 'cust14@cust.com', 'Customer 14', 'Canberra', '030-3456789', '4444 NN');

INSERT INTO vehicle(id, inspection_date, license_plate, make, status, year, customer_id)
VALUES (400001, '2021-11-17 00:00:00', '44-RHZ-AA', 'Renault', 0, 2011, 300001),
       (400002, '2021-11-17 00:00:00', '44-RHZ-BB', 'Mazda', 0, 2011, 300002),
       (400003, '2021-11-17 00:00:00', '44-RHZ-CC', 'Range Rover', 1, 2011, 300003),
       (400004, '2021-11-17 00:00:00', '44-RHZ-DD', 'Ferrari', 1, 2011, 300004),
       (400005, '2021-11-17 00:00:00', '44-RHZ-EE', 'Lamborghi', 2, 2011, 300005),
       (400006, '2021-11-17 00:00:00', '44-RHZ-FF', 'Opel', 2, 2011, 300006),
       (400007, '2021-11-17 00:00:00', '44-RHZ-GG', 'Mercedes', 3, 2011, 300007),
       (400008, '2021-11-17 00:00:00', '44-RHZ-HH', 'Honda', 3, 2011, 300008),
       (400009, '2021-11-17 00:00:00', '44-RHZ-II', 'BMW', 4, 2011, 300009),
       (400010, '2021-11-17 00:00:00', '44-RHZ-JJ', 'Spyker', 4, 2011, 300010),
       (400011, '2021-11-17 00:00:00', '44-RHZ-KK', 'Fiat', 5, 2011, 300011),
       (400012, '2021-11-17 00:00:00', '44-RHZ-LL', 'Jaguar', 5, 2011, 300012),
       (400013, '2021-11-17 00:00:00', '44-RHZ-MM', 'Nissan', 6, 2011, 300013),
       (400014, '2021-11-17 00:00:00', '44-RHZ-NN', 'Porsche', 6, 2011, 300014);

INSERT INTO repair(id, remarks, customer_id, vehicle_id)
VALUES (500001, 'remarks1', 300001, 400001),
       (500002, 'remarks2', 300002, 400002),
       (500003, 'remarks3', 300003, 400003),
       (500004, 'remarks4', 300004, 400004),
       (500005, 'remarks5', 300005, 400005),
       (500006, 'remarks6', 300006, 400006),
       (500007, 'remarks7', 300007, 400007),
       (500008, 'remarks8', 300008, 400008),
       (500009, 'remarks9', 300009, 400009),
       (500010, 'remarks10', 300010, 400010),
       (500011, 'remarks11', 300011, 400011),
       (500012, 'remarks12', 300012, 400012),
       (500013, 'remarks13', 300013, 400013),
       (500014, 'remarks14', 300014, 400014);

INSERT INTO part_item(id, buy_price, description, name, quantity, sell_price)
VALUES (500001, 1500, 'left for a Mazda of type 1', 'Left door Mazda 1', 7, 2000),
       (500002, 150, 'Steering wheel for a Renault', 'Steering wheel Renault', 12, 300),
       (500003, 200, 'Grill Ferrari', 'Grill Ferrari', 20, 350),
       (500004, 400, 'Spoiler Porsche', 'Spoiler Porsche', 3, 800);

INSERT INTO repair_part_items(id, part_id, repair_id)
VALUES (600001, 500001, 500009),
       (600002, 500002, 500009),
       (600003, 500003, 500010),
       (600004, 500004, 500010),
       (600005, 500001, 500011),
       (600006, 500004, 500011);

INSERT INTO repair_service_items(id, service_part_id, repair_id)
VALUES (700001, 200001, 500009),
       (700002, 200002, 500010),
       (700003, 200003, 500011),
       (700004, 200004, 500011);






