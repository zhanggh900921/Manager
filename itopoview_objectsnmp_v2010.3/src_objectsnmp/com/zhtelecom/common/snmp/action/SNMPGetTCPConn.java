package com.zhtelecom.common.snmp.action;

import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;

public class SNMPGetTCPConn extends SNMPBaseAction
{
    public SNMPGetTCPConn()
    {
        super("查看TCP连接状态");
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            ObjectTableDesc desc = new ObjectTableDesc()
            {
                public Object[] getcolumnNames()
                {
                    String[] cols =
                        {"TCP连接状态", "本地地址",
                        "本地TCP端口", "远端地址", "远端TCP端口"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibTCPConnEntry table = (MibTCPConnEntry) obj;
                    Object[] viDatas =
                        {
                        new Integer(table.getTcpConnState()), table.getTcpConnLocalAddress(),
                        new Integer(table.getTcpConnLocalPort()),
                        table.getTcpConnRemAddress(), new Integer(table.getTcpConnRemPort())
                    };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibTCPConnEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(600, 500);
            Value[] vs = new Value[12];
            vs[0] = new Value(new Integer(1), "closed");
            vs[1] = new Value(new Integer(2), "listen");
            vs[2] = new Value(new Integer(3), "synSent");
            vs[3] = new Value(new Integer(4), "synReceived");
            vs[4] = new Value(new Integer(5), "established");
            vs[5] = new Value(new Integer(6), "finWait1");
            vs[6] = new Value(new Integer(7), "finWait2");
            vs[7] = new Value(new Integer(8), "closeWait");
            vs[8] = new Value(new Integer(9), "lastAck");
            vs[9] = new Value(new Integer(10), "closing");
            vs[10] = new Value(new Integer(11), "timeWait");
            vs[11] = new Value(new Integer(12), "deleteTCB");

            dialog.table.setRendererKVType(0, vs);
            dialog.setTitle(getTitle());
            dialog.myInit(target, null, null);
            dialog.processQueryall();
            DialogTools.dialogPack(getFrame(), dialog);
        } catch (Exception ex)
        {
            DialogTools.showErroMsgFromEx(getFrame(), getErroTitle(), ex);
        }

    }

    public static void main(String[] ag)
    {
        try
        {
            SNMPFactory.init(SNMPFactory.Mode_Local, null);
            SNMPGetTCPConn action = new SNMPGetTCPConn();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
