FROM debian:bullseye AS builder

RUN apt-get update && \
    apt-get install -y build-essential libmicrohttpd-dev

WORKDIR /app

# Copia TODOS los archivos .c (solo debería haber uno)
COPY *.c .

# Compila el primer archivo .c que encuentra y lo nombra 'calculador'
RUN gcc *.c -o calculador -lmicrohttpd

# Etapa 2: Ejecución (Run)
FROM debian:bullseye-slim
WORKDIR /app

RUN apt-get update && \
    apt-get install -y libmicrohttpd12 && \
    rm -rf /var/lib/apt/lists/*

# Copia el binario compilado
COPY --from=builder /app/calculador .
EXPOSE 8081
CMD ["./calculador"]