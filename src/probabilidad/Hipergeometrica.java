package probabilidad;

import java.math.BigInteger;

public class Hipergeometrica extends Datos{
    
    public Hipergeometrica(int poblacion, int muestra, int exitos_rango, int exitos_poblacion) {
        super(poblacion, muestra, exitos_rango, exitos_poblacion);
    }
    
    public double media(){
        if (getExitos_poblacion() == 0){
            return getMuestra() * getProb_exito();
            
        }
        return getMuestra() * ((double) getExitos_poblacion() / getPoblacion());
    }
    
    public double desviacionEstandar(){
        double N = getPoblacion();
        double K = getExitos_poblacion();
        double n = getMuestra();
        
        double factor1 = (K/ N);
        double factor2 = ((N - K) / N);
        double factor3 = ((N - n) / (N-1));
        
        return Math.sqrt(n * factor1 * factor2 * factor3);
    }
    
    public double calcularProbabilidad() {
        int N = getPoblacion();
        int K = getExitos_poblacion();
        int n = getMuestra();
        int k = getExitos_rango();

        //double combinacionesExitos = combinatoria(K, k).doubleValue();
        //double combinacionesFracasos = combinatoria(N - K, n - k).doubleValue();
        //double combinacionesTotales = combinatoria(N, n).doubleValue();

        //if (combinacionesTotales == 0) return 0; // Manejo de error

        //return (combinacionesExitos * combinacionesFracasos) / combinacionesTotales;
        return 0;
    }
    
    
}