package BrunoAritmetica;

import BrunoAritmetica.MetodosDeOrdenamiento;
import BrunoAritmetica.AritmeticaBase;
import BrunoAritmetica.AritmeticaMatrices;

/**
 * Clase principal para correr los procesos
 *
 * @author Arellano Bruno
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        //Creacion de objetos 
        MetodosDeOrdenamiento mdo = new MetodosDeOrdenamiento();
        AritmeticaBase atb = new AritmeticaBase();
        AritmeticaMatrices atm = new AritmeticaMatrices();

        float[][] matrizcPivote = atm.getMatrizA2();
        MetodosDeOrdenamiento.ImprimirMatriz(matrizcPivote);
        float[] vectores = atm.getvectorA2();
        float[] prueba = new float[2];
        float[] memoriaFila = new float[matrizcPivote[0].length];
        float[] memoriaFila2 = new float[matrizcPivote[0].length];
        float multiplicador1 = 1;
        float multiplicador2 = 1;

        for (int j = 0; j < matrizcPivote[0].length - 1; j++) {

            for (int i = matrizcPivote.length - 1; i > j; i--) {
                prueba[0] = matrizcPivote[j][j];
                prueba[1] = matrizcPivote[i][j];
                System.out.println("");
                System.out.println("");

                System.out.println("El mcm es: " + Math.abs(atb.mcMultiplo(prueba)));
                while (Math.abs(prueba[0] * multiplicador1) != Math.abs(atb.mcMultiplo(prueba))) {
                    multiplicador1++;
                }
// PROBLEMA DE SIGNOS
                for (int k = 0; k < matrizcPivote[0].length; k++) {
                    memoriaFila[k] = matrizcPivote[j][k] * multiplicador1;
                    System.out.print(memoriaFila[k] + " ");
                }
                System.out.println("");
                while (Math.abs(prueba[1] * multiplicador2) != Math.abs(atb.mcMultiplo(prueba))) {
                    multiplicador2++;
                }
                for (int k = 0; k < matrizcPivote[0].length; k++) {
                    memoriaFila2[k] = matrizcPivote[i][k] * multiplicador2;
                    System.out.print(memoriaFila2[k] + " ");

                }

                if ((prueba[0] > 0 && prueba[1] < 0) || (prueba[0] < 0 && prueba[1] > 0)) {
                    for (int k = 0; k < matrizcPivote[0].length; k++) {
                        matrizcPivote[i][k] = memoriaFila2[k] + memoriaFila[k];

                    }
                    vectores[i] = (vectores[i] * multiplicador2) + (vectores[j] * multiplicador1);
                } else {
                    for (int k = 0; k < matrizcPivote[0].length; k++) {
                        matrizcPivote[i][k] = memoriaFila2[k] - memoriaFila[k];

                    }
                    vectores[i] = (vectores[i] * multiplicador2) - (vectores[j] * multiplicador1);
                }
                System.out.println("");
                System.out.println("");

                MetodosDeOrdenamiento.ImprimirMatriz(matrizcPivote);
                System.out.println("Vector fila modificada = "+vectores[i]);
                multiplicador1 = 1;
                multiplicador2 = 1;

            }
        }
        prueba[0] = matrizcPivote[matrizcPivote[1].length - 1][matrizcPivote[0].length - 1];
        prueba[1] = vectores[vectores.length - 1];

        if (prueba[0] % prueba[1] == 0) {
            matrizcPivote[matrizcPivote[1].length - 1][matrizcPivote[0].length - 1] = prueba[0] / prueba[1];
            vectores[vectores.length - 1] = prueba[1] / prueba[1];

        } else if (prueba[1] % prueba[0] == 0){
        matrizcPivote[matrizcPivote[1].length - 1][matrizcPivote[0].length - 1] = prueba[0] / prueba[0];
            vectores[vectores.length - 1] = prueba[1] / prueba[0];
        
        } else {
        
        
        }

     
        for (int i = 0; i < matrizcPivote[1].length; i++) {
            for (int j = 0; j < matrizcPivote[0].length; j++) {
                System.out.print(matrizcPivote[i][j] + " ");
            }
            System.out.println("| " + vectores[i]);

        }
  
    }


}

