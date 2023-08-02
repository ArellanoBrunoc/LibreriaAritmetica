package BrunoAritmetica;

/**
 * Clase utilizada para realizar metodos aritmeticos en: Matrices Sumas, Restas,
 * Multiplicacion, Division, Potenciacion, Raices, Matriz adjunta, transpuesta,
 * Inversa, Determinantes parciales, Determinantes, Etc..
 *
 * @author Arellano Bruno
 * @version 1.1
 */
public class AritmeticaMatrices {
    
    private int[][] matrizA1 = {{3, 4, -3}, {7, -2, -3}, {-8, -2, 3}};
    private float[][] matrizA2 = {{1,-2, 2, -3}, {3, 4, -1,1}, {2, -3, 2,-1},{1,1,-3,-2}};
    private float[] vectorA2 = {15, -6 , 17,-7};
    
//    {{2, -1, 1}, {3, 1, -2}, {-1, 2, 5}};
//{{-2, 3, 3}, {1, -4, -2}, {5, -1, 3}};
//    {{1,-2, 2, -3}, {3, 4, -1,1}, {2, -3, 2,-1},{1,1,-3,-2}};
    /**
     *
     * @param x Recibe un enterero que sera igual a la cantidad de filas de la
     * matriz
     * @param y Recibe un entero que sera igual a la cantidad de columnas de la
     * matriz En este caso el metodo esta ajustado para imprimir la matriz a
     * modo de tablas de multiplicar, donde la columna sera la base y la fila el
     * multiplicador
     */
    public static void matricesTablas(int x, int y) {
        int[][] tablas = new int[x][y];
        int base = 1;
        int mult = 1;
        
        for (int i = 0; i < tablas.length; i++) {
            for (int j = 0; j < tablas[i].length; j++) {
                tablas[i][j] = base * mult;
                mult++;
            }
            base++;
            mult = 1;
        }
        for (int i = 0; i < tablas.length; i++) {
            for (int j = 0; j < tablas[i].length; j++) {
                System.out.print(tablas[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     *
     * @param x Recibe un enterero que sera igual a la cantidad de filas de la
     * matriz
     * @param y Recibe un entero que sera igual a la cantidad de columnas de la
     * matriz En este caso el metodo esta ajustado para imprimir la matriz a
     * modo de tablas de multiplicar, donde la columna sera la base y la fila el
     * multiplicador pero empezando desde la ultima coordenada de la matriz
     */
    public static void matricesTablasReves(int x, int y) {
        int[][] tablas = new int[x][y];
        int base = 1;
        int mult = 1;
        
        for (int i = 0; i < tablas.length; i++) {
            for (int j = 0; j < tablas[i].length; j++) {
                tablas[i][j] = base * mult;
                mult++;
            }
            base++;
            mult = 1;
        }
        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                System.out.print(tablas[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     *
     * @param x Recibe una matriz de 3 x 3 para hallar su determinante, tambien
     * puede utilizarse para matrices de 2 x 2 modificando y
     * @param y Recibe un 3 o un 1, cuando sea 3 el metodo hallara el
     * determinante parcial positivo de una matriz 3x3, si es 1 hara lo mismo
     * pero de una matriz 2x2
     * @return Regresa el determinante parcial positivo de la matriz
     */
    public int determinantePositivo(int x[][], int y) {
        
        int[] arregloMul = new int[x.length]; //Este arreglo va a guardar los valores de cada diagonal a evaluar
        int contador = y;//La cantidad de diagonales principales siempre va a ser igual al numero de filas de la matriz original; // Modificar a matriz.length si se quiere obetener el derterminante de una matriz 3 x 3, dejar en 1 si se planea usar para cofactores de matricecs nxn
        int detPositivos = 0; //Memoria de la suma de las multiplicaciones de las diagonales principales
        byte sumaoresta = 0;
        int desplazadorCoordenadax = 0;
        int desplazadorCoordenaday = 0;
        byte corrector = -1; // Corrige el desfase de la coordenada luego de la primera diagonal para que eventualmente y sea > x por 1

        while (contador != 0) { // Este condicional se asegura de que el ciclo se repetira una cantidad de veces igual al numero de filas de la diagonal principal
            for (int i = 0; i <= x.length - 1; i++) {
                for (int j = 0; j < 1; j++) {
                    arregloMul[i] = x[desplazadorCoordenadax][desplazadorCoordenaday];
                    
                }
                desplazadorCoordenaday++; // Estos incrementadores desplazan la cordenada original (0,0) a la siguiente (1,1).... etc de la primera diagonal
                desplazadorCoordenadax++;
                
            }
            contador--; // Para este punto ya se guardo en el arreglo la primera diagonal asi que el contador disminuye en 1
            corrector++; // Con excepcion de la primera diagonal (0,0) (1,1) .... etc, las siguientes diagonales tienes que ir con un desfase (x, x+1)
            for (int i = 0; i < x.length - 1; i++) {// Este ciclo multiplica todos los numeros de la diagonal guardados en el arreglo y los acumula en la posicion 0 del mismo
                arregloMul[0] *= arregloMul[i + 1];
                
            }
            
            if (sumaoresta == 0) {// Este condicional se utiliza para ir intercalando + y - en la suma de los factores

                detPositivos = detPositivos + (arregloMul[0]); //Este acumulador guarda la multiplicacion de la diagonal
                desplazadorCoordenadax = 0; // se reestablece el valor de la coordenada en filas
                desplazadorCoordenaday = desplazadorCoordenadax + (1 + corrector);// Se reestablece el valor de la coordenada en columnas, teniendo en cuenta el nuevo desfase necesario
                sumaoresta = 1;
            } else {
                detPositivos = detPositivos + (arregloMul[0]); //Este acumulador guarda la multiplicacion de la diagonal
                desplazadorCoordenadax = 0; // se reestablece el valor de la coordenada en filas
                desplazadorCoordenaday = desplazadorCoordenadax + (1 + corrector);// Se reestablece el valor de la coordenada en columnas, teniendo en cuenta el nuevo desfase necesario
                sumaoresta = 0;
            }
        }
        // System.out.println("El pre-determinante positivo es:" + " " + detPositivos);
        return detPositivos;
    }

    /**
     * @param x Recibe una matriz de 3 x 3 para hallar su determinante, tambien
     * puede utilizarse para matrices de 2 x 2 modificando y
     * @param y Recibe un 3 o un 1, cuando sea 3 el metodo hallara el
     * determinante parcial negativo de una matriz 3x3, si es 1 hara lo mismo
     * pero de una matriz 2x2
     * @return Regresa el determinante parcial negativo de la matriz
     */
    public int determinanteNegativo(int x[][], int y) { // version negativa del metodo determinantePositivo

        int[] arregloMul = new int[x.length];
        int contador = y; // Modificar a matriz.length si se quiere obetener el derterminante de una matriz 3 x 3, dejar en 1 si se planea usar para cofactores de matricecs nxn
        int detNegativos = 0;
        byte sumaoresta = 0;
        int desplazadorCoordenadax = 0;
        int desplazadorCoordenaday = x[0].length - 1;
        byte corrector = -1;
        
        while (contador != 0) {
            for (int i = 0; i <= x.length - 1; i++) {
                for (int j = 0; j < 1; j++) {
                    arregloMul[i] = x[desplazadorCoordenadax][desplazadorCoordenaday];
                }
                desplazadorCoordenaday--;
                desplazadorCoordenadax++;
            }
            contador--;
            corrector++;
            for (int i = 0; i < x.length - 1; i++) {
                arregloMul[0] *= arregloMul[i + 1];
            }
            
            if (sumaoresta == 0) {
                detNegativos = detNegativos - (arregloMul[0]);
                desplazadorCoordenadax = 0;
                desplazadorCoordenaday = (x[0].length - 1) - (1 + corrector);
                sumaoresta = 1;
            } else {
                detNegativos = detNegativos - arregloMul[0];
                desplazadorCoordenadax = 0;
                desplazadorCoordenaday = (x[0].length - 1) - (1 + corrector);
                sumaoresta = 0;
                
            }
            
        }
        // System.out.println("El pre-determinante negativo es:" + " " + detNegativos);
        return detNegativos;
    }

    /**
     *
     * @param x Recibe una matriz para crear otra ampliada y sobreescribir su
     * informacion para hallar la determinante de la matriz x
     * @return Regresa la matriz ampliada lista para seguir con el proceso de
     * hallar la determinante
     */
    public int[][] matrizAmpliada(int x[][]) {
        int[][] matrizTemp = new int[x.length][x.length + (x.length - 1)];  // Crea una matriz ampliada en columnas en factor de n+(n-1)
        for (int i = 0; i <= x.length - 1; i++) { // Este ciclo recorre la matriz ampliada y la rellena con la informacion de la matriz inicial
            for (int j = 0; j <= x.length - 1; j++) {
                matrizTemp[i][j] = x[i][j];
            }
        }
        for (int i = 0; i <= x.length - 1; i++) {//Este ciclo reescribe las primeras columnas de la matriz inicial en las ultimas columnas de la matriz ampliada para hallar la determinante
            for (int j = x.length; j <= x.length + (x.length - 2); j++) {
                matrizTemp[i][j] = x[i][j - (x.length)];
            }
        }
        return matrizTemp;
    }

    /**
     *
     * @return Obtiene la matriz con su valores
     */
    public int[][] getMatrizA1() {
        return matrizA1;
        
    }

    /**
     *
     * @return Obtiene la matriz con su valores
     */
    public float[][] getMatrizA2() {
        return matrizA2;
        
    }
    
    public float[] getvectorA2() {
        return vectorA2;
        
    }

    /**
     *
     * @param x Asigna los valores de la matriz x a la matriz de la clase
     * 'matrizA1'
     */
    public void setMatrizA1(int[][] x) {
        this.matrizA1 = x;
        
    }

    /**
     *
     * @param x Recibe una matriz de 3 x 3
     * @return regresa el determinante de la matriz
     */
    public static int determinanteMatriz3(int[][] x) {
        AritmeticaMatrices prueba = new AritmeticaMatrices();
        System.out.println("");
        int[][] matrix = prueba.matrizAmpliada(x);
        int Determinante = (prueba.determinantePositivo(matrix, matrix.length)) + (prueba.determinanteNegativo(matrix, matrix.length));
        return Determinante;
    }

    /**
     *
     * @param x Recibe una matriz de 3 x3 o 2 x 2 y halla la diferencia de sus
     * diagonales principales, para matrices de 2 x 2 es el mismo determinante
     *
     * @return Regresa la diferencia de diagonales principales
     */
    public int diferenciaDiagonales(int[][] x) {
        
        AritmeticaMatrices prueba = new AritmeticaMatrices();
        System.out.println("");
        int[][] matrix = x;
        int Determinante = (prueba.determinantePositivo(matrix, 1)) + prueba.determinanteNegativo(matrix, 1);
        System.out.println(Determinante);
        return Determinante;
    }

    /**
     *
     * @param x recibe una matriz de 4 x 4 para hallar su determinante
     * @return regresa el determinante de la matriz 4 x 4
     */
    public int determinanteMatriz4(int[][] x) {
        int[][] matriz = x;
        int[] cofactor = new int[matriz.length];
        int[][] matrizTemporal = new int[3][3];
        int resultado = 0;
        byte masomenos = 0;
        byte contador = 0;
        int escalares = matriz.length;
        byte salto = 0;
        byte coordi = 0;
        byte coordj = 0;
        
        System.out.println("");
        
        for (int i = 0; i < matriz.length; i++) {
            cofactor[i] = matriz[0][i];
            
        }
        while (escalares != 0) {
            for (int i = 1; i <= 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    if (j != salto) {
                        
                        matrizTemporal[coordi][coordj] = matriz[i][j];
                        coordj++;
                    }
                }
                coordj = 0;
                coordi++;
            }
            coordi = 0;
            salto++;
            
            if (masomenos == 0) {
                resultado = resultado + (cofactor[contador] * AritmeticaMatrices.determinanteMatriz3(matrizTemporal));
                contador++;
                masomenos = 1;
            } else {
                resultado = resultado - (cofactor[contador] * AritmeticaMatrices.determinanteMatriz3(matrizTemporal));
                contador++;
                masomenos = 0;
            }
            escalares--;
            
        }
        return resultado;
    }

    /**
     *
     * @param x Recibe una matriz de 4 x 4
     * @return retorna la matriz 4 x 4 adjunta de x
     */
    public int[][] adjunta4(int[][] x) {
        int[][] adjunta = new int[x.length][x.length];
        int[][] matrizTemporal = new int[x.length - 1][x.length - 1];
        byte saltoj = 0;
        byte saltoi = 0;
        byte coordi = 0; //Lleva un contador en i para hacer la transposición de los datos de la matriz original a las submatrices
        byte coordj = 0;//Lleva un contador en j para hacer la transposición de los datos de la matriz original a las submatrices
        byte coordiA = 0;
        byte coordjA = 0;
        int barrai = adjunta.length;
        int barraj = adjunta.length;
        byte masomenos = 0;
        byte contador = 0;
        
        System.out.println("Las sub matrices de 3 x 3 son :");
        while (barrai != 0) { // Lleva el contador de la cantidad de movimientos de la barra en i
            while (barraj != 0) {// Lleva el contador de la cantidad de movimiento de la barra en j

                for (int i = 0; i <= adjunta.length - 1; i++) {
                    if (i != saltoi) { // Pone la barra para ignorar esa fila en la matrizla, la condicional se asegura de que esa fila sea ignorada
                        for (int j = 0; j <= adjunta.length - 1; j++) {
                            if (j != saltoj) { // Pone la barra para ignorar esa columna en la matriz, la condicional se asegura de que esa columna sea ignorada

                                matrizTemporal[coordi][coordj] = x[i][j]; // Transporta el dato de la matriz grande a la submatriz actual
                                coordj++; // Desplaza el siguiente dato a la siguiente columna de la matriz pequeña
                            }
                        }
                        coordj = 0; // Reestablece la coordenada inicial para la siguiente fila de la submatriz
                        coordi++;// Desplaza el siguiente dato a la siguiente fila de la matriz pequeña
                    }
                }
                coordi = 0; // Reestablece la coordenada inicial para la siguiente submatriz
                saltoj++; // Desplaza la barra de las columnas 1 a la derecha
                MetodosDeOrdenamiento.ImprimirMatriz(matrizTemporal);
                System.out.println("");
                
                if (contador == adjunta.length) {// Este condicional organiza el sistema de modo que los datos resulten en el orden + , - , +, - y reestablece la coordeenada en la matriz adjunta
                    coordiA++;
                    coordjA = 0;
                    contador = 0;
                    if (masomenos == 0) {
                        masomenos = 1;
                    } else {
                        masomenos = 0;
                    }
                }
                
                if (masomenos == 0) {
                    adjunta[coordiA][coordjA] = (AritmeticaMatrices.determinanteMatriz3(matrizTemporal));
                    coordjA++;
                    contador++;
                    masomenos = 1;
                } else {
                    adjunta[coordiA][coordjA] = - 1 * (AritmeticaMatrices.determinanteMatriz3(matrizTemporal));
                    coordjA++;
                    contador++;
                    masomenos = 0;
                }
                
                barraj--;
            }
            saltoi++;
            saltoj = 0;
            barraj = adjunta.length;
            barrai--;
        }
        System.out.println("La matriz adjunta es:");
        MetodosDeOrdenamiento.ImprimirMatriz(adjunta);
        return adjunta;
    }

    /**
     *
     * @param x Recibe una matriz de 3 x 3
     * @return retorna la matriz 3 x 3 adjunta de x
     */
    public int[][] adjunta3(int[][] x) {
        AritmeticaMatrices prueba = new AritmeticaMatrices();
        int[][] adjunta = new int[x.length][x.length];
        int[][] matrizTemporal = new int[x.length - 1][x.length - 1];
        byte saltoj = 0;
        byte saltoi = 0;
        byte coordi = 0;
        byte coordj = 0;
        byte coordiA = 0;
        byte coordjA = 0;
        int barrai = adjunta.length;
        int barraj = adjunta.length;
        byte masomenos = 0;
        byte contador = 0;
        
        System.out.println("Las sub matrices de 2 x 2 son :");
        while (barrai != 0) {
            while (barraj != 0) {
                
                for (int i = 0; i <= adjunta.length - 1; i++) {
                    if (i != saltoi) {
                        for (int j = 0; j <= adjunta.length - 1; j++) {
                            if (j != saltoj) {
                                
                                matrizTemporal[coordi][coordj] = x[i][j];
                                coordj++;
                            }
                        }
                        coordj = 0;
                        coordi++;
                    }
                }
                coordi = 0;
                saltoj++;
                MetodosDeOrdenamiento.ImprimirMatriz(matrizTemporal);
                System.out.println("");
                if (contador == adjunta.length) {
                    coordiA++;
                    coordjA = 0;
                    contador = 0;
                    if (masomenos == 0) {
                        masomenos = 0;
                    } else {
                        masomenos = 1;
                    }
                }
                
                if (masomenos == 0) {
                    adjunta[coordiA][coordjA] = (prueba.diferenciaDiagonales(matrizTemporal));
                    coordjA++;
                    contador++;
                    masomenos = 1;
                } else {
                    adjunta[coordiA][coordjA] = - 1 * (prueba.diferenciaDiagonales(matrizTemporal));
                    coordjA++;
                    contador++;
                    masomenos = 0;
                }
                
                barraj--;
            }
            saltoi++;
            saltoj = 0;
            barraj = adjunta.length;
            barrai--;
        }
        System.out.println("La matriz adjunta es:");
        MetodosDeOrdenamiento.ImprimirMatriz(adjunta);
        return adjunta;
        
    }

    /**
     *
     * @param x recibe una matriz de 4 x 4
     * @return Retorna e imprime la matriz inversa de la matriz original
     */
    public float[][] inversa4x4(int[][] x) {
        
        MetodosDeOrdenamiento prueba = new MetodosDeOrdenamiento();
        
        int[][] Transpuesta = prueba.matrizTranspuesta(adjunta4(x));
        
        float[][] Inversa = new float[Transpuesta.length][Transpuesta.length];
        float inversoDeterminante = (float) 1 / determinanteMatriz4(x);
        
        for (int i = 0; i < Transpuesta.length; i++) {
            for (int j = 0; j < Transpuesta.length; j++) {
                Inversa[i][j] = (Transpuesta[i][j] * inversoDeterminante);
            }
            
        }
        MetodosDeOrdenamiento.ImprimirMatriz(Inversa);
        return Inversa;
    }

    /**
     *
     * @param x recibe una matriz de 3 x 3
     * @return Retorna e imprime la matriz inversa de la matriz original
     */
    public float[][] inversa3x3(int[][] x) {
        
        MetodosDeOrdenamiento prueba = new MetodosDeOrdenamiento();
        
        int[][] Transpuesta = prueba.matrizTranspuesta(adjunta3(x));
        
        float[][] Inversa = new float[Transpuesta.length][Transpuesta.length];
        float inversoDeterminante = (float) 1 / determinanteMatriz3(x);
        
        for (int i = 0; i < Transpuesta.length; i++) {
            for (int j = 0; j < Transpuesta.length; j++) {
                Inversa[i][j] = (Transpuesta[i][j] * inversoDeterminante);
            }
            
        }
        MetodosDeOrdenamiento.ImprimirMatriz(Inversa);
        return Inversa;
    }
    
    /**
     * 
     * @param x  Arreglo que quiere ser asignado a la variable global
     */
    public void setVectorA2(float[] x) {
        this.vectorA2 = x;
    }
    
    /**
     * 
     * @param x Recibe una matriz de nxm o nxn
     * @param y Recibe un arreglo con n = filas de x
     * @return  Regresa la matriz con el pivote "Un 1 en la primera coordenada", ademas, cambia el vector global si hubo cambio de filas
     */
    public float[][] pivote(float[][] x, float[] y) {
        AritmeticaMatrices atm = new AritmeticaMatrices();
        float[][] matrizInicial = x;
        float[] vector = y;
        float[] transportador = new float[matrizInicial.length];
        int filaPivote = -1;
        
        for (int i = 0; i < matrizInicial.length; i++) {
            if (Math.abs(matrizInicial[i][0]) == 1) {
                filaPivote = i;
                i = matrizInicial.length;
            }
        }
        if (filaPivote > 0) {
            
            for (int j = 0; j < matrizInicial[0].length; j++) {
                transportador[j] = matrizInicial[0][j];
                matrizInicial[0][j] = matrizInicial[filaPivote][j];
                matrizInicial[filaPivote][j] = transportador[j];
                
            }
            transportador[0] = vector[0];
            vector[0] = vector[filaPivote];
            vector[filaPivote] = transportador[0];
            System.out.println("La fila pivote es:" + " " + filaPivote);
            System.out.println("La matriz reordenada es:");
            MetodosDeOrdenamiento.ImprimirMatriz(matrizInicial);
            
            System.out.println("Vectores reordenados");
            
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i] + " ");
                
            }
            atm.setVectorA2(vector);

        } else if (filaPivote == 0) {
            System.out.println("La fila pivote ya esta en la posicion correcta");
            System.out.println("La matriz es:");
            MetodosDeOrdenamiento.ImprimirMatriz(matrizInicial);
            System.out.println("Vectores:");
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i] + " ");
                
            }
            
        } else {
            System.out.println("No hay linea pivote");
            float divisor = matrizInicial[0][0];

            System.out.println("La matriz es:");
            MetodosDeOrdenamiento.ImprimirMatriz(matrizInicial);
            
        }
        return matrizInicial;
        
    }
}
