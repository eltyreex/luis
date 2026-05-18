import java.util.Vector;

public class Cliente {
    private String nombre;
    private int edad;
    public Cuenta cuenta;
    
    public Cliente(String nombre, int edad, double saldo, int pin, int numCuenta) {
        this.nombre = nombre;
        this.edad = edad;
        this.cuenta = new Cuenta(saldo, pin, numCuenta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad<=18){
            throw new IllegalArgumentException("Edad no válida, debe ser mayor o igual a 18");
        } this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

   
}
