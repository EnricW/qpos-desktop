package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import model.AuthorizationM;
import model.CompraM;
import util.GestorErrors;

/**
 *
 * @author Enric
 */
public class CompraC {

    public void creaCompra(CompraM compra) {
        try {
            // Obté la instància de la classe AuthorizationM (gestora de tokens)
            AuthorizationM authInstance = AuthorizationM.getInstance();

            // Obtinguem el token d'autenticació
            String token = authInstance.getToken();

            // Preparem URL per la petició POST
            URL urlCompras = new URL("https://qpos.onrender.com/api/compres/");
            HttpURLConnection conn = (HttpURLConnection) urlCompras.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Estableix l'autorització mitjançant el token obtingut
            conn.setRequestProperty("Authorization", "Token " + token);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept", "application/json");

            // Converteix el objecte Compra a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String compraJson = objectMapper.writeValueAsString(compra);
            
            System.out.println(compra);

            // Envia petició a la API
            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(compraJson);
            }

            System.out.println(compraJson);
            
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Compra creada correctament");
            } else {
                GestorErrors.handleHttpError(conn);
            }
        } catch (IOException e) {
            GestorErrors.handleIOException(e);
        }
    }
}
