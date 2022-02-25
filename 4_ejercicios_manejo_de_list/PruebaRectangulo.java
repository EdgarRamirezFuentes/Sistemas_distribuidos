import java.util.Random;

public class PruebaRectangulo {

    public static void main (String[] args) {
	PoligonoIrreg p = new PoligonoIrreg();
	Random r = new Random();
	for(int i = 0; i < 10; i++)
		p.anadeVertice(new Coordenada(r.nextFloat() * (r.nextInt(200) - 100), r.nextFloat() * (r.nextInt(200) - 100)));
	System.out.println("Los 10 vértices desordenados son:");
	System.out.println(p.toString());
	p.ordenaVertices();
	System.out.println("Los 10 vértices ordenados son:");
	System.out.println(p.toString());
   }

}
