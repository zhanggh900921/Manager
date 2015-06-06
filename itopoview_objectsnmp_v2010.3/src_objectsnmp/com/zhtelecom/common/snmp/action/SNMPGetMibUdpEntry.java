package com.zhtelecom.common.snmp.action;
import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;

public class SNMPGetMibUdpEntry extends SNMPBaseAction
{
    public SNMPGetMibUdpEntry()
    {
        super("²é¿´UDPÕìÌý×´Ì¬");
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
                        {"UDPÕìÌýµØÖ·", "UDPÕìÌý¶Ë¿Ú"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibUDPEntry table = (MibUDPEntry) obj;
                    Object[] viDatas =
                        {
                          table.getUdpLocalAddress(),new Integer(table.getUdpLocalPort())
                       };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibUDPEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(500, 500);
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
            SNMPGetMibUdpEntry action = new SNMPGetMibUdpEntry();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
