import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorSelector extends Frame implements ActionListener {
    private Button chooseColor = new Button("Choose Color");
    private Panel colorPanel = new Panel();

    public ColorSelector() {
        setSize(400, 300);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        chooseColor.addActionListener(this);
        colorPanel.setBackground(Color.WHITE);

        add(chooseColor, BorderLayout.SOUTH);
        add(colorPanel, BorderLayout.CENTER);

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

    public static void main(String[] args) {
        new ColorSelector();
    }
}
