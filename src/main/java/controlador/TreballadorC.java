package controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import model.TreballadorM;
import util.GestorErrors;

/**
 *
 * @author Enric
 */
public class TreballadorC {

    /**
     * Mètode per afegir un treballador mitjançant una crida POST a l'API
     *
     * @param treballador
     */
    public void afegeixTreballador(TreballadorM treballador) {
        try {

            // Preparem URL per la petició POST
            URL urlProductes = new URL("https://qpos.onrender.com/api/signup/treballadors/");
            HttpURLConnection conn = (HttpURLConnection) urlProductes.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept", "application/json");

            // Converteix el objecte Treballador a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String treballadorJson = objectMapper.writeValueAsString(treballador);
            
            System.out.println(treballadorJson);

            // Envia petició a la API
            try (DataOutputStream dos2 = new DataOutputStream(conn.getOutputStream())) {
                dos2.writeBytes(treballadorJson);
            }

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Treballador afegit correctament");
            } else {
                GestorErrors.handleHttpError(conn);
            }
        } catch (IOException e) {
            GestorErrors.handleIOException(e);
        }
    }
}
