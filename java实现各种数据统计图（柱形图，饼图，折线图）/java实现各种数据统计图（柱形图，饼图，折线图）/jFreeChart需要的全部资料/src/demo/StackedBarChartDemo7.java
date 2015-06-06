



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo7 extends ApplicationFrame
{

    public StackedBarChartDemo7(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(32.399999999999999D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(17.800000000000001D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(27.699999999999999D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(43.200000000000003D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(15.6D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(18.300000000000001D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(23D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(111.3D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(25.5D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(13D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(11.800000000000001D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(29.5D, "Series 3", "Category 4");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 7", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)categoryplot.getRenderer();
        stackedbarrenderer.setRenderAsPercentages(true);
        stackedbarrenderer.setDrawBarOutline(false);
        stackedbarrenderer.setBaseItemLabelsVisible(true);
        stackedbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedBarChartDemo7 stackedbarchartdemo7 = new StackedBarChartDemo7("Stacked Bar Chart Demo 7");
        stackedbarchartdemo7.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo7);
        stackedbarchartdemo7.setVisible(true);
    }
}
