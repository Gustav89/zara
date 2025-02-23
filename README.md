#  API de Precios Zara
##  Descripción
 API desarrollada con **Spring Boot** que permite obtener el precio de un producto en función de una fecha de aplicacion
 ### Tecnologías utilizadas
- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Security
- Swagger OpenAPI 3
- JUnit 5 (para pruebas)
- Docker (opcional)
---
 📂 Estructura del Proyecto
---
**src/main/java/com/zara**
 - /config # Configuración de seguridad y Aspects
 - /controller # Controlador REST
 -  /dto # Objetos de transferencia de datos (DTO)
 -  /exception # Manejo de excepciones personalizadas
 -  /model # Modelos de entidad
 -  /repository # Repositorios JPA
 -  /service # Lógica de negocio
---
##  Instalación y ejecución
###  1. Clonar el repositorio
```bash
git clone https://github.com/Gustav89/zara.git
cd zara
```
###  2. Configurar el archivo 
**application.properties**
 `src/main/resources/application.properties`

###  3. Compilar y ejecutar la aplicación
Ejecuta los siguientes comandos:
```bash
# Compilar el proyecto
mvn clean install
# Ejecutar la aplicación
mvn spring-boot:run
```
---
##  Autenticación
Esta API usa **autenticación básica** (usuario y contraseña) en cada solicitud.
**Credenciales por defecto:**
- **Usuario:** `admin`
- **Contraseña:** `03188378-52ea-41c3-9fdb-2ded4607f12f`

### Pruebas de integracion con postman ###

el archivo de la coleccion de postman se encuentra en resources/postman
- Capitole.postman_collection.json
- Capitole.postman_environment.json


# Ejecución de Tests en Postman

Para ejecutar la batería de tests, es necesario tener el proyecto en funcionamiento, ya sea a través de Docker, Maven o directamente desde el editor.

Los tests están completamente integrados en Postman, y para ejecutarlos debes seguir estos pasos:

## 1. Importar la colección y el environment
Es fundamental importar tanto la colección como el environment en Postman, ya que este último contiene las variables necesarias para la autenticación.

## 2. Ejecutar la colección de tests
- Dirígete a la sección **Collections** en Postman.
- Haz clic en los tres puntos de la colección y selecciona **Run collection** como se muestra en la siguiente imagen:

  ![Paso 2](../zara/src/main/resources/images/paso1_tests.png)

## 3. Configurar la ejecución
- Define el tiempo de espera entre solicitudes en milisegundos (en nuestro caso, 5 ms).
- Presiona el botón **Run Capitole**.

  ![Paso 3](../zara/src/main/resources/images/paso2_tests.png)

## 4. Validar la ejecución de los tests
- Una vez finalizada la ejecución, verifica que los tests se hayan completado exitosamente.
- Deberían ejecutarse **30 tests** y todos deben estar validados.

  ![Paso 4](../zara/src/main/resources/images/paso3_tests.png)


#### Ejemplo de autenticación en Postman: ####
1. Ir a la pestaña **Authorization**.
2. Seleccionar **Basic Auth**.
3. Ingresar usuario y contraseña.
4. Enviar la solicitud.
---
##  Uso de la API
###  **Obtener el precio de un producto**
**GET** `/api/v1/prices`
#### **Parámetros (query)**
| Parámetro | Tipo | Requerido | Descripción |
|-------------------|--------|-----------|----------------------------------------|
| `applicationDate` | string | ✅      | Fecha de consulta (Formato: `yyyy-MM-dd HH:mm:ss`) |
| `productId` | int | ✅         | ID del producto |
| `brandId` | int | ✅         | ID de la marca (Ejemplo: `1` = Zara) |
#### **Respuesta (200 OK)**
```json
{
 "brandId": 1,
 "startDate": "2020-06-14T00:00:00.000+00:00",
 "endDate": "2020-12-31T23:59:59.000+00:00",
 "priceList": 1,
 "productId": 35455,
 "price": 35.5,
 "curr": "EUR"
}
```
#### **Posibles errores**
| Código | Descripción |
|--------|------------|
| `400` | Parámetros inválidos |
| `401` | No autenticado |
| `404` | Precio no encontrado |
---
##  Documentación con Swagger
La documentación de la API está disponible en:
en ./Zara - API de Precios.yaml
---
##  Despliegue con Docker (Opcional)
###  1. Construir la imagen y contenedor de Docker
```bash
# si no fue compilada en el paso 3  
# Compilar el proyecto
# Ejecutar docker compose
docker compose up
```

Ahora la API estará disponible en `http://localhost:8081`.
---
##  Pruebas Unitarias
Para ejecutar las pruebas unitarias con **JUnit 5**, usa:
```bash
mvn test
```
---
##  Contacto
- Email: [alvarezgustavomatias@gmail.com](mailto:alvarezgustavomatias@gmail.com)
- GitHub: [Gustav89](https://github.com/Gustav89)
---
 **Desarrollado con Intelij por Gustavo Matias Alvarez**