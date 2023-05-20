## ProductDemo

This is a demo project conducted in Telusko's Macbook Contest.
In this contest, We will create a CLI products management project.

Today, We have learnt about some basic operations that we can be preforming in 
the main CLI project, and There implementation.

Today's assignments:
    1. Create a function which returns the products by searching through place
    2. Create a function which returns the products which are out of warranty
    3. Try to implement Stream API in today's operations.
    
### 1. Search by Place:

Using equalsIgnoreCase() method from String, I tried to run a for each loop of 
every product and compared. If I find they are equal then I will add that to a 
List<Product> object which will be return.

### 2. Search products that are out of warranty:

Using Year class from java.time package, We can get the value of the current year
{Year.now().getValue()}. So I compared it with warranty value of the product. 
Then added to the return List<Product> object.

### 3. Implementation of Stream API:

In this part of assignment, I tried to implement Stream APIs for 5 operations:
1. get all products
2. get product using Name value
3. get products using text
4. search by place
5. search products that are out of warranty

In operation 1, I used stream() method on the products collection to convert it 
into a stream are returned it.

Operations 2, 4 by logic but this little differences. So, for simplicity, I will
try to explain 4th operation using Stream API:
I have implemented it in searchByPlaceUsingStreams() method. This function takes
a place parameter as input. It uses the stream() method on the products collection
to convert it into a stream. Then it applies the filter operation on the stream,
using a lambda expression (x -> x.getPlace().equalsIgnoreCase(place)) to check if
the place of each Product object matches the specified place parameter(case-insensitive).
The filter operation creates a new stream that contains only the Product objects
with a place matching the specified value.
Finally, the method returns the resulting filtered stream of Product objects.

All other operations are same as 4 but their lambda expression changes

In Operation 5 the lambda expression changed is 
(x->x.getWarranty()< Year.now().getValue()). As said before {Year.now().getValue()}
will return current year value which is compared with warranty value of the stream product.

In Operation 3 the lambda expression changed is
(x->{return x.getName().toLowerCase().contains(text)|| x.getType().toLowerCase().contains(text)||
x.getPlace().toLowerCase().contains(text);}). In this lambda expression, we get various 
values of the stream and convert the value into lower-case and check if contains 
the text we want to search for. We use or operator to check for various values.
