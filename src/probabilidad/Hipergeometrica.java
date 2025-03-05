package probabilidad;


import java.util.Random;

public class Hipergeometrica {

   private int N; // Tamaño de la población
    private int K; // Número de éxitos en la población
    private int n; // Tamaño de la muestra

    public Hipergeometrica(int N, int K, int n) {
        if (N <= 0 || K < 0 || K > N || n < 0 || n > N) {
            throw new IllegalArgumentException("Valores inválidos para la distribución hipergeométrica.");
        }
        this.N = N;
        this.K = K;
        this.n = n;
    }

    public int getN() {
        return N;
    }

    public int getK() {
        return K;
    }

    public int getSampleSize() {
        return n;
    }

    /**
     * Calcula la probabilidad de obtener exactamente k éxitos en la muestra (P(X = k))
     */
    public double hypergeometricProbability(int k) {
        if (k < 0 || k > n || k > K) return 0;

        return (combination(K, k) * combination(N - K, n - k)) / (double) combination(N, n);
    }

    // Método para calcular la probabilidad acumulada P(X ≤ k)
    public double probabilidad_menor_igual(int k) {
        double suma = 0;
        for (int i = 0; i <= k; i++) {
            suma += hypergeometricProbability(i);
        }
        return suma;
    }
    
    // Método para calcular P(X < k)
    public double probabilidad_menor(int k) {
        return probabilidad_menor_igual(k - 1);
    }

    // Método para calcular P(X ≥ k)
    public double probabilidad_mayor_igual(int k) {
        return 1 - probabilidad_menor(k);
    }

    // Método para calcular P(X > k)
    public double probabilidad_mayor(int k) {
        return 1 - probabilidad_menor_igual(k);
    }

    /**
     * Calcula combinaciones: nCk = n! / (k! * (n - k)!)
     */
    private long combination(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    /**
     * Método para calcular el factorial
     */
    private long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    
    
}