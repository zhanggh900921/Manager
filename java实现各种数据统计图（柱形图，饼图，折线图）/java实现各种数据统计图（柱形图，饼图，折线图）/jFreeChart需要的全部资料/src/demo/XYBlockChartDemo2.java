



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.*;

public class XYBlockChartDemo2 extends ApplicationFrame
{

    public XYBlockChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYZDataset xyzdataset)
    {
        DateAxis dateaxis = new DateAxis("Date");
        dateaxis.setLowerMargin(0.0D);
        dateaxis.setUpperMargin(0.0D);
        dateaxis.setInverted(true);
        NumberAxis numberaxis = new NumberAxis("Hour");
        numberaxis.setUpperMargin(0.0D);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBlockRenderer xyblockrenderer = new XYBlockRenderer();
        xyblockrenderer.setBlockWidth(86400000D);
        xyblockrenderer.setBlockAnchor(RectangleAnchor.BOTTOM_LEFT);
        LookupPaintScale lookuppaintscale = new LookupPaintScale(0.5D, 4.5D, Color.white);
        lookuppaintscale.add(0.5D, Color.red);
        lookuppaintscale.add(1.5D, Color.green);
        lookuppaintscale.add(2.5D, Color.blue);
        lookuppaintscale.add(3.5D, Color.yellow);
        xyblockrenderer.setPaintScale(lookuppaintscale);
        XYPlot xyplot = new XYPlot(xyzdataset, dateaxis, numberaxis, xyblockrenderer);
        xyplot.setOrientation(PlotOrientation.HORIZONTAL);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        JFreeChart jfreechart = new JFreeChart("XYBlockChartDemo2", xyplot);
        jfreechart.removeLegend();
        jfreechart.setBackgroundPaint(Color.white);
        SymbolAxis symbolaxis = new SymbolAxis(null, new String[] {
            "", "Unavailable", "Free", "Group 1", "Group 2"
        });
        symbolaxis.setRange(0.5D, 4.5D);
        symbolaxis.setPlot(new PiePlot());
        symbolaxis.setGridBandsVisible(false);
        PaintScaleLegend paintscalelegend = new PaintScaleLegend(lookuppaintscale, symbolaxis);
        paintscalelegend.setMargin(new RectangleInsets(3D, 10D, 3D, 10D));
        paintscalelegend.setPosition(RectangleEdge.BOTTOM);
        paintscalelegend.setAxisOffset(5D);
        jfreechart.addSubtitle(paintscalelegend);
        return jfreechart;
    }

    private static XYZDataset createDataset()
    {
        double ad[] = new double[2400];
        double ad1[] = new double[2400];
        double ad2[] = new double[2400];
        Object obj = new Day();
        for(int i = 0; i < 100; i++)
        {
            double d = 1.0D;
            for(int j = 0; j < 24; j++)
            {
                if(Math.random() < 0.10000000000000001D)
                    d = Math.random() * 4D;
                ad[i * 24 + j] = ((RegularTimePeriod) (obj)).getFirstMillisecond();
                ad1[i * 24 + j] = j;
                ad2[i * 24 + j] = d;
            }

            obj = ((RegularTimePeriod) (obj)).next();
        }

        DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();
        defaultxyzdataset.addSeries("Series 1", new double[][] {
            ad, ad1, ad2
        });
        return defaultxyzdataset;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBlockChartDemo2 xyblockchartdemo2 = new XYBlockChartDemo2("Block Chart Demo 2");
        xyblockchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xyblockchartdemo2);
        xyblockchartdemo2.setVisible(true);
    }
}
