import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Teacher extends Frame implements WindowListener, ActionListener{

  Button openIn;//buttons to open sign in and sign out text files
  Button openOut;
  Button back;

  File signin;
  File signout;

  Who start;

  public Teacher(String title) {
    super(title);
    setLayout(null);//since it's null I have to set everythings location
    addWindowListener(this);

Font font1 = new Font("SansSerif",Font.PLAIN,10);

      openIn = new Button("Open Sign In Log");
      add(openIn);
      openIn.setFont(font1);
      openIn.setBounds(50,100,150,100);
      openIn.addActionListener(this);

      openOut = new Button("Open Sign Out Log");
      add(openOut);
      openOut.setFont(font1);
      openOut.setBounds(250,100,150,100);
      openOut.addActionListener(this);


  }


  public void actionPerformed(ActionEvent e) {
    Desktop dt = Desktop.getDesktop();
    signin = new File("signin.txt");//files to be typed in
    signout = new File("signout.txt");



  if(e.getSource()==openIn){
    try{
      if(!Desktop.isDesktopSupported()){ //is desktop supported on this system
          System.out.println("not supported");
          return;
          }

      if(signin.exists()){//checks file exists or not
            dt.open(signin);//opens the specified file
          }
    }catch(Exception t){
    t.printStackTrace();
    }
  }else if(e.getSource()==openOut){

    try{
      if(!Desktop.isDesktopSupported()){ //is desktop supported on this system
          System.out.println("not supported");
          return;
          }

      if(signout.exists()){//checks file exists or not
            dt.open(signout);//opens the specified file
          }
    }catch(Exception p)
    {
    p.printStackTrace();
    }
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
