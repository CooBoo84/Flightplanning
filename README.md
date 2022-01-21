## Flightplanning - Laboration
Laboration with myself, Hans, Gustaf and Athanasios.

All endpoints are unlocked för all to use.
But when you are going to handle with airplane endpoints. You need to be authorized first.
After authorized, you have to use your token as "Bearer Token" for it to work.

## Artifact download link

[https://github.com/CooBoo84/Flightplanning/packages/1142536](https://github.com/CooBoo84/Flightplanning/packages/1142536)

## CI link with test reports in maven build

[https://github.com/CooBoo84/Flightplanning/actions](https://github.com/CooBoo84/Flightplanning/actions)

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
GET - http://localhost:8080/FlightApp/users/entity
``
### Get all users (dto)
``
GET - http://localhost:8080/FlightApp/users/dto
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
POST - http://localhost:8080/FlightApp/auth/signin
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

## Airplanes
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
### Get all airplanes (dto)
``
GET - http://localhost:8080/FlightApp/airplanes/dto
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
### Get all routes (dto)
``
GET - http://localhost:8080/FlightApp/routes/dto
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
### Get all food (dto)
``
GET - http://localhost:8080/FlightApp/food/dto
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
### Get all workers (dto)
``
GET - http://localhost:8080/FlightApp/workers/dto
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
