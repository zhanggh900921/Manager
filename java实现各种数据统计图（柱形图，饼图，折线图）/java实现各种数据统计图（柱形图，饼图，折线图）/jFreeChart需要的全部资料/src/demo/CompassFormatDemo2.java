



package demo;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.Range;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo2 extends ApplicationFrame
{
    private static class DemoPanel extends JPanel
        implements ChangeListener
    {

        private XYDataset createDirectionDataset(int i)
        {
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
            TimeSeries timeseries = new TimeSeries("Wind Direction", CompassFormatDemo2.class$org$jfree$data$time$Minute != null ? CompassFormatDemo2.class$org$jfree$data$time$Minute : (CompassFormatDemo2.class$org$jfree$data$time$Minute = CompassFormatDemo2._mthclass$("org.jfree.data.time.Minute")));
            Object obj = new Minute();
            double d = 0.0D;
            for(int j = 0; j < i; j++)
            {
                timeseries.add(((RegularTimePeriod) (obj)), d);
                obj = ((RegularTimePeriod) (obj)).next();
                d += (Math.random() - 0.5D) * 15D;
                if(d < 0.0D)
                {
                    d += 360D;
                    continue;
                }
                if(d > 360D)
                    d -= 360D;
            }

            timeseriescollection.addSeries(timeseries);
            return timeseriescollection;
        }

        private XYDataset createForceDataset(int i)
        {
            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
            TimeSeries timeseries = new TimeSeries("Wind Force", CompassFormatDemo2.class$org$jfree$data$time$Minute != null ? CompassFormatDemo2.class$org$jfree$data$time$Minute : (CompassFormatDemo2.class$org$jfree$data$time$Minute = CompassFormatDemo2._mthclass$("org.jfree.data.time.Minute")));
            Object obj = new Minute();
            double d = 3D;
            for(int j = 0; j < i; j++)
            {
                timeseries.add(((RegularTimePeriod) (obj)), d);
                obj = ((RegularTimePeriod) (obj)).next();
                d = Math.max(0.5D, d + (Math.random() - 0.5D) * 0.5D);
            }

            timeseriescollection.addSeries(timeseries);
            return timeseriescollection;
        }

        private JFreeChart createChart()
        {
            XYDataset xydataset = createDirectionDataset(100);
            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time", "Date", "Direction", xydataset, true, true, false);
            XYPlot xyplot = (XYPlot)jfreechart.getPlot();
            xyplot.getDomainAxis().setLowerMargin(0.0D);
            xyplot.getDomainAxis().setUpperMargin(0.0D);
            rangeAxis = new ModuloAxis("Direction", new Range(0.0D, 360D));
            TickUnits tickunits = new TickUnits();
            tickunits.add(new NumberTickUnit(180D, new CompassFormat()));
            tickunits.add(new NumberTickUnit(90D, new CompassFormat()));
            tickunits.add(new NumberTickUnit(45D, new CompassFormat()));
            tickunits.add(new NumberTickUnit(22.5D, new CompassFormat()));
            rangeAxis.setStandardTickUnits(tickunits);
            XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer();
            xylineandshaperenderer.setBaseLinesVisible(false);
            xylineandshaperenderer.setBaseShapesVisible(true);
            xyplot.setRenderer(xylineandshaperenderer);
            xyplot.setRangeAxis(rangeAxis);
            rangeAxis.setDisplayRange(-45D, 45D);
            XYAreaRenderer xyarearenderer = new XYAreaRenderer();
            NumberAxis numberaxis = new NumberAxis("Force");
            numberaxis.setRange(0.0D, 12D);
            xyarearenderer.setSeriesPaint(0, new Color(0, 0, 255, 128));
            xyplot.setDataset(1, createForceDataset(100));
            xyplot.setRenderer(1, xyarearenderer);
            xyplot.setRangeAxis(1, numberaxis);
            xyplot.mapDatasetToRangeAxis(1, 1);
            return jfreechart;
        }

        public void stateChanged(ChangeEvent changeevent)
        {
            if(changeevent.getSource() == directionSlider)
            {
                direction = directionSlider.getValue();
                rangeAxis.setDisplayRange(direction - degrees, direction + degrees);
            } else
            if(changeevent.getSource() == fieldSlider)
            {
                degrees = fieldSlider.getValue();
                rangeAxis.setDisplayRange(direction - degrees, direction + degrees);
            }
        }

        private JSlider directionSlider;
        private JSlider fieldSlider;
        private ModuloAxis rangeAxis;
        private double direction;
        private double degrees;

        public DemoPanel()
        {
            super(new BorderLayout());
            direction = 0.0D;
            degrees = 45D;
            JPanel jpanel = new JPanel(new GridLayout(1, 2));
            fieldSlider = new JSlider(1, 10, 180, 45);
            fieldSlider.setPaintLabels(true);
            fieldSlider.setPaintTicks(true);
            fieldSlider.setMajorTickSpacing(10);
            fieldSlider.setMinorTickSpacing(5);
            fieldSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            fieldSlider.addChangeListener(this);
            directionSlider = new JSlider(1, 0, 360, 0);
            directionSlider.setMajorTickSpacing(30);
            directionSlider.setMinorTickSpacing(5);
            directionSlider.setPaintLabels(true);
            directionSlider.setPaintTicks(true);
            directionSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            directionSlider.setPaintTrack(true);
            directionSlider.addChangeListener(this);
            jpanel.add(fieldSlider);
            jpanel.add(directionSlider);
            JFreeChart jfreechart = createChart();
            ChartPanel chartpanel = new ChartPanel(jfreechart);
            chartpanel.setPreferredSize(new Dimension(500, 270));
            add(jpanel, "West");
            add(chartpanel);
        }
    }


    public CompassFormatDemo2(String s)
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
        CompassFormatDemo2 compassformatdemo2 = new CompassFormatDemo2("Compass Format Demo 2");
        compassformatdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(compassformatdemo2);
        compassformatdemo2.setVisible(true);
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    static Class class$org$jfree$data$time$Minute; /* synthetic field */
}
