



package demo;

import java.awt.Dimension;
import java.awt.RenderingHints;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FastScatterPlotDemo extends ApplicationFrame
{

    public FastScatterPlotDemo(String s)
    {
        super(s);
        data = new float[2][0x7a120];
        populateData();
        NumberAxis numberaxis = new NumberAxis("X");
        numberaxis.setAutoRangeIncludesZero(false);
        NumberAxis numberaxis1 = new NumberAxis("Y");
        numberaxis1.setAutoRangeIncludesZero(false);
        FastScatterPlot fastscatterplot = new FastScatterPlot(data, numberaxis, numberaxis1);
        JFreeChart jfreechart = new JFreeChart("Fast Scatter Plot", fastscatterplot);
        jfreechart.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ChartPanel chartpanel = new ChartPanel(jfreechart, true);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setDomainZoomable(true);
        chartpanel.setRangeZoomable(true);
        chartpanel.setMinimumDrawHeight(10);
        chartpanel.setMaximumDrawHeight(2000);
        chartpanel.setMinimumDrawWidth(20);
        chartpanel.setMaximumDrawWidth(2000);
        setContentPane(chartpanel);
    }

    private void populateData()
    {
        for(int i = 0; i < data[0].length; i++)
        {
            float f = (float)i + 100000F;
            data[0][i] = f;
            data[1][i] = 100000F + (float)Math.random() * 500000F;
        }

    }

    public static void main(String args[])
    {
        FastScatterPlotDemo fastscatterplotdemo = new FastScatterPlotDemo("Fast Scatter Plot Demo");
        fastscatterplotdemo.pack();
        RefineryUtilities.centerFrameOnScreen(fastscatterplotdemo);
        fastscatterplotdemo.setVisible(true);
    }

    private static final int COUNT = 0x7a120;
    private float data[][];
}
