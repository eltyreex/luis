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
        cliente.cuenta.AgregarSaldo(Inputs.inputDouble("¿Cuanto deseas depositar en la cuenta?"));
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