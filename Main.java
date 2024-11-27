import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends Frame implements ActionListener, ItemListener {
    Panel p1 = new Panel(); //Auswahl Panel
    Panel p2 = new Panel(); //Grafik Panel
    
    Textfield t1 = new Textfield; //Anzahl
    Textfield t2 = new Textfield; // Name
    
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
        add(p1); 
        p1.add(t1); t1.addItemListener(this);
        p1.add(t2); t1.addItemListener(this);
        
        p1.add(b1); b1.addActionListener(this);
        p1.add(b2); b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseColor) {
            Color color = JColorChooser.showDialog(this, "Select a Color", colorPanel.getBackground());
            if (color != null) {
                colorPanel.setBackground(color);
            }
        }
    }
    public void itemStateChanged(ItemEvent e) {
    }

    public static void main(String[] args) {
        new ColorSelector();
    }
}
