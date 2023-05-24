import javax.swing.*;
import java.util.List;

public class Sistema {
    private static List<Personal> personal = Personal.get_personal();
    private static List<Cliente> clientes = Cliente.getClientes();

    private static Persona currentpersona;
    public Sistema(){}

    public boolean login(JTextField m , JPasswordField p) {
        String username = m.getText();
        String password = new String(p.getPassword());
        for (Personal personal : personal) {
            if (personal.getCorreo().equals(username) && personal.getPsswd().equals(password)) {
                return true;
            }
        }
        for (Cliente cliente : clientes) {
            if (!cliente.getCorreo().equals(username) && !cliente.getPsswd().equals(password) || cliente.getPsswd() == null) {

                return false;
            } else
                return true;

        }
        return false;
    }

    public void println(String x){
        System.out.println(x);
    }
    public void println(Producto x){
        System.out.println(x);
    }

}
