package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoLink;
import com.zhtelecom.common.topograph.example.NMSExample;

public class ActionSetLinkEnd extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");

        topoView.setLinkTarget(topoView.getSelectedNode());
        if (topoView.getLinkSource() != null && topoView.getLinkTarget() != null)
        {
            TopoLink link = new TopoLink(new StringBuffer("link+" +
                NMSExample.getNum()), topoView.getLinkSource(),
                                         topoView.getLinkTarget());
            topoView.getTopoDataSource().addTopoData(link,
                topoView.getCurrentNetwork());
            topoView.clearLinkMarked();
        }

    }

    public ActionSetLinkEnd()
    {
        super("设置连接终点");
    }
}
