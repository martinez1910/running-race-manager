package cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import logic.obj.Runner;
import logic.persistance.RepositoryImp;


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
                option = Integer.parseInt(SCANNER.next());
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
        Runner runner = createRunner();
        System.out.println("El siguiente corredor ha sido creado:\n" +runner);
        RepositoryImp.getInstance().addRunner(runner);
    }

    private static void removeRunner() {
        List<Runner> runners = RepositoryImp.getInstance().getRunners();
        if(runners.isEmpty()){
            printNoRunnersMessage();
            return;
        }
        
        String strAux = "";
        if(runners.size() > 1)
            strAux = " - " +(runners.size()-1);
        System.out.println("Elija el corredor que desea eliminar en el intervalo [0" +strAux +"]:");
        
        boolean error = false;
        do{
            try{
                int pos = SCANNER.nextInt();
                if(pos >= 0 && pos < runners.size()){
                    if(RepositoryImp.getInstance().removeRunner(pos))
                        System.out.println("El corredor ha sido eliminado");
                    else
                        System.out.println("Ha habido un error eliminando el corredor");
                }
                else throw new IndexOutOfBoundsException();
                error = false;
            }catch(InputMismatchException | IndexOutOfBoundsException e){
                printInvalidCommandMessage();
                error = true;
            }
        }while(error);
    }

    private static void updateRunner() {
        List<Runner> runners = RepositoryImp.getInstance().getRunners();
        if(runners.isEmpty()){
            printNoRunnersMessage();
            return;
        }
        
        String strAux = "";
        if(runners.size() > 1)
            strAux = " - " +(runners.size()-1);
        System.out.println("Elija el corredor que desea actualizar en el intervalo [0" +strAux +"]:");
        
        boolean error = false;
        do{
            try{
                int pos = SCANNER.nextInt();
                if(pos >= 0 && pos < runners.size()){
                    if(RepositoryImp.getInstance().updateRunner(runners.get(pos), createRunner()))
                        System.out.println("El corredor ha sido actualizado.");
                    else
                        System.out.println("Ha habido un error actualizando el corredor.");
                }
                else throw new IndexOutOfBoundsException();
                error = false;
            }catch(InputMismatchException | IndexOutOfBoundsException e){
                printInvalidCommandMessage();
                error = true;
            }
        }while(error);
    }

    private static void printRunners() {
        printListOfRunners(RepositoryImp.getInstance().getRunners());
    }

    private static void printRunnersByBirthdate() {
        if(RepositoryImp.getInstance().getRunners().isEmpty()){
            printNoRunnersMessage();
            return;
        }
        
        boolean error = false;
        System.out.println("¿Orden ascendente o descendente?");
        do{
            switch(SCANNER.next().toLowerCase()){
                case "asc":
                case "ascendente":
                    printListOfRunners(RepositoryImp.getInstance().getRunnersByDateOfBirthAsc());
                    error = false;
                    break;
                case "desc":
                case "descendente":
                    printListOfRunners(RepositoryImp.getInstance().getRunnersByDateOfBirthDesc());
                    error = false;
                    break;
                default:
                    printInvalidCommandMessage();
                    error = true;
            }
        }while(error);
    }

    private static void exit() {
        boolean error = false;
        System.out.println("¿Está seguro que desea salir? S/N");
        do{
            switch(SCANNER.next().toLowerCase()){
                case "s":
                case "si":
                    RepositoryImp.getInstance().persist();
                    System.exit(0);
                case "n":
                case "no":
                    error = false;
                    break;
                default:
                    printInvalidCommandMessage();
                    error = true;
            }
        }while(error);
    }

    private static void printListOfRunners(List<Runner> runners) {
        if(runners.isEmpty()){
            printNoRunnersMessage();
            return;
        }
        for(int i = 0; i < runners.size(); i++)
            System.out.println(i +" - " +runners.get(i));
    }
    
    
    private static void printInvalidCommandMessage(){
        System.out.println("Por favor, introduzca un valor correcto.");
    }    
    private static void printNoRunnersMessage(){
        System.out.println("¡No se han encontrado corredores!");
    }

    private static Runner createRunner() {
        String name = null, surname = null;
        Date dateOfBirth = null;
        boolean error = false;
        
        System.out.println("Introduzca el NOMBRE del corredor:");
        name = SCANNER.next();
        
        System.out.println("Introduzca el APELLIDO del corredor:");
        surname = SCANNER.next();
        
        System.out.println("Introduzca la FECHA DE NACIMIENTO del corredor (dd-mm-yyyy):");
        do{
            try{
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateOfBirth = dateFormat.parse(SCANNER.next());                
                error = false;
            }catch(ParseException e){
                printInvalidCommandMessage();
                error = true;
            }
        }while(error);
        
        return new Runner(name, surname, dateOfBirth);
    }
}
