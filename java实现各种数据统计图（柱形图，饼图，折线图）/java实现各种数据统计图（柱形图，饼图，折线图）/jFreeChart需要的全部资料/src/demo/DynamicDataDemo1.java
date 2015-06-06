



package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DynamicDataDemo1 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
        implements ActionListener
    {

        private JFreeChart createChart(XYDataset xydataset)
        {
            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Dynamic Data Demo", "Time", "Value", xydataset, true, true, false);
            XYPlot xyplot = (XYPlot)jfreechart.getPlot();
            ValueAxis valueaxis = xyplot.getDomainAxis();
            valueaxis.setAutoRange(true);
            valueaxis.setFixedAutoRange(60000D);
            valueaxis = xyplot.getRangeAxis();
            valueaxis.setRange(0.0D, 200D);
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

        private TimeSeries series;
        private double lastValue;

        public DemoPanel()
        {
            super(new BorderLayout());
            lastValue = 100D;
            series = new TimeSeries("Random Data", DynamicDataDemo1.class$org$jfree$data$time$Millisecond != null ? DynamicDataDemo1.class$org$jfree$data$time$Millisecond : (DynamicDataDemo1.class$org$jfree$data$time$Millisecond = DynamicDataDemo1._mthclass$("org.jfree.data.time.Millisecond")));
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(series);
            ChartPanel chartpanel = new ChartPanel(createChart(timeseriescollection));
            chartpanel.setPreferredSize(new Dimension(500, 270));
            JPanel jpanel = new JPanel();
            jpanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            JButton jbutton = new JButton("Add New Data Item");
            jbutton.setActionCommand("ADD_DATA");
            jbutton.addActionListener(this);
            jpanel.add(jbutton);
            add(chartpanel);
            add(jpanel, "South");
        }
    }


    public DynamicDataDemo1(String s)
    {
        super(s);
        DemoPanel demopanel = new DemoPanel();
        setContentPane(demopanel);
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public static void main(String args[])
    {
        DynamicDataDemo1 dynamicdatademo1 = new DynamicDataDemo1("Dynamic Data Demo");
        dynamicdatademo1.pack();
        RefineryUtilities.centerFrameOnScreen(dynamicdatademo1);
        dynamicdatademo1.setVisible(true);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    static Class class$org$jfree$data$time$Millisecond; /* synthetic field */
}
