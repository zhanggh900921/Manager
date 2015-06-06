



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo2 extends ApplicationFrame
{

    public BarChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        double ad[][] = {
            {
                1.0D, 43D, 35D, 58D, 54D, 77D, 71D, 89D
            }, {
                54D, 75D, 63D, 83D, 43D, 46D, 27D, 13D
            }, {
                41D, 33D, 22D, 34D, 62D, 32D, 42D, 34D
            }
        };
        return DatasetUtilities.createCategoryDataset("Series ", "Factor ", ad);
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart Demo 2", "Category", "Score (%)", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setRange(0.0D, 100D);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        barrenderer.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo2 barchartdemo2 = new BarChartDemo2("Bar Chart Demo 2");
        barchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo2);
        barchartdemo2.setVisible(true);
    }
}
