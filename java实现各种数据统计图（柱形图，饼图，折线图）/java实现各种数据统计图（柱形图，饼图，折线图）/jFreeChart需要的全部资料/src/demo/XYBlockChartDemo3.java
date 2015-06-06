



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.*;

public class XYBlockChartDemo3 extends ApplicationFrame
{

    public XYBlockChartDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYZDataset xyzdataset)
    {
        NumberAxis numberaxis = new NumberAxis("X");
        numberaxis.setLowerMargin(0.0D);
        numberaxis.setUpperMargin(0.0D);
        NumberAxis numberaxis1 = new NumberAxis("Y");
        numberaxis1.setAutoRangeIncludesZero(false);
        numberaxis1.setInverted(true);
        numberaxis1.setLowerMargin(0.0D);
        numberaxis1.setUpperMargin(0.0D);
        numberaxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBlockRenderer xyblockrenderer = new XYBlockRenderer();
        LookupPaintScale lookuppaintscale = new LookupPaintScale(0.5D, 3.5D, Color.black);
        lookuppaintscale.add(0.5D, Color.green);
        lookuppaintscale.add(1.5D, Color.orange);
        lookuppaintscale.add(2.5D, Color.red);
        xyblockrenderer.setPaintScale(lookuppaintscale);
        XYPlot xyplot = new XYPlot(xyzdataset, numberaxis, numberaxis1, xyblockrenderer);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setForegroundAlpha(0.66F);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        JFreeChart jfreechart = new JFreeChart("XYBlockChartDemo3", xyplot);
        jfreechart.removeLegend();
        jfreechart.setBackgroundPaint(Color.white);
        SymbolAxis symbolaxis = new SymbolAxis(null, new String[] {
            "", "OK", "Uncertain", "Bad"
        });
        symbolaxis.setRange(0.5D, 3.5D);
        symbolaxis.setPlot(new PiePlot());
        symbolaxis.setGridBandsVisible(false);
        PaintScaleLegend paintscalelegend = new PaintScaleLegend(lookuppaintscale, symbolaxis);
        paintscalelegend.setAxisOffset(5D);
        paintscalelegend.setPosition(RectangleEdge.BOTTOM);
        paintscalelegend.setMargin(new RectangleInsets(5D, 5D, 5D, 5D));
        jfreechart.addSubtitle(paintscalelegend);
        return jfreechart;
    }

    private static void setValue(double ad[][], int i, int j, double d)
    {
        ad[0][(j - 8) * 60 + i] = i;
        ad[1][(j - 8) * 60 + i] = j;
        ad[2][(j - 8) * 60 + i] = d;
    }

    private static XYZDataset createDataset()
    {
        double ad[] = new double[840];
        double ad1[] = new double[840];
        double ad2[] = new double[840];
        double ad3[][] = {
            ad, ad1, ad2
        };
        for(int i = 0; i < 60; i++)
        {
            for(int j1 = 8; j1 < 22; j1++)
                setValue(ad3, i, j1, 0.0D);

        }

        for(int j = 8; j < 12; j++)
        {
            for(int k1 = 13; k1 < 48; k1++)
                setValue(ad3, k1, j, 1.0D);

        }

        for(int k = 12; k < 20; k++)
        {
            for(int l1 = 23; l1 < 43; l1++)
                setValue(ad3, l1, k, 1.0D);

        }

        setValue(ad3, 2, 20, 2D);
        setValue(ad3, 5, 20, 3D);
        setValue(ad3, 6, 20, 3D);
        setValue(ad3, 7, 20, 3D);
        setValue(ad3, 8, 20, 3D);
        setValue(ad3, 9, 20, 3D);
        setValue(ad3, 11, 20, 3D);
        setValue(ad3, 17, 20, 2D);
        setValue(ad3, 18, 20, 2D);
        setValue(ad3, 19, 20, 2D);
        setValue(ad3, 20, 20, 2D);
        setValue(ad3, 22, 20, 2D);
        setValue(ad3, 25, 20, 2D);
        setValue(ad3, 28, 20, 2D);
        setValue(ad3, 35, 20, 2D);
        for(int l = 40; l < 60; l++)
            setValue(ad3, l, 20, 3D);

        for(int i1 = 23; i1 < 43; i1++)
            setValue(ad3, i1, 21, 1.0D);

        DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();
        defaultxyzdataset.addSeries("Series 1", ad3);
        return defaultxyzdataset;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBlockChartDemo3 xyblockchartdemo3 = new XYBlockChartDemo3("Block Chart Demo 3");
        xyblockchartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(xyblockchartdemo3);
        xyblockchartdemo3.setVisible(true);
    }
}
