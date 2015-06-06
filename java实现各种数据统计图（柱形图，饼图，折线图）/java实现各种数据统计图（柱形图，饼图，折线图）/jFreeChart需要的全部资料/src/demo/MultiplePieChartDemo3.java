



package demo;

import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo3 extends ApplicationFrame
{

    public MultiplePieChartDemo3(String s)
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
        defaultcategorydataset.addValue(4.2999999999999998D, "Row 0", "Column 1");
        defaultcategorydataset.addValue(6.7000000000000002D, "Row 0", "Column 2");
        defaultcategorydataset.addValue(4.4000000000000004D, "Row 0", "Column 3");
        defaultcategorydataset.addValue(6.0999999999999996D, "Row 0", "Column 4");
        defaultcategorydataset.addValue(5.7999999999999998D, "Row 1", "Column 0");
        defaultcategorydataset.addValue(3.2000000000000002D, "Row 1", "Column 1");
        defaultcategorydataset.addValue(4.5D, "Row 1", "Column 2");
        defaultcategorydataset.addValue(7D, "Row 1", "Column 3");
        defaultcategorydataset.addValue(5.7999999999999998D, "Row 1", "Column 4");
        defaultcategorydataset.addValue(5.2999999999999998D, "Row 2", "Column 0");
        defaultcategorydataset.addValue(6.7000000000000002D, "Row 2", "Column 1");
        defaultcategorydataset.addValue(7.0999999999999996D, "Row 2", "Column 2");
        defaultcategorydataset.addValue(4.2000000000000002D, "Row 2", "Column 3");
        defaultcategorydataset.addValue(9D, "Row 2", "Column 4");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 3", "Column 0");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 3", "Column 1");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 3", "Column 2");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 3", "Column 3");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 3", "Column 4");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 4", "Column 0");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 4", "Column 1");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 4", "Column 2");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 4", "Column 3");
        defaultcategorydataset.addValue(5.5999999999999996D, "Row 4", "Column 4");
        return defaultcategorydataset;
    }

    private JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createMultiplePieChart3D("Multiple Pie Chart Demo 3", categorydataset, TableOrder.BY_COLUMN, true, true, false);
        jfreechart.setBackgroundPaint(new Color(216, 255, 216));
        MultiplePiePlot multiplepieplot = (MultiplePiePlot)jfreechart.getPlot();
        PiePlot pieplot = (PiePlot)multiplepieplot.getPieChart().getPlot();
        pieplot.setMaximumLabelWidth(0.34999999999999998D);
        pieplot.setLabelFont(new Font("SansSerif", 0, 9));
        pieplot.setInteriorGap(0.29999999999999999D);
        pieplot.setSectionPaint("Row 1", Color.cyan);
        return jfreechart;
    }

    public static void main(String args[])
    {
        MultiplePieChartDemo3 multiplepiechartdemo3 = new MultiplePieChartDemo3("Multiple Pie Chart Demo 3");
        multiplepiechartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(multiplepiechartdemo3);
        multiplepiechartdemo3.setVisible(true);
    }
}
