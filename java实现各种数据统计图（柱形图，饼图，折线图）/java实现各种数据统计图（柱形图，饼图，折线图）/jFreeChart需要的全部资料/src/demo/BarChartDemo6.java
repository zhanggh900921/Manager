



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class BarChartDemo6 extends ApplicationFrame
{

    public BarChartDemo6(String s)
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
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(83D, "First", "Factor 1");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart(null, "Category", "Score (%)", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.yellow);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setInsets(new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D));
        categoryplot.setRangeGridlinesVisible(false);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setLowerMargin(0.20000000000000001D);
        categoryaxis.setUpperMargin(0.20000000000000001D);
        categoryaxis.setVisible(false);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setRange(0.0D, 100D);
        numberaxis.setVisible(false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo6 barchartdemo6 = new BarChartDemo6("Minimal Chart Demo");
        barchartdemo6.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo6);
        barchartdemo6.setVisible(true);
    }
}
