



package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class StackedBarChart3DDemo4 extends ApplicationFrame
{

    public StackedBarChart3DDemo4(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(10D, "Series 1", "C1");
        defaultcategorydataset.addValue(5D, "Series 1", "C2");
        defaultcategorydataset.addValue(6D, "Series 1", "C3");
        defaultcategorydataset.addValue(7D, "Series 1", "C4");
        defaultcategorydataset.addValue(8D, "Series 1", "C5");
        defaultcategorydataset.addValue(9D, "Series 1", "C6");
        defaultcategorydataset.addValue(10D, "Series 1", "C7");
        defaultcategorydataset.addValue(11D, "Series 1", "C8");
        defaultcategorydataset.addValue(3D, "Series 1", "C9");
        defaultcategorydataset.addValue(4D, "Series 2", "C1");
        defaultcategorydataset.addValue(7D, "Series 2", "C2");
        defaultcategorydataset.addValue(17D, "Series 2", "C3");
        defaultcategorydataset.addValue(15D, "Series 2", "C4");
        defaultcategorydataset.addValue(6D, "Series 2", "C5");
        defaultcategorydataset.addValue(8D, "Series 2", "C6");
        defaultcategorydataset.addValue(9D, "Series 2", "C7");
        defaultcategorydataset.addValue(13D, "Series 2", "C8");
        defaultcategorydataset.addValue(7D, "Series 2", "C9");
        defaultcategorydataset.addValue(15D, "Series 3", "C1");
        defaultcategorydataset.addValue(14D, "Series 3", "C2");
        defaultcategorydataset.addValue(12D, "Series 3", "C3");
        defaultcategorydataset.addValue(11D, "Series 3", "C4");
        defaultcategorydataset.addValue(10D, "Series 3", "C5");
        defaultcategorydataset.addValue(0.0D, "Series 3", "C6");
        defaultcategorydataset.addValue(7D, "Series 3", "C7");
        defaultcategorydataset.addValue(9D, "Series 3", "C8");
        defaultcategorydataset.addValue(11D, "Series 3", "C9");
        defaultcategorydataset.addValue(14D, "Series 4", "C1");
        defaultcategorydataset.addValue(3D, "Series 4", "C2");
        defaultcategorydataset.addValue(7D, "Series 4", "C3");
        defaultcategorydataset.addValue(0.0D, "Series 4", "C4");
        defaultcategorydataset.addValue(9D, "Series 4", "C5");
        defaultcategorydataset.addValue(6D, "Series 4", "C6");
        defaultcategorydataset.addValue(7D, "Series 4", "C7");
        defaultcategorydataset.addValue(9D, "Series 4", "C8");
        defaultcategorydataset.addValue(10D, "Series 4", "C9");
        return defaultcategorydataset;
    }

    private JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart3D("Stacked Bar Chart 3D Demo 4", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        StackedBarRenderer3D stackedbarrenderer3d = (StackedBarRenderer3D)categoryplot.getRenderer();
        stackedbarrenderer3d.setRenderAsPercentages(true);
        stackedbarrenderer3d.setDrawBarOutline(false);
        stackedbarrenderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{3}", NumberFormat.getIntegerInstance(), new DecimalFormat("0.0%")));
        stackedbarrenderer3d.setBaseItemLabelsVisible(true);
        stackedbarrenderer3d.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        stackedbarrenderer3d.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        return jfreechart;
    }

    public static void main(String args[])
    {
        StackedBarChart3DDemo4 stackedbarchart3ddemo4 = new StackedBarChart3DDemo4("Stacked Bar Chart 3D Demo 4");
        stackedbarchart3ddemo4.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchart3ddemo4);
        stackedbarchart3ddemo4.setVisible(true);
    }
}
