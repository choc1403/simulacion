
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

    // P (X = k ) = e^-lambda * lambda^k / k!
    public double poissonProbability(int k) {
        if (k < 0) return 0;
        return (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k);
    }

    
    
    // Método para calcular la probabilidad acumulada P(X ≤ k)
    public double probabilidad_menor_igual(int k) {
        double suma = 0;
        for (int i = 0; i <= k; i++) {
            suma += poissonProbability(i);
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
    

    
    private long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    
    public double poblacion_finita(double desviacion, int muestra, int poblacion){
        return (double)( desviacion /Math.sqrt(muestra)) * (Math.sqrt((poblacion - muestra) / (poblacion -1)));
    }
    
    public double poblacion_infinita(double desviacion, int muestra){
        return (double) (desviacion / Math.sqrt(muestra));
    }

    
    public double media() {
        return lambda;
    }

    
    public double desviacion_estandar(int x, double media, int n){
        double suma = 0;
        
        for (int i = 0; i <= x; i++) {
            suma += Math.pow(i - media, 2);
        }
        
        
        
        
        return Math.sqrt(suma/n);
    }
    
}
