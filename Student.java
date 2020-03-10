import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Student extends Frame implements WindowListener, ActionListener{

//instance variables
TextField name;
TextField year;
TextField month;
TextField day;
TextField time;


Label items;
Checkbox markers;//markers and pens
Checkbox paintbrush;
Checkbox scissor;//scissors and exacto knives

Button submit;

Checkbox in;
Checkbox out;
CheckboxGroup option;

Label top;//title on main page

StringBuilder StrIn;
StringBuilder StrOut;

File signout;
File signin;

public Student(String title) {
  super(title);
  setLayout(null);//since it's null I have to set everythings location
  addWindowListener(this);

StrIn = new StringBuilder();
StrOut = new StringBuilder();

Font font1 = new Font("SansSerif",Font.PLAIN,10);

  top = new Label("     Art Room Supplies Sign in");
  top.setForeground(Color.white);
  add(top);//name box and values
  top.setBackground(Color.gray);//setting the color
  top.setBounds(150,40,200,50);//settting the location

//name and date
  name = new TextField("Name");
  add(name);
  name.setBounds(170,110,150,50);

  year = new TextField("Year");
  add(year);
  year.setBounds(15,180,100,50);

  month = new TextField("Month");
  add(month);
  month.setBounds(135,180,100,50);

  day = new TextField("Day");
  add(day);
  day.setBounds(255,180,100,50);

  time = new TextField("Time");
  add(time);
  time.setBounds(375,180,100,50);

//Items being used
  items = new Label("    Items:");
  items.setForeground(Color.white);
  add(items);
  items.setBackground(Color.gray);
  items.setBounds(50,250,100,40);

  markers = new Checkbox("Markers, Lining Pens, Colored Pencils",false);
  markers.setForeground(Color.white);
  add(markers);
  markers.setFont(font1);
  markers.setBackground(Color.gray);
  markers.setBounds(130,300,250,40);

  paintbrush = new Checkbox("Paintbrushes, Paints",false);
  paintbrush.setForeground(Color.white);
  add(paintbrush);
  paintbrush.setFont(font1);
  paintbrush.setBackground(Color.gray);
  paintbrush.setBounds(130,370,250,40);

  scissor = new Checkbox("Scissors, Rulers, Exacto Knives", false);
  scissor.setForeground(Color.white);
  add(scissor);
  scissor.setFont(font1);
  scissor.setBackground(Color.gray);
  scissor.setBounds(130,440,250,40);


//Submit
  option = new CheckboxGroup();

  in = new Checkbox("I am Signing In",option,false);
  add(in);
  in.setForeground(Color.white);
  in.setFont(font1);
  in.setBackground(Color.gray);
  in.setBounds (50,530,120,30);

  out = new Checkbox("I am Signing Out",option,false);
  add(out);
  out.setForeground(Color.white);
  out.setFont(font1);
  out.setBackground(Color.gray);
  out.setBounds (300,530,120,30);

  submit = new Button("Submit");
  add(submit);
  submit.setBackground(Color.gray);
  submit.setBounds(170,590,120,50);
  submit.addActionListener(this);


  }


  public void actionPerformed(ActionEvent e) {
    Desktop dt = Desktop.getDesktop();
    signin = new File("signin.txt");//files to be typed in
    signout = new File("signout.txt");



//signin
if(in.getState()){
  if(markers.getState()){
    StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers");
    if(paintbrush.getState()){
      StrIn.delete(0,100);
      StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and paintbrushes");//markers and paintbrushes
      if(scissor.getState()){
        StrIn.delete(0,100);
        StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers, paintbrushes and scissors");//all three
      }
    }else if(scissor.getState()){
      StrIn.delete(0,100);
      StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and scissors");
    }

  }else if(paintbrush.getState()){
    StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes");
    if(scissor.getState()){
      StrIn.delete(0,100);
      StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes and scissors");
    }

  }else{
    StrIn.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == scissors");
  }

//signout
}else if(out.getState()){
  if(markers.getState()){
    StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers");
    if(paintbrush.getState()){
      StrOut.delete(0,100);
      StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and paintbrushes");//markers and paintbrushes
      if(scissor.getState()){
        StrOut.delete(0,100);
        StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers, paintbrushes and scissors");//all three
      }
    }else if(scissor.getState()){
      StrOut.delete(0,100);
      StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == markers and scissors");
    }
  }else if(paintbrush.getState()){
    StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes");
    if(scissor.getState()){
      StrOut.delete(0,100);
      StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == paintbrushes and scissors");
    }
  }else{
    StrOut.append(time.getText()+" "+month.getText()+"/"+day.getText()+"/"+year.getText()+" == "+name.getText()+" == scissors");
  }

}

if(e.getSource()== submit){

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

      p.println(StrIn.toString());//the stringbuilder of my window -- main page
      p.close();

}
//signout
  else if(out.getState()==true){
      FileWriter fo = new FileWriter(signout,true);
      BufferedWriter bo = new BufferedWriter(fo);//buffers before it writes and doesn't rely on the io, more efficient
      PrintWriter po = new PrintWriter(bo);

      po.println(StrOut.toString());//the stringbuilder of my window -- main page
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
    }
//opening files for the client



}

//to be added -- color, image(?), way to open text files -- password
//should the date just be one text field
//time ??
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
