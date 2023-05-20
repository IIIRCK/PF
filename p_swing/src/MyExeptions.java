public class MyExeptions {
    public static class Input_Constructor_Error extends Exception{
        public Input_Constructor_Error(String m){
            super(m);
        }
    }
    public static class Input_Setter_Error extends Exception{
        public Input_Setter_Error(String m){
            super(m);
        }
    }
    public static class Action_to_Persona extends  Exception{
        public Action_to_Persona(String m){super(m);}
    }
    public  static class Pedido_Error extends Exception{
        public Pedido_Error(String m){super(m);}
    }
}
