```mysql
CREATE SCHEMA `sporty_shoes_db` ;

use sporty_shoes_db;

create table products(
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         product_name VARCHAR(20),
                         season VARCHAR(20),
                         brand VARCHAR(20),
                         category VARCHAR(20),
                         price DOUBLE,
                         color VARCHAR(20),
                         discount INT
);

```

create table products(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
product_name VARCHAR(20),
season VARCHAR(20),
brand VARCHAR(20),
category VARCHAR(20),
price DOUBLE,
color VARCHAR(20),
discount INT
)

create table users(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(20),
password VARCHAR(100),
email VARCHAR(50),
phone_number VARCHAR(10)
)

create orders(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_id int FOREIGN KEY REFERENCES users(id),
product_order_id int FOREIGN KEY REFERENCES products(id)
)

create product_orders(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
product_id int FOREIGN KEY REFERENCES products(id),
discount INT,
quantity INT,
price INT
)