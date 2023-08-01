package BrunoAritmetica;

/**
 * Clase para realizar operaciones como sumas, restas, raices cuadradas,
 * multiplicacion y potenciacion, utilizando sumas y restas
 *
 * @author Arellano Bruno
 * @version 1.0
 */
public class AritmeticaBase {

    /**
     *
     * @param x Es la base a la que se le quiere sacar la raíz cuadrada
     * @return Regresa la raíz cuadrada de x por medio de restas
     */
    public float raiz(float x) {

        byte mulX = 1;
        int mul100 = 1;
        float contadorE = 0;
        float raiz = x;
        float memoriaRaiz = raiz;
        float memoriaBase = 0;
        float base = 1;
        float stop = -1;
        float numPrueba = base;

        while (contadorE > stop) {
            numPrueba += memoriaBase;
            contadorE++;
            if (contadorE > memoriaBase) {
                if (numPrueba > raiz) {
                    stop = (contadorE + 1);
                    base--;
                } else {
                    contadorE = 0;
                    memoriaBase++;
                    base++;
                    numPrueba = base;
                }
            }
        }

        memoriaBase = base;
        stop = -2;
        contadorE = 1;

        while (stop < -1) {
            memoriaBase += base;
            contadorE++;
            if (contadorE == base) {
                if (raiz - memoriaBase == 0) {
                    stop = 0;
                    memoriaBase = base;
                    System.out.println("La raiz es: " + base);
                } else {
                    memoriaBase = base;
                    while (mulX < 10) {
                        memoriaBase += base;
                        mulX++;
                    }
                    while (mul100 < 100) {
                        raiz += memoriaRaiz;
                        mul100++;
                    }
                    numPrueba = 0;
                    contadorE = 1;
                    stop = -1;
                    while (contadorE > stop) {
                        numPrueba += memoriaBase;
                        contadorE++;
                        if (contadorE == memoriaBase) {
                            if ((raiz - numPrueba) < memoriaBase) {
                                stop = (contadorE + 1);
                                while (memoriaBase - 10 > 0) {
                                    memoriaBase = memoriaBase - 10;
                                }
                            } else {
                                contadorE = 0;
                                memoriaBase++;
                                numPrueba = memoriaBase;
                            }
                        }
                    }

                }

            }
        }
        memoriaBase = memoriaBase / 10;
        base += memoriaBase;
        return base;

    }

    /**
     *
     * @param x Numerador de la división
     * @param y Divisor
     * @return El resultado de la division x/y utilizando arreglos y restas
     */
    public int divArreglo(int x, int y) {
        int primerN = x;
        int segundoN = y;
        int resultado = primerN;
        int contador = 0;

        while (resultado >= segundoN) {
            resultado -= segundoN;
            contador++;
        }

        int[] arregloEnteros = new int[contador + 2];
        resultado = primerN;

        for (int i = 0; i < (contador); i++) {
            resultado -= segundoN;
            arregloEnteros[i] = resultado;
        }
        arregloEnteros[contador] = resultado;
        arregloEnteros[contador + 1] = contador;
        System.out.println("El resultado es = " + arregloEnteros[contador + 1]);
        System.out.println("El residuo es = " + arregloEnteros[contador]);
        return arregloEnteros[contador + 1];
    }

    /**
     *
     * @param x Primer entero a evaluar
     * @param y Segundo entero a evaluar
     * @return El maximo comun divisor entre 'x' y 'y''
     */
    public int maxComDiv(int x, int y) {

        int primos = 1;
        int contador = 1;
        int primerNumero = x;
        int segundoNumero = y;

        while ((primerNumero > 1) && (segundoNumero > 1)) {
            int calculo = primerNumero % primos;
            int calculo2 = segundoNumero % primos;
            if ((calculo == 0) && (calculo2 == 0)) {
                primerNumero = primerNumero / primos;
                segundoNumero = segundoNumero / primos;
                System.out.println(primerNumero + "   " + segundoNumero + "|" + primos);
                contador *= primos;
                primos = 2;
            } else {
                if ((primerNumero == primos) || (segundoNumero == primos)) {
                    System.out.print(" Al menos un número es primo; ");
                    primerNumero = 0;
                    segundoNumero = 0;
                } else {
                    primos++;
                }
            }
        }
        return contador;
    }

    /**
     *
     * @param x Es la base de la potenciacion
     * @param y El exponente al que se elevara la base
     * @return Regresa el resultado de la potenciacion utilizando arreglos
     */
    public int potArr(int x, int y) {

        int primerN = x;
        int segundoN = y;
        int memoriaNum = primerN;
        int memoriaNum2 = 0;
        int memoriaVeces = 1;

        int[] arregloEnteros = new int[segundoN]; // [0 = 2, 1 = 4 , 2 = 8]
        for (int i = 0; i < segundoN;) {
            memoriaNum += memoriaNum2;
            memoriaVeces++;
            if (memoriaVeces == primerN) {
                memoriaNum2 = memoriaNum;
                arregloEnteros[i] = memoriaNum;
                memoriaVeces = 1;
                i++;
            }
        }
        System.out.print(primerN + "^" + segundoN + " =");
        return arregloEnteros[segundoN - 1];
    }

    /**
     *
     * @param x Primer entero a multiplicar
     * @param y segundo entero a multiplicar, ya que el método utiliza arreglos,
     * este numero tambien es utilizado como el definidor del tamaño del mismo,
     * por lo tanto en ningun caso puede ser 0
     * @return Regresa el ultimo numero del arreglo (resultado de la
     * multiplicacion), en caso de quererse se puede modificar para que envie el
     * arreglo completo de x * n hasta n mayor que y
     */
    public int multiplicacioncArreglo(int x, int y) {
        int resultado = 0;
        int[] arregloEnteros = new int[Math.abs(y)];
        if ((x >= 1 && y > 0) || (x < 0 && y < 0)) {

            for (int i = 0; i < Math.abs(y); i++) {
                resultado += Math.abs(x);
                arregloEnteros[i] = resultado;
            }
        } else if ((x >= 1 && y < 0) || (x < 0 && y >= 1)) {
            for (int i = 0; i < Math.abs(y); i++) {
                resultado -= Math.abs(x);
                arregloEnteros[i] = resultado;
            }

        } else if (y == 0) {
            System.out.println("El segundo valor no puede ser 0");

        }
        System.out.println(arregloEnteros[Math.abs(y) - 1]);
        return arregloEnteros[Math.abs(y) - 1];
    }

    /**
     *
     * @param x Recibe un entero grande cualquiera
     * @return Retorna el mayor factor primo de x
     */
    public double mayorFactorPrimo(double x) {

        double primos = 1;
        double primos2 = 1;
        double mayorPrimo = 1;
        int contador = 0;
        double primerNumero = x;

        while (primerNumero > 1) {

            for (double i = primos; i > 1;) {  // Este ciclo se asegura de que los valores que van a ser evaluados sean numeros primos, el contador no puede exceder el numero 2 porque ningun primo tiene más de 2 divisores exactos.
                double calculo = i % primos2;
                if (calculo == 0) {
                    i = i / primos2;
                    primos2 = 2;
                    contador++;
                } else {
                    primos2++;
                }

            }
            primos2 = 1;
            if (contador <= 2) {
                double calculo = primerNumero % primos;
                if (calculo == 0) {
                    primerNumero = primerNumero / primos;
                    if (mayorPrimo < primos) {
                        mayorPrimo = primos;
                    }
                    primos = 1;
                }
            }
            contador = 0;
            primos++;
        }
        System.out.println(mayorPrimo);
        return mayorPrimo;
    }

    /**
     *
     * @param x Pide un entero para descomponer en sus factores primos y
     * guardarlo en un arreglo
     * @return Regresa el arreglo de factores primos del numero
     */
    public int[] factorizarenPrimos(int x) {

        int primos = 2;
        int contador = 0;
        int primerNumero = x;

        System.out.println("La división por factores primos es: ");
        for (double numero = primerNumero; numero > 1;) {
            double calculo = (byte) numero % primos;
            if (calculo == 0) {
                numero = numero / primos;
                primos = 2;
                contador++;
            } else {
                primos++;
            }
        }
        int[] arregloFactores = new int[contador];
        contador = 0;
        for (double numero = primerNumero; numero > 1;) {
            double calculo = (byte) numero % primos;
            if (calculo == 0) {
                numero = numero / primos;
                arregloFactores[contador] = primos;
                primos = 2;
                contador++;
            } else {
                primos++;
            }

        }
        return arregloFactores;
    }

    /**
     * @param x Arreglo desordenado de numeros
     * @return Regresa un entero que es el minimo comun multiplo de todos.
     */
    public static int mcMultiplo(int[] x) {

        int[] bases = MetodosDeOrdenamiento.menoraMayor(x);
        int multiplicador = 1;

        for (int i = 0; i < bases.length - 1;) {
            if (((bases[0] * multiplicador) % bases[i + 1]) == 0) {
                i++;
            } else {
                multiplicador++;
                i = 0;
            }
        }
        return bases[0] * multiplicador;
    }
}
