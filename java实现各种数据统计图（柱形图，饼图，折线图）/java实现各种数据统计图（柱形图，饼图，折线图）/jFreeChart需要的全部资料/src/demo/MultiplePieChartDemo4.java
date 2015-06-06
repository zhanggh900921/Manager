



package demo;

import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo4 extends ApplicationFrame
{

    public MultiplePieChartDemo4(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart, true, true, true, false, true);
        chartpanel.setPreferredSize(new Dimension(600, 380));
        setContentPane(chartpanel);
    }

    private CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 0", "Column 0");
        defaultcategorydataset.addValue(3.2000000000000002D, "Row 0", "Column 1");
        defaultcategorydataset.addValue(1.8D, "Row 0", "Column 2");
        defaultcategorydataset.addValue(0.20000000000000001D, "Row 0", "Column 3");
        defaultcategorydataset.addValue(4.0999999999999996D, "Row 0", "Column 4");
        defaultcategorydataset.addValue(9.8000000000000007D, "Row 1", "Column 0");
        defaultcategorydataset.addValue(6.2999999999999998D, "Row 1", "Column 1");
        defaultcategorydataset.addValue(0.10000000000000001D, "Row 1", "Column 2");
        defaultcategorydataset.addValue(1.8999999999999999D, "Row 1", "Column 3");
        defaultcategorydataset.addValue(9.5999999999999996D, "Row 1", "Column 4");
        defaultcategorydataset.addValue(7D, "Row 2", "Column 0");
        defaultcategorydataset.addValue(5.2000000000000002D, "Row 2", "Column 1");
        defaultcategorydataset.addValue(2.7999999999999998D, "Row 2", "Column 2");
        defaultcategorydataset.addValue(8.8000000000000007D, "Row 2", "Column 3");
        defaultcategorydataset.addValue(7.2000000000000002D, "Row 2", "Column 4");
        defaultcategorydataset.addValue(9.5D, "Row 3", "Column 0");
        defaultcategorydataset.addValue(1.2D, "Row 3", "Column 1");
        defaultcategorydataset.addValue(4.5D, "Row 3", "Column 2");
        defaultcategorydataset.addValue(4.4000000000000004D, "Row 3", "Column 3");
        defaultcategorydataset.addValue(0.20000000000000001D, "Row 3", "Column 4");
        defaultcategorydataset.addValue(3.5D, "Row 4", "Column 0");
        defaultcategorydataset.addValue(6.7000000000000002D, "Row 4", "Column 1");
        defaultcategorydataset.addValue(9D, "Row 4", "Column 2");
        defaultcategorydataset.addValue(1.0D, "Row 4", "Column 3");
        defaultcategorydataset.addValue(5.2000000000000002D, "Row 4", "Column 4");
        defaultcategorydataset.addValue(5.0999999999999996D, "Row 5", "Column 0");
        defaultcategorydataset.addValue(6.7000000000000002D, "Row 5", "Column 1");
        defaultcategorydataset.addValue(0.90000000000000002D, "Row 5", "Column 2");
        defaultcategorydataset.addValue(3.2999999999999998D, "Row 5", "Column 3");
        defaultcategorydataset.addValue(3.8999999999999999D, "Row 5", "Column 4");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 6", "Column 0");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 6", "Column 1");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 6", "Column 2");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 6", "Column 3");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 6", "Column 4");
        defaultcategorydataset.addValue(7.5D, "Row 7", "Column 0");
        defaultcategorydataset.addValue(9D, "Row 7", "Column 1");
        defaultcategorydataset.addValue(3.3999999999999999D, "Row 7", "Column 2");
        defaultcategorydataset.addValue(4.0999999999999996D, "Row 7", "Column 3");
        defaultcategorydataset.addValue(0.5D, "Row 7", "Column 4");
        return defaultcategorydataset;
    }

    private JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createMultiplePieChart3D("Multiple Pie Chart Demo 4", categorydataset, TableOrder.BY_COLUMN, false, true, false);
        jfreechart.setBackgroundPaint(new Color(216, 255, 216));
        MultiplePiePlot multiplepieplot = (MultiplePiePlot)jfreechart.getPlot();
        JFreeChart jfreechart1 = multiplepieplot.getPieChart();
        multiplepieplot.setLimit(0.10000000000000001D);
        PiePlot pieplot = (PiePlot)jfreechart1.getPlot();
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        pieplot.setLabelFont(new Font("SansSerif", 0, 8));
        pieplot.setInteriorGap(0.29999999999999999D);
        return jfreechart;
    }

    public static void main(String args[])
    {
        MultiplePieChartDemo4 multiplepiechartdemo4 = new MultiplePieChartDemo4("Multiple Pie Chart Demo");
        multiplepiechartdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(multiplepiechartdemo4);
        multiplepiechartdemo4.setVisible(true);
    }
}
