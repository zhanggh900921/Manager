



package demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.*;
import org.jfree.ui.*;
import org.jfree.util.UnitType;

public class DynamicDataDemo3 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            for(int i = 0; i < 3; i++)
                if(actionevent.getActionCommand().endsWith(String.valueOf(i)))
                {
                    Millisecond millisecond1 = new Millisecond();
                    System.out.println("Now = " + millisecond1.toString());
                    lastValue[i] = lastValue[i] * (0.90000000000000002D + 0.20000000000000001D * Math.random());
                    datasets[i].getSeries(0).add(new Millisecond(), lastValue[i]);
                }

            if(actionevent.getActionCommand().equals("ADD_ALL"))
            {
                Millisecond millisecond = new Millisecond();
                System.out.println("Now = " + millisecond.toString());
                for(int j = 0; j < 3; j++)
                {
                    lastValue[j] = lastValue[j] * (0.90000000000000002D + 0.20000000000000001D * Math.random());
                    datasets[j].getSeries(0).add(new Millisecond(), lastValue[j]);
                }

            }
        }

        public static final int SUBPLOT_COUNT = 3;
        private TimeSeriesCollection datasets[];
        private double lastValue[];

        public DemoPanel()
        {
            super(new BorderLayout());
            lastValue = new double[3];
            CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(new DateAxis("Time"));
            datasets = new TimeSeriesCollection[3];
            for(int i = 0; i < 3; i++)
            {
                lastValue[i] = 100D;
                TimeSeries timeseries = new TimeSeries("Random " + i, DynamicDataDemo3.class$org$jfree$data$time$Millisecond != null ? DynamicDataDemo3.class$org$jfree$data$time$Millisecond : (DynamicDataDemo3.class$org$jfree$data$time$Millisecond = DynamicDataDemo3._mthclass$("org.jfree.data.time.Millisecond")));
                datasets[i] = new TimeSeriesCollection(timeseries);
                NumberAxis numberaxis = new NumberAxis("Y" + i);
                numberaxis.setAutoRangeIncludesZero(false);
                XYPlot xyplot = new XYPlot(datasets[i], null, numberaxis, new StandardXYItemRenderer());
                xyplot.setBackgroundPaint(Color.lightGray);
                xyplot.setDomainGridlinePaint(Color.white);
                xyplot.setRangeGridlinePaint(Color.white);
                combineddomainxyplot.add(xyplot);
            }

            JFreeChart jfreechart = new JFreeChart("Dynamic Data Demo 3", combineddomainxyplot);
            LegendTitle legendtitle = (LegendTitle)jfreechart.getSubtitle(0);
            legendtitle.setPosition(RectangleEdge.RIGHT);
            legendtitle.setMargin(new RectangleInsets(UnitType.ABSOLUTE, 0.0D, 4D, 0.0D, 4D));
            jfreechart.setBorderPaint(Color.black);
            jfreechart.setBorderVisible(true);
            jfreechart.setBackgroundPaint(Color.white);
            combineddomainxyplot.setBackgroundPaint(Color.lightGray);
            combineddomainxyplot.setDomainGridlinePaint(Color.white);
            combineddomainxyplot.setRangeGridlinePaint(Color.white);
            combineddomainxyplot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));
            ValueAxis valueaxis = combineddomainxyplot.getDomainAxis();
            valueaxis.setAutoRange(true);
            valueaxis.setFixedAutoRange(60000D);
            ChartPanel chartpanel = new ChartPanel(jfreechart);
            add(chartpanel);
            JPanel jpanel = new JPanel(new FlowLayout());
            for(int j = 0; j < 3; j++)
            {
                JButton jbutton1 = new JButton("Series " + j);
                jbutton1.setActionCommand("ADD_DATA_" + j);
                jbutton1.addActionListener(this);
                jpanel.add(jbutton1);
            }

            JButton jbutton = new JButton("ALL");
            jbutton.setActionCommand("ADD_ALL");
            jbutton.addActionListener(this);
            jpanel.add(jbutton);
            add(jpanel, "South");
            chartpanel.setPreferredSize(new Dimension(500, 470));
            chartpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        }
    }


    public DynamicDataDemo3(String s)
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
        DynamicDataDemo3 dynamicdatademo3 = new DynamicDataDemo3("Dynamic Data Demo 3");
        dynamicdatademo3.pack();
        RefineryUtilities.centerFrameOnScreen(dynamicdatademo3);
        dynamicdatademo3.setVisible(true);
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
