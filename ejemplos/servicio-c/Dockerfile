# Etapa 1: Compilación (Build)
FROM debian:bullseye AS builder

RUN apt-get update && \
    apt-get install -y build-essential libmicrohttpd-dev

WORKDIR /app
COPY sumador.c .
RUN gcc sumador.c -o sumador -lmicrohttpd

# Etapa 2: Ejecución (Run)
FROM debian:bullseye-slim
WORKDIR /app

RUN apt-get update && \
    apt-get install -y libmicrohttpd12 && \
    rm -rf /var/lib/apt/lists/*

COPY --from=builder /app/sumador .
EXPOSE 8081
CMD ["./sumador"]