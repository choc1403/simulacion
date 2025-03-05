
package probabilidad;


public class Binomial extends Datos{

    public Binomial() {
    }
    
    
    
    // Método para calcular el coeficiente binomial
    public double coeficiente_binomial(int x) {
        if (getMuestra() < x) {
            return 0; // No es posible tener más éxitos que intentos
        }
        return factorial(getMuestra()) / (factorial(x) * factorial(getMuestra() - x));
    }
    
    // Método para calcular la probabilidad binomial exacta P(X = k)
    public double probabilidad_exacta(int x) {
        double nCK = coeficiente_binomial(x);
        return nCK * Math.pow(getProb_exito(), x) * Math.pow(getProb_fracaso(), (getMuestra() - x));
    }

    // Método para calcular la probabilidad acumulada P(X ≤ k)
    public double probabilidad_menor_igual(int k) {
        double suma = 0;
        for (int i = 0; i <= k; i++) {
            suma += probabilidad_exacta(i);
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
