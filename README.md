## Flightplanning - Laboration
Laboration with myself, Hans, Gustaf and Athanasios.

## Endpoints
- [Users](#users)
- [Customers](#customers)
- [Roles](#roles)
- [Routes](#routes)
- [Airplanes](#airplanes)
- [Protections](#protections)
- [Food](#food)
- [Workers](#workers)
---
## Users

## Customers

## Roles

## Routes
### Create a new route
``
POST - http://localhost:8080/routes
``
- JSON-body
```
{
	"routeName": "Gbg-Sthlm"
}
```
### Get all routes
``
GET - http://localhost:8080/routes
``

## Airplanes
### Create a new airplane
``
POST - http://localhost:8080/airplanes
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
GET - http://localhost:8080/airplanes
``

### Get a airplane by ID
``
GET - http://localhost:8080/airplanes/{id}
``
| Example |
| --- |
| localhost:8080/airplanes/1 |

### Delete a airplane by ID
``
DELETE - http://localhost:8080/airplanes/{id}
``
| Example |
| --- |
| localhost:8080/airplanes/1 |

## Protections
### Create a new protection
``
POST - http://localhost:8080/cancellationprotections
``
- JSON-body
```
{
	"protection": "Yes"
}
```

### Get all protections
``
GET - http://localhost:8080/cancellationprotections
``

### Delete protection by ID
``
DELETE - http://localhost:8080/cancellationprotections/{id}
``
| Example |
| --- |
| localhost:8080/cancellationprotections/1 |

## Food
### Create food
``
POST - http://localhost:8080/food
``
- JSON-body
```
{
	"food": "Yes"
}
```

### Get all food
``
GET - http://localhost:8080/food
``

### Get food by ID
``
GET - http://localhost:8080/food/{id}
``
| Example |
| --- |
| localhost:8080/food/1 |

### Delete food by ID
``
DELETE - http://localhost:8080/food/{id}
``
| Example |
| --- |
| localhost:8080/food/1 |

## Workers
### Create a new worker
``
POST - http://localhost:8080/workers
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
GET - http://localhost:8080/workers
``

### Delete worker by ID
``
DELETE - http://localhost:8080/workers/{id}
``
| Example |
| --- |
| localhost:8080/workers/1 |
