package controlador;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import model.AuthorizationM;
import model.ProducteM;
import util.GestorErrors;

// Classe encarregada de gestionar les operacions relacionades amb els productes mitjançant crides a l'API
public class ProducteC {
    
    // Mètode per obtenir els productes mitjançant una crida GET a l'API
    public ProducteM getProductes() {

        try {
            // Obté la instància de la classe AuthorizationM (gestora de tokens)
            AuthorizationM authInstance = AuthorizationM.getInstance();

            // Obtinguem el token d'autenticació
            String token = authInstance.getToken();

            // Imprimeix el token per a propòsits de depuració
            System.out.println("userToken is " + token);

            // Fes una crida GET per obtenir l'array de Producte a través de l'API
            String apiUrl = "https://qpos.onrender.com/api/productes/";
            URL urlProductes = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) urlProductes.openConnection();
            conn.setRequestMethod("GET");

            // Estableix l'autorització mitjançant el token obtingut
            conn.setRequestProperty("Authorization", "Token " + token);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Utilitza try-with-resources per gestionar el tancament automàtic del Scanner
                try (Scanner scanner = new Scanner(conn.getInputStream())) {
                    // Llegeix la resposta JSON i construeix un array de Producte
                    StringBuilder sb = new StringBuilder();
                    while (scanner.hasNext()) {
                        sb.append(scanner.nextLine());
                    }

                    ObjectMapper objMapper = new ObjectMapper();
                    ProducteM[] productes = objMapper.readValue(sb.toString(), new TypeReference<ProducteM[]>() {
                    });

                    // Retorna els productes com un model de ProducteM
                    return new ProducteM(productes);
                }
            } else {
                // En cas d'error en la crida, mostra un missatge d'error
                GestorErrors.displayError("Failed to retrieve product data. HTTP Error Code: " + responseCode);
            }
        } catch (IOException e) {
            // Gestiona els errors d'IO mostrant-los a la consola
            GestorErrors.logError("IO Exception during product retrieval", e);
        }

        // Retorna null si hi ha hagut problemes en l'execució
        return null;
    }
}