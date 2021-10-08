# Sinema Room REST Service

A simple implementation of Virtual Cinema Theater. It is based on Spring Boot and built with Intellij IDEA.

### About
Always wanted to have your private movie theater and screen only the movies you like? You can buy a fancy projector and set it up in a garage, but how can you sell tickets? Having a booth is old-fashioned, so let's create a special service for that! Make good use of Spring and write a REST service that can show the available seats, sell and refund tickets, and display the statistics of your venue. Pass me the popcorn, please!

### Learning outcomes
In this project, I learned how to create a simple Spring REST service that will help you manage a small movie theatre. Handle HTTP requests in controllers, create services and respond with JSON objects.

## Example:
### Example 1: a ```GET /seats``` request
Response body:
```
{
   "total_rows":9,
   "total_columns":9,
   "available_seats":[
      {
         "row":1,
         "column":1,
         "price":10
      },
      {
         "row":1,
         "column":2,
         "price":10
      },
      {
         "row":1,
         "column":3,
         "price":10
      },

      ........

      {
         "row":9,
         "column":8,
         "price":8
      },
      {
         "row":9,
         "column":9,
         "price":8
      }
   ]
}
```

## Buying and returning a ticket.
### Example 1: a ```POST /purchase``` request
Request body:
```
{
    "row": 3,
    "column": 4
}
```

Response body:
```
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556",
    "ticket": {
        "row": 3,
        "column": 4,
        "price": 10
    }
}
```

### Example 2: ```POST /return``` with the correct token
Request body:
```
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```

Response body:
```
{
    "returned_ticket": {
        "row": 1,
        "column": 2,
        "price": 10
    }
}
```

### Example 3: ```POST /return``` with an expired token

Request body:
```
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```
Response body:
```
{
    "error": "Wrong token!"
}
```

### Example 4: a ```POST /purchase``` request, the ticket is already booked

Request body:
```
{
    "row": 3,
    "column": 4
}
```
Response body:
```
{
    "error": "The ticket has been already purchased!"
}
```

### Example 5: a ```POST /purchase``` request, a wrong row number

Request body:
```
{
    "row": 15,
    "column": 4
}
```
Response body:
```
{
    "error": "The number of a row or a column is out of bounds!"
}
```
## The statistics 
Endpoint ```/stats``` will handle POST requests with URL parameters. If the URL parameters contain a password key with a super_secret value, it will return the movie theatre statistics in the following format:
```
{
    "current_income": 0,
    "number_of_available_seats": 81,
    "number_of_purchased_tickets": 0
}
```
### Example 1: a ```POST /stats``` request with no parameters

Response body:
```
{
    "error": "The password is wrong!"
}
```
### Example 2: a ```POST /stats``` request with the correct password == super_secret

Response body:
```
{
    "current_income": 30,
    "number_of_available_seats": 78,
    "number_of_purchased_tickets": 3
}
```
