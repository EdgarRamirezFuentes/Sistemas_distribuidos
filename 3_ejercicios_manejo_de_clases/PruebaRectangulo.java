import java.util.Random;

public class PruebaRectangulo {

    public static void main (String[] args) {

	//Primera modificación - Agregar el constructor de la clase Rectangulo

	Coordenada c1, c2;

	c1 = new Coordenada(2,3);
	c2 = new Coordenada(5,1);

	Rectangulo rect1 = new Rectangulo(c1, c2);

        double ancho, alto;

        System.out.println("Calculando el área de un rectángulo dadas sus coordenadas en un plano cartesiano:");
	System.out.println(rect1);

        alto = rect1.superiorIzquierda().ordenada() - rect1.inferiorDerecha().ordenada();
        ancho = rect1.inferiorDerecha().abcisa() - rect1.superiorIzquierda().abcisa();

        System.out.println("El área del rectángulo es = " + ancho*alto);

	//Segunda modificación - Crear la clase PoligonoIrreg

	PoligonoIrreg p = new PoligonoIrreg(2);
	p.anadeVertice(c1);
	p.anadeVertice(c2);
	System.out.println(p.toString());

	//Tercera y cuarta modificación - Comparar creación de objeto Coordenada y métodos setter

	long tiempoIni = System.nanoTime();
	PoligonoIrreg px = new PoligonoIrreg(10000000);
	Random r = new Random();
	for(int i = 0; i < 10000000; i++)
		px.anadeVertice(new Coordenada(r.nextInt(100), r.nextInt(100)));
	System.out.println("Tiempo en nanosegundos 1 = " + (System.nanoTime() - tiempoIni));

	tiempoIni = System.nanoTime();
	PoligonoIrreg px2 = new PoligonoIrreg(10000000);
	Random r2 = new Random();
	Coordenada cx = new Coordenada(0,0);
	for(int i = 0; i < 10000000; i++){
		cx.setAbcisa(r2.nextInt(100));
		cx.setOrdenada(r2.nextInt(100));
		px2.anadeVertice(cx);
	}
	System.out.println("Tiempo en nanosegundos 2 = " + (System.nanoTime() - tiempoIni));

    }

}
