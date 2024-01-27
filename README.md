import java.util.Scanner;
import java.text.DecimalFormat;
class run {
    public static void main(String[] args) {
        System.out.print("how much cash do you want = $"); //ask the user how much cash they want and lets them enter an amount
        Scanner scanner = new Scanner(System.in);
        double cash = scanner.nextDouble();
        calculate(cash);
        while (cash >= 0){ //prints the items to the user and lets them type what they want to buy
            Scanner myObj = new Scanner(System.in);
            System.out.println("what would you like: |seed| |meat| |fish| |apple|");
            var item = myObj.nextLine();
            double seed = 1.43; //change the prices of items
            double meat = 2.32;
            double fish = 3.65;
            double apple = 4.87;
            if (item.equals("seed")){ //checks if you are out of cash and stops the program
                cash -= seed;
            }
            else if (item.equals("meat")){
                cash -= meat;
            }
            else if (item.equals("fish")){
                cash -= fish;
            }
            else if (item.equals("apple")){
                cash -= apple;
            }
            if (cash <= 0){
                System.out.println("Sorry you're out of cash");
                break;
            }
            calculate(cash);
        }
    }
    public static void calculate(double cash) {
        DecimalFormat df = new DecimalFormat("0.00"); //formats and prints your remaining cash
        System.out.println("remaining cash: " + df.format(cash));
        cash *= 100; //calculates the coins in your wallet
        int quarters = (int) cash / 25;
        cash -= (quarters * 25);
        int dimes = (int) cash / 10;
        cash -= (dimes * 10);
        int nickels = (int) cash / 5;
        cash -= (nickels * 5);
        int pennies = (int) cash;
        System.out.println("quarters: " + quarters); //prints the coins
        System.out.println("dimes: " + dimes);
        System.out.println("nickels: " + nickels);
        System.out.println("pennies: " + pennies);
        }
}
