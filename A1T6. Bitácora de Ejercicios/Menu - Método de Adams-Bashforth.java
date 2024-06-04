import java.util.Scanner;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Cifra Significativa");
            System.out.println("2. Precisión");
            System.out.println("3. Exactitud");
            System.out.println("4. Sesgo");
            System.out.println("5. Error Absoluto");
            System.out.println("6. Error Relativo");
            System.out.println("7. Truncamiento");
            System.out.println("8. Redondeo");
            System.out.println("9. Bisección");
            System.out.println("10. PuntoFijo");
            System.out.println("11. Interpolacion de Newton");
            System.out.println("12. Metodo de Jacobi");
            System.out.println("13. GaussSeidel");
            System.out.println("14. Diferenciacion Numerica");
            System.out.println("15. Regla del trapecio");
            System.out.println("16. Regla de Simpson");
            System.out.println("17. Polinomio de Interpolacion de Newton");
            System.out.println("18. Polinimio de Interpolacion de Langrage");
            System.out.println("19. Regresión Lineal");
            System.out.println("20. Minimos Cuadrados");
            System.out.println("21. Método de Euler");
            System.out.println("22. Método de Taylor");
            System.out.println("23. Método de Adams-Bashforth");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    NotacionCientifica.main(null);
                    break;
                case 2:
                    ComparadorValores.main(null);
                    break;
                case 3:
                    ComparadorValores.main(null);
                    break;
                case 4:
                    Sesgo1.main(null);
                    break;
                case 5:
                    ErrorAbsoluto.main(null);
                    break;
                case 6:
                    ErrorRelativo.main(null);
                    break;
                case 7:
                    Truncamiento.main(null);
                    break;
                case 8:
                    Redondeo.main(null);
                    break;
                case 9:
                    Biseccion.main(null);
                    break;
                case 10:
                    // Llamar al método de punto fijo
                    PuntoFijo1.main(null);
                    break;
                case 11:
                    InterpolacionNewton.main(null);
                    break;
                case 12:
                    Jacobi.main(null);
                    break;
                case 13:
                    // Llamar al método de Gauss-Seidel
                    GaussSeidel.main(null);
                    break;
                case 14:
                    DiferenciacionNumerica.main(null);
                    break;
                case 15:
                ReglaTrapecio.main(null);
                    break;
                case 16:
                    ReglaDeSimpson.main(null);
                    break;
                case 17:
                    PolinimioInterpolacionNewton.main(null);
                    break;
                case 18:
                    LagrangeInterpolation.main(null);
                    break;
                case 19:
                    RegresionLineal.main(null);
                    break;
                case 20:
                    MinimosCuadrados.main(null);
                    break;
                case 21:
                    euler.main(null);
                    
                    break;
                case 22:
                    TaylorSeries.main(null);
                    break;

                case 23:
                    AdamsBashforth.main(null);
                    break; 
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }
}

class TaylorSeries {

    // La función original f(x) = x^4 - 3x^2 + 1
    public static double f(double x) {
        return Math.pow(x, 4) - 3 * Math.pow(x, 2) + 1;
    }
    
    // Primera derivada de f(x)
    public static double fPrime(double x) {
        return 4 * Math.pow(x, 3) - 6 * x;
    }
    
    // Segunda derivada de f(x)
    public static double fDoublePrime(double x) {
        return 12 * Math.pow(x, 2) - 6;
    }
    
    // Tercera derivada de f(x)
    public static double fTriplePrime(double x) {
        return 24 * x;
    }
    
    // Cuarta derivada de f(x)
    public static double fQuadruplePrime(double x) {
        return 24;
    }
    
    // Método para calcular el término de Taylor en torno a x0
    public static double taylorTerm(int n, double x0) {
        double term;
        switch (n) {
            case 0:
                term = f(x0);
                break;
            case 1:
                term = fPrime(x0);
                break;
            case 2:
                term = fDoublePrime(x0) / 2;
                break;
            case 3:
                term = fTriplePrime(x0) / 6;
                break;
            case 4:
                term = fQuadruplePrime(x0) / 24;
                break;
            default:
                term = 0;
                break;
        }
        return term;
    }
    
    // Método para construir la serie de Taylor
    public static String taylorSeries(double x0, int terms) {
        StringBuilder series = new StringBuilder();
        for (int n = 0; n < terms; n++) {
            double coefficient = taylorTerm(n, x0);
            if (n == 0) {
                series.append(coefficient);
            } else if (coefficient != 0) {
                if (coefficient > 0) {
                    series.append(" + ");
                } else {
                    series.append(" - ");
                    coefficient = -coefficient; // Para evitar duplicar el signo negativo
                }
                series.append(coefficient).append("*(x - ").append(x0).append(")^").append(n);
            }
        }
        return series.toString();
    }

    public static void main(String[] args) {
        double x0 = 1.0; // Punto alrededor del cual se expande la serie de Taylor
        int terms = 5;   // Número de términos en la serie de Taylor

        String series = taylorSeries(x0, terms);
        System.out.println("La serie de Taylor de f(x) alrededor de x0 = " + x0 + " es:");
        System.out.println(series);
    }
}

class PuntoFijo1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opci;
        System.out.println("Bienvenido al programa de punto fijo ");
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Método del punto fijo con e^-x");
            System.out.println("2. Método del punto fijo con 0.4e^(x^2)");
            System.out.println("3. Salir");
            opci = teclado.nextInt();
            switch (opci) {
                case 1:
                    System.out.println("Bienvenido al apartado de punto fijo con e^-x:");
                    metodoPuntoFijo(PuntoFijo1::funcion1);
                    break;
                case 2:
                    System.out.println("Bienvenido al apartado de punto fijo con 0.4e^(x^2):");
                    metodoPuntoFijo(PuntoFijo1::funcion2);
                    break;
                case 3:
                    System.out.println("Gracias Vuelva pronto ");
                    break;
                    
                default:
                    System.out.println("ingresa un numero correcto por favor ");
            }
        } while (opci != 3);
    }

    // Definición de la función g(x) como e^-x
    static double funcion1(double x) {
        return Math.exp(-x);
    }


    // Definición de la función g(x) como 0.4e^(x^2)
    static double funcion2(double x) {
        return 0.4 * Math.exp(Math.pow(x, 2));
    }

    // Método del punto fijo
    static void metodoPuntoFijo(FuncionG funcionG) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa tu valor inicial (x):");
        double x = teclado.nextDouble();

        System.out.println("Ingresa tu número máximo de iteraciones:");
        int maxIteraciones = teclado.nextInt();

        System.out.println("Ingresa tu margen de error:");
        double error = teclado.nextDouble();

        int iteraciones = 0; // Variable para almacenar el número de iteraciones realizadas
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-12s %-12s %-12s\n", "Interaccion ", "Valor ini ", "Error");

        for (int i = 1; i <= maxIteraciones; i++) {
            double e = x;
            x = funcionG.calcular(x); // Calcular el próximo valor de x usando la función g(x)
            e = Math.abs(x - e);
            System.out.printf("%-12d %-12.6f %-12.4f\n", i, x, e);

            if (e <= error) { // Comprobar si el error es menor o igual al error tolerado
                iteraciones = i; // Almacenar el número de iteraciones realizadas
                break; // Salir del bucle while si se alcanza el error tolerado
            }
        }
        System.out.println("---------------------------------------------------------------------------");

        if (iteraciones == 0) {
            System.out.println("No se encontró solución después de " + maxIteraciones + " iteraciones.");
        } else {
            System.out.println("Total de iteraciones: " + iteraciones);
        }
    }

    // Interfaz funcional para representar una función g(x)
    interface FuncionG {
        double calcular(double x);
    }
}

class GaussSeidel {

    public static final int MAX_ITERATIONS = 1000;
    public static final double TOLERANCE = 1e-6;//MAX_ITERATIONS y TOLERANCE aseguran que el algoritmo de Gauss-Seidel se ejecute de manera controlada y eficiente, 
   // evitando casos de bucles infinitos y garantizando que se detenga una vez que se haya alcanzado una solución aceptable dentro de los límites especificados.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de ecuaciones: ");
        int n = scanner.nextInt();
        
        double[][] coefficients = new double[n][n];
        double[] constants = new double[n];

        System.out.println("Ingrese los coeficientes de las ecuaciones:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Ecuación %d:\n", i + 1);
            for (int j = 0; j < n; j++) {
                System.out.printf("Coeficiente x%d: ", j + 1);
                coefficients[i][j] = scanner.nextDouble();
            }
            System.out.print("Constante: ");
            constants[i] = scanner.nextDouble();
        }

        double[] initialGuess = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Suposición inicial para x%d: ", i + 1);
            initialGuess[i] = scanner.nextDouble();
        }

        double[] solution = gaussSeidel(coefficients, constants, initialGuess);

        System.out.println("Solución:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.6f\n", i + 1, solution[i]);
        }
    }

    public static double[] gaussSeidel(double[][] coefficients, double[] constants, double[] initialGuess) {
        int n = constants.length;
        double[] solution = new double[n];
        double[] nextSolution = new double[n];

        System.arraycopy(initialGuess, 0, solution, 0, n);

        int iteration = 0;
        while (iteration < MAX_ITERATIONS) {
            for (int i = 0; i < n; i++) {
                double sum = constants[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= coefficients[i][j] * nextSolution[j];
                    }
                }
                nextSolution[i] = sum / coefficients[i][i];
            }

            double maxDiff = 0;
            for (int i = 0; i < n; i++) {
                double diff = Math.abs(nextSolution[i] - solution[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
            if (maxDiff < TOLERANCE) {
                break;
            }

            System.arraycopy(nextSolution, 0, solution, 0, n);

            iteration++;
        }

        if (iteration == MAX_ITERATIONS) {
            System.err.println("El método no converge después de " + MAX_ITERATIONS + " iteraciones.");
        }

        return solution;
    }
}

 class NotacionCientifica {

    // Método para contar cifras significativas
    public static int contarCifrasSignificativas(double numero) {
        // Convertir el número a una cadena para facilitar el conteo de cifras significativas
        String numeroStr = Double.toString(numero);

        // Contar las cifras significativas
        int cifrasSignificativas = 0;
        boolean inicioCifrasSignificativas = false;
        boolean puntoEncontrado = false;
        boolean cerosContados = false; // Variable para rastrear si ya hemos contado los ceros

        for (char c : numeroStr.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c != '0' || inicioCifrasSignificativas) {
                    cifrasSignificativas++;
                    inicioCifrasSignificativas = true;
                }
            } else if (c == '.') {
                puntoEncontrado = true;
            } else if (puntoEncontrado && !cerosContados && c == '0') {
                cifrasSignificativas++; // Contar el cero solo si está a la derecha del punto decimal
            }
        }

        return cifrasSignificativas;
    }

    // Método para ejecutar el proceso interactivo de notación científica
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Solicitar al usuario que ingrese el tipo de número
            System.out.println("Elija el tipo de número:");
            System.out.println("1. Número normal");
            System.out.println("2. Número en notación científica");
            System.out.print("Ingrese su elección (1 o 2): ");
            int opcion = scanner.nextInt();

            // Declarar variables para el número y el exponente
            double numero = 0;
            int exponente = 0;

            // Verificar la opción seleccionada por el usuario
            if (opcion == 1) {
                // Solicitar al usuario que ingrese un número normal
                System.out.print("Ingrese un número normal: ");
                numero = scanner.nextDouble();
            } else if (opcion == 2) {
                // Solicitar al usuario que ingrese un número y un exponente en notación científica
                System.out.print("Ingrese el número en notación científica (por ejemplo, 6.022): ");
                numero = scanner.nextDouble();
                System.out.print("Ingrese el exponente en notación científica (por ejemplo, 23): ");
                exponente = scanner.nextInt();
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 1 o 2.");
                continue;
            }

            // Imprimir el número ingresado
            if (opcion == 1) {
                System.out.println("El número ingresado es: " + numero);
            } else {
                System.out.println("El número ingresado en notación científica es: " + numero + " x 10^" + exponente);
            }

            // Contar las cifras significativas
            int cifrasSignificativas = contarCifrasSignificativas(numero);

            // Imprimir el resultado de las cifras significativas
            System.out.println("El número tiene " + cifrasSignificativas + " cifras significativas");

            // Preguntar al usuario si desea agregar otro valor
            System.out.print("¿Desea agregar otro valor? (Sí/No): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("Si")) {
                continuar = false;
            }
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Método main para ejecutar directamente desde el menú
    public static void main(String[] args) {
        ejecutar();
    }
}

class ComparadorValores {

    // Método para ejecutar el proceso de comparación de valores
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese el valor verdadero
        System.out.print("Ingrese el valor verdadero: ");
        double valorVerdadero = scanner.nextDouble();

        // Pedir al usuario que ingrese cuántos valores desea comparar
        System.out.print("¿Cuántos valores desea ingresar para comparar? ");
        int cantidadValores = scanner.nextInt();

        // Pedir al usuario que ingrese el margen de error
        System.out.print("Ingrese el margen de error: ");
        double margenError = scanner.nextDouble();

        // Inicializar variables para el conteo de valores exactos y precisos
        int exactos = 0;
        int precisos = 0;

        // Pedir al usuario que ingrese los valores para comparar
        for (int i = 1; i <= cantidadValores; i++) {
            System.out.print("Ingrese el valor #" + i + ": ");
            double valor = scanner.nextDouble();

            // Verificar si el valor es exacto o preciso
            if (valor >= valorVerdadero - margenError && valor <= valorVerdadero + margenError) {
                precisos++;
                if (valor == valorVerdadero) {
                    exactos++;
                }
            }
        }

        // Mostrar resultados
        System.out.println("Exactos: " + exactos);
        System.out.println("Precisos: " + precisos);

        scanner.close();
    }

    // Método main para ejecutar directamente desde el menú
    public static void main(String[] args) {
        ejecutar();
    }
}

class Sesgo1 {

    // Método para calcular el sesgo de un conjunto de datos
    public static double calcularSesgo(double[] datos) {
        int n = datos.length;
        double suma = 0;
        double media = calcularMedia(datos);

        // Calcular la suma de las desviaciones al cubo
        for (double dato : datos) {
            suma += Math.pow(dato - media, 3);
        }

        // Calcular el sesgo
        double sesgo = suma / (n * Math.pow(calcularDesviacionEstandar(datos), 3));
        return sesgo;
    }

    // Método para calcular la media de un conjunto de datos
    public static double calcularMedia(double[] datos) {
        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        return suma / datos.length;
    }

    // Método para calcular la desviación estándar de un conjunto de datos
    public static double calcularDesviacionEstandar(double[] datos) {
        double media = calcularMedia(datos);
        double suma = 0;
        for (double dato : datos) {
            suma += Math.pow(dato - media, 2);
        }
        return Math.sqrt(suma / datos.length);
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de números:");
        int cantidadNumeros = scanner.nextInt();

        double[] datos = new double[cantidadNumeros];

        System.out.println("Ingrese los números uno por uno:");

        for (int i = 0; i < cantidadNumeros; i++) {
            datos[i] = scanner.nextDouble();
        }

        double sesgo = calcularSesgo(datos);
        System.out.println("El sesgo de los datos es: " + sesgo);

        scanner.close();
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

 class ErrorRelativo {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa que calcula el error relativo");

        System.out.print("Ingrese el valor exacto: ");
        double valorExacto = sc.nextDouble();

        System.out.print("Ingrese el valor aproximado: ");
        double valorAproximado = sc.nextDouble();

        double errorAbsoluto = errorAbs(valorExacto, valorAproximado);

        double resultado = errorRel(errorAbsoluto, valorExacto);
        System.out.print("El error relativo es: " + (resultado * 100) + "%");
        System.out.println();

        sc.close();
    }

    static double errorAbs(double valorExacto, double valorAproximado) {
        return Math.abs(valorAproximado - valorExacto);
    }

    static double errorRel(double errorAbs, double valorExacto) {
        return Math.abs(errorAbs / valorExacto);
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

 class ErrorAbsoluto {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa que calcula el error absoluto");

        System.out.print("Ingrese el valor exacto: ");
        double valorExacto = sc.nextDouble();

        System.out.print("Ingrese el valor aproximado: ");
        double valorAproximado = sc.nextDouble();

        double errorAbsoluto = calcularErrorAbsoluto(valorExacto, valorAproximado);
        System.out.println("El error absoluto es: " + errorAbsoluto);

        sc.close();
    }

    static double calcularErrorAbsoluto(double valorExacto, double valorAproximado) {
        return Math.abs(valorAproximado - valorExacto);
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

class Truncamiento {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa que calcula el error de truncamiento");

        System.out.print("Ingrese el valor exacto: ");
        double valorExacto = sc.nextDouble();

        System.out.print("Ingrese el valor truncado: ");
        double valorTruncado = sc.nextDouble();

        double errorTruncamiento = calcularErrorTruncamiento(valorExacto, valorTruncado);
        System.out.println("El error de truncamiento es: " + errorTruncamiento);

        sc.close();
    }

    static double calcularErrorTruncamiento(double valorExacto, double valorTruncado) {
        return Math.abs(valorExacto - valorTruncado);
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

 class Redondeo {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa que calcula el error de redondeo");

        System.out.print("Ingrese el valor exacto: ");
        double valorExacto = sc.nextDouble();

        System.out.print("Ingrese el valor redondeado: ");
        double valorRedondeado = sc.nextDouble();

        double errorRedondeo = calcularErrorRedondeo(valorExacto, valorRedondeado);
        System.out.println("El error de redondeo es: " + errorRedondeo);

        sc.close();
    }

    static double calcularErrorRedondeo(double valorExacto, double valorRedondeado) {
        return Math.abs(valorExacto - valorRedondeado);
    }

    public static void main(String[] args) {
        ejecutar();
    }
}

class Biseccion {

    // Función cúbica f(x) = x^3 - 2x - 5
    public static double f(double x) {
        return Math.pow(x, 3) - 2 * x - 5;
    }

    // Método de bisección
    public static double biseccion(double a, double b, double tolerancia) {
        double c = (a + b) / 2;
        while ((b - a) / 2 > tolerancia) {
            c = (a + b) / 2;
            if (f(c) == 0.0)
                break;
            else if (f(c) * f(a) < 0)
                b = c;
            else
                a = c;
        }
        return c;
    }

    // Método main para probar el método de bisección
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        System.out.println("Ingrese el valor de b: ");
        double b = scanner.nextDouble();
        System.out.println("Ingrese la tolerancia: ");
        double tolerancia = scanner.nextDouble();

        double resultado = biseccion(a, b, tolerancia);
        System.out.println("La raíz aproximada es: " + resultado);

        scanner.close();
    }
}
 class InterpolacionNewton {

    // Método para calcular las diferencias divididas
    public static double[][] calcularDiferenciasDivididas(List<Double> x, List<Double> y) {
        int n = y.size();
        double[][] dd = new double[n][n];

        // La primera columna es simplemente los valores de y
        for (int i = 0; i < n; i++) {
            dd[i][0] = y.get(i);
        }

        // Calcular las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dd[i][j] = (dd[i + 1][j - 1] - dd[i][j - 1]) / (x.get(i + j) - x.get(i));
            }
        }

        return dd;
    }

    // Método para construir el polinomio interpolante
    public static String interpolacionNewton(List<Double> x, List<Double> y) {
        int n = y.size();
        StringBuilder polinomio = new StringBuilder();

        double[][] dd = calcularDiferenciasDivididas(x, y);

        // Construir el polinomio
        polinomio.append(dd[0][0]);
        for (int j = 1; j < n; j++) {
            polinomio.append(" + ");
            polinomio.append(dd[0][j]);
            for (int i = 0; i < j; i++) {
                polinomio.append(" * (x - ").append(x.get(i)).append(")");
            }
        }

        return polinomio.toString();
    }

    // Método para imprimir la tabla con la tabulación
    public static void imprimirTabla(List<Double> x, List<Double> y, double[][] dd) {
        int n = x.size();
        System.out.println("Tabla de Diferencias Divididas:");
        System.out.println("J\tX_j\tf(x)\tDiferencias Divididas");

        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t" + x.get(i) + "\t" + y.get(i) + "\t");
            for (int j = 0; j < n - i; j++) {
                System.out.print(dd[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese la cantidad de puntos
        System.out.print("Ingrese la cantidad de puntos: ");
        int n = scanner.nextInt();

        // Inicializar listas para almacenar los puntos
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();

        // Pedir al usuario que ingrese los puntos
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el valor de x" + (i + 1) + ": ");
            x.add(scanner.nextDouble());
            System.out.print("Ingrese el valor de y" + (i + 1) + ": ");
            y.add(scanner.nextDouble());
        }

        // Calcular el polinomio interpolante
        String polinomio = interpolacionNewton(x, y);

        // Calcular las diferencias divididas
        double[][] dd = calcularDiferenciasDivididas(x, y);

        // Imprimir la tabla de tabulación
        imprimirTabla(x, y, dd);

        // Imprimir el polinomio interpolante
        System.out.println("Polinomio interpolante: P(x) = " + polinomio);

        scanner.close();
    }
}

class Jacobi {
    public static void main(String[] args) {
        double[][] A = {{10, -1, 2}, {1, 10, -1}, {2, 1, 10}};
        double[] b = {7, 8, 6};
        int maxIterations = 100;
        double tolerance = 1e-6;
        double[] x = jacobi(A, b, maxIterations, tolerance);
        System.out.println("Solución utilizando Jacobi:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    public static double[] jacobi(double[][] A, double[] b, int maxIterations, double tolerance) {
        int n = A.length;
        double[] x = new double[n];
        double[] x_new = new double[n];
        Arrays.fill(x, 0.0);
        
        for (int k = 0; k < maxIterations; k++) {
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= A[i][j] * x[j];
                    }
                }
                x_new[i] = sum / A[i][i];
            }
            
            double error = 0.0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(x_new[i] - x[i]);
            }
            if (error < tolerance) {
                return x_new;
            }
            
            System.arraycopy(x_new, 0, x, 0, n);
        }
        
        return x;
    }
}

 class DiferenciacionNumerica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos necesarios para la diferenciación numérica:");
        System.out.print("Valor de x: ");
        double x = scanner.nextDouble();
        System.out.print("Valor de h: ");
        double h = scanner.nextDouble();
        scanner.close();

        double resultado = calcularDiferenciaNumerica(x, h);
        System.out.println("El resultado de la diferenciación numérica es: " + resultado);
    }

    public static double calcularDiferenciaNumerica(double x, double h) {
        double f1 = funcion(x + h);
        double f2 = funcion(x - h);
        return (f1 - f2) / (2 * h);
    }

    public static double funcion(double x) {
        // Ejemplo de función, reemplazar con la función real
        return x * x; // Por ejemplo, x^2
    }
}

class ReglaTrapecio {

    // Método para calcular la aproximación de la integral usando la regla del trapecio
    public static double reglaTrapecio(Function<Double, Double> funcion, double a, double b, int n) {
        // Calculamos el ancho de cada subintervalo
        double h = (b - a) / n;
        // Sumamos el valor de la función en los extremos de los intervalos
        double suma = 0.5 * (funcion.apply(a) + funcion.apply(b));
        // Sumamos el valor de la función en los puntos interiores de los intervalos
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += funcion.apply(x);
        }
        // Multiplicamos por el ancho de los intervalos y devolvemos el resultado
        return h * suma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitamos al usuario que ingrese los límites de integración
        System.out.print("Ingrese el límite inferior de integración: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el límite superior de integración: ");
        double b = scanner.nextDouble();

        // Solicitamos al usuario que ingrese el número de subintervalos
        System.out.print("Ingrese el número de subintervalos (mayor número, mayor precisión): ");
        int n = scanner.nextInt();

        // Definimos la función f(x) = e^(x^2)
        Function<Double, Double> funcion = x -> Math.exp(x * x);

        // Calculamos la aproximación de la integral usando la regla del trapecio
        double resultado = reglaTrapecio(funcion, a, b, n);

        // Tomamos el valor absoluto del resultado para asegurarnos de que sea positivo
        double resultadoPositivo = Math.abs(resultado);

        // Imprimimos el resultado
        System.out.println("Aproximación de la integral de e^(x^2) usando la regla del trapecio: " + resultadoPositivo);

        scanner.close();
    }
}

 class ReglaDeSimpson {

    // Método para calcular la integral usando la Regla de Simpson
    public static double reglaDeSimpson(Function<Double, Double> funcion, double a, double b, int n) {
        // Verificar que n sea par
        if (n % 2 != 0) {
            System.out.println("n debe ser un número par.");
            return Double.NaN;
        }

        double h = (b - a) / n;
        double suma = funcion.apply(a) + funcion.apply(b);

        for (int i = 1; i < n; i += 2) {
            suma += 4 * funcion.apply(a + i * h);
        }

        for (int i = 2; i < n - 1; i += 2) {
            suma += 2 * funcion.apply(a + i * h);
        }

        return (h / 3) * suma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese los límites de integración y el número de subintervalos
        System.out.print("Ingrese el límite inferior de integración (a): ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior de integración (b): ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese el número de subintervalos (n) (debe ser un número par): ");
        int n = scanner.nextInt();

        // Pedir al usuario que ingrese la función
        System.out.print("Ingrese la función a integrar (por ejemplo, para f(x) = x^2 ingrese x^2): ");
        String funcionStr = scanner.next();

        // Convertir la cadena de la función a un objeto Function
        Function<Double, Double> funcion = x -> {
            // Aquí puedes usar una biblioteca como exp4j para evaluar la función ingresada por el usuario
            // pero para este ejemplo simple, solo manejaremos la función x^2
            return x * x;
        };

        // Calcular la integral usando la Regla de Simpson
        double resultado = reglaDeSimpson(funcion, a, b, n);

        // Imprimir el resultado
        System.out.println("La integral aproximada es: " + resultado);

        scanner.close();
    }
}

class PolinimioInterpolacionNewton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lectura de los puntos
        System.out.print("Ingrese el número de puntos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Ingrese los puntos (x y): ");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        // Cálculo de la tabla de diferencias divididas
        double[][] dividedDifferences = new double[n][n];
        for (int i = 0; i < n; i++) {
            dividedDifferences[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dividedDifferences[i][j] = (dividedDifferences[i + 1][j - 1] - dividedDifferences[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Mostrar la tabla de diferencias divididas
        System.out.println("Tabla de diferencias divididas:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%.4f\t", dividedDifferences[i][j]);
            }
            System.out.println();
        }

        // Lectura del número de puntos en los que se va a evaluar el polinomio
        System.out.print("Ingrese el número de puntos donde desea evaluar el polinomio: ");
        int m = scanner.nextInt();
        double[] evalPoints = new double[m];

        System.out.println("Ingrese los puntos x donde desea evaluar el polinomio: ");
        for (int i = 0; i < m; i++) {
            System.out.print("x_eval[" + i + "]: ");
            evalPoints[i] = scanner.nextDouble();
        }

        // Evaluación del polinomio interpolador en los puntos especificados
        for (int i = 0; i < m; i++) {
            double value = evalPoints[i];
            double result = evaluateNewtonPolynomial(x, dividedDifferences, n, value);
            System.out.printf("El valor interpolado en x = %.4f es: %.4f\n", value, result);
        }

        scanner.close();
    }

    // Método para evaluar el polinomio interpolador en un punto dado
    private static double evaluateNewtonPolynomial(double[] x, double[][] dividedDifferences, int n, double value) {
        double result = dividedDifferences[0][0];
        double product;

        for (int i = 1; i < n; i++) {
            product = dividedDifferences[0][i];
            for (int j = 0; j < i; j++) {
                product *= (value - x[j]);
            }
            result += product;
        }

        return result;
    }
}

 class LagrangeInterpolation {

    // Método para calcular el polinomio de Lagrange
    public static double lagrangeInterpolation(double[] x, double[] y, double xi) {
        int n = x.length;
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = term * (xi - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de puntos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Introduce los valores de x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.println("Introduce los valores de y:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        System.out.print("Introduce el valor de xi para el cual quieres interpolar: ");
        double xi = scanner.nextDouble();

        double yi = lagrangeInterpolation(x, y, xi);
        System.out.println("El valor interpolado en xi = " + xi + " es yi = " + yi);

        scanner.close();
    }
}

class RegresionLineal {

    // Método para calcular la regresión lineal
    public static double[] calcularRegresionLineal(List<Double> x, List<Double> y) {
        int n = x.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x.get(i);
            sumY += y.get(i);
            sumXY += x.get(i) * y.get(i);
            sumX2 += x.get(i) * x.get(i);
        }

        double mediaX = sumX / n;
        double mediaY = sumY / n;

        double b1 = (sumXY - n * mediaX * mediaY) / (sumX2 - n * mediaX * mediaX);
        double b0 = mediaY - b1 * mediaX;

        return new double[]{b0, b1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese la cantidad de puntos
        System.out.print("Ingrese la cantidad de puntos: ");
        int n = scanner.nextInt();

        // Inicializar listas para almacenar los puntos
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();

        // Pedir al usuario que ingrese los puntos
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el valor de x" + (i + 1) + ": ");
            x.add(scanner.nextDouble());
            System.out.print("Ingrese el valor de y" + (i + 1) + ": ");
            y.add(scanner.nextDouble());
        }

        // Calcular los coeficientes de la regresión lineal
        double[] coeficientes = calcularRegresionLineal(x, y);

        // Imprimir la ecuación de la recta
        System.out.println("La ecuación de la recta es: y = " + coeficientes[0] + " + " + coeficientes[1] + "x");

        scanner.close();
    }
}

class MinimosCuadrados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número de datos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Ingresa los valores de x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.println("Ingresa los valores de y:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        // Calculamos la pendiente (m) y el punto de corte (b)
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXY = 0.0;
        double sumX2 = 0.0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        System.out.println("La línea de mejor ajuste es: y = " + m + "x + " + b);
    }
}


 class AdamsBashforth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar valores iniciales al usuario
        System.out.print("Ingrese el valor inicial de x (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese el valor inicial de y (y0): ");
        double y0 = scanner.nextDouble();

        System.out.print("Ingrese el tamaño de paso (h): ");
        double h = scanner.nextDouble();

        System.out.print("Ingrese el número de pasos: ");
        int n = scanner.nextInt();

        double[] x = new double[n + 1];
        double[] y = new double[n + 1];

        // Valores iniciales
        x[0] = x0;
        y[0] = y0;
        // Calcular los primeros valores con Runge-Kutta de orden 4
        for (int i = 0; i < 3 && i < n; i++) {
            double k1 = f(x[i], y[i]);
            double k2 = f(x[i] + h / 2, y[i] + h / 2 * k1);
            double k3 = f(x[i] + h / 2, y[i] + h / 2 * k2);
            double k4 = f(x[i] + h, y[i] + h * k3);

            y[i + 1] = y[i] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
            x[i + 1] = x[i] + h;

            System.out.println("Paso " + (i + 1) + ":");
            System.out.println("k1 = " + k1);
            System.out.println("k2 = " + k2);
            System.out.println("k3 = " + k3);
            System.out.println("k4 = " + k4);
            System.out.println("x[" + (i + 1) + "] = " + x[i + 1] + ", y[" + (i + 1) + "] = " + y[i + 1]);
        }

        // Calcular y[n] usando Adams-Bashforth de orden 4 si hay suficientes puntos
        if (n >= 4) {
            for (int i = 3; i < n; i++) {
                y[i + 1] = y[i] + (h / 24) * (55 * f(x[i], y[i]) - 59 * f(x[i - 1], y[i - 1])
                        + 37 * f(x[i - 2], y[i - 2]) - 9 * f(x[i - 3], y[i - 3]));
                x[i + 1] = x[i] + h;

                System.out.println("Paso " + (i + 1) + ":");
                System.out.println("x[" + (i + 1) + "] = " + x[i + 1] + ", y[" + (i + 1) + "] = " + y[i + 1]);
            }
        } else {
            System.out.println("Se necesitan al menos 4 puntos para usar el método de Adams-Bashforth.");
        }

        scanner.close();
    }

public static double f(double x, double y) {
return x+y;
}
}

 class euler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada del usuario para la función derivada f(x, y) = 2 * x * y
        System.out.println("Introduce la función derivada f(x, y). Por ejemplo, '2 * x * y':");
        String funcionDerivada = scanner.nextLine();

        // Valores iniciales ingresados por el usuario
        System.out.println("Introduce el valor inicial de x (x0):");
        double x0 = scanner.nextDouble();

        System.out.println("Introduce el valor inicial de y (y0):");
        double y0 = scanner.nextDouble();

        System.out.println("Introduce el tamaño del paso (h):");
        double h = scanner.nextDouble();

        System.out.println("Introduce el número de pasos (n):");
        int n = scanner.nextInt();

        // Llamamos al método de Euler
        double[] resultado = euler(x0, y0, h, n);
        System.out.printf("Después de %d pasos, x = %.2f y y = %.2f%n", n, resultado[0], resultado[1]);
    }

    // Método de Euler
    public static double[] euler(double x0, double y0, double h, int n) {
        double x = x0;
        double y = y0;
        for (int i = 0; i < n; i++) {
            y += h * calcularDerivada(x, y);
            x += h;
        }
        return new double[]{x, y};
    }

    // Método para calcular la derivada basado en la entrada del usuario
    public static double calcularDerivada(double x, double y) {
        // Aquí se debe implementar la lógica para interpretar y calcular la derivada basada en la entrada del usuario
        // Por ejemplo, si el usuario ingresa "2 * x * y", se debe calcular y devolver ese valor
        // Esta es una funcionalidad avanzada y requiere un análisis de la entrada del usuario o una interfaz gráfica
        return 2 * x * y; // Esto es solo un placeholder
    }
}
