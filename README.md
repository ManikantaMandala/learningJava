## DAY-1:

### Problem statement:

Create pascal's triangle with 3 different approaches 
1. Iteration
2. Recursion
3. Memoization

### 1. Iteration:

I have created a pascalTriangleCreation method in Solution class which takes height as input(User input). In this method, I have created a pascalTriangle variable which stores the pascalTriangle.
Now, inside the for loop which will iterate through rows I added 1 as first element(because the first element is 1 in the top of the pascal's triangle)
If the current row is not the first row, It means that we can access the previous row of the pascalTriangle to calculate the values of the current row.
After calculating and updating the values. We should add 1 at the end.
After this we should add the curretnRow to the pascalTriangle.
    
### 2. Recursion:
    
I have created a usingRecursion method in Solution class in pascalsTriangleRecursion.java file which takes the number of rows(ROWS) as input and returns an ArrayList of ArrayList of Integers representing Pascal's triangle.
Firstly I created a dummy pascal's triangle, I will update the values of every index from the return value of value function. In this value function, I used recursion for calculating the value of the current node with base cases as if the Node is starting or ending return 1.
    
### 3. Memoization:

Same as Recursion function from the above, I just introduced to Dynamic programming that is solving each subproblem only once. The results of the subproblems are stored in a datastruture(Here ArrayList of ArrayList of Integers). I have accomplished that by using -1 to calculate or not calculate.
