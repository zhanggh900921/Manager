package com.zhtelecom.common.snmp.action;

import java.awt.event.*;

import com.l2fprod.common.beans.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;

public class SNMPGetIP extends SNMPBaseAction
{

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            SNMPTarget target = getTarget();
            MibBeanInfo beaninfo = new MibBeanInfo();
            SNMPSheetDialog dialog = new SNMPSheetDialog(getFrame(), false, false, true, beaninfo);
            dialog.setTitle(getTitle());

            MibIP mib = new MibIP();
            dialog.initObject(target, mib);
            dialog.processFresh();
            dialog.setSize(400, 460);

            DialogTools.dialogPack(getFrame(), dialog);
        } catch (Exception ex)
        {
            DialogTools.showErroMsgFromEx(getFrame(), getErroTitle(), ex);
        }

    }

    public SNMPGetIP()
    {
        super("查看IP数据包状态");
    }

    public static class MibBeanInfo extends BaseBeanInfo
    {

        public MibBeanInfo()
        {
            super(MibIP.class);
            addProperty("ipInReceives").setReadOnly().setDisplayName("所有接收到的IP包数量：");
            addProperty("ipInDelivers").setReadOnly().setDisplayName("成功处理的接收包数量：");
            addProperty("ipInHdrErrors").setReadOnly().setDisplayName("收到IP头错误的包数量：");
            addProperty("ipInAddrErrors").setReadOnly().setDisplayName("收到地址错误的包数量：");
            addProperty("ipForwDatagrams").setReadOnly().setDisplayName("接收并路由转发的包数量：");
            addProperty("ipInDiscards").setReadOnly().setDisplayName("直接丢弃的接收包数量：");

            addProperty("ipOutRequests").setReadOnly().setDisplayName("全部发送的IP包数量：");
            addProperty("ipOutDiscards").setReadOnly().setDisplayName("直接丢弃的发送包数量：");
            addProperty("ipOutNoRoutes").setReadOnly().setDisplayName("丢失路由的发送包数量：");

            addProperty("ipReasmReqds").setReadOnly().setDisplayName("接收到的分片IP包数量：");
            addProperty("ipFragOKs").setReadOnly().setDisplayName("成功分片的IP包数量：");

        }
    }

    public static void main(String args[])
    {
        try
        {
            SNMPFactory.init(SNMPFactory.Mode_Local, null);
            SNMPGetIP action = new SNMPGetIP();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
