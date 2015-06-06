



package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CloneTest1 extends ApplicationFrame
    implements ActionListener
{

    public CloneTest1(String s)
    {
        super(s);
        lastValue = 100D;
        series = new TimeSeries("Random Data", org.jfree.data.time.Millisecond.class);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(series);
        JFreeChart jfreechart = createChart(timeseriescollection);
        JFreeChart jfreechart1 = null;
        try
        {
            jfreechart1 = (JFreeChart)jfreechart.clone();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        XYPlot xyplot = (XYPlot)jfreechart1.getPlot();
        TimeSeriesCollection timeseriescollection1 = (TimeSeriesCollection)xyplot.getDataset();
        series = timeseriescollection1.getSeries(0);
        ChartPanel chartpanel = new ChartPanel(jfreechart1);
        JButton jbutton = new JButton("Add New Data Item");
        jbutton.setActionCommand("ADD_DATA");
        jbutton.addActionListener(this);
        JPanel jpanel = new JPanel(new BorderLayout());
        jpanel.add(chartpanel);
        jpanel.add(jbutton, "South");
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Clone Test 1", "Time", "Value", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        ValueAxis valueaxis = xyplot.getDomainAxis();
        valueaxis.setAutoRange(true);
        valueaxis.setFixedAutoRange(60000D);
        return jfreechart;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getActionCommand().equals("ADD_DATA"))
        {
            double d = 0.90000000000000002D + 0.20000000000000001D * Math.random();
            lastValue = lastValue * d;
            Millisecond millisecond = new Millisecond();
            System.out.println("Now = " + millisecond.toString());
            series.add(new Millisecond(), lastValue);
        }
    }

    public static void main(String args[])
    {
        CloneTest1 clonetest1 = new CloneTest1("JFreeChart : Clone Test 1");
        clonetest1.pack();
        RefineryUtilities.centerFrameOnScreen(clonetest1);
        clonetest1.setVisible(true);
    }

    private TimeSeries series;
    private double lastValue;
}
