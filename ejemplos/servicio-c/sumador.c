#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h> 
#include <microhttpd.h>

#define PORT 8081

// Esta función para manejar la conexión está perfecta, no se cambia
static enum MHD_Result answer_to_connection(void *cls, struct MHD_Connection *connection,
                                            const char *url, const char *method,
                                            const char *version, const char *upload_data,
                                            size_t *upload_data_size, void **con_cls) {
    
    if (0 != strcmp(method, "GET") || 0 != strcmp(url, "/sumar")) {
        return MHD_NO; // Ruta no encontrada
    }

    const char *num1_str = MHD_lookup_connection_value(connection, MHD_GET_ARGUMENT_KIND, "num1");
    const char *num2_str = MHD_lookup_connection_value(connection, MHD_GET_ARGUMENT_KIND, "num2");

    char response_buffer[256];
    struct MHD_Response *response;
    enum MHD_Result ret;

    if (num1_str == NULL || num2_str == NULL) {
        sprintf(response_buffer, "Error: Faltan parametros 'num1' o 'num2'");
        response = MHD_create_response_from_buffer(strlen(response_buffer),
                                                   (void *)response_buffer, MHD_RESPMEM_MUST_COPY);
        ret = MHD_queue_response(connection, MHD_HTTP_BAD_REQUEST, response);
    } else {
        int num1 = atoi(num1_str);
        int num2 = atoi(num2_str);
        int suma = num1 + num2;
        
        sprintf(response_buffer, "%d", suma);
        
        response = MHD_create_response_from_buffer(strlen(response_buffer),
                                                   (void *)response_buffer, MHD_RESPMEM_MUST_COPY);
        MHD_add_response_header(response, "Content-Type", "text/plain");
        ret = MHD_queue_response(connection, MHD_HTTP_OK, response);
    }

    MHD_destroy_response(response);
    return ret;
}

// ----- FUNCIÓN MAIN CORREGIDA -----
int main() {
    struct MHD_Daemon *daemon;

    daemon = MHD_start_daemon(MHD_USE_SELECT_INTERNALLY, PORT, NULL, NULL,
                              &answer_to_connection, NULL, MHD_OPTION_END);
    if (NULL == daemon) {
        printf("Error al iniciar el demonio de C\n");
        return 1;
    }

    printf("Servidor C escuchando en http://localhost:%d\n", PORT);

    pause(); 

    MHD_stop_daemon(daemon);
    return 0;
}