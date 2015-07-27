-- Table: products

DROP TABLE products;

CREATE TABLE products
(
  id serial NOT NULL,
  product_name character varying(250),
  product_description character varying(400),
  stock_qty double precision,
  price double precision,
  CONSTRAINT "Products_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE products
  OWNER TO momo;
  
-- Table: tasks

DROP TABLE tasks;

CREATE TABLE tasks
(
  task_id serial NOT NULL,
  task_name character varying(100) NOT NULL,
  task_description text,
  task_priority character varying(20),
  task_status character varying(20),
  task_start_time time without time zone NOT NULL,
  task_end_time time without time zone NOT NULL,
  task_archived boolean DEFAULT false,
  CONSTRAINT "Task_pkey" PRIMARY KEY (task_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tasks
  OWNER TO momo;
  