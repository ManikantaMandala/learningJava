## ProductDemo

This is a demo project conducted for Telusko's Macbook Contest. In this contest,
we will create a CLI product management project.

Today, we have learnt about some basic operations that we can perform in 
the main CLI project and their implementation.

Today's assignments:
1.Create a function that returns the products by searching through the place.
2.Create a function that returns the products that are out of warranty.
3.Try to implement the Stream API in today's operations.

### 1.Search by Place:

Using the equalsIgnoreCase() method from String, I tried to run a for each loop 
for every product and compare. If I find they are equal, then I will add that 
to a List object, which will be returned.

### 2. Search products that are out of warranty:

Using the Year class from the java.time package, we can get the value of the 
current year {Year.now().getValue()}. So I compared it with the warranty value 
of the product. Then added to the List object that we will return.

### 3. Implementation of Stream API:

In this part of assignment, I tried to implement Stream APIs for 5 operations:
1. get all products
2. get product using Name value
3. get products using text
4. search by place
5. search products that are out of warranty

In operation 1, I used the stream() method on the products collection to convert 
it into a stream and return it.

Operations 2, 4 by logic are same, but there are some little differences. 
So, for simplicity, I will try to explain the 4th operation using the Stream API:
I have implemented it in the searchByPlaceUsingStreams() function.
This function takes a place parameter as input. It uses the stream() method on 
the products collection to convert it into a stream. Then it applies the filter
operation on the stream, using a lambda expression 
(x -> x.getPlace().equalsIgnoreCase(place)) to check if the place of each 
Product object matches the specified place parameter (with case-insensitive).
The filter operation creates a new Stream that contains only the product 
objects with a place matching the specified value. 
Finally, the method returns the resulting filtered stream of Product objects.

All other operations are same as 4 but their lambda expression changes.

In Operation 3, the lambda expression changed is
(x->{return x.getName().toLowerCase().contains(text)||
x.getType().toLowerCase().contains(text)||x.getPlace().toLowerCase().contains(text);}).
In this lambda expression, we get various values of the stream, convert them 
into lower-case and check if contains the text we want to search for.
We use or operator to check for various values. If the searching text matches 
then we filter it.

In Operation 5, the lambda expression changed is 
x->x.getWarranty()< Year.now().getValue(). As said before {Year.now().getValue()}
will return current year value which is compared with warranty value of the stream 
product. If the condition is satisfied then we filter it.


