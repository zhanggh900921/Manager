



package demo;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.io.PrintStream;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo4 extends ApplicationFrame
    implements ChartMouseListener
{

    public MouseListenerDemo4(String s)
    {
        super(s);
        String s1 = "Mouse Listener Demo 4";
        XYDataset xydataset = createDataset();
        chart = ChartFactory.createXYLineChart(s1, "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        chartPanel.addChartMouseListener(this);
        setContentPane(chartPanel);
    }

    public XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(12.5D, 11D);
        xyseries.add(15D, 9.3000000000000007D);
        xyseries.add(20D, 21D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        return xyseriescollection;
    }

    public void chartMouseClicked(ChartMouseEvent chartmouseevent)
    {
        int i = chartmouseevent.getTrigger().getX();
        int j = chartmouseevent.getTrigger().getY();
        System.out.println("x = " + i + ", y = " + j);
        Point2D point2d = chartPanel.translateScreenToJava2D(new Point(i, j));
        XYPlot xyplot = (XYPlot)chart.getPlot();
        ChartRenderingInfo chartrenderinginfo = chartPanel.getChartRenderingInfo();
        java.awt.geom.Rectangle2D rectangle2d = chartrenderinginfo.getPlotInfo().getDataArea();
        ValueAxis valueaxis = xyplot.getDomainAxis();
        org.jfree.ui.RectangleEdge rectangleedge = xyplot.getDomainAxisEdge();
        ValueAxis valueaxis1 = xyplot.getRangeAxis();
        org.jfree.ui.RectangleEdge rectangleedge1 = xyplot.getRangeAxisEdge();
        double d = valueaxis.java2DToValue(point2d.getX(), rectangle2d, rectangleedge);
        double d1 = valueaxis1.java2DToValue(point2d.getY(), rectangle2d, rectangleedge1);
        System.out.println("Chart: x = " + d + ", y = " + d1);
    }

    public void chartMouseMoved(ChartMouseEvent chartmouseevent)
    {
    }

    public static void main(String args[])
    {
        MouseListenerDemo4 mouselistenerdemo4 = new MouseListenerDemo4("Mouse Listener Demo 4");
        mouselistenerdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(mouselistenerdemo4);
        mouselistenerdemo4.setVisible(true);
    }

    private JFreeChart chart;
    private ChartPanel chartPanel;
}
