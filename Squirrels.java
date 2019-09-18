// Squirrels.java by Mr. Considine
// 9/17/19

import java.util.*;
import java.io.*;

class Squirrels {

  public static void main(String[] args) {

    System.out.println("\n====== WELCOME TO THE" +
    " SQUIRREL TRACKER ======\n\n");

    ArrayList<String> names = new ArrayList<String>();//array lists of categories for later calculations and printing
    ArrayList<Double> lengths = new ArrayList<Double>();
    ArrayList<Double> weight = new ArrayList<Double>();

    try {
      File data = new File("squirrelData.txt");
      Scanner fr = new Scanner(data);

      while (fr.hasNext()) {//to get information in the text file
        names.add(fr.next());
        lengths.add(Double.parseDouble(fr.next()));
        weight.add(Double.parseDouble(fr.next()));
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    //calculate length
    Double best = 0.0;
    Double worst = 10000.0;
    int b = 0;
    int w = 0;
    for (int i = 0; i < lengths.size(); i++) {
      if (lengths.get(i) > best) {//compares lengths to check for the greatest value
        best = lengths.get(i);
        b = i;
      }
      if (lengths.get(i) < worst) {
        worst = lengths.get(i);
        w = i;
      }
    }
    System.out.println("The longest squirrel is " +//printing height +
    names.get(b) + ".\nThis squirrel is " + lengths.get(b) +
    " cm long.\n");
    System.out.println("The shortest squirrel is " +
    names.get(w) + ".\nThis squirrel is " + lengths.get(w) + //printing height -``
    " cm long.\n\n");

    //calculate weight
    Double best2 = 0.0;
    Double worst2 = 10000.0;
    int b2 = 0;
    int w2 = 0;
    for (int i = 0; i < weight.size(); i++) {
      if (weight.get(i) > best2) {//comparing values to find the best by setting the greatest vale as best2
        best2 = weight.get(i);
        b2 = i;
      }
      if (weight.get(i) < worst2) {
        worst2 = weight.get(i);
        w2 = i;
      }
    }
    System.out.println("The heaviest squirrel is " +//printing weight +
    names.get(b2) + ".\nThis squirrel is " + weight.get(b2) +
    " grams.\n");
    System.out.println("The smallest squirrel is " +//pringting weight -
    names.get(w2) + ".\nThis squirrel is " + weight.get(w2) +
    " grams.\n\n");

  }
}
//does not like it when the squirrel has two names (salty samantha)
//or if the height or weight is over 10,000,000 (does exponents)
//impossible data such as negative masses and heights
//squirrels can be nonexistant (mass and height of 0)
//no weight or height in words (twenty two)
//if there's two squirrels only with the exact height and weight the first squirrel
// listed is both the worst and the best in all categories
