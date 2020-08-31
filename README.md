# test2_bogota

###### **Punto 3** 
Iniciar contenedor de base de datos postgres:

sudo docker-compose up   (dentro de test2_bogota)

iniciar aplicación java:

./mvnw spring-boot:run -e  (dentro de test2_bogota/app)


* crear location:

petición POST al recurso "http://localhost:8080/api/v1/location"
enviando JSON con la forma: 
{
	"name": "Cali",
	"area_m2": "2664.467"
}

* obtener todos los location:

petición GET al recurso "http://localhost:8080/api/v1/location"

* obtener location por medio del id:

petición GET al recurso "http://localhost:8080/api/v1/location/{ID}"  (reemplazar "{ID}" por el id del location)

* editar location:

petición PUT al recurso "http://localhost:8080/api/v1/location/{ID}"  (reemplazar "{ID}" por el id del location)
enviando JSON con la forma:
{
	"name": "Cali edited"
}

Eliminar location:

petición DELETE al recurso "http://localhost:8080/api/v1/location/{ID}" (reemplazar "{ID}" por el id del location)

