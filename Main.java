import java.util.Vector;
public class Main{
    static Vector<Cliente> clientes = new Vector<>(1, 1);
    public static void main(String[] args) {
        clientes.add(new Cliente("pepe", 18, 1000, 1234,"MXN"));
        
        inicio(true);
    }
    public static void inicio(boolean bucle){
        String menuPrincipal = """
        ¿A que panel deseas ingresar?
        1. Cajero. 
        2. Administrativo. 
        0. Salir.""";
        do{
            switch (Inputs.inputInt(menuPrincipal)) {
                case 0 ->{
                    bucle = false;
                }
                case 1 ->{
                    Cajero.imprimirMenu(bucle);
                }
                case 2 ->{
                    Administracion.imprimirMenu(bucle);
                }
                default ->{
                    System.out.println(Inputs.error);
                }
            }
        }while(bucle);
    }
}