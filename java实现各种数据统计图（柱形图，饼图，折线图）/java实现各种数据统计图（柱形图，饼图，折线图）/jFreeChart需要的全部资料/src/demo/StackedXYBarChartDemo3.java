



package demo;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.*;

public class StackedXYBarChartDemo3 extends ApplicationFrame
{

    public StackedXYBarChartDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static TableXYDataset createDataset()
    {
        TimeTableXYDataset timetablexydataset = new TimeTableXYDataset();
        timetablexydataset.add(new Year(2002), 41287D, "Landfilled");
        timetablexydataset.add(new Year(2003), 41096D, "Landfilled");
        timetablexydataset.add(new Year(2004), 39603D, "Landfilled");
        timetablexydataset.add(new Year(2005), 39693D, "Landfilled");
        timetablexydataset.add(new Year(2006), 37227D, "Landfilled");
        timetablexydataset.add(new Year(2002), 7717D, "Recycled");
        timetablexydataset.add(new Year(2003), 8317D, "Recycled");
        timetablexydataset.add(new Year(2004), 9493D, "Recycled");
        timetablexydataset.add(new Year(2005), 11228D, "Recycled");
        timetablexydataset.add(new Year(2006), 14941D, "Recycled");
        return timetablexydataset;
    }

    private static JFreeChart createChart(TableXYDataset tablexydataset)
    {
        DateAxis dateaxis = new DateAxis("Year");
        dateaxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateaxis.setLowerMargin(0.01D);
        dateaxis.setUpperMargin(0.01D);
        NumberAxis numberaxis = new NumberAxis("Tonnes");
        numberaxis.setNumberFormatOverride(new DecimalFormat("0.0%"));
        StackedXYBarRenderer stackedxybarrenderer = new StackedXYBarRenderer(0.29999999999999999D);
        stackedxybarrenderer.setRenderAsPercentages(true);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, new Color(64, 0, 0), 0.0F, 0.0F, Color.red);
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, new Color(0, 64, 0), 0.0F, 0.0F, Color.green);
        stackedxybarrenderer.setSeriesPaint(0, gradientpaint);
        stackedxybarrenderer.setSeriesPaint(1, gradientpaint1);
        stackedxybarrenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        stackedxybarrenderer.setDrawBarOutline(false);
        stackedxybarrenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0} : {1} = {2} tonnes", new SimpleDateFormat("yyyy"), new DecimalFormat("#,##0")));
        XYPlot xyplot = new XYPlot(tablexydataset, dateaxis, numberaxis, stackedxybarrenderer);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        JFreeChart jfreechart = new JFreeChart("Waste Management", xyplot);
        jfreechart.setBackgroundPaint(Color.white);
        jfreechart.addSubtitle(new TextTitle("St Albans City and District Council"));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedXYBarChartDemo3 stackedxybarchartdemo3 = new StackedXYBarChartDemo3("JFreeChart: StackedXYBarChartDemo3");
        stackedxybarchartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(stackedxybarchartdemo3);
        stackedxybarchartdemo3.setVisible(true);
    }
}
