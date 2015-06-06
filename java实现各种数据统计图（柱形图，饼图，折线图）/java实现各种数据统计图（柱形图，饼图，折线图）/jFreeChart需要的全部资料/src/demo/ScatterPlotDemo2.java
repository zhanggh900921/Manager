



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

// Referenced classes of package demo:
//            SampleXYDataset2

public class ScatterPlotDemo2 extends ApplicationFrame
{

    public ScatterPlotDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Scatter Plot Demo 2", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYDotRenderer xydotrenderer = new XYDotRenderer();
        xydotrenderer.setDotWidth(2);
        xydotrenderer.setDotHeight(2);
        xyplot.setRenderer(xydotrenderer);
        NumberAxis numberaxis = (NumberAxis)xyplot.getDomainAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(new SampleXYDataset2());
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setVerticalAxisTrace(true);
        chartpanel.setHorizontalAxisTrace(true);
        chartpanel.setPopupMenu(null);
        chartpanel.setDomainZoomable(true);
        chartpanel.setRangeZoomable(true);
        return chartpanel;
    }

    public static void main(String args[])
    {
        ScatterPlotDemo2 scatterplotdemo2 = new ScatterPlotDemo2("Scatter Plot Demo 2");
        scatterplotdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(scatterplotdemo2);
        scatterplotdemo2.setVisible(true);
    }
}
