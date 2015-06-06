



package demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.ui.RectangleInsets;

public class MemoryUsageDemo extends JPanel
{
    class DataGenerator extends Timer
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            long l = Runtime.getRuntime().freeMemory();
            long l1 = Runtime.getRuntime().totalMemory();
            addTotalObservation(l1);
            addFreeObservation(l);
        }

        DataGenerator(int i)
        {
            super(i, null);
            addActionListener(this);
        }
    }


    public MemoryUsageDemo(int i)
    {
        super(new BorderLayout());
        total = new TimeSeries("Total Memory", org.jfree.data.time.Millisecond.class);
        total.setMaximumItemAge(i);
        free = new TimeSeries("Free Memory", org.jfree.data.time.Millisecond.class);
        free.setMaximumItemAge(i);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(total);
        timeseriescollection.addSeries(free);
        DateAxis dateaxis = new DateAxis("Time");
        NumberAxis numberaxis = new NumberAxis("Memory");
        dateaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
        numberaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
        dateaxis.setLabelFont(new Font("SansSerif", 0, 14));
        numberaxis.setLabelFont(new Font("SansSerif", 0, 14));
        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);
        xylineandshaperenderer.setSeriesPaint(0, Color.red);
        xylineandshaperenderer.setSeriesPaint(1, Color.green);
        xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F, 0, 2));
        xylineandshaperenderer.setSeriesStroke(1, new BasicStroke(3F, 0, 2));
        XYPlot xyplot = new XYPlot(timeseriescollection, dateaxis, numberaxis, xylineandshaperenderer);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        dateaxis.setAutoRange(true);
        dateaxis.setLowerMargin(0.0D);
        dateaxis.setUpperMargin(0.0D);
        dateaxis.setTickLabelsVisible(true);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        JFreeChart jfreechart = new JFreeChart("JVM Memory Usage", new Font("SansSerif", 1, 24), xyplot, true);
        jfreechart.setBackgroundPaint(Color.white);
        ChartPanel chartpanel = new ChartPanel(jfreechart, true);
        chartpanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        add(chartpanel);
    }

    private void addTotalObservation(double d)
    {
        total.add(new Millisecond(), d);
    }

    private void addFreeObservation(double d)
    {
        free.add(new Millisecond(), d);
    }

    public static void main(String args[])
    {
        JFrame jframe = new JFrame("Memory Usage Demo");
        MemoryUsageDemo memoryusagedemo = new MemoryUsageDemo(30000);
        jframe.getContentPane().add(memoryusagedemo, "Center");
        jframe.setBounds(200, 120, 600, 280);
        jframe.setVisible(true);
        (memoryusagedemo. new DataGenerator(100)).start();
        jframe.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                System.exit(0);
            }

        }
);
    }

    private TimeSeries total;
    private TimeSeries free;


}
