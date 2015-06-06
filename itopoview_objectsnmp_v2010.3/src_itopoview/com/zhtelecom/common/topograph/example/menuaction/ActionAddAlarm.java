package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoObject;
import com.zhtelecom.common.topograph.example.NMSExample;

public class ActionAddAlarm extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {
        //之前已被赋值，这里获取该拓扑对象。也可以通过TopoGraphView.getContextGraphView()快速获取唯一实例。
        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");

        String rs = JOptionPane.showInputDialog(topoView,
            "请输入要添加的告警对象的级别(0,1,2,3,4,5,6),0-最低，6-最高");
        if (rs == null || rs.equals(""))
        {
            rs = "2";
        }

        int level = Integer.parseInt(rs);
        TopoObject obj = topoView.getSelectedObject();
        obj.addAlarm("告警" + NMSExample.getNum(), level);
    }

    public ActionAddAlarm()
    {
        super("添加告警");
    }
}
