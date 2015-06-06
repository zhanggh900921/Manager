



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class IntervalBarChartDemo1 extends ApplicationFrame
{

    public IntervalBarChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static IntervalCategoryDataset createDataset()
    {
        double ad[] = {
            0.10000000000000001D, 0.20000000000000001D, 0.29999999999999999D
        };
        double ad1[] = {
            0.29999999999999999D, 0.40000000000000002D, 0.5D
        };
        double ad2[] = {
            0.5D, 0.59999999999999998D, 0.69999999999999996D
        };
        double ad3[] = {
            0.69999999999999996D, 0.80000000000000004D, 0.90000000000000002D
        };
        double ad4[][] = {
            ad, ad1
        };
        double ad5[][] = {
            ad2, ad3
        };
        DefaultIntervalCategoryDataset defaultintervalcategorydataset = new DefaultIntervalCategoryDataset(ad4, ad5);
        return defaultintervalcategorydataset;
    }

    private static JFreeChart createChart(IntervalCategoryDataset intervalcategorydataset)
    {
        CategoryAxis categoryaxis = new CategoryAxis("Category");
        NumberAxis numberaxis = new NumberAxis("Percentage");
        numberaxis.setNumberFormatOverride(new DecimalFormat("0.00%"));
        IntervalBarRenderer intervalbarrenderer = new IntervalBarRenderer();
        CategoryPlot categoryplot = new CategoryPlot(intervalcategorydataset, categoryaxis, numberaxis, intervalbarrenderer);
        JFreeChart jfreechart = new JFreeChart(categoryplot);
        jfreechart.setBackgroundPaint(Color.white);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        IntervalBarChartDemo1 intervalbarchartdemo1 = new IntervalBarChartDemo1("Interval Bar Chart Demo 1");
        intervalbarchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(intervalbarchartdemo1);
        intervalbarchartdemo1.setVisible(true);
    }
}
