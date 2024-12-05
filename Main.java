import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
//Button "-" textfelder löschen; Nur int möglich einzugeben bei anzahl; nur string bei name; nur int bei textfield anzahl schritte
public class Main extends Frame implements ActionListener, ItemListener, MouseListener{
  Panel p1 = new Panel(); //Auswahl Panel
  Panel p2 = new Panel(); //Grafik Panel
  
  java.util.List <TextField> aA = new ArrayList <TextField>();
  java.util.List <TextField> aN = new ArrayList <TextField>();
    
  Button b1 = new Button("Erstellen");
  Button b2 = new Button ("+");
  
  Checkbox c = new Checkbox("Mit zurücklegen",true);
  TextField t = new TextField();
  
  Label l1 = new Label("Anzahl");
  Label l2 = new Label("Name");
  Label l3 = new Label("Anzahl der Schritte");
  
  int anzahl;
  boolean zuruck;

  Dimension size 
    = Toolkit.getDefaultToolkit().getScreenSize(); 
    
    // width will store the width of the screen 
  int width = (int)size.getWidth(); 
    
    // height will store the height of the screen 
  int height = (int)size.getHeight(); 
   
  public Main() {
    
    
    
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    
    
    setLayout(null);
    setSize(width, height);
    /*float f = 10f;
    Font of = t1.getFont();
    of.deriveFont(f);*/
    
    add(p2); 
    p2.setBounds(0,0, width, (int)(height*0.25)); 
    p2.setBackground(new Color (0,100,200));
    p2.setLayout(null);
    p2.addMouseListener(this);
    
    add(p1); 
    p1.setBounds(0,(int)(height*0.25), width, (int)(height*0.75)); 
    p1.setBackground( new Color (50,150,255));
    p1.setLayout(null);
    p1.addMouseListener(this);
    
    p1.add(l1);
    l1.setBounds(30,5,80,20);
    l1.setForeground(new Color(0,100,200));
    
    p1.add(l2);
    l2.setBounds(140,5,80,20);
    l2.setForeground(new Color(0,100,200));
    
    
    p1.add(b1); 
    b1.addActionListener(this); 
    b1.setBounds((int)(width-140),30,80,60); 
    b1.setForeground(new Color(0,100,200)); 
    //b1.setFont(of);
    
    p1.add(b2); 
    b2.addActionListener(this); 
    b2.setBounds(30,120,80,60); 
    b2.setForeground(new Color(0,100,200)); 
    //b2.setFont(of);
    
    p1.add(c);
    c.addItemListener(this);
    c.setBounds((int)(width*0.35),30,100,30);
    c.setForeground(new Color(0,100,200));
    
    p1.add(l3);
    l3.setBounds((int)(width*0.5),5,150,20);
    l3.setForeground(new Color(0,100,200));
    
    p1.add(t);
    t.addActionListener(this);
    t.setBounds((int)(width*0.5),30,150,30);
    t.setForeground(new Color(0,100,200));
    
    
    addTF();
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    /*if (e.getSource() == chooseColor) {
    Color color = JColorChooser.showDialog(this, "Select a Color", colorPanel.getBackground());
    if (color != null) {
    colorPanel.setBackground(color);
    }
    } */
    if (e.getSource() == b1) {
      int[]arrA = new int[aA.size()];
      String[]arrN = new String[aN.size()];
      p2.setSize(width, (int)(height*0.75));
      p1.setBounds(0,(int)(height*0.75), width, (int)(height*0.25));
      for (int i = 0; i < aA.size(); i++) {
        
        arrA[i]=Integer.parseInt(aA.get(i).getText());
        System.out.print(arrA[i]+" ");
      }
      System.out.println(" ");
      for (int i = 0; i < aN.size(); i++) {
        arrN[i]=aN.get(i).getText();
        System.out.print(arrN[i]+" ");
      }
      anzahl = Integer.parseInt(t.getText());
      System.out.println(anzahl);
      zuruck=c.getState();
      System.out.println(c.getState());
    } // end of if
    if (e.getSource().equals(b2)) {
      addTF();
      
    } // end of if

  }
  public void itemStateChanged(ItemEvent e) {
      
  }
  
  public void mouseReleased (MouseEvent e){
  }
  
  public void mouseClicked (MouseEvent e){
    if (e.getSource()==p1) {
      p2.setSize(width, (int)(height*0.25));
      p1.setBounds(0,(int)(height*0.25), width, (int)(height*0.75));
    } // end of if
    
    if (e.getSource()==p2) {
      p2.setSize(width, (int)(height*0.75));
      p1.setBounds(0,(int)(height*0.75), width, (int)(height*0.25));
    } 
  }
  
  public void mouseEntered (MouseEvent e){
    
  }
  
  public void mouseExited (MouseEvent e){
  }
  
  public void mousePressed (MouseEvent e){
  }
  
  public void addTF (){
    
    String a = "";
    String n = "";
    TextField t1 = new TextField(a); //Anzahl
    TextField t2 = new TextField(n); // Name
    
    
    
    p1.add(t1); 
    t1.addActionListener(this); 
    t1.setBounds(30,30+90*aN.size(),80,60); 
    t1.setForeground(new Color(0,100,200)); 
    //t1.setFont(of);
    
    p1.add(t2); 
    t2.addActionListener(this); 
    t2.setBounds(140,30+90*aA.size(),80,60); 
    t2.setForeground(new Color(0,100,200)); 
    //t2.setFont(of);
    
    b2.setBounds(30,120+90*aA.size(),80,60);
    
    aA.add(t1);
    aN.add(t2);
  }
  
  public static void main(String[] args) {
    new Main();
  }
}
