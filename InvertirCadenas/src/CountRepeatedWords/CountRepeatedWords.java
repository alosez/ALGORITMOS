package CountRepeatedWords;

/*
    CONTANDO PALABRAS

    Enunciado;

        Crea un programa que cuente cuantas veces se repite cada palabra y que meustre el recuento
            - Los signos de puntuación no forman parte de la palabra.
            - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
            - No se pueden utilizar funciones propias del lenugaje que lo resuelvan automáticamente.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CountRepeatedWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string;

        System.out.println("Introduce una cadena de texto");
        string = sc.nextLine();

        countRepeatedWords(string);
        countRepeatedChars(string);
        firstCharNotRepeat(string);
    }

    private static void countRepeatedChars(String string) {

        String cleanString = string.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll("\\d", "").replaceAll(" ", "");   // clean symbols
//        String cleanString = string.toLowerCase().replaceAll("[-+.,:;?¿¡'!$%&/()=·ç¨^*<>ºª{}]", "");  clean symbols
//        String cleanString = string.toLowerCase().replaceAll("[0-9]", "");    // clean numbers
//        cleanString = string.toLowerCase().replaceAll("\\d", "");    // clean numbers
        char[] chars;
        HashMap<Character, Integer> mapFrequency = new HashMap<>();

        chars = cleanString.toCharArray();

        System.out.println(cleanString);

        for (char c : chars) {
            if (mapFrequency.containsKey(c)) {
                mapFrequency.put(c, mapFrequency.get(c) + 1);
            } else {
                mapFrequency.put(c, 1);
            }
        }
        // Imprimir mapa (recorrer con entry)
        for (HashMap.Entry<Character, Integer> entry : mapFrequency.entrySet()) {
            System.out.printf("Letra '%s' con frecuencia %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("");
        // Imprimir mapa (recorrer congiendo valor a traves de la clave)
        for (Character c : mapFrequency.keySet()) {
            int value = mapFrequency.get(c);
            System.out.printf("Letra '%s' con frecuencia %d\n", c, value);
        }
        System.out.println("");
        // Imprimir mapa (recorrer cogiendo valores con iterator)
        Iterator<Character> it = mapFrequency.keySet().iterator();
        while (it.hasNext()) {
            char key = it.next();
            int value = mapFrequency.get(key);
            System.out.printf("Letra '%s' con frecuencia %d\n", key, value);
        }

    }

    private static void countRepeatedWords(String string) {

        String cleanString = string.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll("\\d", "");

        String[] words = cleanString.split(" ");

        HashMap<String, Integer> mapaDeFrecuencias = new HashMap<>();
        for (String word : words) {
            if (mapaDeFrecuencias.containsKey(word)) {
                mapaDeFrecuencias.put(word, mapaDeFrecuencias.get(word) + 1);
            } else {
                mapaDeFrecuencias.put(word, 1);
            }
        }
        // Imprimir mapa
        for (HashMap.Entry<String, Integer> entry : mapaDeFrecuencias.entrySet()) {
            System.out.printf("Palabra '%s' con frecuencia %d\n", entry.getKey(), entry.getValue());
        }
    }

    private static void firstCharNotRepeat(String string) {
        // Primer caracter no repetido de una cadena
        String cleanString = string.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll("\\d", "").replaceAll(" ", "");   // clean symbols
        char[] chars;
        HashMap<Character, Integer> mapFrequency = new HashMap<>();

        chars = cleanString.toCharArray();

        for (char c : chars) {
            if (mapFrequency.containsKey(c)) {
                mapFrequency.put(c, mapFrequency.get(c) + 1);
            } else {
                mapFrequency.put(c, 1);
            }
        }
        // Imprimir mapa
        boolean flag = true;
        for (HashMap.Entry<Character, Integer> entry : mapFrequency.entrySet()) {
            if (entry.getValue() == 1 & flag) {
                System.out.printf("Primera palabra no repetida: '%s' número de veces repetida: %d\n", entry.getKey(), entry.getValue());
                flag = false;
            } else {
                System.out.println("_");
            }
        }
    }

}
