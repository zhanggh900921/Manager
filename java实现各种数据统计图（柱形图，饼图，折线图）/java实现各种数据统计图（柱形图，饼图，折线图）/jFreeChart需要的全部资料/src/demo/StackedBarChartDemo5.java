



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class StackedBarChartDemo5 extends ApplicationFrame
{

    public StackedBarChartDemo5(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(3396D, "S1", "C1");
        defaultcategorydataset.addValue(1580D, "S2", "C1");
        defaultcategorydataset.addValue(76D, "S3", "C1");
        defaultcategorydataset.addValue(10100D, "S4", "C1");
        defaultcategorydataset.addValue(3429D, "S1", "C2");
        defaultcategorydataset.addValue(1562D, "S2", "C2");
        defaultcategorydataset.addValue(61D, "S3", "C2");
        defaultcategorydataset.addValue(-10100D, "S4", "C2");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 5", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        GroupedStackedBarRenderer groupedstackedbarrenderer = new GroupedStackedBarRenderer();
        KeyToGroupMap keytogroupmap = new KeyToGroupMap("G1");
        keytogroupmap.mapKeyToGroup("S1", "G1");
        keytogroupmap.mapKeyToGroup("S2", "G1");
        keytogroupmap.mapKeyToGroup("S3", "G2");
        keytogroupmap.mapKeyToGroup("S4", "G3");
        groupedstackedbarrenderer.setSeriesToGroupMap(keytogroupmap);
        groupedstackedbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        groupedstackedbarrenderer.setBaseItemLabelsVisible(true);
        groupedstackedbarrenderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        groupedstackedbarrenderer.setItemMargin(0.10000000000000001D);
        SubCategoryAxis subcategoryaxis = new SubCategoryAxis("Category / Group");
        subcategoryaxis.setCategoryMargin(0.050000000000000003D);
        subcategoryaxis.addSubCategory("G1");
        subcategoryaxis.addSubCategory("G2");
        subcategoryaxis.addSubCategory("G3");
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setDomainAxis(subcategoryaxis);
        categoryplot.setRenderer(groupedstackedbarrenderer);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedBarChartDemo5 stackedbarchartdemo5 = new StackedBarChartDemo5("Stacked Bar Chart Demo 5");
        stackedbarchartdemo5.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo5);
        stackedbarchartdemo5.setVisible(true);
    }
}
