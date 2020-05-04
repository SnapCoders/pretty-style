INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (1,'bruno.futema@outlook.com','2020-04-12 19:35:32',NULL,NULL,'NjU0MzIx',NULL,NULL);
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (2,'amanda.cano@outlook.com','2020-04-12 19:48:05',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (5,'admin.master@prettystyle.com.br','2020-04-14 01:26:54',NULL,NULL,'MTIzNDU2',NULL,NULL);
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (6,'bruno.futema@outlook.com','2020-04-15 02:29:52',NULL,NULL,'MTIzNDU2Nzg=','BrunoFutema','bruno.futema@outlook.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (7,'bruno.futema@outlook.com','2020-04-15 02:33:31',NULL,NULL,'MTIzNDU2Nzg=','BrunoFutema','bruno.futema@outlook.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (8,'bruno.futema@outlook.com','2020-04-15 02:35:47',NULL,NULL,'MTIzNDU2Nzg=','BrunoFutema','bruno.futema@outlook.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (9,'bruno.futema@outlook.com','2020-04-15 02:38:48',NULL,NULL,'MTIzNDU2Nzg=','BrunoFutema','bruno.futema@outlook.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (10,'bruno.futema@outlook.com','2020-04-15 02:40:24',NULL,NULL,'MTIzNDU2Nzg=','BrunoFutema','bruno.futema@outlook.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (11,'prettystyle@prettystyle.com.br','2020-04-15 15:34:01',NULL,NULL,'MTIzNDU2Nzg=','PrettyStyle','prettystyle@prettystyle.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (12,'camandinha@gmail.com','2020-04-17 11:08:04',NULL,NULL,'MTIzNDU2Nzg=','camandinha','camandinha@gmail.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (13,'camandinha@gmail.com','2020-04-17 11:09:35',NULL,NULL,'MTIzNDU2Nzg=','camandinha','camandinha@gmail.com');
INSERT INTO `user` (`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES ('jhon@gmail.com','2020-04-17 11:11:04',NULL,NULL,'MTIzNDU2Nzg=','jhonatan','jhon@gmail.com');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (15,'teste1@ps.com.br','2020-04-20 04:56:30',NULL,NULL,'MTIzNDU2Nzg=','Teste 1','teste1@ps.com.br');
INSERT INTO `user` (`id`,`email`,`created_at`,`updated_at`,`deleted_at`,`password_hash`,`username`,`email_confirmation`) VALUES (16,'teste2@ps.com.br','2020-04-20 04:57:22',NULL,NULL,'MTIzNDU2Nzg=','Teste 2','teste2@ps.com.br');
INSERT INTO `provider` (`id`,`cnpj`,`id_user`,`created_at`,`updated_at`,`deleted_at`,`social_reason`,`contact`,`fantasy_name`) VALUES (2,'12.345.678/1234-89',11,'2020-04-18 20:50:30',NULL,NULL,'','','Pretty Style');
INSERT INTO client ( id,cpf,id_user,created_at,updated_at,deleted_at,birthday,genre,name,surname) VALUES (1,'471.033.418-85',1,"2020-04-12 19:36:20",NULL,NULL,'2010-04-12','M','Bruno','Futema');
INSERT INTO client ( id,cpf,id_user,created_at,updated_at,deleted_at,birthday,genre,name,surname) VALUES (3,'471.033.418-85',2,"2020-04-12 19:48:52",NULL,NULL,'2010-04-12','M','Jhon','Costa');
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (1,1000,1,'2020-04-12 19:37:00',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (3,1000,3,'2020-04-12 19:49:46',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (4,1500,1,'2020-04-14 21:24:54',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (5,1500,1,'2020-04-14 23:19:24',NULL,NULL,'99c62e88-7ebf-11ea-a0ea-64006afce879',NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (6,1500,1,'2020-04-15 15:37:35',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (7,1500,1,'2020-04-15 17:07:21',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (8,2643.0425,1,'2020-04-16 01:19:43',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (9,2643.0425,1,'2020-04-16 01:24:16',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (10,2643.0425,1,'2020-04-16 01:27:03',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (11,2643.0425,1,'2020-04-16 01:28:18',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (12,2643.0425,1,'2020-04-16 01:31:32',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (13,2643.0425,1,'2020-04-16 01:32:52',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (14,2643.0425,1,'2020-04-16 01:34:30',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (15,2643.0425,1,'2020-04-16 01:35:08',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (16,6855.5,1,'2020-04-19 22:33:32',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (17,6512.725,1,'2020-04-19 22:34:03',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (18,6512.725,1,'2020-04-19 22:34:15',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (19,6512.725,1,'2020-04-19 22:36:04',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (20,6512.725,1,'2020-04-19 23:58:13',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (21,6512.725,1,'2020-04-20 00:15:10',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (22,6512.725,1,'2020-04-20 00:19:10',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (23,6512.725,1,'2020-04-20 00:21:39',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (24,6855.5,1,'2020-04-20 00:29:07',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (25,6855.5,1,'2020-04-20 01:25:21',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (26,6855.5,1,'2020-04-20 04:54:47',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (27,6855.5,1,'2020-04-20 15:08:40',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (28,14506.975,1,'2020-04-20 18:35:45',NULL,NULL,NULL,NULL);
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (29,23227.8781,1,'2020-04-20 18:48:11',NULL,NULL,'001-1a200ff2-f74e-47a8-a21a-a68013126072','creditCard');
INSERT INTO `request` (`id`,`total_price`,`id_client`,`created_at`,`updated_at`,`deleted_at`,`number_request`,`type_payment`) VALUES (30,23227.8781,1,'2020-04-20 23:14:46',NULL,NULL,'001-bbee45cc-e82c-41cc-8dd4-003770e36659','creditCard');
INSERT INTO `mark` (`id`,`name`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (1,'JBL','2020-04-10 21:51:33',NULL,'2020-04-20 20:50:00',2);
INSERT INTO `mark` (`id`,`name`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (2,'Apple','2020-04-11 16:56:15',NULL,'2020-04-20 21:05:07',2);
INSERT INTO `mark` (`id`,`name`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (3,'Marca de teste','2020-04-20 20:29:08',NULL,NULL,2);
INSERT INTO `mark` (`id`,`name`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (4,'Teste2','2020-04-20 20:30:09',NULL,'2020-04-20 22:37:44',2);
INSERT INTO `mark` (`id`,`name`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (5,'Marca de teste','2020-04-20 20:31:05',NULL,NULL,2);
INSERT INTO `mark` (`id`,`name`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (6,'JBL','2020-04-20 22:36:41',NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (1,"JBL Flip 3 Portable","Qualquer coisa",250,1,"2020-04-10 21:52:27",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (2,"Samsung S9 Plus","Qualquer coisa",4250,1,"2020-04-10 23:00:22",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (3,"Notebook Dell 15 Gaming","Qualquer coisa",8250,1,"2020-04-10 23:00:54",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (7,"iPad 10","O novo iPad da Apple",8999.9,2,"2020-04-11 16:56:22",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (9,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:07:15",NULL,"2020-04-12 16:20:58",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (10,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:43",NULL,"2020-04-12 16:33:41",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (11,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:44",NULL,"2020-04-13 18:08:48",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (12,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:44",NULL,"2020-04-12 16:51:24",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (13,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:44",NULL,"2020-04-12 16:58:20",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (14,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:44",NULL,"2020-04-12 16:59:01",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (15,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:45",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (16,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:45",NULL,"2020-04-13 02:05:23",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (17,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:45",NULL,"2020-04-13 02:23:18",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (18,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:45",NULL,"2020-04-13 02:13:42",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (19,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:45",NULL,"2020-04-13 02:12:01",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (20,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:45",NULL,"2020-04-13 02:13:56",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (21,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 02:24:11",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (22,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 02:14:10",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (23,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 02:19:12",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (24,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 02:20:47",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (25,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 02:20:10",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (26,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 18:08:45",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (27,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:11:46",NULL,"2020-04-13 02:27:50",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (28,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:12:10",NULL,"2020-04-13 02:28:16",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (29,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:12:10",NULL,"2020-04-13 18:07:20",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (30,"iPhone XR Branco","IPhone XR branco com câmera 12 MP",3999.99,NULL,"2020-04-11 21:12:10",NULL,"2020-04-13 18:08:52",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (33,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-12 22:54:31",NULL,"2020-04-13 18:09:42",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (34,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-12 22:54:55",NULL,"2020-04-13 02:17:58",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (35,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-12 22:55:53",NULL,"2020-04-13 02:18:28",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (36,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-12 23:04:30",NULL,"2020-04-13 18:08:59",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (37,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 15:41:31",NULL,"2020-04-13 18:09:02",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (38,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 15:42:04",NULL,"2020-04-13 18:09:34",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (39,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 15:45:29",NULL,"2020-04-13 18:09:09",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (41,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 15:59:49",NULL,"2020-04-13 18:09:12",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (42,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 16:45:42",NULL,"2020-04-13 18:09:06",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (43,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 16:50:04",NULL,"2020-04-13 18:09:37",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (44,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 16:51:19",NULL,"2020-04-13 18:12:26",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (45,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 16:53:13",NULL,"2020-04-13 18:09:39",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (46,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 16:57:01",NULL,"2020-04-13 18:12:09",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (47,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 16:57:20",NULL,"2020-04-13 18:11:46",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (48,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 17:51:47",NULL,"2020-04-13 18:09:46",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (49,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:04:14",NULL,"2020-04-13 18:11:43",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (50,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:04:40",NULL,"2020-04-13 18:09:50",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (51,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:10",NULL,"2020-04-13 18:11:56",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (52,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:12",NULL,"2020-04-13 18:11:51",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (53,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:14",NULL,"2020-04-13 18:11:59",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (54,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:15",NULL,"2020-04-13 18:12:02",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (55,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:15",NULL,"2020-04-13 18:12:06",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (56,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:16",NULL,"2020-04-13 18:12:19",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (57,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:17",NULL,"2020-04-13 18:12:22",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (58,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:05:38",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (59,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,1,"2020-04-13 18:07:36",NULL,"2020-04-13 18:12:15",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (60,"Relógio SmartWatch","Relógio moderno.",800,2,"2020-04-13 19:17:17",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (61,"Caixa de som Mondial","Caixa de som 20 watts.",250,1,"2020-04-13 19:18:37",NULL,"2020-04-20 20:48:07",2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (62,"Fone de ouvido JBL","Fone de ouvido in-Ear sem fio JBL Tune 205 Bluetooth 4.0",156.65,3,"2020-04-20 21:15:04",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (63,"Fone de ouvido JBL sem fio","Fone sem fio",250,6,"2020-04-20 22:39:53",NULL,NULL,2);
INSERT INTO product ( id,name,description,price,id_mark,created_at,updated_at,deleted_at,id_provider) VALUES (64,"Fone de ouvido JBL sem fio","Fone sem fio",250,6,"2020-04-20 22:39:53",NULL,"2020-04-20 22:40:40",2);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (1,11,' 8585-5656',7,'2020-04-15 02:33:40',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (2,11,' 8585-5656',8,'2020-04-15 02:35:54',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (3,11,' 8585-5656',9,'2020-04-15 02:38:52',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (4,11,' 97676-8585',9,'2020-04-15 02:38:58',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (5,11,' 8585-5656',10,'2020-04-15 02:40:26',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (6,11,' 97676-8585',10,'2020-04-15 02:40:27',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (7,11,' 2525-5656',11,'2020-04-15 15:34:08',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (8,11,' 97676-8585',11,'2020-04-15 15:34:15',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (9,12,' 3165-1613',12,'2020-04-17 11:08:13',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (10,12,' 3165-1613',13,'2020-04-17 11:09:38',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (11,23,' 1 3216-6516',13,'2020-04-17 11:09:41',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (12,32,' 1516-5165',14,'2020-04-17 11:11:12',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (13,16,' 5 1651-5165',14,'2020-04-17 11:11:17',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (14,11,' 2525-2525',15,'2020-04-20 04:56:30',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (15,11,' 9 8585-8585',15,'2020-04-20 04:56:30',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (16,11,' 2626-2626',16,'2020-04-20 04:57:22',NULL,NULL);
INSERT INTO `phone_number` (`id`,`ddd`,`number`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (17,11,' 9 5656-5656',16,'2020-04-20 04:57:22',NULL,NULL);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (1,10,1,'2020-04-12 19:39:03',NULL,NULL,1);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (2,1,9,'2020-04-12 19:50:40',NULL,NULL,3);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (3,2,1,'2020-04-14 21:26:11',NULL,NULL,3);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (4,2,1,'2020-04-15 15:37:35',NULL,NULL,3);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (5,2,1,'2020-04-15 17:07:21',NULL,NULL,3);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (6,1,1,'2020-04-15 18:29:33',NULL,NULL,3);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (7,1,1,'2020-04-15 18:36:16',NULL,NULL,NULL);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (8,1,2,'2020-04-15 18:36:36',NULL,NULL,1);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (9,1,3,'2020-04-20 18:30:15',NULL,NULL,NULL);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (10,1,3,'2020-04-20 18:31:14',NULL,NULL,NULL);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (11,1,3,'2020-04-20 18:32:35',NULL,NULL,NULL);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (12,1,3,'2020-04-20 18:34:49',NULL,NULL,1);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (13,1,7,'2020-04-20 18:41:56',NULL,NULL,1);
INSERT INTO `item` (`id`,`quantity`,`id_product`,`created_at`,`updated_at`,`deleted_at`,`id_client`) VALUES (14,1,7,'2020-04-20 18:42:40',NULL,NULL,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (1,1,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (10,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (11,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (12,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (13,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (14,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (15,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (16,3,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (17,7,1,1);
INSERT INTO `client_product_like` (`id`,`id_product`,`action`,`id_user`) VALUES (18,2,1,1);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (1,'Masculino','#0E9AEF','2020-04-16 18:53:12',NULL,NULL,2);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (2,'Feminino','#0E9AEF','2020-04-16 18:53:12',NULL,NULL,2);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (3,'Novidades','#0E9AEF','2020-04-16 18:53:12',NULL,NULL,2);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (4,'Pets','#0E9AEF','2020-04-16 18:53:12',NULL,NULL,2);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (5,'Categoria de teste','#ddd','2020-04-20 20:31:49',NULL,NULL,2);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (6,'Teste2','#ddd','2020-04-20 21:05:50',NULL,NULL,2);
INSERT INTO `category` (`id`,`name`,`color`,`created_at`,`updated_at`,`deleted_at`,`id_provider`) VALUES (7,'Categoria 1','#7159c1','2020-04-20 22:38:24',NULL,NULL,2);
INSERT INTO `address` (`id`,`place`,`number`,`neighborhood`,`city`,`country`,`zip`,`complement`,`id_user`,`created_at`,`updated_at`,`deleted_at`) VALUES (1,'Rua Silveira Tavares','28','Parque Edu Chaves','São Paulo','Brasil','02233040','Casa',1,'2020-04-14',NULL,NULL);
INSERT INTO product_photo ( id,url,name,id_product,created_at,updated_at,deleted_at) VALUES (1,'/Uploads/jbl.png','jbl.png',1,"2020-04-17 22:43:49",NULL,NULL);
INSERT INTO product_photo ( id,url,name,id_product,created_at,updated_at,deleted_at) VALUES (2,'/Uploads/jbl.png','jbl.png',1,"2020-04-18 18:31:55",NULL,NULL);
INSERT INTO product_photo ( id,url,name,id_product,created_at,updated_at,deleted_at) VALUES (3,'/Uploads/jbl.png','jbl.png',1,"2020-04-18 19:00:33",NULL,NULL);
INSERT INTO product_photo ( id,url,name,id_product,created_at,updated_at,deleted_at) VALUES (4,'/Uploads/jbl.png','jbl.png',1,"2020-04-18 19:00:34",NULL,NULL);
INSERT INTO user_address ( id_user,id_address) VALUES (1,2);
INSERT INTO `product_request` (`id_product`,`id_request`,`created_at`) VALUES (1,5,'2020-04-17 11:18:17');
INSERT INTO product_category ( id_product,id_category,created_at) VALUES (1,1,"2020-04-20 20:06:06");
INSERT INTO product_category ( id_product,id_category,created_at) VALUES (2,1,"2020-04-20 20:06:27");
INSERT INTO product_category ( id_product,id_category,created_at) VALUES (3,1,"2020-04-20 20:06:27");
INSERT INTO product_category ( id_product,id_category,created_at) VALUES (7,1,"2020-04-20 20:06:27");
