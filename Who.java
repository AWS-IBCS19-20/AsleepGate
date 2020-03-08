import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Who extends Frame implements WindowListener, ActionListener{
  Button teacher;
  Button student;


  Student stuWin;
  Teacher teaWin;

  //student.java

  public Who(String title) {

    super(title);
    setLayout(null);//since it's null I have to set everythings location
    addWindowListener(this);

    teacher = new Button("Teacher");
    add(teacher);
    teacher.setBounds(50,100,150,100);
    teacher.addActionListener(this);

    student = new Button("Student");
    add(student);
    student.setBounds(250,100,150,100);
    student.addActionListener(this);

    stuWin = new Student("Sign In");
    teaWin = new Teacher("Files");

  }
  public static void main(String[] args) {

          Who start = new Who("Startup");
          start.setSize(500,300);
          start.setVisible(true);


          start.stuWin.setSize(500,700);//window size
          start.stuWin.setVisible(false);//it is visible

          start.teaWin.setSize(500,300);
          start.teaWin.setVisible(false);

  }
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == student){
      stuWin.setVisible(true);
      this.setVisible(false);
    }
    else if(e.getSource() == teacher)
      teaWin.setVisible(true);
      this.setVisible(false);
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
