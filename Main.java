import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//Button "-" textfelder löschen; Nur int möglich einzugeben bei anzahl; nur string bei name; nur int bei textfield anzahl schritte
public class Main extends Frame implements ActionListener, ItemListener, MouseListener {
    Panel p1 = new Panel(); // Auswahl Panel
    Graph p2 = new Graph(); // Grafik Panel

    java.util.List<TextField> aA = new ArrayList<TextField>();
    java.util.List<TextField> aN = new ArrayList<TextField>();

    Button b1 = new Button("Erstellen");
    Button b2 = new Button("+");

    Checkbox c = new Checkbox("Mit zurücklegen", true);
    TextField t = new TextField();

    Label l1 = new Label("Anzahl");
    Label l2 = new Label("Name");
    Label l3 = new Label("Anzahl der Schritte");

    int anzahl;
    boolean zuruck;

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    // width will store the width of the screen
    int width = (int) size.getWidth();

    // height will store the height of the screen
    int height = (int) size.getHeight();

    public Main() {
        super("Baumdiagramm");
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(width, height, width, height);
        width += 10;// Fix width of panels
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(width, height);
        /*
         * float f = 10f;
         * Font of = t1.getFont();
         * of.deriveFont(f);
         */

        add(p2);
        p2.setbounds(new Rectangle(0, 0, width, (int) (height * 0.25)));
        p2.setBackground(new Color(0, 100, 200));
        p2.addMouseListener(this);

        add(p1);
        p1.setBounds(0, (int) (height * 0.25), width, (int) (height * 0.75));
        p1.setBackground(new Color(50, 150, 255));
        p1.setLayout(null);
        p1.addMouseListener(this);

        p1.add(l1);
        l1.setBounds(30, 5, 80, 20);
        l1.setForeground(new Color(0, 100, 200));

        p1.add(l2);
        l2.setBounds(140, 5, 80, 20);
        l2.setForeground(new Color(0, 100, 200));

        p1.add(b1);
        b1.addActionListener(this);
        b1.setBounds((int) (width - 140), 30, 80, 60);
        b1.setForeground(new Color(0, 100, 200));
        // b1.setFont(of);

        p1.add(b2);
        b2.addActionListener(this);
        b2.setBounds(30, 120, 80, 60);
        b2.setForeground(new Color(0, 100, 200));
        // b2.setFont(of);

        p1.add(c);
        c.addItemListener(this);
        c.setBounds((int) (width * 0.35), 30, 100, 30);
        c.setForeground(new Color(0, 100, 200));

        p1.add(l3);
        l3.setBounds((int) (width * 0.5), 5, 150, 20);
        l3.setForeground(new Color(0, 100, 200));

        p1.add(t);
        t.addActionListener(this);
        t.setBounds((int) (width * 0.5), 30, 150, 30);
        t.setForeground(new Color(0, 100, 200));

        addTF();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        /*
         * if (e.getSource() == chooseColor) {
         * Color color = JColorChooser.showDialog(this, "Select a Color",
         * colorPanel.getBackground());
         * if (color != null) {
         * colorPanel.setBackground(color);
         * }
         * }
         */
        if (e.getSource() == b1) {
            try {
                int[] arrA = new int[aA.size()];
                String[] arrN = new String[aN.size()];
                System.out.print("Anzahl verschiedener Arten: ");
                for (int i = 0; i < aA.size(); i++) {

                    arrA[i] = Integer.parseInt(aA.get(i).getText());
                    System.out.print(arrA[i] + " ");
                }
                System.out.print("\nNamen: ");
                for (int i = 0; i < aN.size(); i++) {
                    arrN[i] = aN.get(i).getText();
                    System.out.print(arrN[i] + " ");
                }
                anzahl = Integer.parseInt(t.getText());
                System.out.println("\nAnzahl der Schritte: " + anzahl);
                zuruck = c.getState();
                System.out.println(c.getState() ? "Mit zurücklegen" : "Ohne zurücklegen");
                Color[] colors = new Color[arrA.length];
                for (int i = 0; i < arrA.length; i++) {
                    colors[i] = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                            (int) (Math.random() * 255));
                }

                p2.setbounds(new Rectangle(0, 0, width, (int) (height * 0.75)));
                p1.setBounds(0, (int) (height * 0.75), width, (int) (height * 0.25));
                p2.setConfig(arrN, arrA, colors, zuruck, anzahl);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen");
            }
        } // end of if
        if (e.getSource().equals(b2)) {
            addTF();

        } // end of if

    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == p1) {
            p2.setbounds(new Rectangle(0, 0, width, (int) (height * 0.25)));
            p1.setBounds(0, (int) (height * 0.25), width, (int) (height * 0.75));
        } // end of if

        if (e.getSource() == p2) {
            p2.setbounds(new Rectangle(0, 0, width, (int) (height * 0.75)));
            p1.setBounds(0, (int) (height * 0.75), width, (int) (height * 0.25));
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void addTF() {

        String a = "";
        String n = "";
        TextField t1 = new TextField(a); // Anzahl
        TextField t2 = new TextField(n); // Name

        p1.add(t1);
        t1.addActionListener(this);
        t1.setBounds(30, 30 + 90 * aN.size(), 80, 60);
        t1.setForeground(new Color(0, 100, 200));
        // t1.setFont(of);

        p1.add(t2);
        t2.addActionListener(this);
        t2.setBounds(140, 30 + 90 * aA.size(), 80, 60);
        t2.setForeground(new Color(0, 100, 200));
        // t2.setFont(of);

        b2.setBounds(30, 120 + 90 * aA.size(), 80, 60);

        aA.add(t1);
        aN.add(t2);
    }

    public static void main(String[] args) {
        new Main();
    }
}

// UI
class Knoten {
    public int index;
    public int x, y;
    public int remaining;
    public Knoten children[];
    public int[] amounts;
    public String[] names;
    public int width;
    public Color[] colors;
    public int amount = 0;

    public Knoten() {

    }

    public Knoten(int index, int x, int y, int width, int remaining, int[] amounts, String[] names, Color[] colors) {
        this.index = index;
        this.children = new Knoten[amounts.length];
        this.amounts = amounts;
        this.names = names;
        this.x = x;
        this.y = y;
        this.width = width;
        this.remaining = remaining;
        this.colors = colors;
        for (int i = 0; i < amounts.length; i++) {
            amount += amounts[i];
        }
        if (remaining <= 0) {
            return;
        }
        for (int i = 0; i < amounts.length; i++) {
            Knoten k = new Knoten(i, x - width / 2 + (i + 1) * width / (amounts.length + 1),
                    y + Graph.nodeSize + Graph.padding,
                    width / amounts.length,
                    remaining - 1, amounts,
                    names, colors);
            children[i] = k;
        }
    }

    public Knoten(int remaining, int[] amounts, String[] names, Color[] colors) {
        this.children = new Knoten[amounts.length];
        this.amounts = amounts;
        this.names = names;
        this.remaining = remaining;
        this.colors = colors;
        if (remaining <= 0) {
            return;
        }
        for (int i = 0; i < amounts.length; i++) {
            int[] newAmounts;
            String[] newNames;
            Color[] newColors;
            if (amounts[i] > 1) {// same Length
                newAmounts = new int[amounts.length];
                newNames = new String[amounts.length];
                newColors = new Color[amounts.length];
                System.arraycopy(amounts, 0, newAmounts, 0, amounts.length);
                System.arraycopy(names, 0, newNames, 0, names.length);
                System.arraycopy(colors, 0, newColors, 0, colors.length);
                newAmounts[i] = amounts[i] - 1;
            } else if (amounts[i] == 1) {// Shortened by 1
                newAmounts = new int[amounts.length - 1];
                newNames = new String[amounts.length - 1];
                newColors = new Color[amounts.length - 1];
                System.arraycopy(amounts, 0, newAmounts, 0, i);
                System.arraycopy(amounts, i + 1, newAmounts, i, amounts.length - i - 1);
                System.arraycopy(names, 0, newNames, 0, i);
                System.arraycopy(names, i + 1, newNames, i, names.length - i - 1);
                System.arraycopy(colors, 0, newColors, 0, i);
                System.arraycopy(colors, i + 1, newColors, i, colors.length - i - 1);
            } else {
                continue;
            }
            Knoten k = new Knoten(remaining - 1, newAmounts, newNames, newColors);
            children[i] = k;
        }
    }

    public int getWidth() {
        if (children.length <= 0) {
            width = Graph.nodeSize + Graph.padding;
            return width;
        }
        this.width = 0;
        for (int i = 0; i < children.length; i++) {
            width += children[i].getWidth();
        }
        return width;
    }

    public void position(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        for (int i = 0; i < children.length; i++) {
            children[i].position(x, y, width);
        }
    }

    public void createChildren() {

    }

    public void display(int x, int y, Graphics g) {
        g.setColor(this.colors[this.index]);
        g.fillOval(this.x, this.y, Graph.nodeSize, Graph.nodeSize);
        int x1 = this.x + Graph.nodeSize / 2;
        int y1 = this.y + Graph.nodeSize / 4;
        int x2 = x + Graph.nodeSize / 2;
        int y2 = y + Graph.nodeSize;
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.white);
        g.drawString(amounts[index] + "/" + amount, x1 - Graph.nodeSize / 4, y1 - Graph.nodeSize / 2);
        if (children.length <= 0) {
            return;
        }
        for (int j = 0; j < this.children.length; j++) {
            if (this.children[j] == null)
                break;
            this.children[j].display(this.x, this.y, g);
        }
    }
}

class RootKnoten {
    public int index;
    public int x, y;
    public int remaining;
    public Knoten children[];
    public int[] amounts;
    public String[] names;
    public int width;
    public Color[] colors;

    public RootKnoten() {

    }

    public RootKnoten(int x, int y, int width, int remaining, int[] amounts, String[] names, Color[] colors) {
        this.children = new Knoten[amounts.length];
        this.amounts = amounts;
        this.names = names;
        this.x = x;
        this.y = y;
        this.width = width;
        this.remaining = remaining;
        this.colors = colors;
        if (remaining <= 0) {
            return;
        }
        for (int i = 0; i < amounts.length; i++) {
            Knoten k = new Knoten(i, x - width / 2 + (i + 1) * width / (amounts.length + 1),
                    y + Graph.nodeSize + Graph.padding,
                    width / amounts.length,
                    remaining - 1, amounts,
                    names, colors);
            children[i] = k;
        }
    }

    public void display(Graphics g) {
        g.fillOval(this.x, this.y, Graph.nodeSize, Graph.nodeSize);
        if (children.length <= 0) {
            return;
        }
        for (int j = 0; j < this.children.length; j++) {
            if (this.children[j] == null)
                break;
            this.children[j].display(this.x, this.y, g);
        }
    }

    public int getWidth() {
        if (children.length <= 0) {
            width = Graph.nodeSize + Graph.padding;
            return width;
        }
        this.width = 0;
        for (int i = 0; i < children.length; i++) {
            width += children[i].getWidth();
        }
        return width;
    }

    public void createChildren(int remaining, int[] amounts, String[] names, Color[] colors) {
        this.children = new Knoten[amounts.length];
        this.amounts = amounts;
        this.names = names;
        this.remaining = remaining;
        this.colors = colors;
        if (remaining <= 0) {
            return;
        }
        for (int i = 0; i < amounts.length; i++) {
            int[] newAmounts;
            String[] newNames;
            Color[] newColors;
            int index = i;
            if (amounts[i] > 1) {// same Length
                newAmounts = new int[amounts.length];
                newNames = new String[amounts.length];
                newColors = new Color[amounts.length];
                System.arraycopy(amounts, 0, newAmounts, 0, amounts.length);
                System.arraycopy(names, 0, newNames, 0, names.length);
                System.arraycopy(colors, 0, newColors, 0, colors.length);
                newAmounts[i] = amounts[i] - 1;
            } else if (amounts[i] == 1) {// Shortened by 1
                newAmounts = new int[amounts.length - 1];
                newNames = new String[amounts.length - 1];
                newColors = new Color[amounts.length - 1];
                System.arraycopy(amounts, 0, newAmounts, 0, i);
                System.arraycopy(amounts, i + 1, newAmounts, i, amounts.length - i - 1);
                System.arraycopy(names, 0, newNames, 0, i);
                System.arraycopy(names, i + 1, newNames, i, names.length - i - 1);
                System.arraycopy(colors, 0, newColors, 0, i);
                System.arraycopy(colors, i + 1, newColors, i, colors.length - i - 1);
            } else {
                continue;
            }
            Knoten k = new Knoten(remaining - 1, newAmounts, newNames, newColors);
            children[i] = k;
        }
    }

    public void position(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        for (int i = 0; i < children.length; i++) {
            children[i].position(x, y, width);
            // (x - width / 2 + (i + 1) * width / (children.length + 1), y + Graph.nodeSize
            // + Graph.padding, width / children.length);
        }
    }
}

class Graph extends Component implements MouseListener {

    /** @see java.awt.Component#paint(java.awt.Graphics) */
    private Rectangle bounding;
    private Rectangle drag = new Rectangle(0, 0, 0, 0);
    private boolean dragging = false;
    private boolean back = false;
    private int steps = 1;
    private int[] amounts;
    private String[] names;
    private Color[] colors;
    private int endWidth;
    public static int nodeSize = 50;
    public static int padding = 50;
    private RootKnoten RootNode;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, bounding.width + 1, bounding.height);
        g.setColor(Color.YELLOW);
        if (RootNode == null)
            return;
        RootNode.display(g);
        // g.drawLine(0, 0, bounding.width, bounding.height);
        // System.out.println(String.valueOf(bounding));
        // g.drawLine(10, 10, (int) (bounding.width * .2), bounding.height);
        /*
         * g.fillOval(this.RootNode.x, this.RootNode.y, nodeSize, nodeSize);
         * for (int i = 0; i < RootNode.children.length; i++) {
         * RootNode.children[i].display(RootNode.x, RootNode.y, g);
         * /*
         * for (int j = 0; j < RootNode.children[i].children.length; j++) {
         * RootNode.children[i].children[j].display(RootNode.children[i].x,
         * RootNode.children[i].y, g);
         * }
         *
         * }
         */

    }

    public void setbounds(Rectangle rect) {
        super.setBounds(rect);
        bounding = rect;
    }

    public Graph() {
        this.addMouseListener(this);
    }

    public boolean setConfig(String[] names, int[] amounts, Color[] colors, boolean back, int steps) {
        if (names.length != amounts.length) {
            return false;
        }
        this.names = names;
        this.amounts = amounts;
        this.colors = colors;
        this.back = back;
        this.steps = steps;
        if (back) {
            this.endWidth = (int) Math.pow(amounts.length, steps) * (nodeSize + padding);
            this.RootNode = new RootKnoten(this.bounding.width / 2, 30, endWidth, steps, amounts, names, colors);
        } else {// Remove all empty items
            RootNode = new RootKnoten();
            RootNode.createChildren(steps, amounts, names, colors);
            this.endWidth = RootNode.getWidth();
            RootNode.position(this.bounding.width / 2, 30, endWidth);
        }
        repaint();
        return true;
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Hi");
        dragging = false;
        bounding.x += (e.getX() - drag.x);
        bounding.y += (e.getY() - drag.y);
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        dragging = true;
        drag.x = e.getX();
        drag.y = e.getY();
    }

    public void mousePressed(MouseEvent e) {
    }

}
