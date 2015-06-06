



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChart3DDemo1 extends ApplicationFrame
{

    public LineChart3DDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(143.19999999999999D, "S1", "C1");
        defaultcategorydataset.addValue(120.2D, "S1", "C2");
        defaultcategorydataset.addValue(135D, "S1", "C3");
        defaultcategorydataset.addValue(115D, "S1", "C4");
        defaultcategorydataset.addValue(98.700000000000003D, "S2", "C1");
        defaultcategorydataset.addValue(63.200000000000003D, "S2", "C2");
        defaultcategorydataset.addValue(71.400000000000006D, "S2", "C3");
        defaultcategorydataset.addValue(55D, "S2", "C4");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createLineChart3D("Line Chart 3D Demo 1", null, "Class Count", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(new Color(187, 187, 221));
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LineChart3DDemo1 linechart3ddemo1 = new LineChart3DDemo1("JFreeChart - Line Chart 3D Demo 1");
        linechart3ddemo1.pack();
        RefineryUtilities.centerFrameOnScreen(linechart3ddemo1);
        linechart3ddemo1.setVisible(true);
    }
}
