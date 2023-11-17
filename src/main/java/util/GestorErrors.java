/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 *
 * @author sardineta_fresca
 */
public class GestorErrors {

    public static void logError(String message, Exception exception) {
        System.err.println("Error: " + message);
        if (exception != null) {
            exception.printStackTrace();
        }
    }

    public static void displayError(String message) {
        System.err.println("Error: " + message);
    }
    
    public static void handleHttpError(HttpURLConnection conn) {
        // Implementation for handling HTTP errors
        int responseCode;
        try {
            responseCode = conn.getResponseCode();
            System.err.println("HTTP Error: " + responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void handleIOException(IOException e) {
        // Implementation for handling IO errors
        e.printStackTrace();
    }
}
