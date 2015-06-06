



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.*;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;

public class BarChart3DDemo2 extends ApplicationFrame
{

    public BarChart3DDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(23D, "Series 1", "London");
        defaultcategorydataset.addValue(14D, "Series 1", "New York");
        defaultcategorydataset.addValue(14D, "Series 1", "Istanbul");
        defaultcategorydataset.addValue(14D, "Series 1", "Cairo");
        defaultcategorydataset.addValue(13D, "Series 2", "London");
        defaultcategorydataset.addValue(19D, "Series 2", "New York");
        defaultcategorydataset.addValue(19D, "Series 2", "Istanbul");
        defaultcategorydataset.addValue(19D, "Series 2", "Cairo");
        defaultcategorydataset.addValue(7D, "Series 3", "London");
        defaultcategorydataset.addValue(9D, "Series 3", "New York");
        defaultcategorydataset.addValue(9D, "Series 3", "Istanbul");
        defaultcategorydataset.addValue(9D, "Series 3", "Cairo");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart3D("3D Bar Chart Demo 2", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setForegroundAlpha(1.0F);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        CategoryLabelPositions categorylabelpositions = categoryaxis.getCategoryLabelPositions();
        CategoryLabelPosition categorylabelposition = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0D, CategoryLabelWidthType.RANGE, 0.3F);
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(categorylabelpositions, categorylabelposition));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        Log.getInstance().addTarget(new PrintStreamLogTarget());
        BarChart3DDemo2 barchart3ddemo2 = new BarChart3DDemo2("3D Bar Chart Demo 2");
        barchart3ddemo2.pack();
        RefineryUtilities.centerFrameOnScreen(barchart3ddemo2);
        barchart3ddemo2.setVisible(true);
    }
}
