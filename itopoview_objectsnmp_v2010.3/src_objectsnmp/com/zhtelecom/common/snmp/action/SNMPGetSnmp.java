package com.zhtelecom.common.snmp.action;
import java.awt.event.*;

import com.l2fprod.common.beans.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.snmp.mib.MibSNMP;

public class SNMPGetSnmp extends SNMPBaseAction
{

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            SNMPTarget target = getTarget();
            MibBeanInfo beaninfo = new MibBeanInfo();
            SNMPSheetDialog dialog = new SNMPSheetDialog(getFrame(), false, false, true, beaninfo);
            dialog.setTitle(getTitle());

            MibSNMP mib = new MibSNMP();
            dialog.initObject(target, mib);
            dialog.processFresh();
            dialog.setSize(400, 360);

            DialogTools.dialogPack(getFrame(), dialog);
        } catch (Exception ex)
        {
            DialogTools.showErroMsgFromEx(getFrame(), getErroTitle(), ex);
        }

    }

    public SNMPGetSnmp()
    {
        super("查看SNMP代理状态");
    }

    public static class MibBeanInfo extends BaseBeanInfo
    {

        public MibBeanInfo()
        {
            super(MibSNMP.class);
            addProperty("snmpInPkts").setReadOnly().setDisplayName("接收到的SNMP请求数量：");
            addProperty("snmpOutPkts").setReadOnly().setDisplayName("回复的SNMP应答数量：");
            addProperty("snmpOutTraps").setReadOnly().setDisplayName("发起的Trap消息通知数量：");
            addProperty("snmpInBadCommunityNames").setReadOnly().setDisplayName("接收到错误的共同体请求数量：");
            addProperty("snmpInNoSuchNames").setReadOnly().setDisplayName("接收到不存在OID的请求数量：");
            addProperty("snmpInASNParseErrs").setReadOnly().setDisplayName("接收到的错误语法请求数量：");
            addProperty("snmpInTooBigs").setReadOnly().setDisplayName("接收到超长包的请求数量：");
            addProperty("snmpInBadValues").setReadOnly().setDisplayName("接收到错误OID值的请求数量：");

        }
    }

    public static void main(String args[])
    {
        try
        {
            SNMPFactory.init(SNMPFactory.Mode_Local, null);
            SNMPGetSnmp action = new SNMPGetSnmp();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
