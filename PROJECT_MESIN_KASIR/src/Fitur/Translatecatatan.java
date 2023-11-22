package Fitur;

import java.util.Scanner;

class Translatecatatan {

    public static void main(String[] args) {
        Scanner inputStr = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        String food="x", drink="x", change;
        int foodPrice=0, drinkPrice=0, foodQty, drinkQty, totalItems, totalPrice, paymentMethod;
        int foodChoice, drinkChoice;
        boolean orderConfirm = false;

        String[][] menuRes = {
            {"Fried Chicken", "Grilled Chicken", "Crispy Chicken", "Fried Rice", "Nasi Lemak"},
            {"Hot Tea", "Iced Sweet Tea", "Joshua", "Happy Soda", "Black Coffee"} 
        };
        int[][] price = {
            {12000, 13500, 15000, 11000, 15000},
            {3500, 3500, 7500, 7500, 5000}
        };
        do {

            System.out.println("=========<{[ FOOD ]}>=========");
            System.out.println("Food Menu      | Price       ");
            System.out.println("[0] Fried Chicken  | 12000   ");
            System.out.println("[1] Grilled Chicken | 13500   "); 
            System.out.println("[2] Crispy Chicken | 15000   ");
            System.out.println("[3] Fried Rice | 11000   ");
            System.out.println("[4] Nasi Lemak | 15000   ");  
            System.out.println("========<{[ DRINKS ]}>========");
            System.out.println("Drinks Menu     | Price      ");
            System.out.println("[0] Hot Tea   | 3500    ");
            System.out.println("[1] Iced Sweet Tea | 3500    ");
            System.out.println("[2] Joshua       | 7500    ");
            System.out.println("[3] Happy Soda | 7500    ");
            System.out.println("[4] Black Coffee   | 5000    ");

            System.out.print("Enter Food ID (0~4): ");
            foodChoice = inputInt.nextInt();
            System.out.print("Enter food quantity: ");
            foodQty = inputInt.nextInt();
            System.out.print("Enter Drink ID (0~4): ");
            drinkChoice = inputInt.nextInt(); 
            System.out.print("Enter Drink Quantity: ");
            drinkQty = inputInt.nextInt();
            System.out.println("Do you want to confirm the order (y/n)?");
            System.out.print(">>");
            change = inputStr.nextLine();

            if (foodChoice < menuRes[0].length && drinkChoice < menuRes[1].length){
            food = menuRes[0][foodChoice];
            foodPrice = price[0][foodChoice];
            drink = menuRes[1][drinkChoice];
            drinkPrice = price[1][drinkChoice];
            } else {
                System.out.println("[WARNING] INVALID FOOD ID!");
                System.out.println("Please re-enter with the correct input!");
                continue;
            }
            
            if(change.equalsIgnoreCase("y")) {
                orderConfirm = true;
            } else {
                continue;
            }

        } while (!orderConfirm);

        totalItems = foodQty + drinkQty;
        drinkPrice *= drinkQty;
        foodPrice *= foodQty;
        totalPrice = foodPrice + drinkPrice;

        System.out.println("Your order is " + food + " and " + drink);
        System.out.println("With a total of " + totalItems + " items"); 
        System.out.println(food + " with a quantity of " + foodQty);
        System.out.println(drink + " with a quantity of " + drinkQty);
        System.out.println("The total for your order is " + totalPrice);
        System.out.println("What payment method would you like to use?");
        System.out.println("[1] Cash | [2] Bank Transfer");
        System.out.print(">>");
        paymentMethod = inputInt.nextInt();
        switch (paymentMethod) {
            case 1: 
                System.out.println("Thank you. Have a nice day!");
                break;
            case 2:
                System.out.println("Thank you. Please proceed to the nearest ATM.");
                break;
        }

        inputStr.close();
        inputInt.close();
    }
}