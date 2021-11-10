-- Drop table
DROP TABLE IF EXISTS public.item;
DROP TABLE IF EXISTS public.order;

-- Table: public.item
CREATE TABLE IF NOT EXISTS public.item
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    price numeric,
    name text COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.item
    OWNER to postgres;

-- Table: public.order

CREATE TABLE IF NOT EXISTS public.order
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    item_id integer,
    quantity integer
)

TABLESPACE pg_default;

ALTER TABLE public.order
    OWNER to postgres;
-- Data

insert into item(price, name)
values(2.50, 'Veggie Taco'),
(3.00, 'Chicken or Beef Taco'),
(3.50, 'Chorizo Taco');