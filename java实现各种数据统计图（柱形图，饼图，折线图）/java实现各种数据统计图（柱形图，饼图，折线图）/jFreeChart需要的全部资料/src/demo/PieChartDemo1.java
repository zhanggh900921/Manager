



package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo1 extends ApplicationFrame
{

    public PieChartDemo1(String s)
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
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 1", piedataset, true, true, false);
        TextTitle texttitle = jfreechart.getTitle();
        texttitle.setToolTipText("A title tooltip!");
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setLabelFont(new Font("SansSerif", 0, 12));
        pieplot.setNoDataMessage("No data available");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PieChartDemo1 piechartdemo1 = new PieChartDemo1("Pie Chart Demo 1");
        piechartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo1);
        piechartdemo1.setVisible(true);
    }
}
