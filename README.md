## ShortURL

In today's assignment, we got 3 problems,

1. build a shortURL program using HashMap as storage
2. build a spring boot MVC web application with a UI build on react

Explanations:

1. A URL is sent to handleURL() method to generate of search in hashMap(if if contains) => This can be seen in hashMapImplementation directory

2. This is a Spring boot MVC web application which will create a short url of an original url that we send to the server. Here I used React for Frontend, Spring boot for backend and PostgreSQL Database for storage. Basically, flow goes link this
   1. User enter the URL with the UI
   2. controller gets the request and maps it to the service layer
   3. This service layer will handle whether the provided URL is gotten a shortURL already or not
      - If not it will generate a shortURL and send it back
      - else it searches for that URL in Database and send back to the User
   4. So the shortURL will be sent back as a response to the UI.
   5. It will be printed.

The other implementation, To get all the URLs => This can be seen in first-react-app and shortURL directories.

Learnings:
Never push nested git repositories to github repos
The code never reaches the repo

Okay bye!🙂
