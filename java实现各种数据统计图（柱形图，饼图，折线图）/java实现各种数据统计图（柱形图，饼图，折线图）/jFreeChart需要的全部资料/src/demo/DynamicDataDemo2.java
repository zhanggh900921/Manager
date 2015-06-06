



package demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.ui.*;

public class DynamicDataDemo2 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            boolean flag = false;
            boolean flag1 = false;
            if(actionevent.getActionCommand().equals("ADD_DATA_1"))
                flag = true;
            else
            if(actionevent.getActionCommand().equals("ADD_DATA_2"))
                flag1 = true;
            else
            if(actionevent.getActionCommand().equals("ADD_BOTH"))
            {
                flag = true;
                flag1 = true;
            }
            if(flag)
            {
                double d = 0.90000000000000002D + 0.20000000000000001D * Math.random();
                lastValue1 = lastValue1 * d;
                Millisecond millisecond = new Millisecond();
                System.out.println("Now = " + millisecond.toString());
                series1.add(new Millisecond(), lastValue1);
            }
            if(flag1)
            {
                double d1 = 0.90000000000000002D + 0.20000000000000001D * Math.random();
                lastValue2 = lastValue2 * d1;
                Millisecond millisecond1 = new Millisecond();
                System.out.println("Now = " + millisecond1.toString());
                series2.add(new Millisecond(), lastValue2);
            }
        }

        private TimeSeries series1;
        private TimeSeries series2;
        private double lastValue1;
        private double lastValue2;

        public DemoPanel()
        {
            super(new BorderLayout());
            lastValue1 = 100D;
            lastValue2 = 500D;
            series1 = new TimeSeries("Random 1", DynamicDataDemo2.class$org$jfree$data$time$Millisecond != null ? DynamicDataDemo2.class$org$jfree$data$time$Millisecond : (DynamicDataDemo2.class$org$jfree$data$time$Millisecond = DynamicDataDemo2._mthclass$("org.jfree.data.time.Millisecond")));
            series2 = new TimeSeries("Random 2", DynamicDataDemo2.class$org$jfree$data$time$Millisecond != null ? DynamicDataDemo2.class$org$jfree$data$time$Millisecond : (DynamicDataDemo2.class$org$jfree$data$time$Millisecond = DynamicDataDemo2._mthclass$("org.jfree.data.time.Millisecond")));
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(series1);
            TimeSeriesCollection timeseriescollection1 = new TimeSeriesCollection(series2);
            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Dynamic Data Demo 2", "Time", "Value", timeseriescollection, true, true, false);
            jfreechart.setBackgroundPaint(Color.white);
            XYPlot xyplot = (XYPlot)jfreechart.getPlot();
            xyplot.setBackgroundPaint(Color.lightGray);
            xyplot.setDomainGridlinePaint(Color.white);
            xyplot.setRangeGridlinePaint(Color.white);
            xyplot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));
            ValueAxis valueaxis = xyplot.getDomainAxis();
            valueaxis.setAutoRange(true);
            valueaxis.setFixedAutoRange(10000D);
            xyplot.setDataset(1, timeseriescollection1);
            NumberAxis numberaxis = new NumberAxis("Range Axis 2");
            numberaxis.setAutoRangeIncludesZero(false);
            xyplot.setRenderer(1, new DefaultXYItemRenderer());
            xyplot.setRangeAxis(1, numberaxis);
            xyplot.mapDatasetToRangeAxis(1, 1);
            ChartPanel chartpanel = new ChartPanel(jfreechart);
            add(chartpanel);
            JButton jbutton = new JButton("Add To Series 1");
            jbutton.setActionCommand("ADD_DATA_1");
            jbutton.addActionListener(this);
            JButton jbutton1 = new JButton("Add To Series 2");
            jbutton1.setActionCommand("ADD_DATA_2");
            jbutton1.addActionListener(this);
            JButton jbutton2 = new JButton("Add To Both");
            jbutton2.setActionCommand("ADD_BOTH");
            jbutton2.addActionListener(this);
            JPanel jpanel = new JPanel(new FlowLayout());
            jpanel.setBackground(Color.white);
            jpanel.add(jbutton);
            jpanel.add(jbutton1);
            jpanel.add(jbutton2);
            add(jpanel, "South");
            chartpanel.setPreferredSize(new Dimension(500, 270));
        }
    }


    public DynamicDataDemo2(String s)
    {
        super(s);
        setContentPane(new DemoPanel());
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public static void main(String args[])
    {
        DynamicDataDemo2 dynamicdatademo2 = new DynamicDataDemo2("JFreeChart: DynamicDataDemo2.java");
        dynamicdatademo2.pack();
        RefineryUtilities.centerFrameOnScreen(dynamicdatademo2);
        dynamicdatademo2.setVisible(true);
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
