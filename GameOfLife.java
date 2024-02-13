import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){

        // i commented this so terminal wouldnt be so cluttered 
        //the obligatory part of this task:
        // Verden verden1 = new Verden(8, 12);

        // for (int i = 0; i < 3; i++){ // a loop to make 3 gens of verden 1
        //     verden1.tegn();
        //     verden1.oppdatering();}


        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Enter number of rows: ");
        int rad = scanner.nextInt();
        scanner.nextLine(); //this consumes the rest of string past the int, 
        //otherwise the input for yes or not doesnt work, since its takes in the line shift that is sent with enter

        System.out.println("Enter number of columns: ");
        int kol = scanner.nextInt();
        scanner.nextLine();


        Verden verden3 = new Verden(rad, kol);
        
        String anotherGen = "yes";
        while (anotherGen.equals("yes")){
            verden3.tegn();
            verden3.oppdatering();
            System.out.println("Another generation? yes or no :) ");
            anotherGen = scanner.nextLine();
        }
        System.out.println("Oki, bye :) ");
        scanner.close();
    }
}

