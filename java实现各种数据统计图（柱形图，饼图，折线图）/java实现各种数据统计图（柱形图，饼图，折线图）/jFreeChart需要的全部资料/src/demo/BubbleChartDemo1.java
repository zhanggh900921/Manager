



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BubbleChartDemo1 extends ApplicationFrame
{

    public BubbleChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYZDataset xyzdataset)
    {
        JFreeChart jfreechart = ChartFactory.createBubbleChart("Bubble Chart Demo 1", "X", "Y", xyzdataset, PlotOrientation.HORIZONTAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setForegroundAlpha(0.65F);
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesPaint(0, Color.blue);
        NumberAxis numberaxis = (NumberAxis)xyplot.getDomainAxis();
        numberaxis.setLowerMargin(0.14999999999999999D);
        numberaxis.setUpperMargin(0.14999999999999999D);
        NumberAxis numberaxis1 = (NumberAxis)xyplot.getRangeAxis();
        numberaxis1.setLowerMargin(0.14999999999999999D);
        numberaxis1.setUpperMargin(0.14999999999999999D);
        return jfreechart;
    }

    public static XYZDataset createDataset()
    {
        DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();
        double ad[] = {
            2.1000000000000001D, 2.2999999999999998D, 2.2999999999999998D, 2.2000000000000002D, 2.2000000000000002D, 1.8D, 1.8D, 1.8999999999999999D, 2.2999999999999998D, 3.7999999999999998D
        };
        double ad1[] = {
            14.1D, 11.1D, 10D, 8.8000000000000007D, 8.6999999999999993D, 8.4000000000000004D, 5.4000000000000004D, 4.0999999999999996D, 4.0999999999999996D, 25D
        };
        double ad2[] = {
            2.3999999999999999D, 2.7000000000000002D, 2.7000000000000002D, 2.2000000000000002D, 2.2000000000000002D, 2.2000000000000002D, 2.1000000000000001D, 2.2000000000000002D, 1.6000000000000001D, 4D
        };
        double ad3[][] = {
            ad, ad1, ad2
        };
        defaultxyzdataset.addSeries("Series 1", ad3);
        return defaultxyzdataset;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setDomainZoomable(true);
        chartpanel.setRangeZoomable(true);
        return chartpanel;
    }

    public static void main(String args[])
    {
        BubbleChartDemo1 bubblechartdemo1 = new BubbleChartDemo1("Bubble Chart Demo 1");
        bubblechartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(bubblechartdemo1);
        bubblechartdemo1.setVisible(true);
    }
}
