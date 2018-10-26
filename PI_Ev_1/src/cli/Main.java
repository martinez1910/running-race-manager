package cli;

import java.util.Scanner;


public class Main {
    private final static Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args){
        while(true){
            selectOption(showMenu());
        }
    }
    
    private static int showMenu(){
        String str = "######################\n";
        str += "# GESTIÓN CORREDORES #\n";
        str += "######################\n";
        str += "1 - Alta.\n";
        str += "2 - Baja.\n";
        str += "3 - Modificar.\n";
        str += "4 - Mostrar.\n";
        str += "5 - Mostrar ordenados (fecha de nacimiento).\n";
        str += "6 - Salir.";
        System.out.println(str);
        boolean error = false;
        int option = -1;
        do{
            System.out.println("\nSeleccione una opción:\n");
            try{
                option = Integer.parseInt(SCANNER.nextLine());
                if(option >= 1 && option <= 6)
                    error = false;
                else
                    throw new IndexOutOfBoundsException();
            }catch(NumberFormatException | IndexOutOfBoundsException e){
                error = true;
            }
        }while(error);
        return option;
    }
    
    private static void selectOption(int option){
        switch(option){
            case 1:
                newRunner();
                break;
            case 2:
                removeRunner();
                break;
            case 3:
                updateRunner();
                break;
            case 4:
                printRunners();
                break;
            case 5:
                printRunnersByBirthdate();
                break;
            case 6:
                exit();
                break;
            default:
                util.MyUtil.unreachableCode("Invalid menu option");
        }
    }

    private static void newRunner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void removeRunner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void updateRunner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void printRunners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void printRunnersByBirthdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
