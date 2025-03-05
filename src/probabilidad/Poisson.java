
package probabilidad;

import java.util.Random;


public class Poisson {
    private double lambda; // Tasa promedio de ocurrencias en un intervalo

    public Poisson(double lambda) {
        if (lambda <= 0) {
            throw new IllegalArgumentException("Lambda debe ser mayor que 0.");
        }
        this.lambda = lambda;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        if (lambda <= 0) {
            throw new IllegalArgumentException("Lambda debe ser mayor que 0.");
        }
        this.lambda = lambda;
    }

    /**
     * Calcula la probabilidad de que ocurran exactamente k eventos (P(X = k))
     * @param k Número de ocurrencias
     * @return Probabilidad de que X sea exactamente k
     */
    public double poissonProbability(int k) {
        if (k < 0) return 0;
        return (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k);
    }

    /**
     * Calcula la probabilidad acumulada P(X ≤ k)
     * @param k Número máximo de ocurrencias
     * @return Probabilidad acumulada
     */
    public double cumulativeProbability(int k) {
        double sum = 0.0;
        for (int i = 0; i <= k; i++) {
            sum += poissonProbability(i);
        }
        return sum;
    }

    /**
     * Método para calcular el factorial de un número de manera eficiente
     * @param n Número entero
     * @return Factorial de n
     */
    private long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /**
     * Devuelve un valor aleatorio generado según la distribución de Poisson
     * usando el método de Knuth
     * @return Número aleatorio que sigue la distribución de Poisson
     */
    public int generateRandomPoisson() {
        Random random = new Random();
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= random.nextDouble();
        } while (p > L);

        return k - 1;
    }

    /**
     * Calcula la media de la distribución de Poisson (que es igual a lambda)
     * @return Media de la distribución
     */
    public double mean() {
        return lambda;
    }

    /**
     * Calcula la varianza de la distribución de Poisson (que es igual a lambda)
     * @return Varianza de la distribución
     */
    public double variance() {
        return lambda;
    }
    
}
