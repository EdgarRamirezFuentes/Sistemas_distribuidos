import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class PoligonoIrreg{

	List<Coordenada> vertices;

	//Constructor de la clase
	public PoligonoIrreg(){ vertices = new ArrayList<Coordenada>(); }

	//Método para añadir vértices
	public void anadeVertice(Coordenada c){ vertices.add(c); }

	public void ordenaVertices(){
		Comparator<Coordenada> comparador = (Coordenada c1, Coordenada c2) -> (int)(c1.magnitud() - c2.magnitud());
		Collections.sort(vertices, comparador);
	}

	//Sobreescritura del método toString para imprimir lista de objetos tipo "Coordenada"
	@Override
	public String toString(){
		String cadena = "";

		for(Coordenada c: vertices){
			cadena += "Coordenada: " + c.toString() + " Magnitud: " + c.magnitud() + "\n";
		}

		return cadena;
	}
}
