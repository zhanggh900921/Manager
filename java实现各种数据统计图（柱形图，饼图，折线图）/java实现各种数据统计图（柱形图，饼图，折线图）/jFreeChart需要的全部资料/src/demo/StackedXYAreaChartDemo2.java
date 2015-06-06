



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.data.xy.CategoryTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo2 extends ApplicationFrame
{

    public StackedXYAreaChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static TableXYDataset createDataset()
    {
        CategoryTableXYDataset categorytablexydataset = new CategoryTableXYDataset();
        categorytablexydataset.add(0.0D, 0.0D, "Series 1");
        categorytablexydataset.add(10D, 20D, "Series 1");
        categorytablexydataset.add(20D, 15D, "Series 1");
        categorytablexydataset.add(30D, 25D, "Series 1");
        categorytablexydataset.add(40D, 21D, "Series 1");
        categorytablexydataset.add(10D, 9D, "Series 2");
        categorytablexydataset.add(20D, -7D, "Series 2");
        categorytablexydataset.add(30D, 15D, "Series 2");
        categorytablexydataset.add(40D, 11D, "Series 2");
        categorytablexydataset.add(45D, -10D, "Series 2");
        categorytablexydataset.add(50D, 0.0D, "Series 2");
        return categorytablexydataset;
    }

    private static JFreeChart createChart(TableXYDataset tablexydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedXYAreaChart("Stacked XY Area Chart Demo 2", "X Value", "Y Value", tablexydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        StackedXYAreaRenderer2 stackedxyarearenderer2 = new StackedXYAreaRenderer2();
        stackedxyarearenderer2.setRoundXCoordinates(true);
        stackedxyarearenderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        xyplot.setRenderer(0, stackedxyarearenderer2);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedXYAreaChartDemo2 stackedxyareachartdemo2 = new StackedXYAreaChartDemo2("Stacked XY Area Chart Demo 2");
        stackedxyareachartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(stackedxyareachartdemo2);
        stackedxyareachartdemo2.setVisible(true);
    }
}
