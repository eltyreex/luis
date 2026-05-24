public class Cuenta_Nomina extends Cuenta{
    private int retiro;

    public Cuenta_Nomina(int retiro, double saldo, int pin, String divisa) {
        super(saldo, pin,divisa);
        this.retiro = retiro;
    }

    public int getRetiro() {
        return retiro;
    }

    public void setRetiro(int retiro) {
        this.retiro = retiro;
    }
    public void retiros(){
        if(contador > 3){
            super.setSaldo(super.getSaldo() - 20);
        }
    }
}
