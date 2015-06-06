



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo6 extends ApplicationFrame
{

    public StackedBarChartDemo6(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        long l = 0x5265c00L;
        defaultcategorydataset.addValue(3L * l, "Series 1", "Category 1");
        defaultcategorydataset.addValue(1L * l, "Series 2", "Category 1");
        defaultcategorydataset.addValue(2L * l, "Series 3", "Category 1");
        defaultcategorydataset.addValue(4L * l, "Series 1", "Category 2");
        defaultcategorydataset.addValue(5L * l, "Series 2", "Category 2");
        defaultcategorydataset.addValue(1L * l, "Series 3", "Category 2");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 6", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)categoryplot.getRenderer();
        stackedbarrenderer.setDrawBarOutline(false);
        long l = System.currentTimeMillis();
        stackedbarrenderer.setBase(l);
        DateAxis dateaxis = new DateAxis("Date");
        dateaxis.setLowerMargin(0.0D);
        categoryplot.setRangeAxis(dateaxis);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedBarChartDemo6 stackedbarchartdemo6 = new StackedBarChartDemo6("Stacked Bar Chart Demo 6");
        stackedbarchartdemo6.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo6);
        stackedbarchartdemo6.setVisible(true);
    }
}
