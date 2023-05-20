import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Persona extends MyExeptions {

    static Pattern patternNumero = Pattern.compile("\\d{9}");
    static Pattern patternCorreo = Pattern.compile("^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]$");

    private String nombre;
    private String[] apellido;
    private  String direccion;
    private  String numero;
    private String correo;

    public Persona(String nombre, String[] apellido, String direccion, String numero, String correo) throws Input_Constructor_Error {

        // Verificar los valores de los inputs
        if (nombre.isEmpty() ||  apellido[0].isEmpty() || apellido[1].isEmpty() || direccion.isEmpty() || numero.isEmpty() || correo.isEmpty()) {
            throw new MyExeptions.Input_Constructor_Error("Los valores de los inputs son incorrectos.");
        } else if (!patternNumero.matcher(numero).matches()) {
            throw new MyExeptions.Input_Constructor_Error("El formato del número es incorrecto.");
        }
        // Verificar el formato del correo electrónico utilizando regex
        if (patternCorreo.matcher(correo).matches()) {
            throw new MyExeptions.Input_Constructor_Error("El formato del correo electrónico es incorrecto.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.numero = numero;
        this.correo = correo;
    }
    public Persona() {
    }

    public void setNombre(String nombre) throws Input_Setter_Error{
        if (nombre.isEmpty()) {
            throw new Input_Setter_Error("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setApellido(String[] apellido) throws Input_Setter_Error {
        if (apellido[0].isEmpty()|| apellido[1].isEmpty()) {
            throw new Input_Setter_Error("El apellido no puede estar vacío.");
        }
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) throws Input_Setter_Error {
        if (direccion == null || direccion.isEmpty()) {
            throw new Input_Setter_Error("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    public void setNumero(String numero) throws Input_Setter_Error {
        if (!patternNumero.matcher(numero).matches()) {
            throw new Input_Setter_Error("El formato del número es incorrecto.");
        }else if (numero.isEmpty()) {
            throw new Input_Setter_Error("El número no puede estar vacío.");
        }
        this.numero = numero;
    }

    public void setCorreo(String correo)  throws Input_Setter_Error {
        if (!patternCorreo.matcher(correo).matches()) {
            throw new Input_Setter_Error("El formato del número es incorrecto.");
        }else if (numero.isEmpty()) {
            throw new Input_Setter_Error("El número no puede estar vacío.");
        }
        this.correo = correo;
    }

    public String getCorreo() {return correo;}

    @Override
    public String toString() {
        return   nombre +
                ";" + Arrays.toString(apellido) +
                ";" + direccion  +
                ";" + numero  +
                ";" + correo;
    }
}