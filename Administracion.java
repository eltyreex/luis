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
        int tipoCuenta = Inputs.inputInt("""
            Tipo de cuenta
            1. Cuenta convencional
            2. Cuenta nomina
            3. Cuenta ahorro
            0. Regresar""");

        if (tipoCuenta == 0) {
            bucle = false;
            break;
        }
        String nombre = Inputs.input("Introduce el nombre del cliente:");
        int edad = Inputs.inputInt("Introduce la edad del cliente:");
        double saldo = Inputs.inputDouble("Introduce un saldo base:");
        int pin = Inputs.inputInt("Introduce un NIP:");
        
        int opcionDivisa = Inputs.inputInt("""
            Selecciona la divisa de la cuenta:
            1. Pesos Mexicanos (MXN)
            2. Dolares (USD)
            3. Euros (EUR)""");
        
        String divisaElegida = "MXN";
        switch (opcionDivisa) {
            case 2 -> divisaElegida = "USD";
            case 3 -> divisaElegida = "EUR";
        }

        switch (tipoCuenta) {
            case 1 -> {
                // Cuenta normal
                Main.clientes.add(new Cliente(nombre, edad, saldo, pin,  divisaElegida));
                System.out.println("Cliente con cuenta convencional creado con exito en " + divisaElegida);
            }
            case 2 -> {
                // Cuenta nómina
                int retiro = Inputs.inputInt("Introduce el límite de retiro para la cuenta nómina:");
                Cliente nuevoCliente = new Cliente(nombre, edad, 0, pin, divisaElegida);
                
                nuevoCliente.cuenta = new Cuenta_Nomina(retiro, saldo, pin, divisaElegida);
                Main.clientes.add(nuevoCliente);
                System.out.println("Cliente con cuenta nomina creado con exito en " + divisaElegida);
            }
            case 3 -> {
                // Cuenta ahorro
                int meses = Inputs.inputInt("Introduce los meses de plazo:");
                int fechaInicio = Inputs.inputInt("Introduce la fecha de inicio (ej. 2026):");
                Cliente nuevoCliente = new Cliente(nombre, edad, 0, pin, divisaElegida);
                
                nuevoCliente.cuenta = new Cuenta_Ahorro(meses, fechaInicio, saldo, pin, divisaElegida);
                Main.clientes.add(nuevoCliente);
                System.out.println("Cliente con cuenta ahorro creado con exito en " + divisaElegida);
            }
            default -> {
                System.out.println(Inputs.error);
            }
        }
    } while(bucle);
    }
    
    public static void validarCliente(boolean bucle){
        do{
            Inputs.inputInt("Escribe el numero del cliente:");

        }while(bucle);
    }
}

