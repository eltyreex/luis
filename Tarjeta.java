public class Tarjeta {
    //no necesario una relacion de herencia
    private int pin;
    private int numTarjeta = (int)(Math.random() * 900000) + 100000;
    public Tarjeta(int pin) {
        this.pin = pin;
    }
    

    private void setPin(int pin) {
        this.pin = pin;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    
    
    public boolean validarPin(int pin){
        boolean verificador;
        if(pin != this.pin){
            System.out.println("Pin no valido");
            verificador = false;
        }else{
            System.out.println("Pin correcto");
            verificador = true;
        }
        return verificador;
}
    
    public void cambiarPin(int pinActual, int pinNuevo){
        if(validarPin(pinActual) == true){
            this.pin = pinNuevo;
        }else{
            System.out.println("Pin actual no valido");
        }
    }
    
    @Override
    public String toString() {
        return "Tarjeta{" + "numTarjeta=" + numTarjeta + '}';
    }
    
    
    }
    

