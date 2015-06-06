package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoDataSource;
import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoLink;
import com.zhtelecom.common.topograph.TopoNetwork;
import com.zhtelecom.common.topograph.TopoNode;
import com.zhtelecom.common.topograph.example.NMSExample;
import javax.swing.JOptionPane;

/**
 *
 */
public class ActionBatchAddNodeTest extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {
        TopoDataSource tds = TopoGraphView.getContextGraphView().
            getTopoDataSource();

        //网络
        for (int i = 1; i <= 8; i++)
        {
            try
            {
                TopoNetwork netSub = new TopoNetwork(new StringBuffer("Net" +
                    i));
                netSub.setX(386);
                netSub.setY((i-1) * 160);
                tds.addTopoData(netSub);

                for (int z = 1; z <= 8; z++)
                {

                    TopoNode node1 = new TopoNode(new StringBuffer("NodeA" +
                        z +
                        "_" + netSub.toString()));
                    node1.setX(68);
                    node1.setY(z * 60);

                    TopoNode node2 = new TopoNode(new StringBuffer("NodeZ" +
                        z +
                        "_" + netSub.toString()));
                    node2.setX(386);
                    node2.setY(z * 60);

                    TopoLink link = new TopoLink(new StringBuffer("" +
                        NMSExample.getNum()), node1, node2);
                    tds.addTopoData(node1, netSub);
                    tds.addTopoData(node2, netSub);
                    tds.addTopoData(link, netSub);

                } //
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        } //for


        //JOptionPane.showMessageDialog(TopoGraphView.getContextGraphView(), "批量添加结束", "通知",
        //                              JOptionPane.INFORMATION_MESSAGE);

    }

    public ActionBatchAddNodeTest()
    {
        super("拓扑图批量添加");
    }
}
