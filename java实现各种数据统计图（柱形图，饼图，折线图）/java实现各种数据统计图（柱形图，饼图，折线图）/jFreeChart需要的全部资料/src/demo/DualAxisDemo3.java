



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class DualAxisDemo3 extends ApplicationFrame
{

    public DualAxisDemo3(String s)
    {
        super(s);
        JFreeChart jfreechart = createChart();
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart()
    {
        CategoryDataset categorydataset = createDataset1();
        JFreeChart jfreechart = ChartFactory.createBarChart("Dual Axis Chart", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(new Color(204, 255, 204));
        LegendTitle legendtitle = (LegendTitle)jfreechart.getSubtitle(0);
        legendtitle.setPosition(RectangleEdge.LEFT);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10F);
        CategoryDataset categorydataset1 = createDataset2();
        NumberAxis numberaxis = new NumberAxis("Secondary");
        categoryplot.setRangeAxis(1, numberaxis);
        categoryplot.setDataset(1, categorydataset1);
        categoryplot.mapDatasetToRangeAxis(1, 1);
        categoryplot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        categoryplot.setRenderer(1, lineandshaperenderer);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        return jfreechart;
    }

    private static CategoryDataset createDataset1()
    {
        String s = "First";
        String s1 = "Second";
        String s2 = "Third";
        String s3 = "Category 1";
        String s4 = "Category 2";
        String s5 = "Category 3";
        String s6 = "Category 4";
        String s7 = "Category 5";
        String s8 = "Category 6";
        String s9 = "Category 7";
        String s10 = "Category 8";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, s, s3);
        defaultcategorydataset.addValue(4D, s, s4);
        defaultcategorydataset.addValue(3D, s, s5);
        defaultcategorydataset.addValue(5D, s, s6);
        defaultcategorydataset.addValue(5D, s, s7);
        defaultcategorydataset.addValue(7D, s, s8);
        defaultcategorydataset.addValue(7D, s, s9);
        defaultcategorydataset.addValue(8D, s, s10);
        defaultcategorydataset.addValue(5D, s1, s3);
        defaultcategorydataset.addValue(7D, s1, s4);
        defaultcategorydataset.addValue(6D, s1, s5);
        defaultcategorydataset.addValue(8D, s1, s6);
        defaultcategorydataset.addValue(4D, s1, s7);
        defaultcategorydataset.addValue(4D, s1, s8);
        defaultcategorydataset.addValue(2D, s1, s9);
        defaultcategorydataset.addValue(1.0D, s1, s10);
        defaultcategorydataset.addValue(4D, s2, s3);
        defaultcategorydataset.addValue(3D, s2, s4);
        defaultcategorydataset.addValue(2D, s2, s5);
        defaultcategorydataset.addValue(3D, s2, s6);
        defaultcategorydataset.addValue(6D, s2, s7);
        defaultcategorydataset.addValue(3D, s2, s8);
        defaultcategorydataset.addValue(4D, s2, s9);
        defaultcategorydataset.addValue(3D, s2, s10);
        return defaultcategorydataset;
    }

    private static CategoryDataset createDataset2()
    {
        String s = "Fourth";
        String s1 = "Category 1";
        String s2 = "Category 2";
        String s3 = "Category 3";
        String s4 = "Category 4";
        String s5 = "Category 5";
        String s6 = "Category 6";
        String s7 = "Category 7";
        String s8 = "Category 8";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(15D, s, s1);
        defaultcategorydataset.addValue(24D, s, s2);
        defaultcategorydataset.addValue(31D, s, s3);
        defaultcategorydataset.addValue(25D, s, s4);
        defaultcategorydataset.addValue(56D, s, s5);
        defaultcategorydataset.addValue(37D, s, s6);
        defaultcategorydataset.addValue(77D, s, s7);
        defaultcategorydataset.addValue(18D, s, s8);
        return defaultcategorydataset;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        DualAxisDemo3 dualaxisdemo3 = new DualAxisDemo3("Dual Axis Demo 3");
        dualaxisdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(dualaxisdemo3);
        dualaxisdemo3.setVisible(true);
    }
}
