public class Administracion {
    static final String menu = """
    <---->Administracion<---->
    1. Registrar cliente
    2. Obtener datos cliente
    3. Cambiar datos cliente
    0. Regresar""";

    static int contraseñaDefault = 1234;
    static String usuarioDefault = "admin";

    public static boolean seguridadAdministracion(boolean bucle){
        do{
            String usuario = Inputs.input("Escribe el usuario: (-1 para regresar)");
            if(usuario.equals("-1")) return bucle;
            int contraseña = Inputs.inputInt("Escribe el contraseña: (-1 para regresar)");
            if(contraseña == -1) return bucle;
            else if(!(usuario.equals(usuarioDefault) && contraseña == contraseñaDefault)){
                System.out.println("Datos incorrectos");
                continue;
            }
            bucle = false;
        }while(bucle);
        return bucle;
    }

    public static void imprimirMenu(boolean bucle){
        if(seguridadAdministracion(bucle)) return;
        do{
            switch (Inputs.inputInt(menu)) {
                case 0 ->{
                    bucle = false;
                }
                case 1 ->{
                    registrarCliente(bucle);
                }
                case 2 ->{
                    obtenerDatosCliente(bucle);
                }
                case 3 ->{
                    cambiarDatosCliente(bucle);
                }
                default ->{
                    System.out.println(Inputs.error);
                }
            }
        }while(bucle);
    }

    public static void registrarCliente(boolean bucle){
        do{
            switch (Inputs.inputInt("""
                Tipo de cuenta
                1. Cuenta convencional
                2. Cuenta nomina
                3. Cuenta ahorro
                0. Regresar""")) {
                case 0 ->{
                    bucle = false;
                }
                case 1 ->{
                    Main.clientes.add(new Cliente(
                        Inputs.input("Introduce el nombre del cliente:"), 
                        Inputs.inputInt("Introduce la edad del cliente:"), 
                        Inputs.inputInt("Introduce un saldo base:"), 
                        Inputs.inputInt("Introduce un NIP:"), 
                        Inputs.inputInt("Introduce un numero de cliente:")));
                }
                case 2 ->{
                }
                case 3 ->{
                }
                default ->{
                    System.out.println(Inputs.error);
                }
            }
        }while(bucle);
    }
    public static void obtenerDatosCliente(boolean bucle){
        int cliente = validarCliente(bucle);
        do{
            switch (Inputs.inputInt("""
                    1. Consultar datos persona
                    """)) {
                case 0 ->{
                    bucle = false;
                }
                case 1 ->{
                    /*for(int i=0; i<Main.clientes.size(); i++){
                        if(Main.clientes.get(i)== cliente)
                            System.out.println(Main.clientes.get(i).toString());
                    }*/
                }
                case 2 ->{
                }
                case 3 ->{
                }
                default ->{
                    System.out.println(Inputs.error);
                }
            }
        }while(bucle);
    }
    public static void cambiarDatosCliente(boolean bucle){
        do{
            switch (Inputs.inputInt("")){
                case 0 ->{
                    bucle = false;
                }
                case 1 ->{
                }
                case 2 ->{
                }
                case 3 ->{
                }
                default ->{
                    System.out.println(Inputs.error);
                }
            }
        }while(bucle);
    }
    
    public static void validarCliente(boolean bucle){
        do{
            Inputs.inputInt("Escribe el numero del cliente:");

        }while(bucle);
    }
}

