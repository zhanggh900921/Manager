package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoNetwork;
import com.zhtelecom.common.topograph.example.NMSExample;

public class ActionNetworkAdd extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        TopoNetwork network = new TopoNetwork(new StringBuffer("network" +
            NMSExample.getNum()));
        TopoNetwork  parent=topoView.getCurrentNetwork();
        if(parent==null)
        {
            topoView.getTopoDataSource().addTopoData(network);
        }
        else
        {
            topoView.getTopoDataSource().addTopoData(network,parent);

        }

    }

    public ActionNetworkAdd()
    {
        super("Ìí¼ÓÍøÂç");
    }

}
