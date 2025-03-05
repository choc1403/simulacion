
package probabilidad;


public class Binomial extends Datos{

    public Binomial() {
    }
    
    // Método para calcular el factorial
    public double factorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        }

        double factoria = 1;
        for (int i = 2; i <= numero; i++) {
            factoria *= i;
        }

        return factoria;
    }
    
    // Método para calcular el coeficiente binomial
    public double coeficiente_binomial(int n,int x) {
        
        return factorial(n) / (factorial(x) * factorial(n - x));
    }
    
    // Método para calcular la probabilidad binomial exacta P(X = k)
    public double probabilidad_exacta(double p,int x, double q, int n) {
        double nCK = coeficiente_binomial(n,x);
        
        return nCK * Math.pow(p, x) * Math.pow(q, (n - x));
    }

    // Método para calcular la probabilidad acumulada P(X ≤ k)
    public double probabilidad_menor_igual(double p, int k, double q, int n) {
        double suma = 0;
        for (int i = 0; i <= k; i++) {
            suma += probabilidad_exacta(p,i,q,n);
        }
        return suma;
    }

    // Método para calcular P(X < k)
    public double probabilidad_menor(double p, int k, double q, int n) {
        return probabilidad_menor_igual(p,k - 1,q,n);
    }

    // Método para calcular P(X ≥ k)
    public double probabilidad_mayor_igual(double p, int k, double q, int n) {
        return 1 - probabilidad_menor(p,k,q,n);
    }

    // Método para calcular P(X > k)
    public double probabilidad_mayor(double p, int k, double q, int n) {
        return 1 - probabilidad_menor_igual(p,k,q,n);
    }

    // Método para verificar si la población es infinita
    public boolean verificar_infinita() {
        return (getPoblacion() <= 0 || (double) getMuestra() / getPoblacion() <= 0.05);
    }
    // Método para calcular la media
    public double media() {
        return getMuestra() * getProb_exito();
    }

    // Método para calcular la desviación estándar
    public double desviacion() {
        double calculo = Math.sqrt(getMuestra() * getProb_exito() * (getProb_fracaso()));
        if (verificar_infinita()) {
            return calculo;
        }
        return factor_correcion() * calculo;

    }
    
    // Método para el factor de correción
    public double factor_correcion() {
        double numerador = getPoblacion() - getMuestra();
        double denomidor = getPoblacion() - 1;
        double proc = numerador / denomidor;
        return Math.sqrt(proc);
    }
    
    
}
