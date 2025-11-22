#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>     
#include <microhttpd.h>

#define PORT 8081

static enum MHD_Result answer_to_connection(void *cls, struct MHD_Connection *connection,
                                            const char *url, const char *method,
                                            const char *version, const char *upload_data,
                                            size_t *upload_data_size, void **con_cls) {
    
    // Todos aceptan GET en /operar
    if (0 != strcmp(method, "GET") || 0 != strcmp(url, "/operar")) {
        return MHD_NO; 
    }

    const char *num1_str = MHD_lookup_connection_value(connection, MHD_GET_ARGUMENT_KIND, "num1");
    const char *num2_str = MHD_lookup_connection_value(connection, MHD_GET_ARGUMENT_KIND, "num2");

    char response_buffer[256];
    struct MHD_Response *response;
    enum MHD_Result ret;

    if (num1_str == NULL || num2_str == NULL) {
    } else {
        double num1 = atof(num1_str); // Usamos double (atof)
        double num2 = atof(num2_str);
        
        double resultado = num1 * num2;

        sprintf(response_buffer, "%.2f", resultado); // Responder con 2 decimales
        
        response = MHD_create_response_from_buffer(strlen(response_buffer),
                                                   (void *)response_buffer, MHD_RESPMEM_MUST_COPY);
        MHD_add_response_header(response, "Content-Type", "text/plain");
        ret = MHD_queue_response(connection, MHD_HTTP_OK, response);
    }

    MHD_destroy_response(response);
    return ret;
}

int main() {
    struct MHD_Daemon *daemon;
    daemon = MHD_start_daemon(MHD_USE_SELECT_INTERNALLY, PORT, NULL, NULL,
                              &answer_to_connection, NULL, MHD_OPTION_END);
    if (NULL == daemon) { return 1; }
    printf("Servicio C (Calculador Multiplicacion) escuchando en puerto %d\n", PORT);
    fflush(stdout);
    while(1) { sleep(1000); }
    MHD_stop_daemon(daemon);
    return 0;
}