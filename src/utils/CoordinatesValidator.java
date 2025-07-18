package utils;

import java.util.Scanner;

public class CoordinatesValidator {

    public static int checkInt(Scanner scanner, String message) {
        System.out.printf("%s", message);

        int row;
        String inputTemporary = scanner.nextLine().trim();

        if (inputTemporary.isEmpty()) {
            System.out.println("No puedes dejar la coordenada vacía. Por favor, introduce un número entero válido para la fila.");
            System.out.println();
            return checkInt(scanner, "Introduce la fila (0-9): ");
        } else {
            try {
                row = Integer.parseInt(inputTemporary);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Error: Debes introducir un número entero válido para la fila. ");
                return checkInt(scanner, "Introduce la fila (0-9): ");
            }
        }
        return row >= 0 && row <= 9 ? row : checkInt(scanner, "No seas pirata, introduce un número entre 0 y 9: ");
    }

    public static int checkLetter(Scanner scanner, String message) {
        System.out.printf("%s", message);

        String temporaryInput = scanner.nextLine().trim();
        String column;

        if (temporaryInput.isEmpty()) {
            System.out.println("Error: No puedes dejar la coordenada vacía.");
            System.out.println();
            return checkLetter(scanner, "Introduce la columna (A-J): ");
        } else if (temporaryInput.matches("\\d+|[!|·#$~%&/()=?¿'{¨}.,:;_]")) {
            System.out.println("Error: Numeros o carácteres especiales no son válidos.");
            System.out.println();
            return checkLetter(scanner, "Introduce la columna (A-J): ");
        }

        column = temporaryInput.toUpperCase();

        return (column.length() == 1 && column.charAt(0) >= 'A' && column.charAt(0) <= 'J') ? column.charAt(0) - 'A' : checkLetter(scanner, "No seas pirata, introduce solo una letra entre A y J: ");
    }
}

