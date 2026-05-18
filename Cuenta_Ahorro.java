public class Cuenta_Ahorro extends Cuenta{
    private int meses;
    private int fechaInicio;

    public Cuenta_Ahorro(int meses, int fechaInicio, double saldo, int pin, int numtarjeta) {
        super(saldo, pin, numtarjeta);
        this.meses = meses;
        this.fechaInicio = fechaInicio;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public double CalculoIntereses(){
        double Saldo = super.getSaldo();
        Saldo *= 0.16;
        return Saldo;
    }
    public void InteresesPagadados(int meses){
        double SaldoActualizado =  meses * CalculoIntereses();
        super.setSaldo(SaldoActualizado + super.getSaldo());
    }
}
