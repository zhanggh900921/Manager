package com.zhtelecom.common.snmp.action;

import java.awt.event.*;

import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;

public class SNMPGetIPAddr extends SNMPBaseAction
{
    public SNMPGetIPAddr()
    {
        super("查看IP地址信息");
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
                        {"IP地址", "接口编号",
                        "子网掩码", "IP包最大长度"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibIPAddrEntry table = (MibIPAddrEntry) obj;
                    Object[] viDatas =
                        {table.getIpAdEntAddr(), new Integer(table.getIpAdEntIfIndex()),
                        table.getIpAdEntNetMask(), new Integer(table.getIpAdEntReasmMaxSize())
                    };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibIPAddrEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(600, 300);

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
            SNMPGetIPAddr action = new SNMPGetIPAddr();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
