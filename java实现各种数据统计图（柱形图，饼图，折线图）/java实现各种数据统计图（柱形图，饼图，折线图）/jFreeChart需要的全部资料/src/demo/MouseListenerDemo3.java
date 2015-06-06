



package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo3 extends ApplicationFrame
    implements ChartMouseListener
{

    public MouseListenerDemo3(String s)
    {
        super(s);
        String s1 = "Legal & General Unit Trust Prices";
        XYDataset xydataset = createDataset();
        chart = ChartFactory.createTimeSeriesChart(s1, "Date", "Price Per Unit", xydataset, true, true, false);
        chart.addSubtitle(new TextTitle("Click on the legend to see series highlighted..."));
        XYPlot xyplot = (XYPlot)chart.getPlot();
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        chartpanel.addChartMouseListener(this);
        setContentPane(chartpanel);
    }

    public XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("L&G European Index Trust", org.jfree.data.time.Month.class);
        timeseries.add(new Month(2, 2001), 181.80000000000001D);
        timeseries.add(new Month(3, 2001), 167.30000000000001D);
        timeseries.add(new Month(4, 2001), 153.80000000000001D);
        timeseries.add(new Month(5, 2001), 167.59999999999999D);
        timeseries.add(new Month(6, 2001), 158.80000000000001D);
        timeseries.add(new Month(7, 2001), 148.30000000000001D);
        timeseries.add(new Month(8, 2001), 153.90000000000001D);
        timeseries.add(new Month(9, 2001), 142.69999999999999D);
        timeseries.add(new Month(10, 2001), 123.2D);
        timeseries.add(new Month(11, 2001), 131.80000000000001D);
        timeseries.add(new Month(12, 2001), 139.59999999999999D);
        timeseries.add(new Month(1, 2002), 142.90000000000001D);
        timeseries.add(new Month(2, 2002), 138.69999999999999D);
        timeseries.add(new Month(3, 2002), 137.30000000000001D);
        timeseries.add(new Month(4, 2002), 143.90000000000001D);
        timeseries.add(new Month(5, 2002), 139.80000000000001D);
        timeseries.add(new Month(6, 2002), 137D);
        timeseries.add(new Month(7, 2002), 132.80000000000001D);
        TimeSeries timeseries1 = new TimeSeries("L&G UK Index Trust", org.jfree.data.time.Month.class);
        timeseries1.add(new Month(2, 2001), 129.59999999999999D);
        timeseries1.add(new Month(3, 2001), 123.2D);
        timeseries1.add(new Month(4, 2001), 117.2D);
        timeseries1.add(new Month(5, 2001), 124.09999999999999D);
        timeseries1.add(new Month(6, 2001), 122.59999999999999D);
        timeseries1.add(new Month(7, 2001), 119.2D);
        timeseries1.add(new Month(8, 2001), 116.5D);
        timeseries1.add(new Month(9, 2001), 112.7D);
        timeseries1.add(new Month(10, 2001), 101.5D);
        timeseries1.add(new Month(11, 2001), 106.09999999999999D);
        timeseries1.add(new Month(12, 2001), 110.3D);
        timeseries1.add(new Month(1, 2002), 111.7D);
        timeseries1.add(new Month(2, 2002), 111D);
        timeseries1.add(new Month(3, 2002), 109.59999999999999D);
        timeseries1.add(new Month(4, 2002), 113.2D);
        timeseries1.add(new Month(5, 2002), 111.59999999999999D);
        timeseries1.add(new Month(6, 2002), 108.8D);
        timeseries1.add(new Month(7, 2002), 101.59999999999999D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        timeseriescollection.addSeries(timeseries1);
        timeseriescollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeseriescollection;
    }

    public void chartMouseClicked(ChartMouseEvent chartmouseevent)
    {
        org.jfree.chart.entity.ChartEntity chartentity = chartmouseevent.getEntity();
        if(chartentity != null && (chartentity instanceof LegendItemEntity))
        {
            LegendItemEntity legenditementity = (LegendItemEntity)chartentity;
            Comparable comparable = legenditementity.getSeriesKey();
            XYPlot xyplot = (XYPlot)chart.getPlot();
            XYDataset xydataset = xyplot.getDataset();
            XYItemRenderer xyitemrenderer = xyplot.getRenderer();
            for(int i = 0; i < xydataset.getSeriesCount(); i++)
            {
                xyitemrenderer.setSeriesStroke(i, new BasicStroke(1.0F));
                if(xydataset.getSeriesKey(i).equals(comparable))
                    xyitemrenderer.setSeriesStroke(i, new BasicStroke(2.0F));
            }

        }
    }

    public void chartMouseMoved(ChartMouseEvent chartmouseevent)
    {
    }

    public static void main(String args[])
    {
        MouseListenerDemo3 mouselistenerdemo3 = new MouseListenerDemo3("Mouse Listener Demo 3");
        mouselistenerdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(mouselistenerdemo3);
        mouselistenerdemo3.setVisible(true);
    }

    private JFreeChart chart;
}
