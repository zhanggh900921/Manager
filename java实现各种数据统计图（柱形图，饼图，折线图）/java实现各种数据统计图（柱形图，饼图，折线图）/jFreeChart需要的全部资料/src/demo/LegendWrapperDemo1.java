



package demo;

import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.block.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.*;

public class LegendWrapperDemo1 extends ApplicationFrame
{

    public LegendWrapperDemo1(String s)
    {
        super(s);
        setContentPane(createDemoPanel());
    }

    private static PieDataset createDataset()
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("One", new Double(43.200000000000003D));
        defaultpiedataset.setValue("Two", new Double(10D));
        defaultpiedataset.setValue("Three", new Double(27.5D));
        defaultpiedataset.setValue("Four", new Double(17.5D));
        defaultpiedataset.setValue("Five", new Double(11D));
        defaultpiedataset.setValue("Six", new Double(19.399999999999999D));
        return defaultpiedataset;
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createPieChart("Legend Wrapper Demo 1", piedataset, false, true, false);
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setLabelFont(new Font("SansSerif", 0, 12));
        pieplot.setNoDataMessage("No data available");
        pieplot.setCircular(true);
        pieplot.setLabelGap(0.02D);
        LegendTitle legendtitle = new LegendTitle(jfreechart.getPlot());
        BlockContainer blockcontainer = new BlockContainer(new BorderArrangement());
        blockcontainer.setFrame(new BlockBorder(1.0D, 1.0D, 1.0D, 1.0D));
        LabelBlock labelblock = new LabelBlock("Legend Items:", new Font("SansSerif", 1, 12));
        labelblock.setPadding(5D, 5D, 5D, 5D);
        blockcontainer.add(labelblock, RectangleEdge.TOP);
        LabelBlock labelblock1 = new LabelBlock("Source: http://www.jfree.org");
        labelblock1.setPadding(8D, 20D, 2D, 5D);
        blockcontainer.add(labelblock1, RectangleEdge.BOTTOM);
        BlockContainer blockcontainer1 = legendtitle.getItemContainer();
        blockcontainer1.setPadding(2D, 10D, 5D, 2D);
        blockcontainer.add(blockcontainer1);
        legendtitle.setWrapper(blockcontainer);
        legendtitle.setPosition(RectangleEdge.RIGHT);
        legendtitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
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
        LegendWrapperDemo1 legendwrapperdemo1 = new LegendWrapperDemo1("Legend Wrapper Demo 1");
        legendwrapperdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(legendwrapperdemo1);
        legendwrapperdemo1.setVisible(true);
    }
}
