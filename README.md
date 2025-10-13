# 💻 Proyecto de Microservicios en Java (Spring Boot)

## UEA: Proyecto de Ingeniería de Software II

Este repositorio contiene la implementación práctica y los ejemplos fundamentales de la arquitectura de **Microservicios** utilizando **Java** y el framework **Spring Boot**. El objetivo es demostrar los conceptos teóricos de **desacoplamiento, autonomía, resiliencia** y **escalabilidad** cubiertos en la asignatura.

---

## 👥 Datos del Proyecto

| Rol | Nombre |
| :--- | :--- |
| **Alumno** | José Eduardo Campuzano Corona |
| **Profesor** | Dr. Netz Romero |
| **Asignatura** | Proyecto de Ingeniería de Software II |

---

## 🛠️ Tecnologías Utilizadas

| Componente | Herramienta/Versión | Propósito |
| :--- | :--- | :--- |
| **Lenguaje** | Java 25 (Seleccionado) | Base para el desarrollo de la lógica de negocio. |
| **Framework** | Spring Boot 3.5.6 (Seleccionado) | Simplifica la creación de aplicaciones *stand-alone* y RESTful. |
| **Gestor de Compilación** | Gradle / Maven | Manejo de dependencias y empaquetamiento (`.jar`). |
| **IDE** | Visual Studio Code | Entorno de desarrollo ligero y adaptable para múltiples microservicios. |
| **Arquitectura** | RESTful APIs | Comunicación síncrona fundamental. |

---

## 📝 Estructura y Microservicio Inicial (`hola-microservicio`)

Este repositorio inicia con el microservicio **`hola-microservicio`**, el cual sirve como prueba de concepto para la configuración y *build* de Spring Boot.

### 1. Funcionalidad Implementada

* **Objetivo:** Recibir una petición `GET` y responder con un saludo personalizado.
* **Componente Clave:** `HolaController.java` (Anotado con `@RestController` y `@GetMapping`).
* **Principio Demostrado:** **Autonomía** y **Comunicación Síncrona**.

### 2. Endpoint de Prueba

| Método | Ruta | Parámetros | Respuesta Ejemplo |
| :--- | :--- | :--- | :--- |
| **GET** | `/saludar` | `nombre` (opcional, por defecto "Invitado") | `¡Hola, Jose! Tu microservicio está corriendo.` |

**URL de Prueba:**

http://localhost:8080/saludar?nombre=Jose

---

## 🚀 Cómo Ejecutar el Microservicio

### Requisitos Previos

* **JDK 25** (o 21/17)
* **Git**
* **Visual Studio Code** con las Extensiones de Java y Spring Boot.

### Pasos de Ejecución

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://aws.amazon.com/es/what-is/repo/](https://aws.amazon.com/es/what-is/repo/)
    cd hola-microservicio
    ```

2.  **Compilación (Maven - si es el caso):**
    ```bash
    ./mvnw clean install
    ```

3.  **Ejecución:**
    Ejecutar la clase principal `HolaMicroservicioApplication.java` desde su IDE.

4.  **Prueba Final:**
    Acceda a la URL de prueba en su navegador o herramienta REST (como Postman).

---

## 🗓️ Próximos Pasos

La evolución del proyecto se enfocará en la implementación de patrones avanzados:

* Integración de un **API Gateway**.
* Implementación del **Patrón Circuit Breaker** para la **Resiliencia**.
* Uso de **Mensajería Asíncrona** (Event-Driven Architecture).