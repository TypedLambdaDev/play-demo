# --- !Ups
CREATE TABLE "pickups"
(
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "order_name" VARCHAR
);

# --- !Downs
drop table "pickups"

