import java.util.*;

public class TwentyQuestions{

public static void main(String[] args) {

  System.out.println("Welcome to Twenty Questions, choose one of the options below:\n");
  System.out.println("Rat\nFrench Fries\nBalloon\nHairbrush\nChicken\nCheese\nToast\nTruck\nShark\nCanary");
  System.out.println("Type 'yes' once you have chosen from the list");
  Scanner choice = new Scanner(System.in);
  String chosen = choice.next();

  if(chosen.equals("yes")){
    System.out.println("Is your option alive?");
  }
  Scanner question = new Scanner(System.in);
  String answer = question.next();

  if(answer.equals("yes")){//rat, chicken, Shark nCanary
    System.out.println("Is your option a type of bird?");
    String answer2 = question.next();
    if(answer2.equals("yes")){
      System.out.println("Do people typically eat this bird?");
      String answer3 = question.next();
      if(answer3.equals("yes")){
        System.out.println("You chose Chicken");
      }else{
        System.out.println("You chose Canary");
        }
      }else{
        System.out.println("Does your option live in the ocean?");
        String answer4 = question.next();
        if(answer4.equals("yes")){
          System.out.println("You chose Shark");
        }else{
          System.out.println("You chose Rat");
        }
      }
    }
  else{//French Fries balloon hairbrush cheese toast truck
    System.out.println("Is your option edible?");
    String answer5 = question.next();
    if(answer5.equals("yes")){
        System.out.println("is your option a dairy product?");
        String answer6 = question.next();
        if(answer6.equals("yes")){
          System.out.println("You chose Cheese");
        }else{
          System.out.println("Is your option made of potatoes?");
          String answer7 = question.next();
          if(answer7.equals("yes")){
            System.out.println("You chose French Fries");
          }else{
            System.out.println("You chose Toast");
          }

        }
    }else{
      System.out.println("Does your option have an engine?");
      String answer8 = question.next();
        if(answer8.equals("yes")){
          System.out.println("You chose Truck");
        }else{
          System.out.println("Does your option float?");
          String answer9 = question.next();
            if(answer9.equals("yes")){
              System.out.println("You chose Balloon");
            }else{
              System.out.println("You chose Hairbrush");
            }
          }
        }
      }
    }
  }
