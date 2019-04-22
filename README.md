# SpringMVC-books
It's a simple example of using SpringMVC with hibernate and jdbc template/
### 1.Create a table
~~~
CREATE TABLE `Book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `author` varchar(60) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
~~~
### 2.Set DBMS properties
Edit file placed at `resources/application.properties` with your parametres in the next way:
~~~
jdbc.driver=your_type_of_dbms
jdbc.url=jdbc:mysql://localhost:3306/your_database_name
jdbc.username=your_username
jdbc.password=your_pass
~~~
### 3.Change model
Adapt a model placed at `entity` to your database entities.
### 4.Change DAO implementation
Re-write the selects placed within `dao.BookDAOImp` changed to yours database selects.
### ENJOY
