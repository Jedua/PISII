# ----- Etapa 1: Compilación (Build) -----
# Usamos la imagen oficial de Maven con JDK 21 para compilar
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos solo los archivos de definición del proyecto
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#Agregamos esta linea para permisos en linux
RUN chmod +x ./mvnw

# Descargamos todas las dependencias (esto se cachea si pom.xml no cambia)
RUN ./mvnw dependency:go-offline

# Copiamos el resto del código fuente y construimos el JAR
COPY src ./src
# -DskipTests omite la ejecución de tests para una build más rápida
RUN ./mvnw package -DskipTests


# ----- Etapa 2: Ejecución (Run) -----
# Usamos una imagen ligera que solo tiene Java 21 para correr
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copiamos el JAR compilado desde la etapa 'builder'
# OJO: El nombre del JAR debe coincidir con tu 'pom.xml' (ArtifactId)
COPY --from=builder /app/target/calculadora-poliglota-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080 (el que definimos en application.properties)
EXPOSE 8080

# Comando para correr la aplicación cuando inicie el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]