



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class LayeredBarChartDemo1 extends ApplicationFrame
{

    public LayeredBarChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        String s = "First";
        String s1 = "Second";
        String s2 = "Third";
        String s3 = "Category 1";
        String s4 = "Category 2";
        String s5 = "Category 3";
        String s6 = "Category 4";
        String s7 = "Category 5";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, s, s3);
        defaultcategorydataset.addValue(4D, s, s4);
        defaultcategorydataset.addValue(3D, s, s5);
        defaultcategorydataset.addValue(5D, s, s6);
        defaultcategorydataset.addValue(5D, s, s7);
        defaultcategorydataset.addValue(5D, s1, s3);
        defaultcategorydataset.addValue(7D, s1, s4);
        defaultcategorydataset.addValue(6D, s1, s5);
        defaultcategorydataset.addValue(8D, s1, s6);
        defaultcategorydataset.addValue(4D, s1, s7);
        defaultcategorydataset.addValue(4D, s2, s3);
        defaultcategorydataset.addValue(3D, s2, s4);
        defaultcategorydataset.addValue(2D, s2, s5);
        defaultcategorydataset.addValue(3D, s2, s6);
        defaultcategorydataset.addValue(6D, s2, s7);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Layered Bar Chart Demo 1", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LayeredBarRenderer layeredbarrenderer = new LayeredBarRenderer();
        layeredbarrenderer.setDrawBarOutline(false);
        categoryplot.setRenderer(layeredbarrenderer);
        categoryplot.setRowRenderingOrder(SortOrder.DESCENDING);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
        layeredbarrenderer.setSeriesPaint(0, gradientpaint);
        layeredbarrenderer.setSeriesPaint(1, gradientpaint1);
        layeredbarrenderer.setSeriesPaint(2, gradientpaint2);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LayeredBarChartDemo1 layeredbarchartdemo1 = new LayeredBarChartDemo1("Layered Bar Chart Demo 1");
        layeredbarchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(layeredbarchartdemo1);
        layeredbarchartdemo1.setVisible(true);
    }
}
