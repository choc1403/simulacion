package probabilidad;

/**
 *
 * @author eloic
 */
public class Datos {

    private int poblacion = 0; 
    private int muestra = 0;   
    private int exitos_rango = 0; 
    private double prob_exito = -1; // Inicializamos en -1 para indicar que no se ha calculado
    private double prob_fracaso = -1;
    private int exitos_poblacion = 0; 
    private double lambda = 0;

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public Datos() {
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getMuestra() {
        return muestra;
    }

    public void setMuestra(int muestra) {
        this.muestra = muestra;
    }

    public int getExitos_rango() {
        return exitos_rango;
    }

    public void setExitos_rango(int exitos_rango) {
        this.exitos_rango = exitos_rango;
    }

    public double getProb_exito() {
        if (prob_exito == -1) { // Solo calcular si no ha sido asignado
            if (poblacion != 0 && exitos_poblacion != 0) {
                prob_exito = (double) exitos_poblacion / poblacion;
            } else if (prob_fracaso != -1) {
                prob_exito = 1 - prob_fracaso;
            }
        }
        return prob_exito;
    }

    public void setProb_exito(double prob_exito) {
        this.prob_exito = prob_exito;
        this.prob_fracaso = 1 - prob_exito; // Ajustar automáticamente probabilidad de fracaso
    }

    public double getProb_fracaso() {
        if (prob_fracaso == -1) {
            if (prob_exito != -1) {
                prob_fracaso = 1 - prob_exito;
            }
        }
        return prob_fracaso;
    }

    public void setProb_fracaso(double prob_fracaso) {
        this.prob_fracaso = prob_fracaso;
        this.prob_exito = 1 - prob_fracaso; // Ajustar automáticamente probabilidad de éxito
    }

    public int getExitos_poblacion() {
        return exitos_poblacion;
    }

    public void setExitos_poblacion(int exitos_poblacion) {
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

    // Método para calcular sesgo
    public double sesgo() {
        double p = getProb_exito();
        double q = getProb_fracaso();

        if (muestra == 0 || p == 0 || q == 0) {
            throw new ArithmeticException("No se puede calcular el sesgo con valores nulos o cero.");
        }

        return (q - p) / Math.sqrt(muestra * p * q);
    }

    // Método para calcular curtosis
    public double curtosis() {
        double p = getProb_exito();
        double q = getProb_fracaso();

        if (muestra == 0 || p == 0 || q == 0) {
            throw new ArithmeticException("No se puede calcular la curtosis con valores nulos o cero.");
        }

        return 3 + (1 - 6 * p * q) / (Math.sqrt(muestra * p * q));
    }
}
