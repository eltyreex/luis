import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
    static Scanner input = new Scanner(System.in);

    static final String error = "Favor de escribir algo valido";

    public static int inputInt(String msg){
        do{
            System.out.println(msg);
            try{
                int respuesta = input.nextInt();
                return respuesta;
                
            }catch(InputMismatchException e){
                System.out.println(error);
                input.next();
            }
        }while(true);
    }
    public static double inputDouble(String msg){
        do{
            System.out.println(msg);
            try{
                double respuesta = input.nextDouble();
                return respuesta;
            }catch(InputMismatchException e){
                System.out.println(error);
                input.next();
            }
        }while(true);
    }
    public static String input(String msg){
        do{
            System.out.println(msg);
            input.nextLine();
            String respuesta = input.nextLine();
            return respuesta;
        }while(true);
    }
}

