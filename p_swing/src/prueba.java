import javax.swing.*;
import java.util.*;

public class prueba {
    static List<Producto> catalogo = Catalogo.get_productos();

    public static void main(String[] args) {

        catalogo.forEach(p -> System.out.println(p.getId()));
    }
}
