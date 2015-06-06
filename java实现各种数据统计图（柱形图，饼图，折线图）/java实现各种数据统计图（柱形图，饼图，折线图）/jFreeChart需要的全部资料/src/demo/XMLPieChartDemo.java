



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.text.NumberFormat;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.xml.DatasetReader;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XMLPieChartDemo extends ApplicationFrame
{

    public XMLPieChartDemo(String s)
    {
        super(s);
        org.jfree.data.general.PieDataset piedataset = null;
        URL url = getClass().getResource("/org/jfree/chart/demo/piedata.xml");
        try
        {
            java.io.InputStream inputstream = url.openStream();
            piedataset = DatasetReader.readPieDatasetFromXML(inputstream);
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception.getMessage());
        }
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 1", piedataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.yellow);
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        pieplot.setNoDataMessage("No data available");
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public static void main(String args[])
    {
        XMLPieChartDemo xmlpiechartdemo = new XMLPieChartDemo("XML Pie Chart Demo");
        xmlpiechartdemo.pack();
        RefineryUtilities.centerFrameOnScreen(xmlpiechartdemo);
        xmlpiechartdemo.setVisible(true);
    }
}
