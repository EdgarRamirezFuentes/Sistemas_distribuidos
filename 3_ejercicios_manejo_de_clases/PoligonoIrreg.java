import java.util.Random;

public class PoligonoIrreg{

	private Coordenada[] vertices;
	private int tam = 0;

	//Constructor de la clase
	public PoligonoIrreg(int n){
		vertices = new Coordenada[n];
	}

	//Método para añadir vértices
	public void anadeVertice(Coordenada c){
		vertices[tam] = c;
		tam++;
	}

	//Sobreescritura del método toString para imprimir lista de objetos tipo "Coordenada"
	@Override
	public String toString(){
		String cadena = "";
		for(int i = 0; i < tam; i++)
			cadena += "La coordenada " + Integer.toString(i+1) + " es: " + vertices[i].toString() + "\n";
		return cadena;
	}
}
