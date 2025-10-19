import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

public class Cliente_HTTP {
    URL url;
    BufferedReader in;
    //CASO a)
    void getDocumentSocket(String u)
    {
        try
        {
            URL url = new URL(u);
            String host = url.getHost();
            String path = url.getPath().isEmpty() ? "/" : url.getPath();
            int port = url.getPort() == -1 ? 80 : url.getPort(); // Puerto 80 para HTTP por defecto

            System.out.println("\n--- Contenido obtenido usando java.net.Socket ---");
            System.out.println("Conectando a: " + host + ":" + port + path);

            //Abrir el Socket y streams
            try (Socket socket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                //Enviar la Petición HTTP GET
                out.println("GET " + path + " HTTP/1.1");
                out.println("Host: " + host);
                out.println("Connection: Close"); // Pide al servidor cerrar la conexión después de la respuesta
                out.println(""); // Línea vacía final OBLIGATORIA para terminar la cabecera

                //Leer la Respuesta completa (cabeceras + cuerpo)
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }

        } catch (IOException e) {
            System.err.println("Error de conexión/lectura con Socket: " + e.getMessage());
        }
    }
    //CASO b)
    void getDocument_URL(String u)
    {
        try
        {
            url = new URL(u);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        }
        catch(IOException e)
        {
            System.out.printf("Error al leer de la URL.");
            e.printStackTrace();
        }
    }
}






