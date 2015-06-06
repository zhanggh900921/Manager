



package demo;

import java.awt.Dimension;
import java.awt.Font;
import java.io.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class AnnotationDemo1 extends ApplicationFrame
{

    public AnnotationDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(360, 500));
        setContentPane(jpanel);
    }

    private static XYSeriesCollection createDataset()
    {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((org.jfree.data.xy.XYSeriesCollection.class).getClassLoader().getResourceAsStream("demo/wtageinf.txt")));
            String s = bufferedreader.readLine();
            s = bufferedreader.readLine();
            s = bufferedreader.readLine();
            s = bufferedreader.readLine();
            XYSeries xyseries = new XYSeries("P3", true, false);
            XYSeries xyseries1 = new XYSeries("P5", true, false);
            XYSeries xyseries2 = new XYSeries("P10", true, false);
            XYSeries xyseries3 = new XYSeries("P25", true, false);
            XYSeries xyseries4 = new XYSeries("P50", true, false);
            XYSeries xyseries5 = new XYSeries("P75", true, false);
            XYSeries xyseries6 = new XYSeries("P90", true, false);
            XYSeries xyseries7 = new XYSeries("P95", true, false);
            XYSeries xyseries8 = new XYSeries("P97", true, false);
            for(String s1 = bufferedreader.readLine(); s1 != null; s1 = bufferedreader.readLine())
            {
                int i = Integer.parseInt(s1.substring(1, 8).trim());
                float f = Float.parseFloat(s1.substring(9, 17).trim());
                float f1 = Float.parseFloat(s1.substring(69, 86).trim());
                float f2 = Float.parseFloat(s1.substring(87, 103).trim());
                float f3 = Float.parseFloat(s1.substring(104, 122).trim());
                float f4 = Float.parseFloat(s1.substring(123, 140).trim());
                float f5 = Float.parseFloat(s1.substring(141, 158).trim());
                float f6 = Float.parseFloat(s1.substring(159, 176).trim());
                float f7 = Float.parseFloat(s1.substring(177, 193).trim());
                float f8 = Float.parseFloat(s1.substring(194, 212).trim());
                float f9 = Float.parseFloat(s1.substring(212, s1.length()).trim());
                if(i == 1)
                {
                    xyseries.add(f, f1);
                    xyseries1.add(f, f2);
                    xyseries2.add(f, f3);
                    xyseries3.add(f, f4);
                    xyseries4.add(f, f5);
                    xyseries5.add(f, f6);
                    xyseries6.add(f, f7);
                    xyseries7.add(f, f8);
                    xyseries8.add(f, f9);
                }
            }

            xyseriescollection.addSeries(xyseries);
            xyseriescollection.addSeries(xyseries1);
            xyseriescollection.addSeries(xyseries2);
            xyseriescollection.addSeries(xyseries3);
            xyseriescollection.addSeries(xyseries4);
            xyseriescollection.addSeries(xyseries5);
            xyseriescollection.addSeries(xyseries6);
            xyseriescollection.addSeries(xyseries7);
            xyseriescollection.addSeries(xyseries8);
        }
        catch(FileNotFoundException filenotfoundexception)
        {
            System.err.println(filenotfoundexception);
        }
        catch(IOException ioexception)
        {
            System.err.println(ioexception);
        }
        return xyseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart(null, "Age in Months", "Weight (kg)", xydataset, PlotOrientation.VERTICAL, true, true, false);
        TextTitle texttitle = new TextTitle("Growth Charts: United States", new Font("SansSerif", 1, 14));
        TextTitle texttitle1 = new TextTitle("Weight-for-age percentiles: boys, birth to 36 months", new Font("SansSerif", 0, 11));
        jfreechart.addSubtitle(texttitle);
        jfreechart.addSubtitle(texttitle1);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        NumberAxis numberaxis = (NumberAxis)xyplot.getDomainAxis();
        numberaxis.setUpperMargin(0.12D);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis numberaxis1 = (NumberAxis)xyplot.getRangeAxis();
        numberaxis1.setAutoRangeIncludesZero(false);
        XYTextAnnotation xytextannotation = null;
        Font font = new Font("SansSerif", 0, 9);
        xytextannotation = new XYTextAnnotation("3rd", 36.5D, 11.76D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("5th", 36.5D, 12.039999999999999D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("10th", 36.5D, 12.493D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("25th", 36.5D, 13.313000000000001D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("50th", 36.5D, 14.33D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("75th", 36.5D, 15.478D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("90th", 36.5D, 16.641999999999999D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("95th", 36.5D, 17.408000000000001D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        xytextannotation = new XYTextAnnotation("97th", 36.5D, 17.936D);
        xytextannotation.setFont(font);
        xytextannotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xyplot.addAnnotation(xytextannotation);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        AnnotationDemo1 annotationdemo1 = new AnnotationDemo1("Annotation Demo 1");
        annotationdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(annotationdemo1);
        annotationdemo1.setVisible(true);
    }
}
