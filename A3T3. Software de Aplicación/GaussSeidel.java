import java.util.Scanner;

public class GaussSeidel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el número de ecuaciones: ");
        int n = scanner.nextInt();

        double[][] matriz = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            System.out.println("Ecuación " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.println("Coeficiente x" + (j + 1) + ":");
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.println("Constante: ");
            matriz[i][n] = scanner.nextDouble();
        }

        double[] soluciones = gaussSeidel(matriz);

        System.out.println("Resultados:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + soluciones[i]);
        }

        scanner.close();
    }

    private static double[] gaussSeidel(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n];
        double[] nx = new double[n];
        double epsilon = 0.0001; // tolerancia para la convergencia
        int iteracionesMax = 1000;

        // Iteración inicial
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }

        int iteraciones = 0;
        boolean convergencia = false;
        while (!convergencia && iteraciones < iteracionesMax) {
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += matriz[i][j] * x[j];
                    }
                }
                nx[i] = (matriz[i][n] - suma) / matriz[i][i];
            }

            convergencia = true;
            for (int i = 0; i < n; i++) {
                if (Math.abs(nx[i] - x[i]) > epsilon) {
                    convergencia = false;
                    break;
                }
            }

            // Actualizar x
            for (int i = 0; i < n; i++) {
                x[i] = nx[i];
            }

            iteraciones++;
        }

        return x;
    }
}
