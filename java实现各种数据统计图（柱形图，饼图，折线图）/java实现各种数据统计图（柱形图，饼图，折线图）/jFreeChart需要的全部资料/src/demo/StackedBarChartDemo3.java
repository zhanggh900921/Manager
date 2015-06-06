



package demo;

import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

// Referenced classes of package demo:
//            ExtendedStackedBarRenderer

public class StackedBarChartDemo3 extends ApplicationFrame
{

    public StackedBarChartDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(10D, "Series 1", "Jan");
        defaultcategorydataset.addValue(12D, "Series 1", "Feb");
        defaultcategorydataset.addValue(13D, "Series 1", "Mar");
        defaultcategorydataset.addValue(4D, "Series 2", "Jan");
        defaultcategorydataset.addValue(3D, "Series 2", "Feb");
        defaultcategorydataset.addValue(2D, "Series 2", "Mar");
        defaultcategorydataset.addValue(2D, "Series 3", "Jan");
        defaultcategorydataset.addValue(3D, "Series 3", "Feb");
        defaultcategorydataset.addValue(2D, "Series 3", "Mar");
        defaultcategorydataset.addValue(2D, "Series 4", "Jan");
        defaultcategorydataset.addValue(3D, "Series 4", "Feb");
        defaultcategorydataset.addValue(4D, "Series 4", "Mar");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 3", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, false, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        ExtendedStackedBarRenderer extendedstackedbarrenderer = new ExtendedStackedBarRenderer();
        extendedstackedbarrenderer.setBaseItemLabelsVisible(true);
        extendedstackedbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        extendedstackedbarrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        categoryplot.setRenderer(extendedstackedbarrenderer);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLowerMargin(0.14999999999999999D);
        numberaxis.setUpperMargin(0.14999999999999999D);
        numberaxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedBarChartDemo3 stackedbarchartdemo3 = new StackedBarChartDemo3("Stacked Bar Chart Demo 3");
        stackedbarchartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo3);
        stackedbarchartdemo3.setVisible(true);
    }
}
