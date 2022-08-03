package ReverseNumbers;

import javax.management.StringValueExp;

public class ReverseNumbers {

    /*
    INVIRTIENDO NÚMEROS
    Crea un programa que invierta el orden de un número sin usar funcines propias del sistema
    Si pasamos "123456789" nos retornará "987654321"

 */

    public static void main(String[] args) {

        reverseNumber(123456789);
        reverseNumber2(123456789);

    }

    private static void reverseNumber(int number) {
        System.out.println(number);
        int digit, reverse = 0;
        while (number != 0) {
            digit = number % 10;
            reverse = (reverse * 10) + digit;
            number /= 10;
        }
        System.out.println(reverse);
    }

    private static void reverseNumber2(int number) {
        // Convirtiendo el número entero en string
        String reverseInt = "";
        String str = Integer.toString(number);

        for (int a = str.length() - 1; a > -1; a--) {
            reverseInt = reverseInt + str.charAt(a);
        }
        System.out.println(Integer.parseInt(reverseInt));
    }
}
