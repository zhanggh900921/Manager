package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoNode;
import com.zhtelecom.common.topograph.example.NMSExample;
import com.zhtelecom.common.topograph.TopoNetwork;

public class ActionNodeAdd extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        TopoNode node = new TopoNode(new StringBuffer("node" +
            NMSExample.getNum()));

        TopoNetwork  parent=topoView.getCurrentNetwork();
            if(parent==null)
            {
                topoView.getTopoDataSource().addTopoData(node);
            }
            else
            {
                topoView.getTopoDataSource().addTopoData(node,parent);

            }

    }

    public ActionNodeAdd()
    {
        super("Ìí¼Ó½Úµã");
    }
}
