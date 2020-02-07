import java.util.*;

class Tapir{

  private Boolean vegetarian;//values
  private Integer speed;
  private String color;
  private String name;


  public void setColor(String c){
    color = c;
  }
  public void setSpeed(Integer s){
    speed = s;
  }
  public void setVeg(Boolean v){
    vegetarian = v;
  }
  public void setName(String n){
    name = n;
  }

  public String getName(){//actions
    return name;
  }
  public Integer getSpeed(){
    return speed;
  }
  public Boolean getVeg(){
    return vegetarian;
  }
  public String getColor(){
    return color;
  }


  public Tapir(String n, Integer s, Boolean v, String c) {//constructor method
    name = n;
    speed = s;
    vegetarian = v;
    color = c;

  }


  public static void main(String[] args) {

    Tapir t1 = new Tapir("Christian",50,true,"Blue");//creating of object from the constructor
    Tapir t2 = new Tapir("Morgan",23,false,"Gray");
    Tapir t3 = new Tapir("Monty",75,true,"Pink");

    System.out.println("Which Tapir would you like to view?\n--1--\n--2--\n--3--");//prints options
           Scanner input = new Scanner(System.in);//creation of scanner
           String result = input.next();//scanning for user input

           if (result.equals("1")){
              System.out.println("Tapir #1\nName: "+t1.name+"\nSpeed: "+t1.speed+"\nVegetarian: "+t1.vegetarian+"\nColor: "+t1.color);
           }
           if(result.equals("2")){
              System.out.println("Tapir #2\nName: "+t2.name+"\nSpeed: "+t2.speed+"\nVegetarian: "+t2.vegetarian+"\nColor: "+t2.color);
           }
           if(result.equals("3")){
              System.out.println("Tapir #3\nName: "+t3.name+"\nSpeed: "+t3.speed+"\nVegetarian: "+t3.vegetarian+"\nColor: "+t3.color);
           }


  }

}
