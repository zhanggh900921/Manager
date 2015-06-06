



package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CategoryLabelPositionsDemo1 extends ApplicationFrame
{

    public CategoryLabelPositionsDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 350));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("CategoryLabelPositionsDemo1", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setMaximumCategoryLabelLines(0x7fffffff);
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.78539816339744828D));
        return jfreechart;
    }

    public static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "R1", "Category 1 (Long)");
        defaultcategorydataset.addValue(5D, "R1", "Category 2 (Long)");
        defaultcategorydataset.addValue(3D, "R1", "Category 3 (Long)");
        defaultcategorydataset.addValue(2D, "R1", "Category 4 (Long)");
        defaultcategorydataset.addValue(9D, "R1", "Category 5 (Long)");
        defaultcategorydataset.addValue(7D, "R1", "Category 6 (Long)");
        defaultcategorydataset.addValue(6D, "R1", "Category 7 (Long)");
        defaultcategorydataset.addValue(8D, "R1", "Category 8 (Long)");
        return defaultcategorydataset;
    }

    public static JPanel createDemoPanel()
    {
        CategoryDataset categorydataset = createDataset();
        chart = createChart(categorydataset);
        JPanel jpanel = new JPanel(new BorderLayout());
        JPanel jpanel1 = new JPanel(new BorderLayout());
        JPanel jpanel2 = new JPanel();
        invertCheckBox = new JCheckBox("Invert Range Axis?");
        invertCheckBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                CategoryPlot categoryplot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                categoryplot.getRangeAxis().setInverted(CategoryLabelPositionsDemo1.invertCheckBox.isSelected());
            }

        }
);
        jpanel2.add(invertCheckBox);
        ButtonGroup buttongroup = new ButtonGroup();
        horizontalRadioButton = new JRadioButton("Horizontal", false);
        horizontalRadioButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                if(CategoryLabelPositionsDemo1.horizontalRadioButton.isSelected())
                {
                    CategoryPlot categoryplot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                    categoryplot.setOrientation(PlotOrientation.HORIZONTAL);
                }
            }

        }
);
        buttongroup.add(horizontalRadioButton);
        verticalRadioButton = new JRadioButton("Vertical", true);
        verticalRadioButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                if(CategoryLabelPositionsDemo1.verticalRadioButton.isSelected())
                {
                    CategoryPlot categoryplot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                    categoryplot.setOrientation(PlotOrientation.VERTICAL);
                }
            }

        }
);
        buttongroup.add(verticalRadioButton);
        jpanel2.add(horizontalRadioButton);
        jpanel2.add(verticalRadioButton);
        jpanel2.setBorder(new TitledBorder("Plot Settings: "));
        JPanel jpanel3 = new JPanel(new BorderLayout());
        slider = new JSlider(0, 90, 45);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent changeevent)
            {
                CategoryPlot categoryplot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                CategoryAxis categoryaxis = categoryplot.getDomainAxis();
                categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(((double)CategoryLabelPositionsDemo1.slider.getValue() * 3.1415926535897931D) / 180D));
            }

        }
);
        jpanel3.add(slider);
        jpanel3.setBorder(new TitledBorder("Axis Label Rotation Angle:"));
        jpanel1.add("North", jpanel2);
        jpanel1.add(jpanel3);
        jpanel.add(new ChartPanel(chart));
        jpanel.add("South", jpanel1);
        return jpanel;
    }

    public static void main(String args[])
    {
        CategoryLabelPositionsDemo1 categorylabelpositionsdemo1 = new CategoryLabelPositionsDemo1("Category Label Positions Demo 1");
        categorylabelpositionsdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(categorylabelpositionsdemo1);
        categorylabelpositionsdemo1.setVisible(true);
    }

    static JFreeChart chart;
    static JCheckBox invertCheckBox;
    static JRadioButton horizontalRadioButton;
    static JRadioButton verticalRadioButton;
    static JSlider slider;
}
