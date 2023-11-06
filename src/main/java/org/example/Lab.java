package org.example;

public class Lab {

    public static int cont = 0;

    public static String[][] transformarEnMatriz(String[] array) {
        int filas = array.length;
        int columnas = array[0].length();

        String[][] matriz = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = String.valueOf(array[i].charAt(j));
            }
        }

        return matriz;
    }

    // Recorro y guardo en un string toda la secuencia de caracteres, tanto de columna como de filas
    public static void recorrerFilasYColumnas(String[][] adn) {
        String strF = "";
        String strC = "";
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn[i].length; j++) {
                strF += adn[i][j];
                strC += adn[j][i];
            }
            containsDNA(strF);
            containsDNA(strC);
            strC = "";
            strF = "";
        }
    }

    // Recorro primero las diagonales hasta la principal de arriba-izquierda a abajo-derecha, luego recorro desde la diagonal siguiente de la principal hasta el final
    public static void diagonalArribaIzquierdaAbajoDerecha(String[][] adn) {
        int filas = adn.length;
        int columnas = adn[0].length;
        String str;
    // DIAGONAL de 0 a diagonal principal
        for (int i = 0; i < filas; i++){
            int fila = i;
            int columna = 0;
            str = "";
            while(fila >= 0){
                str += adn[fila][columna];
                columna++;
                fila--;
            }
            containsDNA(str);
        }
    // DIAGONAL despues de contar la principal hasta la final
        for (int j = 1; j < columnas; j++){
            int fila = filas - 1;
            int columna = j;
            str = "";
            while (columna < columnas){
                str += adn[fila][columna];
                columna++;
                fila--;
            }
            containsDNA(str);
        }
    }

    // Recorro primero las diagonales hasta la principal de abajo-izquierda a arriba-derecha, luego recorro desde la diagonal siguiente de la principal hasta el final
    public static void diagonalAbajoIzquierdaArribaDerecha(String[][] adn) {
        int filas = adn.length;
        String str;

        for (int j = 0; j < filas; j++){
            int fila = filas - 1;
            int columna = j;
            str = "";
            while (columna >= 0){
                str += adn[fila][columna];
                columna--;
                fila--;
            }
            containsDNA(str);
        }

        for (int i = filas - 2; i >= 0; i--){
            int fila = i;
            int columna =  filas - 1;
            str = "";
            while(fila >= 0){
                str += adn[fila][columna];
                columna--;
                fila--;
            }
            containsDNA(str);
        }
    }

    // Verifico si alguna de las cadenas que voy pasando a traves de los metodos anteriores contiene la secuencia de caracteres de las 4 letras posibles
    public static void containsDNA(String str) {
        if (str.contains("AAAA") || str.contains("TTTT") || str.contains("CCCC") || str.contains("GGGG")) {
            cont++;
        }
    }

    // Metodo base que recorre las filas y las columnas, aumentando el contador si encuentra una de las secuencias y retornando verdadero si el adn contiene mas de 1 secuencia
    public static boolean isMutant(String[] muestra) {
        String[][] adn = transformarEnMatriz(muestra);
        recorrerFilasYColumnas(adn);
        diagonalArribaIzquierdaAbajoDerecha(adn);
        diagonalAbajoIzquierdaArribaDerecha(adn);
        return cont > 1;
    }
}
