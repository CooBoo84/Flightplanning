## Flightplanning - Laboration
Laboration with myself, Hans, Gustaf and Athanasios.

## Endpoints
- [Users](#users)
- [Auth](#auth)
- [Airplanes](#airplanes)
- [Routes](#routes)
- [Food](#food)
- [Workers](#workers)
---
## Users
### Create a new user as ADMIN
``
POST - http://localhost:8080/FlightApp/users/signup
``
- JSON-body
```
{
	"firstName": "Förnamn",
	"lastName": "Efternamn",
	"email": "mail@mail.com",
	"telephone": "123131",
	"username": "user1",
	"password": "user",
	"admin": true
}
```

### Get all users
``
GET - http://localhost:8080/FlightApp/users
``

### Get a users by ID
``
GET - http://localhost:8080/FlightApp/users/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/users/1 |

### Delete a users by ID
``
DELETE - http://localhost:8080/FlightApp/users/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/users/1 |


## Auth
### Create token for your user
``
POST - http://localhost:8080/FlightApp/users/signup
``
- JSON-body
```
{
	"firstName": "Förnamn",
	"lastName": "Efternamn",
	"email": "mail@mail.com",
	"telephone": "123131",
	"username": "user1",
	"password": "user",
	"admin": true
}
```
- Output example
```
{
	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6M......."
}
```

## Airplanes (You need to set admin = true, when creating a new user)
### Create a new airplane
``
POST - http://localhost:8080/FlightApp/airplanes
``
- JSON-body
```
{
	"airplaneName": "FlygplansNamn",
	"numberOfSeat": 100,
	"numberOfStaff": 10
}
```

### Get all airplanes
``
GET - http://localhost:8080/FlightApp/airplanes
``

### Get a airplane by ID
``
GET - http://localhost:8080/FlightApp/airplanes/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/airplanes/1 |

### Delete a airplane by ID
``
DELETE - http://localhost:8080/FlightApp/airplanes/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/airplanes/1 |


## Routes
### Create a new route
``
POST - http://localhost:8080/FlightApp/routes
``
- JSON-body
```
{
	"routeName": "Gbg-Sthlm"
}
```
### Get all routes
``
GET - http://localhost:8080/FlightApp/routes
``

### Get a route by ID
``
GET - http://localhost:8080/FlightApp/routes/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/routes/1 |

### Delete a route by ID
``
DELETE - http://localhost:8080/FlightApp/routes/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/routes/1 |


## Food
### Create food
``
POST - http://localhost:8080/FlightApp/food
``
- JSON-body
```
{
	"food": "Yes"
}
```

### Get all food
``
GET - http://localhost:8080/FlightApp/food
``

### Get food by ID
``
GET - http://localhost:8080/FlightApp/food/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/food/1 |

### Delete food by ID
``
DELETE - http://localhost:8080/FlightApp/food/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/food/1 |

## Workers
### Create a new worker
``
POST - http://localhost:8080/FlightApp/workers
``
- JSON-body
```
{
	"pilot": 2,
	"flightAttendant": 7
}
```

### Get all workers
``
GET - http://localhost:8080/FlightApp/workers
``

### Get worker by ID
``
GET - http://localhost:8080/FlightApp/workers/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/workers/1 |

### Delete worker by ID
``
DELETE - http://localhost:8080/FlightApp/workers/{id}
``
| Example |
| --- |
| localhost:8080/FlightApp/workers/1 |
