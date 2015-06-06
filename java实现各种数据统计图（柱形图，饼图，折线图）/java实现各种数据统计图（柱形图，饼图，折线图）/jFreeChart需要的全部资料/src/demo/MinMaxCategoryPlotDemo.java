



package demo;

import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MinMaxCategoryPlotDemo extends ApplicationFrame
{

    public MinMaxCategoryPlotDemo(String s)
    {
        super(s);
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "First", "C1");
        defaultcategorydataset.addValue(4D, "First", "C2");
        defaultcategorydataset.addValue(3D, "First", "C3");
        defaultcategorydataset.addValue(5D, "First", "C4");
        defaultcategorydataset.addValue(5D, "First", "C5");
        defaultcategorydataset.addValue(7D, "First", "C6");
        defaultcategorydataset.addValue(7D, "First", "C7");
        defaultcategorydataset.addValue(8D, "First", "C8");
        defaultcategorydataset.addValue(5D, "Second", "C1");
        defaultcategorydataset.addValue(7D, "Second", "C2");
        defaultcategorydataset.addValue(6D, "Second", "C3");
        defaultcategorydataset.addValue(8D, "Second", "C4");
        defaultcategorydataset.addValue(4D, "Second", "C5");
        defaultcategorydataset.addValue(4D, "Second", "C6");
        defaultcategorydataset.addValue(2D, "Second", "C7");
        defaultcategorydataset.addValue(1.0D, "Second", "C8");
        defaultcategorydataset.addValue(4D, "Third", "C1");
        defaultcategorydataset.addValue(3D, "Third", "C2");
        defaultcategorydataset.addValue(2D, "Third", "C3");
        defaultcategorydataset.addValue(3D, "Third", "C4");
        defaultcategorydataset.addValue(6D, "Third", "C5");
        defaultcategorydataset.addValue(3D, "Third", "C6");
        defaultcategorydataset.addValue(4D, "Third", "C7");
        defaultcategorydataset.addValue(3D, "Third", "C8");
        JFreeChart jfreechart = ChartFactory.createBarChart("Min/Max Category Plot", "Category", "Value", defaultcategorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        MinMaxCategoryRenderer minmaxcategoryrenderer = new MinMaxCategoryRenderer();
        categoryplot.setRenderer(minmaxcategoryrenderer);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public static void main(String args[])
    {
        MinMaxCategoryPlotDemo minmaxcategoryplotdemo = new MinMaxCategoryPlotDemo("Min/Max Category Chart Demo");
        minmaxcategoryplotdemo.pack();
        RefineryUtilities.centerFrameOnScreen(minmaxcategoryplotdemo);
        minmaxcategoryplotdemo.setVisible(true);
    }
}
