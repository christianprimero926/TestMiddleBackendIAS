| Método | URL                | Descripción                     |
|--------|--------------------|---------------------------------|
| POST   | /api/technicians   | Crear un técnico                |
| POST   | /api/services      | Crear un servicio               |
| GET    | /api/services      | Listar servicios con paginación |
| GET    | /api/services/{id} | Obtener un servicio específico  |

1. Endpoint para Crear un Técnico
   URL: POST /api/technicians
   Descripción: Crea un nuevo técnico.
   Request Body:

~~~json   
    {
      "name": "Nombre del Técnico"
    }
~~~

Response:

   ~~~json
    {
      "data": {
        "id": 1,
        "name": "Nombre del Técnico"
      },
      "status": 201,
      "message": "Técnico creado exitosamente"
    }
   ~~~

2. Endpoint para Crear un Servicio
   URL: POST /api/services
   Descripción: Crea un nuevo servicio asignado a un técnico específico.
   Request Body:
   ~~~json
   {
       "address": "Dirección del Servicio",
       "description": "Descripción del Servicio",
       "startDateTime": "2024-10-30T09:00:00",
       "endDateTime": "2024-10-30T18:00:00",
       "technicianId": 1
   }
   ~~~
   Response:
   ~~~json
   
   {
       "data": {
           "id": 1,
           "address": "Dirección del Servicio",
           "description": "Descripción del Servicio",
           "startDateTime": "2024-10-30T09:00:00",
           "endDateTime": "2024-10-30T18:00:00",
           "technician": {
              "id": "technician-id"
           }
       },
       "status": 201,
       "message": "Servicio creado exitosamente"
   }
   ~~~
   3. Endpoint para Listar Servicios con Paginación
      URL: GET /api/services
      Descripción: Obtiene una lista de servicios con soporte de paginación.
      Query Parameters:
      page: Número de página (por defecto: 0).
      size: Tamaño de la página (por defecto: 10).
      Response:
      ~~~json   
      {
          "data": [
          {
              "id": 1,
              "address": "Dirección del Servicio",
              "description": "Descripción del Servicio",
              "startDateTime": "2024-10-30T09:00:00",
              "endDateTime": "2024-10-30T18:00:00",
              "technicianId": 1
          },
          {
              "id": 2,
              "address": "Otra Dirección",
              "description": "Otra Descripción",
              "startDateTime": "2024-10-31T09:00:00",
              "endDateTime": "2024-10-31T18:00:00",
              "technicianId": 2
          }
          ],
          "status": 200,
          "message": "Respuesta ok"
      }
      ~~~
4. Endpoint para Obtener un Servicio Específico
   URL: GET /api/services/{id}
   Descripción: Obtiene los detalles de un servicio específico.
   Path Variable:
   id: ID del servicio que deseas consultar.
   Response:
   ~~~json
   {   
    "data": {
      "id": 1,
      "address": "Dirección del Servicio",
      "description": "Descripción del Servicio",
      "startDateTime": "2024-10-30T09:00:00",
      "endDateTime": "2024-10-30T18:00:00",
      "technicianId": 1
    },
    "status": 200,
    "message": "Servicio encontrado exitosamente"
   }
   ~~~