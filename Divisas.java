public class Divisas {
    private String divisa;


    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
   
    public void eleccionDivisas(){

    }
    public double cambioDolar(double monto){
       return monto *20;
    }
    public double cambioEuro(double monto){
       return monto *22;
    }    
    
    
}
