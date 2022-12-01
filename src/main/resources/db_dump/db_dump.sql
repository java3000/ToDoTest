DROP TABLE IF EXISTS "public"."users";
DROP TABLE IF EXISTS "public"."tasks";
DROP TABLE IF EXISTS "public"."users_tasks";
DROP TABLE IF EXISTS "public"."role";
DROP TABLE IF EXISTS "public"."users_roles";
CREATE TABLE "public"."users" (
                                  "id" BIGINT NOT NULL,
                                  "login" VARCHAR NULL,
                                  "password" VARCHAR NULL,
                                  "name" VARCHAR NULL
);
CREATE TABLE "public"."tasks" (
                                  "id" BIGINT NOT NULL,
                                  "subject" VARCHAR NULL,
                                  "description" VARCHAR NULL
);
CREATE TABLE "public"."users_tasks" (
                                        "user_id" BIGINT NULL,
                                        "task_id" BIGINT NULL
);
CREATE TABLE "public"."role" (
                                 "id" BIGINT NULL,
                                 "name" VARCHAR NULL
);
CREATE TABLE "public"."users_roles" (
                                        "user_id" BIGINT NULL,
                                        "role_id" BIGINT NULL
);
INSERT INTO "public"."users" ("id", "login", "password", "name") VALUES ('2', 'admin', '$2a$10$D8YFXlinD5UO5u3qs9BW2.D6MonXQTbj5aFUNxNu33vi.iIkY1c5S', 'Super User');
INSERT INTO "public"."users" ("id", "login", "password", "name") VALUES ('3', 'user22', '$2a$10$Es5.NxshceNK9AIOxCl7new04JolVG71ZBsEJ9an.PdIKXOKhbqmS', 'user22');
INSERT INTO "public"."users" ("id", "login", "password", "name") VALUES ('4', 'user223', '$2a$10$TcCrAbsOX.XGjCnAmsiGsOTdp1tV1C0tkZSbiWgIyWw7Zj1gvyle2', 'user22');
INSERT INTO "public"."users" ("id", "login", "password", "name") VALUES ('1', 'user', '$2a$10$D8YFXlinD5UO5u3qs9BW2.D6MonXQTbj5aFUNxNu33vi.iIkY1c5S', 'Super User');
INSERT INTO "public"."users" ("id", "login", "password", "name") VALUES ('5', 'user222', '$2a$10$lYtI.vjK/ygCbPLTYPlzYexFxhQTg.lC0DD4euJu.hB5hLtN/L1b2', 'user222');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('4', 'тест 31', 'test');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('5', 'тест 31', '1');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('6', 'тест 31', 'test');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('7', 'тест 31', 'test');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('8', 'Не появился оплаченный полис.', 'bot api call');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('10', 'ьн ефыл', 'bot api call');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('9', 'тест 31', 'test21');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('11', 'Не появился оплаченный полис.', 'bot api call');
INSERT INTO "public"."tasks" ("id", "subject", "description") VALUES ('13', 'ьн ефыл11', 'test');
INSERT INTO "public"."users_tasks" ("user_id", "task_id") VALUES ('1', '10');
INSERT INTO "public"."users_tasks" ("user_id", "task_id") VALUES ('1', '9');
INSERT INTO "public"."users_tasks" ("user_id", "task_id") VALUES ('1', '11');
INSERT INTO "public"."users_tasks" ("user_id", "task_id") VALUES ('5', '12');
INSERT INTO "public"."users_tasks" ("user_id", "task_id") VALUES ('5', '13');
INSERT INTO "public"."role" ("id", "name") VALUES ('1', 'ROLE_USER');
INSERT INTO "public"."role" ("id", "name") VALUES ('2', 'ROLE_ADMIN');
INSERT INTO "public"."role" ("id", "name") VALUES ('3', 'ROLE_ANONYMOUS');
INSERT INTO "public"."users_roles" ("user_id", "role_id") VALUES ('2', '1');
INSERT INTO "public"."users_roles" ("user_id", "role_id") VALUES ('2', '2');
INSERT INTO "public"."users_roles" ("user_id", "role_id") VALUES ('2', '1');
INSERT INTO "public"."users_roles" ("user_id", "role_id") VALUES ('3', '1');
INSERT INTO "public"."users_roles" ("user_id", "role_id") VALUES ('4', '1');
INSERT INTO "public"."users_roles" ("user_id", "role_id") VALUES ('5', '1');
