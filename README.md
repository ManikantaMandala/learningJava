## Product Demo
Today is the day 3 of Macbook Contest by Telusko.
As said yesterday, We are creating a CLI Product Management application 
project.

### The assignment:
- Convert the yesterday's assignment to spring boot, Data JPA and 
PostgreSQL as database

### Learnings:
1. I got to know about the dependency injection with Spring Boot.
A basic implementation of it.
2. Basic understanding of Data JPA and its naming conversions.

In today's assignment, I have implemented 
1. Getting products by name
2. Getting products by text which will be search in multiple columns 
in database by ignoring the cases.
3. Getting products by place 
4. Getting products by warranty which are less than warranty value in 
database.

In all the operation we just need to change the function name, Return type
and parameters in the ProductDB interface which extends JpaRepository.

Operation 1: 
- function name:findByName()
  - findBy : indicates that it's a query by specific criteria.
  - Name : it's the name of the entity column I want to compare.
- Return Type: List<Product> (Because multiple products can have same name)
- parameters: String name (We need the name to check right!)

Operation 2:
- function name: findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase()
  - takes 3 parameters and performs case-insensitive partial match
  search on name, type, place columns in database.
- Return Type: List<Product> (Because multiple products can have same text in different columns)
- parameters: String name, String type, String place

Operation 3:
- function name: findByPlace()
    - findBy : indicates that it's a query by specific criteria.
    - Place : it's the place of the entity column I want to compare.
- Return Type: List<Product> (Because multiple products can have same place)
- parameters: String place (We need the place to check right!) 

Operation 4:
- function name: findByWarrantyLessThan()
  - findBy : indicates that it's a query by specific criteria. 
  - Warranty : is the name of the entity's column you want to compare. 
  - LessThan : specifies the less than comparison operation.
- Return Type: List<Product>
- parameters: int year(current year)

All other things are learnt in yesterday's assignment