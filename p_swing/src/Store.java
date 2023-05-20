import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Store {
    private JComboBox comboBox1;
    private JPanel panel;
    private JPanel p0;
    private JTextField mail;
    private JTabbedPane p1;
    private JPanel tbpusuario;
    private JPanel tbpcatalogo;
    private JPanel tbpcarrito;
    private JPasswordField psswd;
    private JButton login;
    private JButton singin;
    private JLabel llnotify;
    private JPanel p01;
    private JLabel nombre;
    private JTextField tfsnombre;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField tfsapellido;
    private JLabel tfsdireccion;
    private JLabel tfsnumero;
    private JLabel tfscorreo;
    private JLabel pfspsswd;
    private JButton createButton;
    private JButton cancelButton;
    private JLabel lsnotify;
    private JPasswordField passwordField1;
    private JLabel pfpsswd1;
    private JPanel tbppedidos;
    private JTabbedPane p2;

    static List<Cliente> clientes = Cliente.getClientes();
    static List<Personal> personal = Personal.get_personal();

    public Store() throws MyExeptions.Input_Constructor_Error {
        JFrame frame = new JFrame("Login");
        new Cliente("Juan", new String[]{"Perez","12"}, "Calle 1", "123456789", "hola@gmail.com", "1234").add_Cliente();
        new Personal().add_personal(new Personal("Juan", new String[]{"Perez","ss"}, "Calle 1", "123456789", "jefe@gmail.com", "1000", Personal.cargo.jefe, "1234"));
        CardLayout cardLayout = new CardLayout();

        panel.setLayout(cardLayout);
        p0.setVisible(true);
        p01.setVisible(false);
        p1.setVisible(false);

        panel.add(p0, "Login");
        panel.add(p1, "Main");
        panel.add(p01, "Singin");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);

        mail.setText("hola@gmail.com");
        psswd.setText("1234");

        login.addActionListener( a->{
            if (login()) {
                cardLayout.show(panel, "Main");
                frame.setTitle("Store");
                llnotify.setText("");} else {
                llnotify.setText("Credenciales incorrectas");}}
        );
        singin.addActionListener(a ->{
            cardLayout.show(panel, "Singin");
            frame.setTitle("Singin");

        });
    }

    public boolean login() {
        String username = mail.getText();
        String password = new String(psswd.getPassword());
        for (Personal personal : personal) {
            if (personal.getCorreo().equals(username) && personal.getPsswd().equals(password)) {
                return true;
            }

        }

        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(username) && cliente.getPsswd().equals(password)) {
                return true;
            }
            cliente.toString();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Store();
                } catch (MyExeptions.Input_Constructor_Error e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
