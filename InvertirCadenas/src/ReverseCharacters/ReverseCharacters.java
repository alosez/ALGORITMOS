package ReverseCharacters;

/*
    INVIRTIENDO CADENAS
    Crea un programa que invierta el orden de una cadena de texto sin usar funcines propias del sistema
    Si pasamos "Hola mundo" nos retornará odnum aloH"

 */

import java.util.Scanner;

public class ReverseCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string;

        System.out.println("Introduce una cadena de texto");
        string = sc.nextLine();

        reverseWithLoop(string);

    }

    private static void reverseWithLoop(String string) {

        String reverseString = "";

        for (int a = string.length() - 1; a > -1; a--) {
            reverseString = reverseString + string.charAt(a);
        }
        System.out.println(reverseString);
    }
}
