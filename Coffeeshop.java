import java.util.*;

public class Coffeeshop{

  public static void main(String[] args) {
    String order = "";
    String size = "";

    System.out.println("\nWelcome to the coffee shop, hope you find what you're looking for.\nchoose one of the options below:\n");
    System.out.println("1) Coffee\n2) Water\n3) Tea\n4) Scone\n");
    Scanner scan = new Scanner(System.in);
    String coffee = scan.next();

    if(coffee.equals("1")){
      order = "Coffee";
    }
    if(coffee.equals("2")){
      order = "Water";
    }
    if(coffee.equals("3")){
      order = "Tea";
    }
    if(coffee.equals("4")){
      order = "Scone";
    }

    System.out.println ("\nHow many would you like to order?:\n");
    Scanner scan2 = new Scanner(System.in);
    String num = scan2.next();
    if (!num.equals("1")){
      order = order+"s";
    }

    System.out.println ("\nWhat size?:\n1) Small\n2) Medium\n3) Large");
    Scanner scan4 = new Scanner(System.in);
    String size2 = scan4.next();
    if(size2.equals("1")){
      size = "Small";
    }
    if(size2.equals("2")){
      size = "Medium";
    }
    if(size2.equals("3")){
      size = "Large";
    }


    System.out.println ("\nWhose order is this?:\n");
    Scanner scan3 = new Scanner(System.in);
    String name = scan3.next();

    System.out.println("\n"+name+" has ordered "+num+" "+size+" "+order);

  }
}
