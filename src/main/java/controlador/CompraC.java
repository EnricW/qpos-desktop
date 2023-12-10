package controlador;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import model.AuthorizationM;
import model.CompraM;
import model.LiniaCompraM;
import model.novaCompraM;
import model.novaLiniaCompraM;
import util.GestorErrors;

/**
 *
 * @author Enric
 */
public class CompraC {

    public void creaCompra(novaCompraM compra) {
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

    // New method for getting purchases (Compres)
    public List<CompraM> getCompres() {
        try {
            // Obtain the instance of the AuthorizationM class (token manager)
            AuthorizationM authInstance = AuthorizationM.getInstance();

            // Get the authentication token
            String token = authInstance.getToken();

            // Make a GET request to obtain the array of Compres through the API
            String apiUrl = "https://qpos.onrender.com/api/compres/";
            URL urlCompres = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) urlCompres.openConnection();
            conn.setRequestMethod("GET");

            // Set authorization using the obtained token
            conn.setRequestProperty("Authorization", "Token " + token);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Use try-with-resources to manage the automatic closure of the Scanner
                try (Scanner scanner = new Scanner(conn.getInputStream())) {
                    StringBuilder response = new StringBuilder();
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        response.append(line).append("\n");
                    }

                    // Print the raw JSON response
                    System.out.println("Raw JSON Response:");
                    System.out.println(response.toString());

                    ObjectMapper objMapper = new ObjectMapper();

                    List<CompraM> compres = objMapper.readValue(response.toString(), new TypeReference<List<CompraM>>() {
                    });

                    // Return the list of novaCompraM
                    return compres;
                }
            } else {
                // In case of an error in the call, display an error message
                GestorErrors.displayError("Unable to retrieve purchase data. HTTP Error Code: " + responseCode);
            }
        } catch (IOException e) {
            // Handle IO errors by logging them to the console
            GestorErrors.logError("IO Exception during the retrieval of purchases", e);
        }

        // Return an empty list if there were problems during execution
        return Collections.emptyList();
    }

    public void printCompras(List<CompraM> compras) {
        for (CompraM compra : compras) {
            System.out.println("Compra ID: " + compra.getId());
            System.out.println("Data: " + compra.getData());
            System.out.println("Client ID: " + compra.getClient().getNom() + " " + compra.getClient().getCognoms());
            System.out.println("Treballador ID: " + compra.getTreballador().getNom() + " " + compra.getTreballador().getCognoms());
            System.out.println("Metode de Pagament: " + compra.getMetodePagament());
            //System.out.println("Diners Entregats: " + compra.getDinersEntregats());
            //System.out.println("Diners Canvi: " + compra.getDinersCanvi());
            //System.out.println("Descompte: " + compra.getDescompte());

            // Print Linies
            LiniaCompraM[] linies = compra.getLiniesCompra();

            // Check if linies is not null before iterating
            if (linies != null) {
                System.out.println("Linies de Compra:");
                for (LiniaCompraM linia : linies) {
                    System.out.println("  Producte: " + linia.getProducte().getNom());                    
                    System.out.println("  Preu: " + linia.getProducte().getPreu());
                    System.out.println("  Quantitat: " + linia.getQuantitat());
                }
            }
            
            System.out.println("Import final: " + compra.getImportFinal());

            System.out.println("------------------------------------");
        }
    }
}
