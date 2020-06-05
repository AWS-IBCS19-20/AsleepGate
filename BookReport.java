import java.util.*;
import java.io.*;

class BookReport{


public static void main(String[] args) {

  ArrayList<String> text = new ArrayList<String>();//list of words
  StringBuilder text2 = new StringBuilder();//every character, no spaces


  //introduction
    System.out.println("-----Welcome to my Frankenstein 'Book Report'-----");
    System.out.println("1) rSearch"+"\n"+"2) numWords"+"\n"+"3) avgWordLength");
    System.out.println("4) mostCommonChar"+"\n"+"5) mostCommonWord (takes a little bit of time)"+"\n"+"6) randomSummary");

    Scanner input = new Scanner (System.in); //creation of scanner
    String result = input.next();//tells scanner what to do

  try {
    File data = new File("Frankenstein.txt");
    Scanner fr = new Scanner(data);// data for ArrayList
    Scanner fr2 = new Scanner(data);//data for StringBuilder

    while(fr.hasNext()){
      text.add(fr.next());//Arraylist
      text2.append(fr2.next());//Stringbuilder


        }
    for(int i = 0; i<text2.length(); i++){//takes out punctuation from stringbuilder so it isn't considered as part of the length
      if(text2.charAt(i)=='.'){
        text2.setCharAt(i,'\0');
        }
      else if(text2.charAt(i)==','){
        text2.setCharAt(i,'\0');
        }
        else if(text2.charAt(i)==':'){
          text2.setCharAt(i,'\0');
          }
          else if(text2.charAt(i)==';'){
            text2.setCharAt(i,'\0');
            }
            else if(text2.charAt(i)=='?'){
              text2.setCharAt(i,'\0');
              }
              else if(text2.charAt(i)=='!'){
                text2.setCharAt(i,'\0');
                }
                else if(text2.charAt(i)=='-'){
                  text2.setCharAt(i,'\0');
                  }
                  else if(text2.charAt(i)=='_'){
                    text2.setCharAt(i,'\0');
                    }
                    else if(text2.charAt(i)=='('){
                      text2.setCharAt(i,'\0');
                      }
                      else if(text2.charAt(i)==')'){
                        text2.setCharAt(i,'\0');
                        }
                        else if(text2.charAt(i)=='\"'){
                          text2.setCharAt(i,'\0');
                        }
                  }

    }

  catch (FileNotFoundException e) {
    e.printStackTrace();
  }

  if(result.equals("1")){//recursive Word Search -- works
    System.out.println("What word would you like to search for?");
    Scanner tar = new Scanner(System.in);//target is the word being searched for
    String target = tar.next();
    int index = 0;
    int count = 0;

while(true){
    if(index >= text.size()){//if the index is greater than the size of the arraylist exit while loop to print
      break;
      }

    else if(text.get(index).equals(target)){//if the word in the arraylist at an index is equal to the target value increase count and the index by one
      count++;
      index++;
      }
      //if a word is next to any form of punctuation it still counts the word, is there a better way to do this?
    else if(text.get(index).equals(target+".")){
      count++;
      index++;
      }
      else if(text.get(index).equals(target+",")){
        count++;
        index++;
        }
        else if(text.get(index).equals(target+":")){
          count++;
          index++;
          }
          else if(text.get(index).equals(target+";")){
            count++;
            index++;
            }
              else if(text.get(index).equals(target+"?")){
                count++;
                index++;
                }
                  else if(text.get(index).equals(target+"!")){
                    count++;
                    index++;
                    }
                    else if(text.get(index).equals(target+"-")){
                      count++;
                      index++;
                      }
                      else if(text.get(index).equals("_"+target)){//underscore could be on either side in fornt or behind the word
                        count++;
                        index++;
                          }
                            else if(text.get(index).equals(target+"_")){
                              count++;
                              index++;
                              }
                                else if(text.get(index).equals("("+target)){//parentheses could be on either side of a word
                                  count++;
                                  index++;
                                  }
                                  else if(text.get(index).equals(target+")")){
                                    count++;
                                    index++;
                                    }


    else{//if the word in the arraylist at an index does not equal the target value, move onto the next word
      index++;
      }
    }
    //print outside of while loop
    System.out.println("The string: "+"'"+target+"'"+" occurs "+count+" times");
  }

  if(result.equals("2")){//number of words -- works
    System.out.println("The number of words is:"+text.size());//the size of the text is the amount of words in the arraylist
    }

  if(result.equals("3")){//avg length of a word -- works
    int avg;
    avg = text2.length()/text.size();//the number of characters in a text divided by the number of words
    System.out.println("The average word length is:"+avg);
    }

  if(result.equals("4")){//most common character -- works

      int count = 0;
      int amount = 0;
      char letter = '\0';

      for(char c = 'a'; c<='z'; c++){// from a-z
           count = 1;

           for(int j = c+1; j < text2.length(); j++){//count each word in the file
               if(text2.charAt(c)==(text2.charAt(j))){
                   count++;
               }
           }
           if(count > amount){//if the amount is less than count then store value of count in amount
               amount = count;
               letter = text2.charAt(c);
           }
       }
       System.out.println("The most common letter is: '"+letter+"' and it occurs: "+amount+" times"+count);
    }

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

           if(count > amount){//if the amount is less than count then store value of count in amount
               amount = count;
               word = text.get(i);
           }
       }
       System.out.println("The most common word is: '"+word+"' and it occurs: "+amount+" times");
    }

   if(result.equals("6")){

     System.out.println("How many words should the 'summary' be?");
      StringBuilder random = new StringBuilder();
      Scanner input3 = new Scanner(System.in);
      String result3 = input3.next();
      int x = Integer.parseInt(result3);
      int index = 0;

    while(true){
      Collections.shuffle(text);
        if(index >= x){//if the index is greater than the size of the arraylist exit while loop to print
          break;
          }

        else if(text.get(index) != null){
          random.append(text.get(index)+" ");
          index++;
        }
      }
    //print outside of while loop
      System.out.println("Random Summary: "+random);
    }
  }
}
