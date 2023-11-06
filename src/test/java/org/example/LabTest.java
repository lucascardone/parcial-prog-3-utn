package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabTest {

    // Resetea el contador de contador por cada test que haga para crear test mas independientes
    @BeforeEach
    public void setUp(){
        Lab.cont = 0;
    }

    //Se usa una muestra que deberia terminar en la matriz de 6x6 del resultado esperado
   @Test
    public void testTransformarArregloAMatriz(){
        String[] mutantDna = {
                "ATGCAA",
                "CAGTGC",
                "TTATAT",
                "AGAACG",
                "GTCCCC",
                "TCACTG"
        };

        String[][] expResult = {
                {"A", "T", "G", "C", "A", "A"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "A", "T"},
                {"A", "G", "A", "A", "C", "G"},
                {"G", "T", "C", "C", "C", "C"},
                {"T", "C", "A", "C", "T", "G"}
        };

        String[][] result = Lab.transformarEnMatriz(mutantDna);

        // Compara el resultado obtenido con el resultado esperado
        assertArrayEquals(expResult, result);
    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testRecorrerFilasYColumnas() {
        String[][] adn = {
                {"A", "T", "C", "G"},
                {"C", "A", "T", "G"},
                {"G", "T", "A", "C"},
                {"T", "G", "C", "A"}
        };

        Lab.recorrerFilasYColumnas(adn);
        assertEquals(0, Lab.cont); // Por mas de que veamos una secuencia no la cuenta daod a que testeamos el recorrido de filas y columnas


        // Agrega más casos de prueba según sea necesario
        String[][] adnRowAndColumn = {
                {"A", "A", "A", "A"},
                {"A", "C", "T", "G"},
                {"A", "T", "T", "C"},
                {"A", "G", "C", "G"}
        };

        Lab.recorrerFilasYColumnas(adnRowAndColumn);
        assertEquals(2, Lab.cont); // Contiene dos secuencias de adn en las filas como en las columnas

    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testRecorrerFilas(){
        String[][] adn = {
                {"A", "A", "A", "A"},
                {"C", "A", "T", "G"},
                {"G", "T", "A", "C"},
                {"T", "G", "C", "A"}
        };

        Lab.recorrerFilasYColumnas(adn);
        assertEquals(1, Lab.cont); // Contiene una secuencia de ADN en las filas
    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testRecorrerColumnas(){
        String[][] adn = {
                {"A", "A", "C", "A"},
                {"A", "A", "T", "G"},
                {"A", "T", "A", "C"},
                {"A", "G", "C", "A"}
        };

        Lab.recorrerFilasYColumnas(adn);
        assertEquals(1, Lab.cont); // Contiene una secuencia de ADN en las columnas
    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testDiagonalArribaIzquierdaAbajoDerechaOk() {
        String[][] adn = {
                {"C", "T", "C", "G"},
                {"C", "A", "G", "G"},
                {"G", "G", "A", "C"},
                {"G", "G", "C", "A"}
        };

        Lab.diagonalArribaIzquierdaAbajoDerecha(adn);
        assertEquals(1, Lab.cont); // Contiene 1 secuencia en  las diagonales de izquierda a derecha

    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testDiagonalArribaIzquierdaAbajoDerechaNotOk(){
        String[][] adn = {
                {"A", "A", "A", "A"},
                {"C", "T", "T", "T"},
                {"G", "T", "A", "C"},
                {"T", "G", "C", "A"}
        };

        Lab.diagonalArribaIzquierdaAbajoDerecha(adn);
        assertEquals(0, Lab.cont); // No deberia existir una secuencia en cont dado a que no se han revisado las filas y columnas
    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testDiagonalAbajoIzquierdaArribaDerechaOk() {
        String[][] adn = {
                {"A", "T", "C", "G"},
                {"C", "A", "T", "G"},
                {"G", "T", "A", "C"},
                {"T", "G", "C", "A"}
        };

        Lab.diagonalAbajoIzquierdaArribaDerecha(adn);
        assertEquals(1, Lab.cont); // No contiene secuencias de ADN
    }

    // Hago uso ya de una matriz transformada como caso de muestra y de dimension mas pequeña para mejor legibilidad del caso de prueba
    @Test
    public void testDiagonalAbajoIzquierdaArribaDerechaNotOk(){

        String[][] adn = {
                {"A", "T", "C", "G"},
                {"C", "A", "T", "G"},
                {"G", "T", "C", "C"},
                {"T", "G", "C", "A"}
        };

        Lab.diagonalAbajoIzquierdaArribaDerecha(adn);
        assertEquals(0, Lab.cont); // No contiene una secuencia en sus diagonales de abajo-izquierda a arriba-derecha
    }

    //Ejecuto caso de prueba verdadero, sabiendo que el metodo isMutant() es el encargado de llamar a todos los anteriores, incluyendo la conversion de la muestra
    @Test
    public void testIsMutantTrue(){
        String[] adn = {
                "TTTT",
                "CTAG",
                "GATC",
                "TGCT"
        };

        boolean result = Lab.isMutant(adn);
        assertEquals(true, result);
    }

    //Ejecuto caso de prueba falso, sabiendo que el metodo isMutant() es el encargado de llamar a todos los anteriores, incluyendo la conversion de la muestra
    @Test
    public void testIsMutantFalse(){
        String[] adn = {
                "TTCT",
                "CTAG",
                "GATC",
                "TGCT"
        };


        boolean result = Lab.isMutant(adn);
        assertEquals(false, result);
    }

    //Ejecuto caso de prueba Correcto, sabiendo que el metodo isMutant() es el encargado de llamar a todos los anteriores, incluyendo la conversion de la muestra verificamos que se encuentren las cantidades de muestras que habian
    @Test
    public void testIsMutantOk(){
        String[] adn = {
                "TTTT",
                "CTAG",
                "GATC",
                "TGCT"
        };
        Lab.isMutant(adn);
        assertEquals(2, Lab.cont);
    }

    //Ejecuto caso de prueba No correcto, sabiendo que el metodo isMutant() es el encargado de llamar a todos los anteriores, incluyendo la conversion de la muestra verificamos que se encuentren las cantidades de muestras que habian
    @Test
    public void testIsMutantNotOk(){
        String[] adn = {
                "TTTT",
                "CTAG",
                "TATC",
                "TGCT"
        };
        Lab.isMutant(adn);
        assertNotEquals(3, Lab.cont);
    }
}
