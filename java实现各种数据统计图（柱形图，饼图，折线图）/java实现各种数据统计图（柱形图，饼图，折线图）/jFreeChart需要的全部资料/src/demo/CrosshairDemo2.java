



package demo;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class CrosshairDemo2 extends ApplicationFrame
{
    static class DemoTableModel extends AbstractTableModel
        implements TableModel
    {

        public int getColumnCount()
        {
            return 7;
        }

        public int getRowCount()
        {
            return data.length;
        }

        public Object getValueAt(int i, int j)
        {
            return data[i][j];
        }

        public void setValueAt(Object obj, int i, int j)
        {
            data[i][j] = obj;
            fireTableDataChanged();
        }

        public String getColumnName(int i)
        {
            switch(i)
            {
            case 0: // '\0'
                return "Series Name:";

            case 1: // '\001'
                return "X:";

            case 2: // '\002'
                return "Y:";

            case 3: // '\003'
                return "X (prev)";

            case 4: // '\004'
                return "Y (prev):";

            case 5: // '\005'
                return "X (next):";

            case 6: // '\006'
                return "Y (next):";
            }
            return null;
        }

        private Object data[][];

        public DemoTableModel(int i)
        {
            data = new Object[i][7];
        }
    }

    private static class DemoPanel extends JPanel
        implements ChartChangeListener, ChartProgressListener
    {

        private XYDataset createDataset(int i, String s, double d, RegularTimePeriod regulartimeperiod, int j)
        {
            series[i] = new TimeSeries(s, regulartimeperiod.getClass());
            RegularTimePeriod regulartimeperiod1 = regulartimeperiod;
            double d1 = d;
            for(int k = 0; k < j; k++)
            {
                series[i].add(regulartimeperiod1, d1);
                regulartimeperiod1 = regulartimeperiod1.next();
                d1 *= 1.0D + (Math.random() - 0.495D) / 10D;
            }

            datasets[i] = new TimeSeriesCollection();
            datasets[i].addSeries(series[i]);
            return datasets[i];
        }

        public void chartChanged(ChartChangeEvent chartchangeevent)
        {
            if(chartPanel != null)
            {
                JFreeChart jfreechart = chartPanel.getChart();
                if(jfreechart != null)
                {
                    XYPlot xyplot = (XYPlot)jfreechart.getPlot();
                    XYDataset xydataset = xyplot.getDataset();
                    Comparable comparable = xydataset.getSeriesKey(0);
                    double d = xyplot.getDomainCrosshairValue();
                    model.setValueAt(comparable, 0, 0);
                    long l = (long)d;
                    for(int i = 0; i < 4; i++)
                    {
                        model.setValueAt(new Long(l), i, 1);
                        int ai[] = datasets[i].getSurroundingItems(0, l);
                        long l1 = 0L;
                        long l2 = 0L;
                        double d1 = 0.0D;
                        double d2 = 0.0D;
                        if(ai[0] >= 0)
                        {
                            TimeSeriesDataItem timeseriesdataitem = series[i].getDataItem(ai[0]);
                            l1 = timeseriesdataitem.getPeriod().getMiddleMillisecond();
                            Number number = timeseriesdataitem.getValue();
                            if(number != null)
                            {
                                d1 = number.doubleValue();
                                model.setValueAt(new Double(d1), i, 4);
                            } else
                            {
                                model.setValueAt(null, i, 4);
                            }
                            model.setValueAt(new Long(l1), i, 3);
                        } else
                        {
                            model.setValueAt(new Double(0.0D), i, 4);
                            model.setValueAt(new Double(xyplot.getDomainAxis().getRange().getLowerBound()), i, 3);
                        }
                        if(ai[1] >= 0)
                        {
                            TimeSeriesDataItem timeseriesdataitem1 = series[i].getDataItem(ai[1]);
                            l2 = timeseriesdataitem1.getPeriod().getMiddleMillisecond();
                            Number number1 = timeseriesdataitem1.getValue();
                            if(number1 != null)
                            {
                                d2 = number1.doubleValue();
                                model.setValueAt(new Double(d2), i, 6);
                            } else
                            {
                                model.setValueAt(null, i, 6);
                            }
                            model.setValueAt(new Long(l2), i, 5);
                        } else
                        {
                            model.setValueAt(new Double(0.0D), i, 6);
                            model.setValueAt(new Double(xyplot.getDomainAxis().getRange().getUpperBound()), i, 5);
                        }
                        double d3 = 0.0D;
                        if(l2 - l1 > 0L)
                            d3 = d1 + (((double)l - (double)l1) / ((double)l2 - (double)l1)) * (d2 - d1);
                        else
                            d3 = d1;
                        model.setValueAt(new Double(d3), i, 2);
                    }

                }
            }
        }

        private JFreeChart createChart()
        {
            JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Crosshair Demo 2", "Time of Day", "Value", null, true, true, false);
            XYPlot xyplot = (XYPlot)jfreechart.getPlot();
            XYDataset axydataset[] = new XYDataset[4];
            for(int i = 0; i < 4; i++)
            {
                axydataset[i] = createDataset(i, "Series " + i, 100D + (double)i * 200D, new Minute(), 200);
                if(i == 0)
                {
                    xyplot.setDataset(axydataset[i]);
                } else
                {
                    xyplot.setDataset(i, axydataset[i]);
                    xyplot.setRangeAxis(i, new NumberAxis("Axis " + (i + 1)));
                    xyplot.mapDatasetToRangeAxis(i, i);
                    xyplot.setRenderer(i, new XYLineAndShapeRenderer(true, false));
                }
            }

            jfreechart.addChangeListener(this);
            jfreechart.addProgressListener(this);
            jfreechart.setBackgroundPaint(Color.white);
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
            return jfreechart;
        }

        public void chartProgress(ChartProgressEvent chartprogressevent)
        {
            if(chartprogressevent.getType() != 2)
                return;
            if(chartPanel != null)
            {
                JFreeChart jfreechart = chartPanel.getChart();
                if(jfreechart != null)
                {
                    XYPlot xyplot = (XYPlot)jfreechart.getPlot();
                    XYDataset xydataset = xyplot.getDataset();
                    Comparable comparable = xydataset.getSeriesKey(0);
                    double d = xyplot.getDomainCrosshairValue();
                    model.setValueAt(comparable, 0, 0);
                    long l = (long)d;
                    model.setValueAt(new Long(l), 0, 1);
                    for(int i = 0; i < 4; i++)
                    {
                        int j = series[i].getIndex(new Minute(new Date(l)));
                        if(j >= 0)
                        {
                            TimeSeriesDataItem timeseriesdataitem = series[i].getDataItem(Math.min(199, Math.max(0, j)));
                            TimeSeriesDataItem timeseriesdataitem1 = series[i].getDataItem(Math.max(0, j - 1));
                            TimeSeriesDataItem timeseriesdataitem2 = series[i].getDataItem(Math.min(199, j + 1));
                            long l1 = timeseriesdataitem.getPeriod().getMiddleMillisecond();
                            double d1 = timeseriesdataitem.getValue().doubleValue();
                            long l2 = timeseriesdataitem1.getPeriod().getMiddleMillisecond();
                            double d2 = timeseriesdataitem1.getValue().doubleValue();
                            long l3 = timeseriesdataitem2.getPeriod().getMiddleMillisecond();
                            double d3 = timeseriesdataitem2.getValue().doubleValue();
                            model.setValueAt(new Long(l1), i, 1);
                            model.setValueAt(new Double(d1), i, 2);
                            model.setValueAt(new Long(l2), i, 3);
                            model.setValueAt(new Double(d2), i, 4);
                            model.setValueAt(new Long(l3), i, 5);
                            model.setValueAt(new Double(d3), i, 6);
                        }
                    }

                }
            }
        }

        private static final int SERIES_COUNT = 4;
        private TimeSeriesCollection datasets[];
        private TimeSeries series[];
        private ChartPanel chartPanel;
        private DemoTableModel model;

        public DemoPanel()
        {
            super(new BorderLayout());
            datasets = new TimeSeriesCollection[4];
            series = new TimeSeries[4];
            JPanel jpanel = new JPanel(new BorderLayout());
            JFreeChart jfreechart = createChart();
            chartPanel = new ChartPanel(jfreechart);
            chartPanel.setPreferredSize(new Dimension(600, 270));
            chartPanel.setDomainZoomable(true);
            chartPanel.setRangeZoomable(true);
            javax.swing.border.CompoundBorder compoundborder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createEtchedBorder());
            chartPanel.setBorder(compoundborder);
            jpanel.add(chartPanel);
            JPanel jpanel1 = new JPanel(new BorderLayout());
            jpanel1.setPreferredSize(new Dimension(400, 120));
            jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            model = new DemoTableModel(4);
            for(int i = 0; i < 4; i++)
            {
                XYPlot xyplot = (XYPlot)jfreechart.getPlot();
                model.setValueAt(xyplot.getDataset(i).getSeriesKey(0), i, 0);
                model.setValueAt(new Double("0.00"), i, 1);
                model.setValueAt(new Double("0.00"), i, 2);
                model.setValueAt(new Double("0.00"), i, 3);
                model.setValueAt(new Double("0.00"), i, 4);
                model.setValueAt(new Double("0.00"), i, 5);
                model.setValueAt(new Double("0.00"), i, 6);
            }

            JTable jtable = new JTable(model);
            DateCellRenderer datecellrenderer = new DateCellRenderer(new SimpleDateFormat("HH:mm:ss"));
            NumberCellRenderer numbercellrenderer = new NumberCellRenderer();
            jtable.getColumnModel().getColumn(1).setCellRenderer(datecellrenderer);
            jtable.getColumnModel().getColumn(2).setCellRenderer(numbercellrenderer);
            jtable.getColumnModel().getColumn(3).setCellRenderer(datecellrenderer);
            jtable.getColumnModel().getColumn(4).setCellRenderer(numbercellrenderer);
            jtable.getColumnModel().getColumn(5).setCellRenderer(datecellrenderer);
            jtable.getColumnModel().getColumn(6).setCellRenderer(numbercellrenderer);
            jpanel1.add(new JScrollPane(jtable));
            jpanel.add(jpanel1, "South");
            add(jpanel);
        }
    }


    public CrosshairDemo2(String s)
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
        CrosshairDemo2 crosshairdemo2 = new CrosshairDemo2("Crosshair Demo 2");
        crosshairdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(crosshairdemo2);
        crosshairdemo2.setVisible(true);
    }
}
