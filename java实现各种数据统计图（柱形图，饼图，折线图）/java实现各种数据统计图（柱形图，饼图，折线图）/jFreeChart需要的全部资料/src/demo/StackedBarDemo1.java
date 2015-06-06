



package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarDemo1 extends ApplicationFrame
{

    public StackedBarDemo1(String s)
    {
        super(s);
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "Row 1", "Column 1");
        defaultcategorydataset.addValue(5D, "Row 1", "Column 2");
        defaultcategorydataset.addValue(3D, "Row 1", "Column 3");
        defaultcategorydataset.addValue(2D, "Row 2", "Column 1");
        defaultcategorydataset.addValue(3D, "Row 2", "Column 2");
        defaultcategorydataset.addValue(2D, "Row 2", "Column 3");
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createStackedBarChart("StackedBarDemo1", "Category", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public static void main(String args[])
    {
        StackedBarDemo1 stackedbardemo1 = new StackedBarDemo1("StackedBarDemo1");
        stackedbardemo1.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbardemo1);
        stackedbardemo1.setVisible(true);
    }
}
