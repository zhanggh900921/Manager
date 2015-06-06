



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo8 extends ApplicationFrame
{

    public BarChartDemo8(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
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
        JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart Demo 8", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setUpperMargin(0.14999999999999999D);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        categoryitemrenderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo8 barchartdemo8 = new BarChartDemo8("Bar Chart Demo 8");
        barchartdemo8.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo8);
        barchartdemo8.setVisible(true);
    }
}
