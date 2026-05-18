import java.util.Vector;

public class Cuenta {
    private double saldo;
    private Vector<Tarjeta> tarjetas = new Vector<Tarjeta>(1, 1);
    public int contador;
    private String divisa;

    public Cuenta(double saldo,int pin, int numtarjeta) {
        this.saldo = saldo;
        this.tarjetas.add(new Tarjeta(pin, numtarjeta));
    }
    

    public double getSaldo() {
        return saldo;
    }
    public Vector<Tarjeta> getTarjetas(){
        return tarjetas;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void AgregarSaldo(double monto){
       this.saldo = this.saldo + monto;
    }
    public void QuitarSaldo(double monto){
        if(getSaldo() - monto >= 0 && monto > 0 ){
            this.saldo = this.saldo - monto;
            contador ++;
        }else{
            System.out.println("No se realizo ningun movimiento saldo insuficiente ");
        }
       
    }
    
    
    
  
}
