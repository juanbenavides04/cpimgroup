Uso de postman

primero debe crear el usuario
}http://localhost:8081/api/save

{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.org",
"password": "hunter2",
"phones": [
            {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
            },
             {
            "number": "1234567",
            "citycode": "2",
            "contrycode": "57"
            }
        ]
}

////////////////////////////////////////////////////////////////////////
ahora hay que obtener el token
http://localhost:8081/api/login

{  
    "email":"juan@rodriguez.org",
    "password":"hunter2"
}

////////////////////////////////////////////////////////////////////////
Para acceder a los demas endpoint como delete, all, buscarid y update
hay que shacer esto

se dirige a Authorization -> Type coloca Bearer token -> copia el token asi podra tener acceso a los demas endpoint
de lo contrario no podras acceder a los endpoint.

Metodo Get
http://localhost:8081/api/buscarid/1

Metodo Put
http://localhost:8081/api/update

{
"id": 1,    
"name": "Juan Rodriguez update",
"email": "juan@rodriguez.org",
"password": "hunter2",
"phones": [
            {
            "id": 1,
            "number": "1234567 update",
            "citycode": "1",
            "contrycode": "57"
            },
             {
            "id": 2,
            "number": "1234567 update",
            "citycode": "2",
            "contrycode": "57"
            }
        ]
}
Metodo Get
http://localhost:8081/api/all

Metodo delete
http://localhost:8081/api/delete/1


