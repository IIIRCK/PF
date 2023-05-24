import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente extends Persona   {

    public static List<Cliente>clientes = new ArrayList<Cliente>();
    private static int idct = 1;
    private int id ;
    private String  psswd;
    public Cliente(String nombre, String[] apellido, String direccion, String numero, String correo , String psswd) throws Input_Constructor_Error {
        super(nombre, apellido, direccion, numero, correo);
        this.id= idct;
        if(psswd.isEmpty()){
            this.psswd = null;
        }else {
            this.psswd = psswd;
        }

        idct++;
    }

    public void add_Cliente() {
        clientes.add(this);
    }
    public void remove_Cliente() {clientes.remove(this);}

    public static List<Cliente> getClientes() {return clientes;}
    public int getId() {return id;}

//

    public String getPsswd() {
        return psswd;
    }

    public String  getcliente(){
        return id + " " + this.getNombre()+ " " + this.getNumero();
    }

    @Override
    public String toString() {
        return super.toString() + ";" +
                psswd + ";" +
                id;

    }


}
