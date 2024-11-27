import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends Frame implements ActionListener, ItemListener {
  Panel p1 = new Panel(); //Auswahl Panel
  Panel p2 = new Panel(); //Grafik Panel
    
  TextField t1 = new TextField(); //Anzahl
  TextField t2 = new TextField(); // Name
    
  Button b1 = new Button("Erstellen");
  Button b2 = new Button ("+");

    
  public Main() {
    Dimension size 
    = Toolkit.getDefaultToolkit().getScreenSize(); 
    
    // width will store the width of the screen 
    int width = (int)size.getWidth(); 
    
    // height will store the height of the screen 
    int height = (int)size.getHeight(); 
    setSize(width, height);
    
    
    setLayout(null);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    add(p2); p2.setBounds(0,0, width, (int)(height*0.25)); p2.setBackground(new Color (0,100,200));
    p2.setLayout(null);
    add(p1); p1.setBounds(0,(int)(height*0.25), width, (int)(height*0.75)); p1.setBackground( new Color (50,150,255));
    p1.setLayout(null);
    
    p1.add(t1); t1.addActionListener(this); t1.setBounds(30,30,100,100); t1.setForeground(new Color(0,100,200));
    p1.add(t2); t2.addActionListener(this); t2.setBounds(160,30,100,100); t2.setForeground(new Color(0,100,200));
    
    p1.add(b1); b1.addActionListener(this); b1.setBounds((int)(width-160),30,100,100); b1.setForeground(new Color(0,100,200));
    p1.add(b2); b2.addActionListener(this); b2.setBounds(30,160,100,100); b2.setForeground(new Color(0,100,200));
    
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    /*if (e.getSource() == chooseColor) {
    Color color = JColorChooser.showDialog(this, "Select a Color", colorPanel.getBackground());
    if (color != null) {
    colorPanel.setBackground(color);
    }
    } */
  }
  public void itemStateChanged(ItemEvent e) {
  }

  public static void main(String[] args) {
    new Main();
  }
}
