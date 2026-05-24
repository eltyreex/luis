public class Divisas {
    private String divisa;


    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
   
    public void eleccionDivisas(){

    }
    public static double pesoDolar(double monto){
       return monto *20;
    }
    public static double pesoEuro(double monto){
       return monto *22;
    }    
    public static double Europeso(double monto){
       return monto /22;
    }
    public static double Dolarpeso(double monto){
       return monto /20;
    }
    
}
