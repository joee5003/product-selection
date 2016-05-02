# README

#### Building the project
Instructions given assuming linux enviroment.
##### Requirements:
- JDK 1.8
- Maven 3+

Git clone the repository and cd into the project's root directory.
Once there run:
```bash
mvn install
```
This will build the project. 

#### Running the project
To run the project you can use the maven spring boot plugin, by running:
```bash
mvn spring-boot:run
```
or run the jar directly:
```bash
java -jar target/product-selection-1.0-SNAPSHOT.jar
```

Once running open your web browser and navigate to [http://localhost:8080/productSelection](http://localhost:8080/productSelection).
You should be initially presented with an error page. This is due to no cookie being present for the customerId. To inject a cookie open the developer tools in your browser, open the console and enter:
```javascript
document.cookie="customerId=LN0001"
```
Then refresh the page.

"LN0001" is one valid customer id used in the CustomerLocationService stub, relating to a customer in the London area. The full list is as follows:

| Id | Location |
| --- | --- |
| LN0001 | London |
| LN0002 | London |
| LP0001 | Liverpool |
| LP0002 | Liverpool |
| BH0001 | Other |
| EX0001 | Other |
