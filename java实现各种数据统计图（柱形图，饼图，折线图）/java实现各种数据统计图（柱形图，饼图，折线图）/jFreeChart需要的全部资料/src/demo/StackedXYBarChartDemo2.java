



package demo;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.*;

public class StackedXYBarChartDemo2 extends ApplicationFrame
{

    public StackedXYBarChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static TableXYDataset createDataset()
    {
        TimeTableXYDataset timetablexydataset = new TimeTableXYDataset();
        timetablexydataset.add(new Year(1983), 0.0D, "Albatrosses");
        timetablexydataset.add(new Year(1984), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1985), 1.0D, "Albatrosses");
        timetablexydataset.add(new Year(1986), 1.0D, "Albatrosses");
        timetablexydataset.add(new Year(1987), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1988), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1989), 1.0D, "Albatrosses");
        timetablexydataset.add(new Year(1990), 5D, "Albatrosses");
        timetablexydataset.add(new Year(1991), 5D, "Albatrosses");
        timetablexydataset.add(new Year(1992), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1993), 4D, "Albatrosses");
        timetablexydataset.add(new Year(1994), 3D, "Albatrosses");
        timetablexydataset.add(new Year(1995), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1996), 1.0D, "Albatrosses");
        timetablexydataset.add(new Year(1997), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1998), 1.0D, "Albatrosses");
        timetablexydataset.add(new Year(1999), 4D, "Albatrosses");
        timetablexydataset.add(new Year(2000), 6D, "Albatrosses");
        timetablexydataset.add(new Year(2001), 5D, "Albatrosses");
        timetablexydataset.add(new Year(2002), 4D, "Albatrosses");
        timetablexydataset.add(new Year(2003), 2D, "Albatrosses");
        timetablexydataset.add(new Year(1983), 21D, "Aces");
        timetablexydataset.add(new Year(1984), 24D, "Aces");
        timetablexydataset.add(new Year(1985), 32D, "Aces");
        timetablexydataset.add(new Year(1986), 20D, "Aces");
        timetablexydataset.add(new Year(1987), 28D, "Aces");
        timetablexydataset.add(new Year(1988), 17D, "Aces");
        timetablexydataset.add(new Year(1989), 31D, "Aces");
        timetablexydataset.add(new Year(1990), 32D, "Aces");
        timetablexydataset.add(new Year(1991), 29D, "Aces");
        timetablexydataset.add(new Year(1992), 31D, "Aces");
        timetablexydataset.add(new Year(1993), 25D, "Aces");
        timetablexydataset.add(new Year(1994), 44D, "Aces");
        timetablexydataset.add(new Year(1995), 35D, "Aces");
        timetablexydataset.add(new Year(1996), 40D, "Aces");
        timetablexydataset.add(new Year(1997), 32D, "Aces");
        timetablexydataset.add(new Year(1998), 32D, "Aces");
        timetablexydataset.add(new Year(1999), 30D, "Aces");
        timetablexydataset.add(new Year(2000), 29D, "Aces");
        timetablexydataset.add(new Year(2001), 28D, "Aces");
        timetablexydataset.add(new Year(2002), 39D, "Aces");
        timetablexydataset.add(new Year(2003), 32D, "Aces");
        return timetablexydataset;
    }

    private static JFreeChart createChart(TableXYDataset tablexydataset)
    {
        DateAxis dateaxis = new DateAxis("Date");
        dateaxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateaxis.setLowerMargin(0.01D);
        dateaxis.setUpperMargin(0.01D);
        NumberAxis numberaxis = new NumberAxis("Count");
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setUpperMargin(0.10000000000000001D);
        StackedXYBarRenderer stackedxybarrenderer = new StackedXYBarRenderer(0.14999999999999999D);
        stackedxybarrenderer.setDrawBarOutline(false);
        stackedxybarrenderer.setBaseItemLabelsVisible(true);
        stackedxybarrenderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        stackedxybarrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        stackedxybarrenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0} : {1} = {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0")));
        XYPlot xyplot = new XYPlot(tablexydataset, dateaxis, numberaxis, stackedxybarrenderer);
        JFreeChart jfreechart = new JFreeChart("Holes-In-One / Double Eagles", xyplot);
        jfreechart.removeLegend();
        jfreechart.addSubtitle(new TextTitle("PGA Tour, 1983 to 2003"));
        TextTitle texttitle = new TextTitle("http://www.golfdigest.com/majors/masters/index.ssf?/majors/masters/gw20040402albatross.html", new Font("Dialog", 0, 8));
        jfreechart.addSubtitle(texttitle);
        jfreechart.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
        LegendTitle legendtitle = new LegendTitle(xyplot);
        legendtitle.setBackgroundPaint(Color.white);
        legendtitle.setFrame(new BlockBorder());
        legendtitle.setPosition(RectangleEdge.BOTTOM);
        jfreechart.addSubtitle(legendtitle);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedXYBarChartDemo2 stackedxybarchartdemo2 = new StackedXYBarChartDemo2("JFreeChart: Stacked XY Bar Chart Demo 2");
        stackedxybarchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(stackedxybarchartdemo2);
        stackedxybarchartdemo2.setVisible(true);
    }
}
