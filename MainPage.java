import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.font.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainPage extends Frame implements WindowListener, ActionListener{
//instance variables
TextField name;
TextField year;//maybe not a textfield??
TextField month;
TextField day;

Label items;
Checkbox markers;//markers and pens
Checkbox paintbrush;
Checkbox scissor;//scissors and exacto knives

Checkbox other;//maybe, ask Mr.Weir
TextField other2;


Checkbox in;
Checkbox out;
CheckboxGroup option;

Button submit;
Label top;//title on main page

StringBuilder inn;
StringBuilder outt;


File signin;
File signout;


public MainPage(String title) {
  super(title);
  setLayout(null);//since it's null I have to set everythings location
  addWindowListener(this);

inn = new StringBuilder();
outt = new StringBuilder();

Font font1 = new Font("SansSerif",Font.PLAIN,10);

  top = new Label("     Art Room Supplies Sign in");
  add(top);//name box and values
  top.setBackground(Color.gray);//setting the color
  top.setBounds(150,40,200,50);//settting the location

//name and date
  name = new TextField("Name");
  add(name);
  name.setBounds(170,110,150,50);

  year = new TextField("Year");
  add(year);
  year.setBounds(70,180,100,50);

  month = new TextField("Month");
  add(month);
  month.setBounds(190,180,100,50);

  day = new TextField("Day");
  add(day);
  day.setBounds(310,180,100,50);

//Items being used
  items = new Label("    Items:");
  add(items);
  items.setBackground(Color.gray);
  items.setBounds(50,250,100,40);

  markers = new Checkbox("Markers, Lining Pens, Colored Pencils",false);
  add(markers);
  markers.setFont(font1);
  markers.setBackground(Color.gray);
  markers.setBounds(130,300,250,40);

  paintbrush = new Checkbox("Paintbrushes, Paints",false);
  add(paintbrush);
  paintbrush.setFont(font1);
  paintbrush.setBackground(Color.gray);
  paintbrush.setBounds(130,370,250,40);

  scissor = new Checkbox("Scissors, Rulers, Exacto Knives", false);
  add(scissor);
  scissor.setFont(font1);
  scissor.setBackground(Color.gray);
  scissor.setBounds(130,440,250,40);


//Submit
  option = new CheckboxGroup();

  in = new Checkbox("I am Signing In",option,false);
  add(in);
  in.setFont(font1);
  in.setBackground(Color.gray);
  in.setBounds (50,530,120,30);

  out = new Checkbox("I am Signing Out",option,false);
  out.setFont(font1);
  add(out);
  out.setBackground(Color.gray);
  out.setBounds (300,530,120,30);

  submit = new Button("Submit");
  add(submit);
  submit.setBackground(Color.gray);
  submit.setBounds(170,590,120,50);
  submit.addActionListener(this);


  }

//https://beginnersbook.com/2014/01/how-to-append-to-a-file-in-java/


  public static void main(String[] args) {

      MainPage myWindow = new MainPage("Main Page");
      myWindow.setSize(500,700);//window size
      myWindow.setVisible(true);//it is visible

    }


  public void actionPerformed(ActionEvent e) {


//signin
if(in.getState()){
  if(markers.getState()){
    inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers\n");
    if(paintbrush.getState()){
      inn.delete(0,100);
      inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and paintbrushes\n");//markers and paintbrushes
      if(scissor.getState()){
        inn.delete(0,100);
        inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers, paintbrushes and scissors\n");//all three
      }
    }else if(scissor.getState()){
      inn.delete(0,100);
      inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and scissors\n");
    }

  }else if(paintbrush.getState()){
    inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes\n");
    if(scissor.getState()){
      inn.delete(0,100);
      inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes and scissors\n");
    }

  }else{
    inn.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == scissors\n");
  }

//signout
}else if(out.getState()){
  if(markers.getState()){
    outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers\n");
    if(paintbrush.getState()){
      outt.delete(0,100);
      outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and paintbrushes\n");//markers and paintbrushes
      if(scissor.getState()){
        outt.delete(0,100);
        outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers, paintbrushes and scissors\n");//all three
      }
    }else if(scissor.getState()){
      outt.delete(0,100);
      outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and scissors\n");
    }
  }else if(paintbrush.getState()){
    outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes\n");
    if(scissor.getState()){
      outt.delete(0,100);
      outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes and scissors\n");
    }
  }else{
    outt.append(month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == scissors\n");
  }

}

if(e.getSource()== submit){

  signin = new File("signin.txt");//files to be typed in
  signout = new File("signout.txt");

try{//try catch used because the thing you coded may work and may not work -- file could be moved(code is still right, but there is not text)
  if (!signin.exists()) {//makes sure that the file actually exists where it should
    signin.createNewFile();
  }
  if (!signout.exists()) {
   signout.createNewFile();
  }
//signin
  if(in.getState()== true){
      FileWriter f = new FileWriter(signin,true);
      BufferedWriter b = new BufferedWriter(f);//buffers before it writes and doesn't rely on the io, more efficient
      PrintWriter p = new PrintWriter(b);

      p.println(inn.toString());//the stringbuilder of my window -- main page
      p.close();

}
//signout
  else if(out.getState()==true){
      FileWriter fo = new FileWriter(signout,true);
      BufferedWriter bo = new BufferedWriter(fo);//buffers before it writes and doesn't rely on the io, more efficient
      PrintWriter po = new PrintWriter(bo);

      po.println(outt.toString());//the stringbuilder of my window -- main page
      po.close();

      }

  }catch (IOException ioe) {
   ioe.printStackTrace();
        }
//setting everything back to its original state
  name.setText("Name");

  year.setText("Year");
  month.setText("Month");
  day.setText("Day");

  scissor.setState(false);
  markers.setState(false);
  paintbrush.setState(false);

  out.setState(false);
  in.setState(false);

    }

}


  public void windowClosing(WindowEvent e) {//so it closes
          dispose();
          System.exit(0);

  }

  public void windowOpened(WindowEvent e) {}//override stuff
  public void windowActivated(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
}
