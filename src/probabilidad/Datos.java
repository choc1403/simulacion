package probabilidad;

/**
 *
 * @author eloic
 */
public class Datos {

    private int poblacion = 0; // N (Tamaño total de la población)
    private int muestra = 0;   // n (Tamaño de la muestra)
    private int exitos_rango = 0; // x (Éxitos en la muestra)
    private double prob_exito = 0; // p (Probabilidad de éxito, solo para binomial)
    private double prob_fracaso = 0; // q (Probabilidad de fracaso, solo para binomial)
    private int exitos_poblacion = 0; // K (Éxitos totales en la población, solo para hipergeométrica)

    // Constructor para distribución binomial
    public Datos(int poblacion, int muestra, int exitos_rango, double prob_exito, double prob_fracaso) {
        this.poblacion = poblacion;
        this.muestra = muestra;
        this.exitos_rango = exitos_rango;
        this.prob_exito = prob_exito;
        this.prob_fracaso = prob_fracaso;
    }

    // Constructor para distribución hipergeométrica
    public Datos(int poblacion, int muestra, int exitos_rango, int exitos_poblacion) {
        this.poblacion = poblacion;
        this.muestra = muestra;
        this.exitos_rango = exitos_rango;
        this.exitos_poblacion = exitos_poblacion;
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

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public void setMuestra(int muestra) {
        this.muestra = muestra;
    }

    public void setExitos_rango(int exitos_rango) {
        this.exitos_rango = exitos_rango;
    }

    public void setProb_exito(double prob_exito) {
        this.prob_exito = prob_exito;
    }

    public void setProb_fracaso(double prob_fracaso) {
        this.prob_fracaso = prob_fracaso;
    }

    public void setExitos_poblacion(int exitos_poblacion) {
        this.exitos_poblacion = exitos_poblacion;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public int getMuestra() {
        return muestra;
    }

    public int getExitos_rango() {
        return exitos_rango;
    }

    public double getProb_exito() {
        return prob_exito;
    }

    public double getProb_fracaso() {
        return prob_fracaso;
    }

    public int getExitos_poblacion() {
        return exitos_poblacion;
    }
    
    public double calcular_sesgo(){
        double numerador = getProb_fracaso() - getProb_exito();
        double denominador = Math.sqrt((getMuestra() * getProb_exito() * getProb_fracaso()));
        
        double resultado = numerador / denominador;
        
        return resultado;
    }
    
    public double calcular_cortosis(){
        double numerador = 1- (6*getProb_exito() * getProb_fracaso());
        double denominador = Math.sqrt((getMuestra() * getProb_exito() * getProb_fracaso()));
        double resultado = 3 + (numerador / denominador);
        
        
        return resultado;
    }
    
    public String verificacion(){
        double valor = getMuestra() / getPoblacion();
        
        if (valor >= 0.2){
            return "HIPERGEOMETRICA";
        }
        return "BINOMIAL";
        
    }

    
}
