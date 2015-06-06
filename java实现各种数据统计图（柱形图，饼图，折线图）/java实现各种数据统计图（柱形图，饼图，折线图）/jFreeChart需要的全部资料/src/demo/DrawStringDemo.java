



package demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import org.jfree.ui.*;

// Referenced classes of package demo:
//            DrawStringPanel

public class DrawStringDemo extends ApplicationFrame
    implements ActionListener, PropertyChangeListener
{

    public DrawStringDemo(String s)
    {
        super(s);
        setContentPane(createContentPane());
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getActionCommand().equals("fontButton.clicked"))
            displayFontDialog();
        if(actionevent.getActionCommand().equals("combo1.changed"))
            handleCombo1Change();
        if(actionevent.getActionCommand().equals("combo2.changed"))
            handleCombo2Change();
        if(actionevent.getActionCommand().equals("combo3.changed"))
            handleCombo3Change();
    }

    public void propertyChange(PropertyChangeEvent propertychangeevent)
    {
        int i = spinner.getValue();
        double d = 6.2831853071795862D * ((double)i / 360D);
        drawStringPanel2.setAngle(d);
        drawStringPanel2.invalidate();
        drawStringPanel2.repaint();
    }

    private void handleCombo1Change()
    {
        String s = combo1.getSelectedItem().toString();
        drawStringPanel1.setAnchor(convertStringToAnchor(s));
        drawStringPanel1.invalidate();
        drawStringPanel1.repaint();
    }

    private void handleCombo2Change()
    {
        String s = combo2.getSelectedItem().toString();
        drawStringPanel2.setAnchor(convertStringToAnchor(s));
        drawStringPanel2.invalidate();
        drawStringPanel2.repaint();
    }

    private void handleCombo3Change()
    {
        String s = combo3.getSelectedItem().toString();
        drawStringPanel2.setRotationAnchor(convertStringToAnchor(s));
        drawStringPanel2.invalidate();
        drawStringPanel2.repaint();
    }

    private JPanel createContentPane()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        JTabbedPane jtabbedpane = new JTabbedPane();
        jtabbedpane.add("Alignment", createTab1Content());
        jtabbedpane.add("Rotation", createTab2Content());
        jpanel.add(jtabbedpane);
        return jpanel;
    }

    private JPanel createTab1Content()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        combo1 = new JComboBox();
        combo1.setActionCommand("combo1.changed");
        populateTextAnchorCombo(combo1);
        combo1.addActionListener(this);
        JPanel jpanel1 = new JPanel();
        jpanel1.add(combo1);
        JButton jbutton = new JButton("Select Font...");
        jbutton.setActionCommand("fontButton.clicked");
        jbutton.addActionListener(this);
        jpanel1.add(jbutton);
        jpanel.add(jpanel1, "North");
        drawStringPanel1 = new DrawStringPanel("0123456789", false);
        jpanel.add(drawStringPanel1);
        return jpanel;
    }

    private JPanel createTab2Content()
    {
        JPanel jpanel = new JPanel(new BorderLayout());
        JPanel jpanel1 = new JPanel();
        jpanel1.add(new JLabel("Text anchor: "));
        combo2 = new JComboBox();
        populateTextAnchorCombo(combo2);
        combo2.setActionCommand("combo2.changed");
        combo2.addActionListener(this);
        jpanel1.add(combo2);
        jpanel1.add(new JLabel("Rotation anchor: "));
        combo3 = new JComboBox();
        populateTextAnchorCombo(combo3);
        combo3.setActionCommand("combo3.changed");
        combo3.addActionListener(this);
        jpanel1.add(combo3);
        spinner = new Spinner(0);
        spinner.addPropertyChangeListener(this);
        jpanel1.add(spinner);
        jpanel.add(jpanel1, "North");
        drawStringPanel2 = new DrawStringPanel("Rotated Text", true);
        jpanel.add(drawStringPanel2);
        return jpanel;
    }

    private void displayFontDialog()
    {
        FontChooserPanel fontchooserpanel = new FontChooserPanel(drawStringPanel1.getFont());
        int i = JOptionPane.showConfirmDialog(this, fontchooserpanel, "Font Selection", 2, -1);
        if(i == 0)
        {
            drawStringPanel1.setFont(fontchooserpanel.getSelectedFont());
            drawStringPanel2.setFont(fontchooserpanel.getSelectedFont());
        }
    }

    private void populateTextAnchorCombo(JComboBox jcombobox)
    {
        jcombobox.addItem("TextAnchor.TOP_LEFT");
        jcombobox.addItem("TextAnchor.TOP_CENTER");
        jcombobox.addItem("TextAnchor.TOP_RIGHT");
        jcombobox.addItem("TextAnchor.HALF_ASCENT_LEFT");
        jcombobox.addItem("TextAnchor.HALF_ASCENT_CENTER");
        jcombobox.addItem("TextAnchor.HALF_ASCENT_RIGHT");
        jcombobox.addItem("TextAnchor.CENTER_LEFT");
        jcombobox.addItem("TextAnchor.CENTER");
        jcombobox.addItem("TextAnchor.CENTER_RIGHT");
        jcombobox.addItem("TextAnchor.BASELINE_LEFT");
        jcombobox.addItem("TextAnchor.BASELINE_CENTER");
        jcombobox.addItem("TextAnchor.BASELINE_RIGHT");
        jcombobox.addItem("TextAnchor.BOTTOM_LEFT");
        jcombobox.addItem("TextAnchor.BOTTOM_CENTER");
        jcombobox.addItem("TextAnchor.BOTTOM_RIGHT");
    }

    private TextAnchor convertStringToAnchor(String s)
    {
        if(s.equals("TextAnchor.TOP_LEFT"))
            return TextAnchor.TOP_LEFT;
        if(s.equals("TextAnchor.TOP_CENTER"))
            return TextAnchor.TOP_CENTER;
        if(s.equals("TextAnchor.TOP_RIGHT"))
            return TextAnchor.TOP_RIGHT;
        if(s.equals("TextAnchor.CENTER_LEFT"))
            return TextAnchor.CENTER_LEFT;
        if(s.equals("TextAnchor.CENTER"))
            return TextAnchor.CENTER;
        if(s.equals("TextAnchor.CENTER_RIGHT"))
            return TextAnchor.CENTER_RIGHT;
        if(s.equals("TextAnchor.HALF_ASCENT_LEFT"))
            return TextAnchor.HALF_ASCENT_LEFT;
        if(s.equals("TextAnchor.HALF_ASCENT_CENTER"))
            return TextAnchor.HALF_ASCENT_CENTER;
        if(s.equals("TextAnchor.HALF_ASCENT_RIGHT"))
            return TextAnchor.HALF_ASCENT_RIGHT;
        if(s.equals("TextAnchor.BASELINE_LEFT"))
            return TextAnchor.BASELINE_LEFT;
        if(s.equals("TextAnchor.BASELINE_CENTER"))
            return TextAnchor.BASELINE_CENTER;
        if(s.equals("TextAnchor.BASELINE_RIGHT"))
            return TextAnchor.BASELINE_RIGHT;
        if(s.equals("TextAnchor.BOTTOM_LEFT"))
            return TextAnchor.BOTTOM_LEFT;
        if(s.equals("TextAnchor.BOTTOM_CENTER"))
            return TextAnchor.BOTTOM_CENTER;
        if(s.equals("TextAnchor.BOTTOM_RIGHT"))
            return TextAnchor.BOTTOM_RIGHT;
        else
            return null;
    }

    public static void main(String args[])
    {
        DrawStringDemo drawstringdemo = new DrawStringDemo("DrawString Demo");
        drawstringdemo.pack();
        RefineryUtilities.centerFrameOnScreen(drawstringdemo);
        drawstringdemo.setVisible(true);
    }

    private JComboBox combo1;
    private JComboBox combo2;
    private JComboBox combo3;
    private Spinner spinner;
    private DrawStringPanel drawStringPanel1;
    private DrawStringPanel drawStringPanel2;
}
