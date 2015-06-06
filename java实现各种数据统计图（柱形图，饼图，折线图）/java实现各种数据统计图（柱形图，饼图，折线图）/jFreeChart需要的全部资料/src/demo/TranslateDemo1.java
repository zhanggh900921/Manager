



package demo;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.*;
import org.jfree.data.time.*;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class TranslateDemo1 extends ApplicationFrame
{
    private static class DemoPanel extends JPanel
        implements ChangeListener
    {
        static class TranslatingXYDataset extends AbstractXYDataset
            implements XYDataset, DatasetChangeListener
        {

            public double getTranslate()
            {
                return translate;
            }

            public void setTranslate(double d)
            {
                translate = d;
                fireDatasetChanged();
            }

            public int getItemCount(int i)
            {
                return underlying.getItemCount(i);
            }

            public double getXValue(int i, int j)
            {
                return underlying.getXValue(i, j) + translate;
            }

            public Number getX(int i, int j)
            {
                return new Double(getXValue(i, j));
            }

            public Number getY(int i, int j)
            {
                return new Double(getYValue(i, j));
            }

            public double getYValue(int i, int j)
            {
                return underlying.getYValue(i, j);
            }

            public int getSeriesCount()
            {
                return underlying.getSeriesCount();
            }

            public Comparable getSeriesKey(int i)
            {
                return underlying.getSeriesKey(i);
            }

            public void datasetChanged(DatasetChangeEvent datasetchangeevent)
            {
                fireDatasetChanged();
            }

            private XYDataset underlying;
            private double translate;

            public TranslatingXYDataset(XYDataset xydataset)
            {
                underlying = xydataset;
                underlying.addChangeListener(this);
                translate = 0.0D;
            }
        }


        private JFreeChart createChart()
        {
            XYDataset xydataset = createDataset("Random 1", 100D, new Minute(), 200);
            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Translate Demo 1", "Time of Day", "Value", xydataset, true, true, false);
            jfreechart.setBackgroundPaint(Color.white);
            XYPlot xyplot = (XYPlot)jfreechart.getPlot();
            xyplot.setOrientation(PlotOrientation.VERTICAL);
            xyplot.setBackgroundPaint(Color.lightGray);
            xyplot.setDomainGridlinePaint(Color.white);
            xyplot.setRangeGridlinePaint(Color.white);
            xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
            xyplot.setDomainCrosshairVisible(true);
            xyplot.setDomainCrosshairLockedOnData(false);
            xyplot.setRangeCrosshairVisible(false);
            XYItemRenderer xyitemrenderer = xyplot.getRenderer();
            xyitemrenderer.setSeriesPaint(0, Color.black);
            DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
            org.jfree.data.Range range = DatasetUtilities.findDomainBounds(dataset);
            dateaxis.setRange(range);
            return jfreechart;
        }

        private XYDataset createDataset(String s, double d, RegularTimePeriod regulartimeperiod, int i)
        {
            series = new TimeSeries(s, regulartimeperiod.getClass());
            RegularTimePeriod regulartimeperiod1 = regulartimeperiod;
            double d1 = d;
            for(int j = 0; j < i; j++)
            {
                series.add(regulartimeperiod1, d1);
                regulartimeperiod1 = regulartimeperiod1.next();
                d1 *= 1.0D + (Math.random() - 0.495D) / 10D;
            }

            TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
            timeseriescollection.addSeries(series);
            dataset = new TranslatingXYDataset(timeseriescollection);
            return dataset;
        }

        public void stateChanged(ChangeEvent changeevent)
        {
            int i = slider.getValue();
            dataset.setTranslate((double)(i * 60) * 1000D);
        }

        private TimeSeries series;
        private ChartPanel chartPanel;
        private JFreeChart chart;
        private JSlider slider;
        private TranslatingXYDataset dataset;

        public DemoPanel()
        {
            super(new BorderLayout());
            chart = createChart();
            chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(600, 270));
            chartPanel.setDomainZoomable(true);
            chartPanel.setRangeZoomable(true);
            javax.swing.border.CompoundBorder compoundborder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createEtchedBorder());
            chartPanel.setBorder(compoundborder);
            add(chartPanel);
            JPanel jpanel = new JPanel(new BorderLayout());
            jpanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            slider = new JSlider(-200, 200, 0);
            slider.setPaintLabels(true);
            slider.setMajorTickSpacing(50);
            slider.setPaintTicks(true);
            slider.addChangeListener(this);
            jpanel.add(slider);
            add(jpanel, "South");
        }
    }


    public TranslateDemo1(String s)
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
        TranslateDemo1 translatedemo1 = new TranslateDemo1("Translate Demo 1");
        translatedemo1.pack();
        RefineryUtilities.centerFrameOnScreen(translatedemo1);
        translatedemo1.setVisible(true);
    }
}
