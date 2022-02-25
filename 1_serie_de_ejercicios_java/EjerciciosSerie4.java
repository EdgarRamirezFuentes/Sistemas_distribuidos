import java.util.ArrayList;
public class EjerciciosSerie4 {
    public static void main(String[] args){
      int l = 0, r = 1, m = 1, aux;
      for (int i = 1; i <= 20; i++) {
        if (i == 1) {
          System.out.printf("%d ", l);
        } else if (i == 2) {
          System.out.printf("%d ", m);
        } else if (i == 3) {
          System.out.printf("%d ", r);
        } else {
          System.out.printf("%d ", l+m+r);
          aux = l+m+r;
          l = m;
          m = r;
          r = aux;
        }
      }
    }
}
