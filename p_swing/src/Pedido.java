import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {

    List<Pedido> pedidos = new ArrayList<>();

    private static int idct = 1;
    private int id;

    private int id_p_a;
    private int id_p_c;

    //Map<Producto,Integer>
    public Pedido(int id_p_a,int id_p_c) {
        this.id = idct;
        this.id_p_a = id_p_a;
        this.id_p_c = id_p_c;
        idct++;
    }


}


