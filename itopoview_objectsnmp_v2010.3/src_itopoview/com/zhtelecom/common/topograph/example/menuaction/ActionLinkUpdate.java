package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoLink;


public class ActionLinkUpdate extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        TopoLink obj = topoView.getSelectedLink();

        //设置宽度
        obj.setLinkWidth(3);

        //设置转折线
        obj.setStraight(false);

        //设置虚线
        obj.setBrokenLink(true);

        //设置箭头
        obj.setShowArrow(false);

    }



    public ActionLinkUpdate()
    {
        super("改变Link风格");
    }
}
