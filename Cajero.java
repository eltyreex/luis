import java.util.Vector;
public class Cajero{
    static final String menu = 
    """
    <----> Cajero <---->
    1. Depositar
    2. Retirar
    3. Consultar saldo
    0. Regresar""";

    static Cliente cliente;

    public static boolean seguridadTarjeta(boolean bucle){
        do{
            try{
                int NIP = Inputs.inputInt("Ingresa el NIP: (Escribe -1 para salir)");
                if(NIP == -1) return bucle;
                for(int i = 0; i<=Main.clientes.size(); i++){
                    Vector<Tarjeta> tarjetas = Main.clientes.get(i).cuenta.getTarjetas();
                    for(int j = 0; j<=tarjetas.size(); j++){
                        if(tarjetas.get(j).validarPin(NIP)){
                            cliente = Main.clientes.get(i);
                            bucle = false;
                        }
                    }
                }
                }catch(IndexOutOfBoundsException e){/*Vacio*/}
        }while(bucle);
        return bucle;
    }

    public static void imprimirMenu(boolean bucle){
        if(seguridadTarjeta(bucle)) return;
        do{ 
            switch (Inputs.inputInt(menu)) {
                case 0 ->{
                    bucle = false;
                }
                case 1 ->{
                    depositar();
                }
                case 2 ->{
                    retirar();
                }
                case 3 ->{
                    consultarSaldo();
                }
                default ->{
                    System.out.println(Inputs.error);
                }
            }
        }while (bucle);
    }

    public static void depositar(){
        double montoIngresado = Inputs.inputDouble("¿Cuanto deseas depositar?");
    
    String menuDivisas = """
                         Seleccione la divisa del deposito:
                         1. Pesos Mexicanos (MXN)
                         2. Dolares (USD)
                         3. Euros (EUR)""";
                         
    int opcion = Inputs.inputInt(menuDivisas);
    double monto = 0;

    switch (opcion) {
        case 1 -> monto = montoIngresado; 
        case 2 -> monto = Divisas.pesoDolar(montoIngresado);
        case 3 -> monto = Divisas.pesoEuro(montoIngresado); 
        default -> {
            System.out.println("Opcion no valida");
            return;
        }
    }
    cliente.cuenta.AgregarSaldo(monto);
    System.out.println("Deposito exitoso.");
        
    }
    public static void retirar(){
        cliente.cuenta.QuitarSaldo(Inputs.inputDouble("¿Cuanto deseas retirar de la cuenta?"));
    }
    public static void consultarSaldo(){
        System.out.println(
            "-----------------------------\n" +
            Math.round((cliente.cuenta.getSaldo())*1000.000)/1000.000 + " pesos mexicanos" +
            "\n-----------------------------");
    }
}