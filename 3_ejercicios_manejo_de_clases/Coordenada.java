public class Coordenada {

    private double x, y;

    //constructor de la clase
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Metodo getter de x
    public double abcisa() { return x; }

    //Metodo getter de y
    public double ordenada() { return y; }
    
    //Metodo setter de x
    public void setAbcisa(double x) { this.x = x; }

    //Metodo setter de y
    public void setOrdenada(double y) { this.y = y; }

    //Sobreescritura del método de la superclase objeto para imprimir con System.out.println( )
    @Override
    public String toString() { return "[" + x + "," + y + "]"; }

}
