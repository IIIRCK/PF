import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Personal extends Persona  {
    private static List<Personal> personal = new ArrayList<>();

    private int idct = 1;
    private int id = idct;
    private int salario;


    public enum cargo {
        gerente,
        ayudante,
        jefe
    }
    private cargo cargo;
    private String psswd;
    public Personal(String n,String[]a,String d, String no,String c,  String salario, cargo ca ) throws Input_Constructor_Error {
        super(n,a,d,no,c);
        this.id= idct;
        if (Integer.parseInt(salario) < 0) {
            throw new Input_Constructor_Error("El salario debe ser un número entero positivo");
        }
        this.salario = Integer.parseInt(salario);
        this.cargo = ca;
        idct++;
    }
    public Personal(String n,String[]a,String d, String no,String c,  String salario, cargo ca , String psswd) throws Input_Constructor_Error {
        super(n,a,d,no,c);
        this.id= idct;
        if (Integer.parseInt(salario) < 0) {
            throw new Input_Constructor_Error("El salario debe ser un número entero positivo");
        }
        this.salario = Integer.parseInt(salario);
        this.cargo = ca;
        this.psswd = psswd;
        idct++;
    }

    public Personal() throws Input_Constructor_Error {

    }
    public void add_personal(Personal p){personal.add(p);}

    public void modify_personal( int id, Predicate<Personal> condition, PersonalModifier modifier)throws Input_Setter_Error , Action_to_Persona , Input_Constructor_Error {
    // personal.forEach(p -> (p.id== id && condition.test(p)? modifier.modify(p): null));

       for (Personal p: personal) { if (p.get_Id() == id ) {
            modifier.modify(p);
        }}


    }
    public void  rise_salary(int id, String rise) throws  Action_to_Persona {
        for (Personal p: personal) { if (p.get_Id() == id) {
            if ( Integer.parseInt(rise) <0) {
                throw new Action_to_Persona("El aumento debe ser un número entero positivo");

            } else if(Integer.parseInt(rise) < 0) {
                throw new RuntimeException("El aumento debe ser un número entero positivo");
            }
            p.salario += Integer.parseInt(rise);
        }
        }

    }
    public void remove_personal(int id) throws Input_Setter_Error {
        personal.removeIf(p -> p.get_Id() == id);
    }

    /*  for (int i = 0; i < personal.size(); i++) {
        Personal p = personal.get(i);
        if (p.get_cargo() == cargo && condition.test(p)) {
            modifier.modify(p);
        }
    }*/

    public int get_Id() {
        return id;
    }

    public cargo getCargo() {
        return cargo;
    }


    public cargo get_cargo() {
        return  this.cargo;
    }
    public static List<Personal> get_personal() {
        return personal;
    }

    public String getPsswd() {
        return psswd;
    }
    public Iterator<Personal> getIterator() {
        return new PersonalIterator();
    }



    @Override
    public String toString() {
        return id +
                ";" +cargo +
                ";" + salario +
                ";" + super.toString();
    }
    @FunctionalInterface
    public interface PersonalModifier {
        void modify(Personal personal) throws Input_Setter_Error;
    }


    private class PersonalIterator implements Iterator<Personal> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < personal.size();
        }

        @Override
        public Personal next() {
            Personal nextPersonal = personal.get(currentIndex);
            currentIndex++;
            return nextPersonal;
        }

        @Override
        public void remove() {
            Personal removedPersonal = personal.remove(currentIndex - 1);
            currentIndex--;
           System.out.println("Removed: " + removedPersonal);
        }



    }


}

