# Shopping-Application-Console-Based-Java-Project

# Console-Based-Java-Project
This is very basic Console-based Java Project where we are focusing on basics and core topics of java, also using mysql and covering some topic like keys,CURD operations, some operators and functions.

# Shopping Application-
A simple console-based shopping application developed in Java with MySQL integration, enabling users to browse items, add products to their cart, and perform various shopping-related operations.

## Features(Product browsing, Shopping Cart Management, Order Processing, Database Integration) -

### 1)Admin privileges-
 i)They can see all Users Details
 ii)They can see all available products
 iii)They can update the existing Products data like name or quantity, they increase/decrease the quantity.
 iv)They can add new product to the products list
 v)They can Delete the product from the products list
 
 ### 2)User privileges-
  i)They can change their account details 
  ii)They can view the Products
  iii)They can add the products to their cart 
  iv)They can order the products
  v)They can view thrie cart and orders with details
  
## Tech Stack

- Java: Core Java concepts like OOP, collections, and JDBC.
- MySQL: Database for storing and retrieving user,product,cart and order information. 


# If you want to implement this project then you should follow below steps:-

-> In Connect.java file which is present in helper package, You should provide your database connection URL,Username and Password.
# Database Configuration

Ensure that your MySQL database credentials (username, password, and database name) are correctly set in the configuration file.

-> I have used Mysql Workbench for these project I'll provide the commands that needs to fire to create database and the tables for Product, User, Cart and Order. We have theses 4 tables and we manage these tables using keys.

-> First how you can get the database URL on MySql Workbench, You can simply right click on MySql Connection either root or any other connection and select the option of "Copy JDBC Connection String to Clipboard" and you can easily paste it their and then put your Username, Password and also the URL in Double Quotes. 

# Command for creating User Table-
create table User(CustomerID int AUTO_INCREMENT not null,Cname varchar(50),Cnumber varchar(100),Cemail varchar(50),Cpassword varchar(20),primary key(CustomerID) );

# Command For creating Product Table-
create table Product(ProductID int AUTO_INCREMENT not null,Pname varchar(200),Punits int(100),Pprice double,Pcategory varchar(100), primary key(ProductID));

You can store any products as per your wish for eg- insert into Product(Pname,Punits,Pprice,Pcategory)values("Facewash",15,405.20,"BeautyProducts");

# Command for creating Cart-
create table Cart(CustomerID int,ProductID int,Pname varchar(200),Punits int(100),Pprice double,Pcategory varchar(100));

# Command for creating Orders-
create table Orders(CustomerID int,Caddress varchar(1000),OrderDate date,DeliveryDate date,
PaymentOp varchar(100),ProductID int,Pname varchar(200),Punits int(100),Pprice double,Pcategory varchar(100));
