



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class StackedBarChart3DDemo5 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
    {

        private CategoryDataset datasets[];
        private JFreeChart charts[];
        private ChartPanel panels[];

        public DemoPanel()
        {
            super(new GridLayout(2, 2));
            datasets = new CategoryDataset[StackedBarChart3DDemo5.CHART_COUNT];
            charts = new JFreeChart[StackedBarChart3DDemo5.CHART_COUNT];
            panels = new ChartPanel[StackedBarChart3DDemo5.CHART_COUNT];
            for(int i = 0; i < StackedBarChart3DDemo5.CHART_COUNT; i++)
            {
                datasets[i] = StackedBarChart3DDemo5.createDataset(i);
                charts[i] = StackedBarChart3DDemo5.createChart(i, datasets[i]);
                panels[i] = new ChartPanel(charts[i]);
            }

            CategoryPlot categoryplot = (CategoryPlot)charts[1].getPlot();
            CategoryPlot categoryplot1 = (CategoryPlot)charts[2].getPlot();
            CategoryPlot categoryplot2 = (CategoryPlot)charts[3].getPlot();
            categoryplot.getRangeAxis().setInverted(true);
            categoryplot2.getRangeAxis().setInverted(true);
            categoryplot1.setOrientation(PlotOrientation.HORIZONTAL);
            categoryplot2.setOrientation(PlotOrientation.HORIZONTAL);
            add(panels[0]);
            add(panels[1]);
            add(panels[2]);
            add(panels[3]);
            setPreferredSize(new Dimension(800, 600));
        }
    }


    public StackedBarChart3DDemo5(String s)
    {
        super(s);
        setContentPane(createDemoPanel());
    }

    private static CategoryDataset createDataset(int i)
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(2D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(1.5D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(1.5D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(-1D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(-1.8999999999999999D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(-1.5D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(-1.5D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(1.0D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(1.8999999999999999D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(1.5D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(1.5D, "Series 3", "Category 4");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(int i, CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart3D("Chart " + (i + 1), "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, false, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.getDomainAxis().setMaximumCategoryLabelLines(2);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        ValueAxis valueaxis = categoryplot.getRangeAxis();
        valueaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public static void main(String args[])
    {
        StackedBarChart3DDemo5 stackedbarchart3ddemo5 = new StackedBarChart3DDemo5("JFreeChart - Stacked Bar Chart 3D Demo 5");
        stackedbarchart3ddemo5.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchart3ddemo5);
        stackedbarchart3ddemo5.setVisible(true);
    }

    private static int CHART_COUNT = 4;




}
