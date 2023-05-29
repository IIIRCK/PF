import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producto  extends MyExeptions{


    private static List<Producto> productos = new ArrayList<>();
    private static int idct = 1;
    private int id;
    private static int idctpa = 1;
    private int id_producto_almacen;
    private String nombre;
    private String marca;
    private int precio;
    private Categoria categoria;
    private String imgpath;
    private int volumen;
    private boolean stock = false;

    public Producto(String nombre, String marca, String precio, Categoria categoria, String imgpath, boolean stock) throws Input_Constructor_Error {


        this.id = idct;
        if(nombre.isEmpty()|| marca.isEmpty()|| precio.isEmpty()|| categoria.get_Nombre().isEmpty()){
            throw new Input_Constructor_Error("Error en el constructor de Producto");
        }
        this.nombre = nombre;
        this.marca = marca;
        this.precio = Integer.parseInt(precio);
        this.categoria = categoria;
        this.imgpath = imgpath;
        this.stock = stock;
        idct++;
    }

    public Producto(String nombre,int volumen, String marca, String precio, Categoria categoria, String imgpath) throws Input_Constructor_Error {


        this.id = idct;
        if(nombre.isEmpty()||volumen<0|| marca.isEmpty()|| precio.isEmpty()|| categoria.get_Nombre().isEmpty()|| imgpath.isEmpty()){
            throw new Input_Constructor_Error("Error en el constructor de Producto");
        }
        this.nombre = nombre;
        this.volumen = volumen;
        this.marca = marca;
        this.precio = Integer.parseInt(precio);
        this.categoria = categoria;
        this.imgpath = imgpath;
        idct++;
    }
    public Producto(String nombre,int volumen, String marca, String precio, Categoria categoria, String imgpath,boolean stock) throws Input_Constructor_Error {


        this.id = idct;
        if(nombre.isEmpty()||volumen<0|| marca.isEmpty()|| precio.isEmpty()|| categoria.get_Nombre().isEmpty()|| imgpath.isEmpty()){
            throw new Input_Constructor_Error("Error en el constructor de Producto");
        }
        this.nombre = nombre;
        this.volumen = volumen;
        this.marca = marca;
        this.precio = Integer.parseInt(precio);
        this.categoria = categoria;
        this.imgpath = imgpath;
        this.stock = stock;
        idct++;
    }

    public Producto(Producto c, int cantidad) {
        this.id = idctpa;
        this.nombre = c.nombre;
        this.marca = c.marca;
        this.precio = c.precio;
        this.categoria = c.categoria;
        this.imgpath = c.imgpath;
        idctpa++;
    }
    public Producto(){

    }




    public static  List<Producto> get_productos(){
        return  productos;
  }

    public boolean get_stock() {
        return this.stock;
    }
    public boolean set_stock(boolean stock) {
        return this.stock = stock;
    }
    public void setNombre(String nombre) throws Input_Setter_Error {
        if (nombre.isEmpty()) {
            throw new Input_Setter_Error("Error en el setter de nombre");
        }
        this.nombre = nombre;
    }

    public void setMarca(String marca) throws Input_Setter_Error {
        this.marca = marca;
    }

    public void setPrecio(String precio) throws Input_Setter_Error{
        if (precio.isEmpty()) {
            throw new Input_Setter_Error("Error en el setter de precio");
        }
        this.precio = Integer.parseInt(precio);
    }


    public void setCategoria(Categoria categoria) throws Input_Setter_Error {
        if (categoria.get_Nombre().isEmpty()) {
            throw new Input_Setter_Error("El nombre de la categoría está vacío");
        }
        this.categoria = categoria;
    }


    public void setImgpath(String imgpath) throws Input_Setter_Error {
        if (imgpath.isEmpty()) {
            throw new Input_Setter_Error("Error en el setter de imgpath");
        }
        this.imgpath = imgpath;
    }

    public void setVolumen(String volumen)  throws Input_Setter_Error{
        if (volumen.isEmpty()||Integer.parseInt(volumen)<0) {
            throw new Input_Setter_Error("Error en el setter de volumen");
        }
        this.volumen = Integer.parseInt(volumen);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public String getImgpath() {
        return imgpath;
    }

    public int getVolumen() {
        return volumen;
    }


    @Override
    public String toString() {
        String volumenStr = (categoria.get_Nombre().equals("Comics") || categoria.get_Nombre().equals("Manga")) ? ", volumen=" + volumen : "";
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria.get_Nombre() +
                ", imgpath='" + imgpath + '\'' +
                volumenStr +
                '}';
    }




    public static class Categoria {
        private static List<Categoria> categorias = new ArrayList<>();
        private String nombre;

        public Categoria(String n){
            this.nombre = n;
        }
        public void add_categoria(){
            categorias.add(this);
        }
        public String get_Nombre() {
            return this.nombre;
        }
        public String set_categoria(String x){
            for (Categoria c: categorias) {
                if(c.get_Nombre().equals(x)){
                    return c.get_Nombre();
                }
            }
            return "";
        };
        public static void remove_Categoria(String nombreCategoria) {
            Categoria categoriaEliminar = null;
            for (Categoria categoria : categorias) {
                if (categoria.get_Nombre().equals(nombreCategoria)) {
                    categoriaEliminar = categoria;
                    break;
                }
            }
            if (categoriaEliminar != null) {
                categorias.remove(categoriaEliminar);
            }
        }
        public static List<Categoria> getCategorias() {
            return categorias;
        }



    }
}
