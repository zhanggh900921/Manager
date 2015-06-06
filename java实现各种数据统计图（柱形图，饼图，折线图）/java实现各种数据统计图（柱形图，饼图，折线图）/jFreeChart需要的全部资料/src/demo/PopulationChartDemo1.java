



package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.data.general.KeyedValues2DDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PopulationChartDemo1 extends ApplicationFrame
{

    public PopulationChartDemo1(String s)
    {
        super(s);
        KeyedValues2DDataset keyedvalues2ddataset = createDataset();
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createStackedBarChart("Population Chart Demo", "Age Group", "Population (millions)", keyedvalues2ddataset, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private KeyedValues2DDataset createDataset()
    {
        DefaultKeyedValues2DDataset defaultkeyedvalues2ddataset = new DefaultKeyedValues2DDataset();
        defaultkeyedvalues2ddataset.addValue(-6D, "Male", "70+");
        defaultkeyedvalues2ddataset.addValue(-8D, "Male", "60-69");
        defaultkeyedvalues2ddataset.addValue(-11D, "Male", "50-59");
        defaultkeyedvalues2ddataset.addValue(-13D, "Male", "40-49");
        defaultkeyedvalues2ddataset.addValue(-14D, "Male", "30-39");
        defaultkeyedvalues2ddataset.addValue(-15D, "Male", "20-29");
        defaultkeyedvalues2ddataset.addValue(-19D, "Male", "10-19");
        defaultkeyedvalues2ddataset.addValue(-21D, "Male", "0-9");
        defaultkeyedvalues2ddataset.addValue(10D, "Female", "70+");
        defaultkeyedvalues2ddataset.addValue(12D, "Female", "60-69");
        defaultkeyedvalues2ddataset.addValue(13D, "Female", "50-59");
        defaultkeyedvalues2ddataset.addValue(14D, "Female", "40-49");
        defaultkeyedvalues2ddataset.addValue(15D, "Female", "30-39");
        defaultkeyedvalues2ddataset.addValue(17D, "Female", "20-29");
        defaultkeyedvalues2ddataset.addValue(19D, "Female", "10-19");
        defaultkeyedvalues2ddataset.addValue(20D, "Female", "0-9");
        return defaultkeyedvalues2ddataset;
    }

    public static void main(String args[])
    {
        PopulationChartDemo1 populationchartdemo1 = new PopulationChartDemo1("Population Chart Demo");
        populationchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(populationchartdemo1);
        populationchartdemo1.setVisible(true);
    }
}
