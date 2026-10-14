import java.util.Scanner;

class Main {

    /**
     Presentado Por:
     Luis Arturo Diaz
     Carlos Reyes Figueredo
     */
    public static double[] ordenarArreglo(double[] arr) {
        int n = arr.length;
        double[] ordenado = new double[n];
        for (int i = 0; i < n; i++) {
            ordenado[i] = arr[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ordenado[j] > ordenado[j + 1]) {
                    double aux = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = aux;
                }
            }
        }
        return ordenado;
    }
    public static double calcularMediana(double[] x) {
        double[] ordenado = ordenarArreglo(x);
        int n = ordenado.length;
        if (n % 2 != 0) {
            return ordenado[n / 2];
        } else {
            double dato1 = ordenado[(n / 2) - 1];
            double dato2 = ordenado[n / 2];
            return (dato1 + dato2) / 2.0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PROGRAMA: CÁLCULO DE LA MEDIANA ===");
        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.print("El tamaño debe ser mayor a 0. Ingrese nuevamente: ");
            n = scanner.nextInt();
        }
        double[] x = new double[n];
        System.out.println("\nIngrese los " + n + " valores numéricos:");
        for (int i = 0; i < n; i++) {
            System.out.print("Valor [" + (i + 1) + "]: ");
            x[i] = scanner.nextDouble();
        }
        double mediana = calcularMediana(x);
        double[] ordenado = ordenarArreglo(x);
        System.out.println("\n--- RESULTADOS ---");
        System.out.print("Arreglo ingresado: [ ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println("]");

        System.out.print("Arreglo ordenado: [ ");
        for (int i = 0; i < ordenado.length; i++) {
            System.out.print(ordenado[i] + " ");
        }
        System.out.println("]");

        System.out.println("El elemento mediano (Mediana) es: " + mediana);

        scanner.close();
    }
}