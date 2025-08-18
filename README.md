# personas-backend-java

Este proyecto es un servicio RESTful desarrollado con Jakarta EE y GlassFish para la gestión de datos de personas. Actúa como una capa de backend para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una entidad Persona, exponiendo una API clara y sencilla para cualquier cliente.

---

## 🚀 Tecnologías y Dependencias

* **Java 21**: Lenguaje de programación principal.
* **Jakarta EE 11.0.0-M1**: Conjunto de APIs para el desarrollo de aplicaciones empresariales, incluyendo JAX-RS para los servicios REST.
* **GlassFish Server**: Servidor de aplicaciones utilizado para desplegar el proyecto.
* **Maven**: Herramienta de gestión de proyectos y dependencias.
* **Jersey**: Implementación de referencia de JAX-RS para la creación del cliente.

---

## ⚙️ Estructura de la API

La API REST se accede a través de la URL base: `http://localhost:8080/personas-backend-java/webservice/personas`.

A continuación se detallan los endpoints disponibles y sus funcionalidades.

### ➡️ 1. Obtener todas las personas
* **Método**: `GET`
* **URL**: `/`
* **Descripción**: Recupera una lista completa de todas las personas registradas.
* **Ejemplo de Respuesta (JSON)**:
    ```json
    [
      {
        "idPersona": 1,
        "nombre": "Juan"
      },
      {
        "idPersona": 2,
        "nombre": "Maria"
      }
    ]
    ```

### ➡️ 2. Obtener una persona por ID
* **Método**: `GET`
* **URL**: `/{id}`
* **Descripción**: Obtiene los detalles de una persona específica usando su ID.
* **Ejemplo de Uso**: `http://localhost:8080/personas-backend-java/webservice/personas/57`
* **Ejemplo de Respuesta (JSON)**:
    ```json
    {
      "idPersona": 57,
      "nombre": "marcos"
    }
    ```

### ➡️ 3. Agregar una nueva persona
* **Método**: `POST`
* **URL**: `/`
* **Descripción**: Crea un nuevo registro de persona en la base de datos.
* **Ejemplo de Cuerpo de Solicitud (JSON)**:
    ```json
    {
      "nombre": "Pedro"
    }
    ```
* **Ejemplo de Respuesta (JSON)**:
    ```json
    {
      "idPersona": 58,
      "nombre": "Pedro"
    }
    ```

### ➡️ 4. Modificar una persona
* **Método**: `PUT`
* **URL**: `/{id}`
* **Descripción**: Actualiza la información de una persona existente. El ID en la URL y en el cuerpo de la solicitud deben coincidir.
* **Ejemplo de Uso**: `http://localhost:8080/personas-backend-java/webservice/personas/57`
* **Ejemplo de Cuerpo de Solicitud (JSON)**:
    ```json
    {
      "idPersona": 57,
      "nombre": "Marcos Javier"
    }
    ```

### ➡️ 5. Eliminar una persona
* **Método**: `DELETE`
* **URL**: `/{id}`
* **Descripción**: Elimina un registro de persona de la base de datos.
* **Ejemplo de Uso**: `http://localhost:8080/personas-backend-java/webservice/personas/57`
* **Ejemplo de Respuesta**: El servicio retornará un código de éxito si la eliminación fue correcta.

---

## 🧪 Pruebas con Postman

Para probar los endpoints, puedes utilizar Postman. A continuación, se describen los pasos para cada operación.

1.  Abre Postman y crea una nueva solicitud.
2.  Asegúrate de que la aplicación esté desplegada en tu servidor GlassFish.

* **GET /personas**
    * **Método**: `GET`
    * **URL**: `http://localhost:8080/personas-backend-java/webservice/personas`
    * Haz clic en **Send**.

* **GET /personas/{id}**
    * **Método**: `GET`
    * **URL**: `http://localhost:8080/personas-backend-java/webservice/personas/57`
    * Haz clic en **Send**.

* **POST /personas**
    * **Método**: `POST`
    * **URL**: `http://localhost:8080/personas-backend-java/webservice/personas`
    * En la pestaña **Body**, selecciona `raw` y el tipo `JSON`.
    * Pega el JSON del ejemplo en el cuerpo y haz clic en **Send**.

* **PUT /personas/{id}**
    * **Método**: `PUT`
    * **URL**: `http://localhost:8080/personas-backend-java/webservice/personas/57`
    * En la pestaña **Body**, selecciona `raw` y el tipo `JSON`.
    * Pega el JSON con los datos actualizados y haz clic en **Send**.

* **DELETE /personas/{id}**
    * **Método**: `DELETE`
    * **URL**: `http://localhost:8080/personas-backend-java/webservice/personas/57`
    * Haz clic en **Send**. El servicio retornará un código de éxito si la eliminación fue correcta.
