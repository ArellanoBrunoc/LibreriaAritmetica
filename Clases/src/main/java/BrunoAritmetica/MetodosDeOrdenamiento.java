package BrunoAritmetica;

/**
 *Clase con metodos para reorganizar o imprimir arreglos o matrices
 * @author Arellano Bruno
 * @version 1.1
 */
public class MetodosDeOrdenamiento {

    /**
     * @param x Acepta una cantidad definida de datos y el listado de los mismos
     * en cualquier orden
     * @return mediante arreglos lo ordena de menor a mayor, devuelve un arreglo
     * ordenado y tiene en cuenta numeros repetidos
     */
    public  int[] menoraMayor(int[] x) {

        int tamaño = x.length;
        int[] arregloEnteros = x;
        int[] menoraMayor = new int[tamaño];
        int memoriaOrd = tamaño - 1;
        int contador = 0;
        int contador2 = 0;
        int variableTem;

        for (int i2 = 0; i2 < tamaño;) {
            for (int i = 0; i < tamaño;) {
                variableTem = arregloEnteros[i2];
                while (contador < tamaño) {
                    if (variableTem != arregloEnteros[i + contador]) {
                        contador++;
                        contador2++;
                    } else {
                        contador++;
                    }
                }
                while (contador > 0) {
                    if (variableTem == arregloEnteros[i]) {
                        i++;
                        contador--;
                    } else {
                        if (variableTem > arregloEnteros[i]) {
                            i++;
                            contador--;
                        } else {
                            memoriaOrd--;
                            contador--;
                            i++;
                        }
                    }
                }
                while (tamaño - contador2 > 0) {
                    menoraMayor[memoriaOrd] = variableTem;
                    memoriaOrd--;
                    contador2++;
                }
                i2++;
                contador2 = 0;
                memoriaOrd = tamaño - 1;
            }
        }
        x = menoraMayor;
        return menoraMayor;

    }

       /**
     * @param x Acepta una cantidad definida de datos y el listado de los mismos
     * en cualquier orden
     * @return mediante arreglos lo ordena de menor a mayor, devuelve un arreglo
     * ordenado y tiene en cuenta numeros repetidos
     */
    public  float[] menoraMayor(float[] x) {

        int tamaño = x.length;
        float[] arregloEnteros = x;
        float [] menoraMayor = new float[tamaño];
        int memoriaOrd = tamaño - 1;
        int contador = 0;
        int contador2 = 0;
        float variableTem;

        for (int i2 = 0; i2 < tamaño;) {
            for (int i = 0; i < tamaño;) {
                variableTem = arregloEnteros[i2];
                while (contador < tamaño) {
                    if (variableTem != arregloEnteros[i + contador]) {
                        contador++;
                        contador2++;
                    } else {
                        contador++;
                    }
                }
                while (contador > 0) {
                    if (variableTem == arregloEnteros[i]) {
                        i++;
                        contador--;
                    } else {
                        if (variableTem > arregloEnteros[i]) {
                            i++;
                            contador--;
                        } else {
                            memoriaOrd--;
                            contador--;
                            i++;
                        }
                    }
                }
                while (tamaño - contador2 > 0) {
                    menoraMayor[memoriaOrd] = variableTem;
                    memoriaOrd--;
                    contador2++;
                }
                i2++;
                contador2 = 0;
                memoriaOrd = tamaño - 1;
            }
        }
        return menoraMayor;

    }
    
    /**
     * @param x Arreglo que desea imprimir
     */
    public static void imprimir(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    /**
     *
     * @param x Arreglo que se desea imprimir desde el final al inicio
     */
    public void imprimirReversa(int[] x) {
        for (int i = x.length - 1; i >= 0; i--) {
            System.out.println(x[i]);
        }
    }

    /**
     *
     * @param x Acepta un arreglo desorganizado
     * @return Regresa el arreglo ordenado de menor a mayor y todos los impares
     * antes de los pares
     */
    public int[] imparesPares(int[] x) {
        MetodosDeOrdenamiento mdo = new MetodosDeOrdenamiento();
        x = mdo.menoraMayor(x);
        int[] arregloFinal = new int[x.length];
        int modulo;
        int contador = 0;

        for (int i = 0; i < x.length;) {
            modulo = x[i] % 2;
            if (modulo != 0) {
                arregloFinal[contador] = x[i];
                contador++;
                i++;
            } else {
                i++;
            }
        }
        for (int i = 0; i < x.length;) {
            modulo = x[i] % 2;
            if (modulo == 0) {
                arregloFinal[contador] = x[i];
                contador++;
                i++;
            } else {
                i++;
            }
        }
        return arregloFinal;
    }

    /**
     *
     * @param matrix Recibe una matriz para imprimir con tipo de dato float
     * (para inversas)
     */
    public static void ImprimirMatriz(float matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {//CICLO PARA IMPRIMIR TODA LA MATRIZ (RECIBE FLOAT)
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }
    }

    /**
     *
     * @param matrix Recibe una matriz para imprimir
     */
    public static void ImprimirMatriz(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {//CICLO PARA IMPRIMIR TODA LA MATRIZ
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }
    }

    /**
     *
     * @param x Recibe una matriz nxn
     * @return Retorna la matriz intercambiando filas por columnas (transpuesta)
     */
    public int[][] matrizTranspuesta(int[][] x) {
        int[][] matrizTranspuesta = new int[x.length][x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                matrizTranspuesta[i][j] = x[j][i];
            }
        }
        System.out.println("");
        System.out.println("La matriz transpuesta es:");
        MetodosDeOrdenamiento.ImprimirMatriz(matrizTranspuesta);

        return matrizTranspuesta;
    }
}
