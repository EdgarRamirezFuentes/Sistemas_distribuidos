/**
 * La clase Coordenada es la encargada de almacenar un punto sobre el plano
 * Proyecto 2
 * Grupo: 4CM13
 * @author Edgar Alejandro Ramírez Fuentes
 * @version 1.0
 * @since 2022-02-22
 */ 

public class Coordenada {

    private double x, y, magnitud;

    /**
     * Constructor de la clase Coordenada
     * @param x Es el valor en x del plano
     * @param y Es el valor en y del plano
     */
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
	    this.magnitud = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    /**
     * Retorna el valor de x de la coordenada
     * @return double El valor de x de la coordenadad
     */
    public double get_abcisa() { return x; }

    /**
     * Retorna el valor de y de la coordenada
     * @return double El valor de y de la coordenada
     */ 
    public double get_ordenada() { return y; }

    /**
     * Obtiene la magnitud de la coordenada
     * @return double La magnitud de la coordenada
     */ 
    public double get_magnitud() { return magnitud; }

    /**
     * Establece el valor de x en la coordenada
     * @param x El nuevo valor que va a tomar x
     */ 
    public void set_abcisa(double x) { this.x = x; }

    /**
     * Establece el valor de y en la coordenada
     * @param x El nuevo valor que va a tomar y
     */ 
    public void set_ordenada(double y) { this.y = y; }

    /**
     * Sobreescritura del método toString
     */ 
    @Override
    public String toString( ) { return "[" + x + "," + y + "]"; }

}
