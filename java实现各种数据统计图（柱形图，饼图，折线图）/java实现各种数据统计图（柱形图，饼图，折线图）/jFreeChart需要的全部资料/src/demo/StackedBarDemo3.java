



package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarDemo3 extends ApplicationFrame
{

    public StackedBarDemo3(String s)
    {
        super(s);
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "Row 1", "Column 1");
        defaultcategorydataset.addValue(5D, "Row 1", "Column 2");
        defaultcategorydataset.addValue(3D, "Row 1", "Column 3");
        defaultcategorydataset.addValue(2D, "Row 2", "Column 1");
        defaultcategorydataset.addValue(3D, "Row 2", "Column 2");
        defaultcategorydataset.addValue(2D, "Row 2", "Column 3");
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("StackedBarDemo3", "Category", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)categoryplot.getRenderer();
        stackedbarrenderer.setRenderAsPercentages(true);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setLabel("Percentage");
        numberaxis.setNumberFormatOverride(new DecimalFormat("0.0%"));
        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public static void main(String args[])
    {
        StackedBarDemo3 stackedbardemo3 = new StackedBarDemo3("StackedBarDemo3");
        stackedbardemo3.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbardemo3);
        stackedbardemo3.setVisible(true);
    }
}
