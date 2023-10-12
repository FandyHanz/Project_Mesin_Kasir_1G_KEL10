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
        } else if (langSelect.equalsIgnoreCase("id")){
            System.out.println("Bahasa Indonesia terpilih");
        } else {
            System.out.println("INPUT BAHASA TIDAK VALID | LANGUAGE INPUT INVALID");
        }
    }
}
