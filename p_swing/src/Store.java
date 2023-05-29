import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class Store {
    private JComboBox cbxspuesto;
    private JPanel panel;
    private JPanel p0;
    private JTextField mail;
    private JTabbedPane p1;
    private JPasswordField psswd;
    private JButton login;
    private JButton singin;
    private JLabel llnotify;
    private JPanel p01;
    private JTextField tfsnombre;
    private JTextField tfscorreo;
    private JTextField tfsapellido;
    private JButton p01DBoton;
    private JButton cancelButton;
    private JLabel lsnotify;
    private JTextField pfspsswd1;
    private JLabel lspsswd0;
    private JLabel lspsswd1;
    private JLabel lspuesto;
    private JTextField pfspsswd0;
    private JTextField tfsnumero;
    private JTextField tfsdireccion;
    private JPanel p1_1;
    private JButton okbcliente;
    private JButton p1cboton1;
    private JButton p1cboton2;
    private JPanel p1catalogo;
    private JLabel p1cprecio;
    private JPanel p1cimagen;
    private JComboBox p1ccantidad;
    private JComboBox clientescbox;
    private JTextField tfcliente;
    private JLabel p1clientntfy;
    private JTextArea p1clientelist;
    private JComboBox p01DList;
    private JTextField p01tfsalary;
    private JTextPane p1tpclientlist;
    //private JScrollPane p1splist;
    private JComboBox cbxstipo;
    private JTextArea p1cdata;
    private JTextPane p1alista;
    private JComboBox comboBox1;
    private JButton button1;
    private JPanel p1almacen;
    private JComboBox p1cfiltro;
    private JSlider p1cslider;
    private JButton p1ccarrito;
    private JTextField p1ctfid;
    private JButton p1cvender;
    private JTextPane p1clista;
    private JButton p1saddp;
    private JPanel P02;
    private JTextField p02tfn;
    private JTextField p02tfm;
    private JTextField p02tfp;
    private JComboBox p02cbc;
    private JButton p02btc;
    private JButton p02bta;
    private JPanel p1setings;
    private JLabel p02ntfy;
    private JButton p1climpiar;
    private JButton p1cbtid;
    private JPanel p1carrito;
    private JLabel p1cntfy;
    private JScrollPane p1cscroollp;
    private JLabel p1ctotal;
    private JTextPane p1pedidos;
    List<Cliente> clientes = Cliente.getClientes();
    List<Personal> personal = Personal.get_personal();
    Map<Integer, Integer> almacen = Almacen.get_productos();
    List<Producto> catalogo = Catalogo.get_productos();
    List<Producto.Categoria> categorias = Producto.Categoria.getCategorias();
    Map<Integer,Integer> carrito = Carrito.get_productos();
    List<Pedido> pedidos = Pedido.get_pedidos();
    int crrntid =-1;
    String prvp = "";
    int crrntct = 0;

    int crrtpr =0;
    int crrtotal =0;

    int[] ctpc = new int[5];
    int[] ctpcc = new int[5];

    int ctpid;

    int ct=0;

    enum p01tipo{
        cliente,
        personal

    }
    enum p01action {
        Crear,
        Guardar,
        Cambiar_Psswd,
        Delete_cliente,
        Delete_personal,
    }

    public Store()  throws MyExeptions.Input_Constructor_Error, MyExeptions.Input_Constructor_Error {
        JTextField[] tfdisa = {p01tfsalary,pfspsswd0,pfspsswd1};

        new Catalogo().fill_Catalogo();

        for (JTextField tf : tfdisa) {
            tf.setEnabled(false);

        }
        JTextPane[] tpdisa = {p1tpclientlist};
        for (JTextPane tf : tpdisa) {
            tf.setEnabled(false);

        }

        JComboBox[] cbdisa = {cbxstipo};
        for (JComboBox tf : cbdisa) {
            tf.enable(false);

        }
        // arriba setea algunos campos como deshabilitados
        Sistema sys = new Sistema();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setVisible(true);
        CardLayout cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        p0.setVisible(true);
        p01.setVisible(false);
        p1.setVisible(false);
        panel.add(p0, "Login");
        panel.add(p1, "Main");
        panel.add(p01, "Singin");
        panel.add(P02,"addp") ;
        new Cliente("Juan", new String[]{"Perez", "12"}, "Calle 1", "123456789", "hola@gmail.com", "1234").add_Cliente();
        new Personal().add_personal(new Personal("Juan", new String[]{"Perez", "ss"}, "Calle 1", "987654321", "jefe@gmail.com", "1000", Personal.cargo.jefe, "1234"));
        new Cliente("Jose", new String[]{"Perez", "12"}, "Calle 1", "123451111", "hola@gmail.com", "1234").add_Cliente();

        mail.setText("jefe@gmail.com");
        psswd.setText("1234");

        //login
        login.addActionListener(a -> {
                    if (sys.login(mail, psswd)) {
                        cardLayout.show(panel, "Main");
                        frame.setTitle("Store");
                        llnotify.setText("");
                    } else {
                        llnotify.setText("Credenciales incorrectas");
                    }
                }
        );


        //P01 = Singin/Modify
        // abajo se setea configuraciones para los comboBoxes como tipo de personal, tipo de persona y acciones
        singin.addActionListener(a -> {
            cardLayout.show(panel, "Singin");
            frame.setTitle("Singin");
            set_empty();
            crrntid =-1;

        });
        personal.forEach(p -> {
            for ( Personal.cargo c: Personal.cargo.values()) {
                cbxstipo.addItem( c);
            }

        });//anade los tipos de personal al comboBox
        //setea los tipos de persona
        cbxspuesto.addItem(p01tipo.cliente);
        cbxspuesto.addItem(p01tipo.personal);
        //setea las acciones
        p01DList.addItem(p01action.Crear);
        p01DList.addItem(p01action.Guardar);
        p01DList.addItem(p01action.Cambiar_Psswd);
        p01DList.addItem(p01action.Delete_cliente);
        p01DList.addItem(p01action.Delete_personal);

        cbxspuesto.addActionListener(a->{
            if (cbxspuesto.getSelectedItem().equals(p01tipo.personal)){
                p01tfsalary.setEnabled(true);
                pfspsswd0.setEnabled(true);
                pfspsswd1.setEnabled(true);
            }else{ p01tfsalary.setEnabled(false);
                pfspsswd0.setEnabled(false);
                pfspsswd1.setEnabled(false);
            }
        });//comprueba si es personal o cliente y habilita o deshabilita campos

        cbxstipo.addActionListener(a-> {
            if(cbxspuesto.getSelectedItem().equals(p01tipo.personal)){
                cbxstipo.enable(true);
            }else cbxstipo.enable(false);
        });//comprueba si es personal o cliente y habilita o deshabilita campos

        p01DBoton.addActionListener(x -> {
            if(p01DList.getSelectedItem().equals(p01action.Crear)){
                load_to_create();
            } else  if(p01DList.getSelectedItem().equals(p01action.Guardar)){
                load_to_save();
            }
            else if(p01DList.getSelectedItem().equals(p01action.Delete_cliente)){
                clientes.removeIf(c -> c.getId() == crrntid);
            }else if (p01DList.getSelectedItem().equals(p01action.Delete_cliente)){
                if(crrntid != -1){
                    clientes.removeIf(c -> c.getId() == crrntid);
                    lsnotify.setText("Cliente eliminado");
                }else   lsnotify.setText("No hay cliente seleccionado");

            }

        });//comprueba que accion se quiere realizar y llama a la funcion correspondiente

        cancelButton.addActionListener(a -> {
            if (prvp != "") {
                cardLayout.show(panel, prvp);
                frame.setTitle("Store");
            } else {
                cardLayout.show(panel, "Login");
                frame.setTitle("Login");
                crrntid = -1;
            }

        });//cancela la accion y vuelve al login

        //CLIENTES
        clientescbox.addItem("Listar");
        clientescbox.addItem("Modificar");
        //clientescbox.addItem("Eliminar");
        clientescbox.addItem("Crear");
        // p1splist.add(p1tpclientlist);
        okbcliente.addActionListener(a->{
            sys.println("ok");

            if(clientescbox.getSelectedItem().equals("Listar") && !tfcliente.getText().equals("")){
                clientes.forEach(c -> {
                    if (String.valueOf(c.getId()).equals(tfcliente.getText()) || c.getNumero().equals(tfcliente.getText())){
                    p1tpclientlist.setText(c.toString());
                    p1clientntfy.setText("encontrado ");}
                    else p1clientntfy.setText("no encontrado");
                });
            }else if(clientescbox.getSelectedItem().equals("Listar")){
                p1tpclientlist.setText("");
                clientes.forEach(c -> p1tpclientlist.setText(p1tpclientlist.getText() + c.toString() + "\n"));
                p1clientntfy.setText("listado");
            }
            else if(clientescbox.getSelectedItem().equals("Modificar")) {
                String x = tfcliente.getText();
                prvp = "Main";
                clientes.forEach(c -> {
                    if (String.valueOf(c.getId()).equals(x) || c.getNumero().equals(x)) {
                        cardLayout.show(panel, "Singin");
                        crrntid = c.getId();
                        load_to_edit(c.getId());
                    }else p1clientntfy.setText("no encontrado");
                });
            }else if(clientescbox.getSelectedItem().equals("Crear")) {
                prvp = "Main";
                cardLayout.show(panel, "Singin");
                crrntid = -1;
            }
            });
    //catalogo

        //actualiza el notificador de cantidad
        p1cprecio.setText("0");
        p1cslider.addChangeListener(c->{
            p1cprecio.setText(String.valueOf(p1cslider.getValue()));
        });
        p1cfiltro.addItem("Filtro");
        p1cfiltro.addItem("Marca");
        p1cfiltro.addItem("Precio");
        add_to_almacen();
        p1cboton1.addActionListener(a -> {

            Producto cc = new Catalogo().getBackItem(catalogo);
            ImageIcon ii = new ImageIcon(cc.getImgpath());
            p1cdata.setText(
                    "|| Nombre:" + cc.getNombre()+
                            " || Marca: " + cc.getMarca()+
                    "CATEGORIA: " +cc.getCategoria()
            );
            crrtpr = cc.getId();
            check_ct_almacen(cc.getId());
        });
        p1cboton2.addActionListener(a -> {
            Producto cc = new Catalogo().getNextItem(catalogo);
            p1cdata.setText(
                    "|| Nombre:" + cc.getNombre()+
                            " || Marca: " + cc.getMarca()

            );
            crrtpr = cc.getId();
           check_ct_almacen(cc.getId());

        });
        //boton para anyadir al carrito
        p1ccarrito.addActionListener(a->{

            int xx = p1cslider.getValue();
            ctpcc[ct]= xx;
            ctpc[ct] = crrtpr;
            ct++;
        new Carrito().add_producto(crrtpr,p1cslider.getValue());
        String x = crrtpr +" "+ String.valueOf(p1cslider.getValue());
        sys.println(x);
            for (Producto cc : catalogo) {
                for (Map.Entry<Integer, ?> entry : carrito.entrySet()) {
                    if (cc.getId() == crrtpr) {
                        new Carrito().add_producto(crrtpr,p1cslider.getValue());
                        p1clista.setText(p1clista.getText()+ " "+cc.getNombre()+" " + cc.getPrecio() +"\n");
                        crrtotal+=cc.getPrecio();

                        p1ctotal.setText(String.valueOf(crrtotal));
                       // System.out.println(cc.getNombre() + " " +cc.getPrecio());
                    }
                }
            }

        });

        p1cvender.addActionListener(a->{
            for (Producto c : catalogo) {
                for (Map.Entry<Integer, ?> entry : carrito.entrySet()) {
                    if (c.getId() == entry.getKey()) {
                        System.out.println(c.getNombre() + " " + c.getImgpath());
                    }
                }
            }
            int id = Integer.parseInt(p1ctfid.getText());
            new Pedido().add_pedido(ctpc,ctpcc,crrtotal,id);
            pedidos.forEach(p->{
                p.toString();
            });
            pedidos.forEach(p->{
                p1pedidos.setText(p1pedidos.getText()+p.toString());
            });

        });


        try {
            ImageIcon ii = new ImageIcon("/src/img/manga.png");
            JLabel il = new JLabel();
            il.setLayout( new BorderLayout());
            il.setIcon(ii);
            il.setPreferredSize(new Dimension(100, 100));
            p1cimagen.add(il, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        p1saddp.addActionListener(a->{
            cardLayout.show(panel,"addp");
        });
        p02cbc.addItem("");
        p02cbc.addItem("VideoJuegos");
        p02cbc.addItem("Comics");
        p02cbc.addItem("Manga");
        p02cbc.addItem("Funkos");


        p02bta.addActionListener(a->{
            boolean x= true;
            String b = p02tfn.getText();
            String c = p02tfm.getText();
            String d = p02tfp.getText();
            String e = p02cbc.getSelectedItem().toString();
            try {
                catalogo.add(new Producto(b,c,d,new Producto.Categoria(e),"", false));
            } catch (Exception ex) {
                x = false;
                p02ntfy.setText(ex.getMessage());
            }



            if(x) {
                cardLayout.show(panel,"Main");

            }



        });

        p02btc.addActionListener(a->{
            cardLayout.show(panel,"Main");
        });

        //p1clista.enable(false);
        p1cbtid.addActionListener(a->{
            int x = Integer.parseInt(p1ctfid.getText());
            for (Cliente p : clientes)
            {
                if (p.getId()!=x){
                    p1cntfy.setText("not found");
                }
                else p1cntfy.setText("found");
            }
        });













    }

    public void load_to_edit(int id)
    {   clientes.forEach(p->{
        if(p.getId()==id) {
            tfsnombre.setText(p.getNombre());
            String[] a = p.getApellido();
            tfsapellido.setText(a[0] + " " + a[1]);
            tfscorreo.setText(p.getCorreo());
            tfsdireccion.setText(p.getDireccion());
            tfsnumero.setText(p.getNumero());
            crrntid = p.getId();
        }
    });
    }
    public void load_to_save() {
        String a = tfsnombre.getText();
        String[] b = tfsapellido.getText().split(" ");
        String c = tfscorreo.getText();
        String d = tfsdireccion.getText();
        String e = tfsnumero.getText();
        String h = pfspsswd0.getText();
        String g = pfspsswd1.getText();
        String f = p01tfsalary.getText();
        Object i = cbxstipo.getSelectedItem();

            if (cbxspuesto.getSelectedItem().equals(p01tipo.cliente)) {
                for (Cliente cc : clientes) {
                    if (cc.getId() == crrntid) {
                        try {
                            cc.setNombre(a);
                        } catch (Exception ex) {
                            lsnotify.setText(ex.getMessage());
                        }
                        try {
                            cc.setApellido(b);
                        } catch (Exception ex) {
                            lsnotify.setText(ex.getMessage());
                        }
                        try {
                            cc.setCorreo(c);
                        } catch (Exception ex) {
                            lsnotify.setText(ex.getMessage());
                        }
                        try {
                            cc.setDireccion(d);
                        } catch (Exception ex) {
                            lsnotify.setText(ex.getMessage());
                        }
                        try {
                            cc.setNumero(e);
                        } catch (Exception ex) {
                            lsnotify.setText(ex.getMessage());
                        }
                        lsnotify.setText("guardado");
                    }}


            }

    }
    public void load_to_create() {
        String a = tfsnombre.getText();
        String[] b = tfsapellido.getText().split(" ");
        String d = tfsdireccion.getText();
        String e = tfsnumero.getText();
        String c = tfscorreo.getText();
        String h = pfspsswd0.getText();
        String g = pfspsswd1.getText();

        if (!chkcurrent(crrntct)) {
            try {

                if (cbxspuesto.getSelectedItem().equals(p01tipo.cliente)) {
                    clientes.add(new Cliente(a, b, d, e, c, ""));
                    lsnotify.setText("creado");
                }
            } catch (Exception ex) {
                lsnotify.setText(ex.getMessage());
            }
        } else {
            lsnotify.setText("ya existe");
        }}

    public void set_empty(){
        tfsnombre.setText("");
        tfsapellido.setText("");
        tfscorreo.setText("");
        tfsdireccion.setText("");
        tfsnumero.setText("");
        pfspsswd0.setText("");
        pfspsswd1.setText("");
    }



    public boolean chkcurrent(int id) {
        String x ="";
        for (Cliente c : clientes) {
            if (c.getId() == id) {
               x = c.getNumero();
               break;
            }
        }
        for (Cliente c : clientes) {
            if (c.getNumero().equals(x)) {
                return true;
            }
        }
        return false;
    }
    //ALMACEN
    public void add_to_almacen(){
        int[] id_c = {1, 2, 3};
        int[] cantidad = {1, 5, 6};

        for (int i = 0; i < id_c.length; i++) {
            int id = id_c[i];
            int cantidadProducto = cantidad[i];
            for (Producto producto : catalogo) {
                if (producto.getId() == id) {
                    for (int j = 0; j < cantidadProducto; j++) {
                        new Almacen().add_producto(producto.getId());
                    }
                    break;
                }
            }
        }
    }
    public void reload_almacen(){
        for (Producto c : catalogo) {
            for (Map.Entry<Integer, ?> entry : almacen.entrySet()) {
                if (c.getId() == entry.getKey()) {
                    System.out.println(c.getNombre() + " " + c.getImgpath());
                }
            }
        }
    }
    public void check_ct_almacen(int id) {
        int ct=0;
        for (Map.Entry<Integer, Integer> e : almacen.entrySet()) {
                if(id == e.getValue().intValue()) {
                    ct++;
                    System.out.println("id "+ id +" value "+e.getValue() +" pid " + e.getKey());
                }
        }
        p1cslider.setMaximum(ct);
        p1cslider.setValue(p1cslider.getMaximum());

    }


    public static void main(String[] args)  throws MyExeptions.Input_Constructor_Error {
        new Store();

    }



}
