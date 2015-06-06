package com.zhtelecom.common.topograph.example.menuaction;

import javax.swing.AbstractAction;
import com.zhtelecom.common.topograph.TopoGraphView;
import java.awt.event.ActionEvent;

import com.zhtelecom.common.topograph.TopoNode;

public class ActionPrintXY extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {
        //之前已被赋值，这里获取该拓扑对象。也可以通过TopoGraphView.getContextGraphView()快速获取唯一实例。
        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        java.util.Vector rs= topoView.getTopoDataSource().getAllTopoNode();
        for(int i=0;i<rs.size();i++)
        {
            TopoNode node=(TopoNode) rs.get(i);
            System.out.println(""+node+":X="+node.getX()+", Y="+node.getY());
        }
    }

    public ActionPrintXY()
    {
        super("打印所有节点坐标");
    }
}
