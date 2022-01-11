## Flightplanning - Laboration
Laboration with myself, Hans, Gustaf and Athanasios.

## Token for testing
eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik53V1VsWko4azRoUTdOTkE4akZrTCJ9.eyJpc3MiOiJodHRwczovL2Rldi1zNzk0b2ZuNC51cy5hdXRoMC5jb20vIiwic3ViIjoiYTJTdkRibDQ4WlJTMTdhMzR4SDhrUm5FVW4xNzhaRmpAY2xpZW50cyIsImF1ZCI6Imh0dHBzOi8vRmxpZ2h0QXBwLyIsImlhdCI6MTY0MTkwNTE1OCwiZXhwIjoxNjQxOTkxNTU4LCJhenAiOiJhMlN2RGJsNDhaUlMxN2EzNHhIOGtSbkVVbjE3OFpGaiIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyJ9.vqZEInH0x1M7MNxhi2m8Aw5H2DeMxOEz8sksIXiLyD2lEDTEwopQWUdFqiQgfrqDG0Pxi49eYDbmc3je_YtdTDNCRVnf410gvVXcGaoIwUeDiscIInbsf685GOlqIQTmYrHDl_uLo5oL0QGEOu5GidhIDw6dWHYwk_xVYKTnZoW5sjX0ungzAVDkib-PStMVbXE3D6XTzuL4i8MfnB4ehIE0CU0G6Ng7c3nOSTHQhG1nccCTrMCJkT1JtjcnYmE1ULf3e_-E4Hh7voHUEgOI0HpOpxmDtV8P8q7DkB3F-eWi_25ZUHV3DWCYL9w4_AOJh8yPico-t96qV3UFUK3YYQ

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
