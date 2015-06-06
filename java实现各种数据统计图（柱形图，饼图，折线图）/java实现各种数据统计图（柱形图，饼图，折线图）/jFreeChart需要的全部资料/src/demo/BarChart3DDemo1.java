



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart3DDemo1 extends ApplicationFrame
{

    public BarChart3DDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(10D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(4D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(15D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(14D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(-5D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(-7D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(14D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(-3D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(6D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(17D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(-12D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(7D, "Series 3", "Category 4");
        defaultcategorydataset.addValue(7D, "Series 4", "Category 1");
        defaultcategorydataset.addValue(15D, "Series 4", "Category 2");
        defaultcategorydataset.addValue(11D, "Series 4", "Category 3");
        defaultcategorydataset.addValue(0.0D, "Series 4", "Category 4");
        defaultcategorydataset.addValue(-8D, "Series 5", "Category 1");
        defaultcategorydataset.addValue(-6D, "Series 5", "Category 2");
        defaultcategorydataset.addValue(10D, "Series 5", "Category 3");
        defaultcategorydataset.addValue(-9D, "Series 5", "Category 4");
        defaultcategorydataset.addValue(9D, "Series 6", "Category 1");
        defaultcategorydataset.addValue(8D, "Series 6", "Category 2");
        defaultcategorydataset.addValue(0.0D, "Series 6", "Category 3");
        defaultcategorydataset.addValue(6D, "Series 6", "Category 4");
        defaultcategorydataset.addValue(-10D, "Series 7", "Category 1");
        defaultcategorydataset.addValue(9D, "Series 7", "Category 2");
        defaultcategorydataset.addValue(7D, "Series 7", "Category 3");
        defaultcategorydataset.addValue(7D, "Series 7", "Category 4");
        defaultcategorydataset.addValue(11D, "Series 8", "Category 1");
        defaultcategorydataset.addValue(13D, "Series 8", "Category 2");
        defaultcategorydataset.addValue(9D, "Series 8", "Category 3");
        defaultcategorydataset.addValue(9D, "Series 8", "Category 4");
        defaultcategorydataset.addValue(-3D, "Series 9", "Category 1");
        defaultcategorydataset.addValue(7D, "Series 9", "Category 2");
        defaultcategorydataset.addValue(11D, "Series 9", "Category 3");
        defaultcategorydataset.addValue(-10D, "Series 9", "Category 4");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart3D("3D Bar Chart Demo", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setDomainGridlinesVisible(true);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
        categoryaxis.setCategoryMargin(0.0D);
        BarRenderer3D barrenderer3d = (BarRenderer3D)categoryplot.getRenderer();
        barrenderer3d.setDrawBarOutline(false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChart3DDemo1 barchart3ddemo1 = new BarChart3DDemo1("3D Bar Chart Demo 1");
        barchart3ddemo1.pack();
        RefineryUtilities.centerFrameOnScreen(barchart3ddemo1);
        barchart3ddemo1.setVisible(true);
    }
}
