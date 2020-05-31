import java.util.*;
import java.io.*;

class BookReport{

public static void main(String[] args) {

  ArrayList<String> text = new ArrayList<String>();
  StringBuilder text2 = new StringBuilder();


    System.out.println("-----Welcome to my Frankenstein 'Book Report'-----");
    System.out.println("1) rSearch"+"\n"+"2) numWords"+"\n"+"3) avgWordLength");
    System.out.println("4) mostCommonChar"+"\n"+"5) mostCommonWord (takes a little bit of time)"+"\n"+"6) randomSummary");

    Scanner input = new Scanner (System.in); //creation of scanner
    String result = input.next();//tells scanner what to do
  try {
    File data = new File("Frankenstein.txt");
    Scanner fr = new Scanner(data);
    Scanner fr2 = new Scanner(data);

    while(fr.hasNext()){
      text.add(fr.next());//Arraylist
      text2.append(fr2.next().toLowerCase()+"\n");//Stringbuilder -- one word per line
      }
    }

  catch (FileNotFoundException e) {
    e.printStackTrace();
  }

  if(result.equals("1")){

    }
  if(result.equals("2")){//number of words -- works
    System.out.println("The number of words is:"+text.size());
    }

  if(result.equals("3")){//avg length of a word -- works
    int avg;
    avg = text2.length()/text.size();
    System.out.println("The average word length is:"+avg);
    }

/*  if(result.equals("4")){//most common character -- Doesn't work
   int most = 0;
   int diff;
   char maxChar = '\0';
   for(char c = 'a'; c <= 'z'; c++) {
         diff = text2.length() - text.toString().replace("" + c, "").length();
        if(diff > most) {
            maxChar = c;
            most = diff;
        }
      }
      System.out.println(maxChar);
    }*/

    if(result.equals("5")){//most common word --works

      int count = 0;
      int amount = 0;
      String word = "";

      for(int i = 0; i < text.size(); i++){
           count = 1;

           for(int j = i+1; j < text.size(); j++){//count each word in the file
               if(text.get(i).equals(text.get(j))){
                   count++;
               }
           }

           if(count > amount){//if the amount is less than count then store value of count in maxCount
               amount = count;
               word = text.get(i);
           }
       }
       System.out.println("The most common word is: '"+word+"' and it occurs: "+amount+" times");
    }
  /*  if(result.equals("6")){
      StringBuilder random = new StringBuilder();
      Scanner input2 = new Scanner(System.in);
      String result2 = input2.next();
      int x = Integer.parseInt(result2);

      for(int i=0; i==x-1; i++){
      Collections.shuffle(text);
        random.append(text(3)+" ");//is not appending
      }

      System.out.println("Random Summary:"+random);
    }*/
  }
}
