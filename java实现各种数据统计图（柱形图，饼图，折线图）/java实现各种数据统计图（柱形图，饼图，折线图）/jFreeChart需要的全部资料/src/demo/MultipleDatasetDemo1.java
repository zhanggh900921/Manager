



package demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.ui.*;

public class MultipleDatasetDemo1 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
        implements ActionListener
    {

        private TimeSeriesCollection createRandomDataset(String s)
        {
            TimeSeries timeseries = new TimeSeries(s);
            double d = 100D;
            Object obj = new Day();
            for(int i = 0; i < 50; i++)
            {
                timeseries.add(((RegularTimePeriod) (obj)), d);
                obj = ((RegularTimePeriod) (obj)).next();
                d *= 1.0D + Math.random() / 100D;
            }

            return new TimeSeriesCollection(timeseries);
        }

        public void actionPerformed(ActionEvent actionevent)
        {
            if(actionevent.getActionCommand().equals("ADD_DATASET"))
            {
                if(datasetIndex < 20)
                {
                    datasetIndex++;
                    plot.setDataset(datasetIndex, createRandomDataset("S" + datasetIndex));
                    plot.setRenderer(datasetIndex, new StandardXYItemRenderer());
                }
            } else
            if(actionevent.getActionCommand().equals("REMOVE_DATASET") && datasetIndex >= 1)
            {
                plot.setDataset(datasetIndex, null);
                plot.setRenderer(datasetIndex, null);
                datasetIndex--;
            }
        }

        private XYPlot plot;
        private int datasetIndex;

        public DemoPanel()
        {
            super(new BorderLayout());
            datasetIndex = 0;
            TimeSeriesCollection timeseriescollection = createRandomDataset("Series 1");
            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Multiple Dataset Demo 1", "Time", "Value", timeseriescollection, true, true, false);
            jfreechart.setBackgroundPaint(Color.white);
            plot = (XYPlot)jfreechart.getPlot();
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);
            plot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));
            ValueAxis valueaxis = plot.getDomainAxis();
            valueaxis.setAutoRange(true);
            NumberAxis numberaxis = new NumberAxis("Range Axis 2");
            numberaxis.setAutoRangeIncludesZero(false);
            JPanel jpanel = new JPanel(new BorderLayout());
            ChartPanel chartpanel = new ChartPanel(jfreechart);
            jpanel.add(chartpanel);
            JButton jbutton = new JButton("Add Dataset");
            jbutton.setActionCommand("ADD_DATASET");
            jbutton.addActionListener(this);
            JButton jbutton1 = new JButton("Remove Dataset");
            jbutton1.setActionCommand("REMOVE_DATASET");
            jbutton1.addActionListener(this);
            JPanel jpanel1 = new JPanel(new FlowLayout());
            jpanel1.add(jbutton);
            jpanel1.add(jbutton1);
            jpanel.add(jpanel1, "South");
            chartpanel.setPreferredSize(new Dimension(500, 270));
            add(jpanel);
        }
    }


    public MultipleDatasetDemo1(String s)
    {
        super(s);
        setContentPane(createDemoPanel());
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public static void main(String args[])
    {
        MultipleDatasetDemo1 multipledatasetdemo1 = new MultipleDatasetDemo1("Multiple Dataset Demo 1");
        multipledatasetdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(multipledatasetdemo1);
        multipledatasetdemo1.setVisible(true);
    }
}
