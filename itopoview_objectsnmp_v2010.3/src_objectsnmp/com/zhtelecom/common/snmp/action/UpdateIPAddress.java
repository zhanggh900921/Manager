package com.zhtelecom.common.snmp.action;

import java.awt.event.*;
import javax.swing.*;

import com.zhtelecom.common.topograph.*;

public class UpdateIPAddress extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = TopoGraphView.getContextGraphView();
        TopoObject topoObject = topoView.getSelectedObject();
        String rs = JOptionPane.showInputDialog(topoView, "请输入新的IP地址");
        if (rs == null || rs.equals(""))
        {
            rs = "127.0.0.1";
        }
        StringBuffer userID = (StringBuffer) topoObject.getUserID();
        userID.replace(0, userID.length(), rs);

        //通知拓扑图，用户数据发生改变。
        topoObject.fireChanged();

    }

    public UpdateIPAddress()
    {
        super("修改IP地址");
    }
}
