/**
 * La clase PoligonoRegular es utilizada para obtener los vértices de un polígono regular dentro de una circunferencia.
 * Proyecto 2 
 * Grupo: 4CM13
 * @author Edgar Alejandro Ramírez Fuentes
 * @version 1.0
 * @since 2022-03-10
 */ 

import java.util.Random;

public class PoligonoRegular extends PoligonoIrreg {
  private int lados, centro_x, centro_y, radio;
  private double angulo;

  public PoligonoRegular(int lados) {
    // Inicializa el arreglo de vértices del polígono.
    super();
    this.lados = lados;
    this.angulo = (2 * Math.PI) / lados;
    Random r = new Random();
    // Genera la posición pseudo aleatoria del poligono en el panel
    centro_x = r.nextInt(600) + 100;
    centro_y = r.nextInt(600) + 100;
    // Genera un radio de entre 50 y 100
    radio = r.nextInt(61) + 50;

    calcular_vertices();
  } 

  /**
   * Calcula los vértices del polígono regular con base en la posición del centro de una circunferencia
   */ 
  private void calcular_vertices() {
    // Hacemos la limpieza de los vértices anteriores.
    limpiar_vertices(); 
    for (int i = 0; i < lados; i++) {
      add_vertice(new Coordenada(centro_x + radio * Math.cos(i * angulo), centro_y + radio * Math.sin(i * angulo)));
    }
  }

  /**
   * Asigna nuevos valores a las coordenadas del centro de la circunferencia en la que se va a construir el polígono regular.
   * @param x Es la nueva ubicación en x del centro de la circunferencia.
   * @param y Es la nueva ubicación en y del centro de la circunferencia. 
   */ 
  public void set_centro(int x, int y) {
    centro_x = x;
    centro_y = y;
    // Recalculamos los vértices con base en el nuevo centro de la circunferencia
    calcular_vertices();
  }

  /**
   * Calcula el área del Polígono regular
   * @return double Retorna el valor del área del polígono regular
   */ 
  public double get_area() {
    double apotema = radio / (2 * Math.tan(angulo / 2));
    return (radio * lados * apotema) / 2;
  }
}
