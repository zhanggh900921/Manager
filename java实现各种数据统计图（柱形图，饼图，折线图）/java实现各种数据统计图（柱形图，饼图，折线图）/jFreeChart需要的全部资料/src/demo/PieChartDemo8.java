



package demo;

import java.awt.Dimension;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo8 extends ApplicationFrame
{
    static class CustomLabelGenerator
        implements PieSectionLabelGenerator
    {

        public String generateSectionLabel(PieDataset piedataset, Comparable comparable)
        {
            String s = null;
            if(piedataset != null && !comparable.equals("Two"))
                s = comparable.toString();
            return s;
        }

        public AttributedString generateAttributedSectionLabel(PieDataset piedataset, Comparable comparable)
        {
            AttributedString attributedstring = null;
            String s = comparable.toString();
            String s1 = s + " : " + String.valueOf(piedataset.getValue(comparable));
            attributedstring = new AttributedString(s1);
            attributedstring.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, 0, s.length() - 1);
            return attributedstring;
        }

        CustomLabelGenerator()
        {
        }
    }


    public PieChartDemo8(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static PieDataset createDataset()
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("One", new Double(43.200000000000003D));
        defaultpiedataset.setValue("Two", new Double(10D));
        defaultpiedataset.setValue("Three", new Double(27.5D));
        defaultpiedataset.setValue("Four", new Double(17.5D));
        defaultpiedataset.setValue("Five", new Double(11D));
        defaultpiedataset.setValue("Six", new Double(19.399999999999999D));
        return defaultpiedataset;
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 8", piedataset, false, true, false);
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setLabelGenerator(new CustomLabelGenerator());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PieChartDemo8 piechartdemo8 = new PieChartDemo8("Pie Chart Demo 8");
        piechartdemo8.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo8);
        piechartdemo8.setVisible(true);
    }
}
