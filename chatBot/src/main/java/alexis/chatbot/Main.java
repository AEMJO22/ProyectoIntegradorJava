package alexis.chatbot;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // Inicializar el chatbot
        Bot chatbot = new Bot();

        // Interactuar con el usuario
        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.print("Usuario: ");
            userInput = scanner.nextLine();

            // Obtener y mostrar la respuesta del chatbot
            String response = chatbot.getResponse(userInput);
            System.out.println("Chatbot: " + response);

        } while (!userInput.equalsIgnoreCase("Adios!"));

        // Cerrar el escáner
        scanner.close();
    }
    
}