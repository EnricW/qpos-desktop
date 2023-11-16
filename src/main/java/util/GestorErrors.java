/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

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
}
