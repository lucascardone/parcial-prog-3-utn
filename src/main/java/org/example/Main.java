package org.example;

public class Main {
    public static void main(String[] args) {
        /*
        Para otro caso de prueba esta el gen que no es mutante de 6x6

        String[] nonMutantDna = {
                "ATGCGA",
                "CAGTTC",
                "TTATGT",
                "AGCAGG",
                "CCTATA",
                "TCACTG"
        };

         */

        String[] mutantDna = {
                "ATGCAA",
                "CAGTGC",
                "TTATAT",
                "AGAACG",
                "GTCCCC",
                "TCACTG"
        };

        if(Lab.isMutant(mutantDna)){
            System.out.println("El gen ingresado es mutante");
        }else{
            System.out.println("El gen ingresado no es mutante");
        }
    }
}