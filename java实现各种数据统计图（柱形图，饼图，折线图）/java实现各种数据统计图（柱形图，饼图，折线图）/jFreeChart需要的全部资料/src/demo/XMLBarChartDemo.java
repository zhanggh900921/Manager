



package demo;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xml.DatasetReader;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XMLBarChartDemo extends ApplicationFrame
{

    public XMLBarChartDemo(String s)
    {
        super(s);
        org.jfree.data.category.CategoryDataset categorydataset = null;
        URL url = getClass().getResource("/demo/categorydata.xml");
        try
        {
            java.io.InputStream inputstream = url.openStream();
            categorydataset = DatasetReader.readCategoryDatasetFromXML(inputstream);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart", "Domain", "Range", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public static void main(String args[])
    {
        XMLBarChartDemo xmlbarchartdemo = new XMLBarChartDemo("XML Bar Chart Demo");
        xmlbarchartdemo.pack();
        RefineryUtilities.centerFrameOnScreen(xmlbarchartdemo);
        xmlbarchartdemo.setVisible(true);
    }
}
