



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.*;

public class XYBlockChartDemo1 extends ApplicationFrame
{

    public XYBlockChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYZDataset xyzdataset)
    {
        NumberAxis numberaxis = new NumberAxis("X");
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLowerMargin(0.0D);
        numberaxis.setUpperMargin(0.0D);
        numberaxis.setAxisLinePaint(Color.white);
        numberaxis.setTickMarkPaint(Color.white);
        NumberAxis numberaxis1 = new NumberAxis("Y");
        numberaxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis1.setLowerMargin(0.0D);
        numberaxis1.setUpperMargin(0.0D);
        numberaxis1.setAxisLinePaint(Color.white);
        numberaxis1.setTickMarkPaint(Color.white);
        XYBlockRenderer xyblockrenderer = new XYBlockRenderer();
        GrayPaintScale graypaintscale = new GrayPaintScale(-2D, 1.0D);
        xyblockrenderer.setPaintScale(graypaintscale);
        XYPlot xyplot = new XYPlot(xyzdataset, numberaxis, numberaxis1, xyblockrenderer);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinesVisible(false);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setOutlinePaint(Color.blue);
        JFreeChart jfreechart = new JFreeChart("XYBlockChartDemo1", xyplot);
        jfreechart.removeLegend();
        NumberAxis numberaxis2 = new NumberAxis("Scale");
        numberaxis2.setAxisLinePaint(Color.white);
        numberaxis2.setTickMarkPaint(Color.white);
        numberaxis2.setTickLabelFont(new Font("Dialog", 0, 7));
        PaintScaleLegend paintscalelegend = new PaintScaleLegend(new GrayPaintScale(), numberaxis2);
        paintscalelegend.setAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        paintscalelegend.setAxisOffset(5D);
        paintscalelegend.setMargin(new RectangleInsets(5D, 5D, 5D, 5D));
        paintscalelegend.setFrame(new BlockBorder(Color.red));
        paintscalelegend.setPadding(new RectangleInsets(10D, 10D, 10D, 10D));
        paintscalelegend.setStripWidth(10D);
        paintscalelegend.setPosition(RectangleEdge.RIGHT);
        paintscalelegend.setBackgroundPaint(new Color(120, 120, 180));
        jfreechart.addSubtitle(paintscalelegend);
        jfreechart.setBackgroundPaint(new Color(180, 180, 250));
        return jfreechart;
    }

    private static XYZDataset createDataset()
    {
        return new XYZDataset() {

            public int getSeriesCount()
            {
                return 1;
            }

            public int getItemCount(int i)
            {
                return 10000;
            }

            public Number getX(int i, int j)
            {
                return new Double(getXValue(i, j));
            }

            public double getXValue(int i, int j)
            {
                return (double)(j / 100 - 50);
            }

            public Number getY(int i, int j)
            {
                return new Double(getYValue(i, j));
            }

            public double getYValue(int i, int j)
            {
                return (double)(j - (j / 100) * 100 - 50);
            }

            public Number getZ(int i, int j)
            {
                return new Double(getZValue(i, j));
            }

            public double getZValue(int i, int j)
            {
                double d = getXValue(i, j);
                double d1 = getYValue(i, j);
                return Math.sin(Math.sqrt(d * d + d1 * d1) / 5D);
            }

            public void addChangeListener(DatasetChangeListener datasetchangelistener)
            {
            }

            public void removeChangeListener(DatasetChangeListener datasetchangelistener)
            {
            }

            public DatasetGroup getGroup()
            {
                return null;
            }

            public void setGroup(DatasetGroup datasetgroup)
            {
            }

            public Comparable getSeriesKey(int i)
            {
                return "sin(sqrt(x + y))";
            }

            public int indexOf(Comparable comparable)
            {
                return 0;
            }

            public DomainOrder getDomainOrder()
            {
                return DomainOrder.ASCENDING;
            }

        }
;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBlockChartDemo1 xyblockchartdemo1 = new XYBlockChartDemo1("JFreeChart: XYBlockChartDemo1");
        xyblockchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xyblockchartdemo1);
        xyblockchartdemo1.setVisible(true);
    }
}
