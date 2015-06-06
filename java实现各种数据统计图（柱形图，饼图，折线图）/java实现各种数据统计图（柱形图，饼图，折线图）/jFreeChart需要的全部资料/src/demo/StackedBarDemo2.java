



package demo;

import java.awt.Dimension;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarDemo2 extends ApplicationFrame
{

    public StackedBarDemo2(String s)
    {
        super(s);
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "Row 1", "Column 1");
        defaultcategorydataset.addValue(5D, "Row 1", "Column 2");
        defaultcategorydataset.addValue(3D, "Row 1", "Column 3");
        defaultcategorydataset.addValue(2D, "Row 2", "Column 1");
        defaultcategorydataset.addValue(3D, "Row 2", "Column 2");
        defaultcategorydataset.addValue(2D, "Row 2", "Column 3");
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("StackedBarDemo2", "Category", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)categoryplot.getRenderer();
        stackedbarrenderer.setRenderAsPercentages(true);
        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public static void main(String args[])
    {
        StackedBarDemo2 stackedbardemo2 = new StackedBarDemo2("StackedBarDemo2");
        stackedbardemo2.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbardemo2);
        stackedbardemo2.setVisible(true);
    }
}
