



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo4 extends ApplicationFrame
{

    public BarChartDemo4(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "First", "Category 1");
        defaultcategorydataset.addValue(5D, "Second", "Category 1");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart Demo", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(new Color(0xbbbbdd));
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        barrenderer.setMaximumBarWidth(0.10000000000000001D);
        barrenderer.setLegendItemLabelGenerator(new StandardCategorySeriesLabelGenerator("{0} series"));
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.lightGray);
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, Color.lightGray);
        barrenderer.setSeriesPaint(0, gradientpaint);
        barrenderer.setSeriesPaint(1, gradientpaint1);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo4 barchartdemo4 = new BarChartDemo4("Bar Chart Demo 4");
        barchartdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo4);
        barchartdemo4.setVisible(true);
    }
}
