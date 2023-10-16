package Fitur;
import java.util.Scanner;

public class Bilingual {
    public static void main(String[] args){
        Scanner inputL = new Scanner(System.in);
        String langSelect;

        System.out.print("Silahkan memilih bahasa | Please select a language (EN/ID): ");
        langSelect = inputL.nextLine();
        if (langSelect.equalsIgnoreCase("en")){
            System.out.println("English Language Selected");
            System.out.println("Are you the cashier? (y/n, yes/no)");
            //Program dilanjutkan dalam bahasa inggris...

        } else if (langSelect.equalsIgnoreCase("id")){
            System.out.println("Bahasa Indonesia terpilih");
            System.out.println("Apakah anda kasirnya? (y/t, ya, tidak)");
            //Program dilanjutkan dalam bahasa indonesia...
        } else {
            System.out.println("INPUT BAHASA TIDAK VALID | LANGUAGE INPUT INVALID");
        }
        inputL.close();
    }
}
