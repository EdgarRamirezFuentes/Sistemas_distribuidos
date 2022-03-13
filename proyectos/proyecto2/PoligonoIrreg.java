/**
 * La clase PoligonoIrreg es utilizada para obtener los vértices de un Polígono Irregular.
 * Proyecto 2
 * Grupo: 4CM13
 * @author Edgar Alejandro Ramírez Fuentes
 * @version 1.1
 * @since 2022-02-22
 */ 

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class PoligonoIrreg{
    // Almacena las coordenadas de los vértices del polígono
	private List<Coordenada> vertices;

	/**
     * Constructor de la clase e inicializa la lista de vertices
     */ 
	public PoligonoIrreg(){ vertices = new ArrayList<Coordenada>(); }

	/*
     * Añade una coordenada a la lista de vértices
     * @param c Es una coordenada que se va a agregar a la lista de coordenadas del polígono
     */ 
	public void add_vertice(Coordenada c) { vertices.add(c); }
    
    /**
     * Retorna la lista de vértices del polígono
     * @return List<Coordenada> Es la lista de vértices del polígono
     */ 
    public List<Coordenada> get_vertices() { return vertices; }

    /**
     * Ordena los vértices del polígono con base a la magnitud
     */ 
	public void ordenaVertices(){
		Comparator<Coordenada> comparador = (Coordenada c1, Coordenada c2) -> (int)(c1.get_magnitud() - c2.get_magnitud());
		Collections.sort(vertices, comparador);
	}

    /**
     * Limpia la lista que contiene los vértices del Polígono.
     */ 
    public void limpiar_vertices() {
      vertices.clear();
    }

	/**
     * Sobreescritura del método toString para imprimir lista de objetos tipo "Coordenada"
     * @return String La cadena que representa al objeto
     */ 
	@Override
	public String toString(){
		String cadena = "";

		for(Coordenada c: vertices){
			cadena += "Coordenada: " + c.toString() + " Magnitud: " + c.get_magnitud() + "\n";
		}

		return cadena;
	}
}
