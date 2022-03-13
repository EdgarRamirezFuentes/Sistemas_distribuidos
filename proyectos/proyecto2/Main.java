/*
 * El programa GUI se encarga de crear una interfaz gráfica en la cual se mostrarán la cantidad elegida de polígonos regulares.
 * Proyecto 2
 * Grupo: 4CM13
 * @author Edgar Alejandro Ramírez Fuentes
 * @version 1.1
 * @since 2022-02-24
 **/

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Thread; 
import java.util.Comparator;
import java.util.Collections;

public class Main {
  static List<PoligonoRegular> poligonos = new ArrayList<PoligonoRegular>();
  public static void main(String[] args) {
    try {
      Scanner scn = new Scanner(System.in);
      Random r = new Random();
      int num_poligonos;
      System.out.printf("¿Cuantos poligonos se van a graficar? ");
      num_poligonos = scn.nextInt();

      // Creando los polígonos 
      for (int i = 0; i < num_poligonos; i++) {
        // Solo crea poligonos regulares de 3 a 8 lados
        poligonos.add(new PoligonoRegular(r.nextInt(10) + 3)); 
      }

      // Creamos el Frame que va a contener los paneles del programa
      JFrame frame = new JFrame();
      frame.setSize(1200, 1200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      // Creamos el panel que va a mostrar los polígonos posicionados de manera aleatoria 
      JPanel panel = new JPanel() {
        @Override
        public void paintComponent(Graphics g)
        {
          g.setColor(Color.blue);
          for (PoligonoRegular poligono_regular : poligonos) {
          Polygon poligono = new Polygon();
           List<Coordenada> vertices = poligono_regular.get_vertices();
           for (Coordenada vertice : vertices) {
             poligono.addPoint((int) vertice.get_abcisa(), (int) vertice.get_ordenada());
           }
           g.drawPolygon(poligono);
          }
        }
      };

      // Agregamos el panel encargado de mostrar todos los polígonos en ubicaciones aleatorias. 
      frame.add(panel);
      Thread.sleep(3000);
      // Eliminamos el panel porque ya no se va a utilizar
      frame.remove(panel);
      frame.revalidate();
      // Limpiamos el panel
      frame.repaint();

      // Ordenamos los polígonos por área de menor a mayor
      Comparator<PoligonoRegular> cmp = (PoligonoRegular p1, PoligonoRegular p2) -> (int) (p1.get_area() - p2.get_area());
      Collections.sort(poligonos, cmp);

      // Creamos el panel que va a mostrar los polígonos ordenados por área
      JPanel panel2 = new JPanel() {
        // Lleva el control del polígono que toca mostrar.
        private int id_poligono = 0;
        @Override
        public void paintComponent(Graphics g)
        {
          PoligonoRegular poligono_regular = poligonos.get(id_poligono);
          g.setColor(Color.red);
          Polygon poligono = new Polygon();
          List<Coordenada> vertices = poligono_regular.get_vertices();
          poligono_regular.set_centro(600, 600);
          for (Coordenada vertice : vertices) {
            poligono.addPoint((int) vertice.get_abcisa(), (int) vertice.get_ordenada());
          }
          g.drawPolygon(poligono);
          id_poligono++;
        }
      };

      // Agregamos el panel encargado de mostrar los polígonos por área de menor a mayor. 
      frame.add(panel2);
      frame.revalidate();

      // Realizamos el pintado de los polígonos 1 por 1.
      for (int i = 0; i < num_poligonos - 1; i++) {
        Thread.sleep(2000);
        frame.repaint();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
