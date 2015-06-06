package com.zhtelecom.common.snmp.test;

import com.zhtelecom.common.snmp.*;

/**
 * 自动生成O-M Mapping代码。
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class GenJavaCode
{
    public static void main(String args[])
    {
        String packageName = "com.zhtelecom.common.snmp.mib";
        String srcCodeDirectory = "F:/networkmanager/src/src_common/com/zhtelecom/common/snmp/mib/";
        GenJavaCodeTool.setJavaCodeDirectory(srcCodeDirectory, packageName);

        //RFC1213中重要的MIB
        GenJavaCodeTool.genJavaCode("MibSystem", "1.3.6.1.2.1.1");
        GenJavaCodeTool.genJavaCode("MibIfEntry", "1.3.6.1.2.1.2.2.1");
        GenJavaCodeTool.genJavaCode("MibIP", "1.3.6.1.2.1.4");
        GenJavaCodeTool.genJavaCode("MibTCPConnEntry", "1.3.6.1.2.1.6.13.1");
        GenJavaCodeTool.genJavaCode("MibUDPEntry", "1.3.6.1.2.1.7.5.1");
        GenJavaCodeTool.genJavaCode("MibSNMP", "1.3.6.1.2.1.11");
        GenJavaCodeTool.genJavaCode("MibIPAddrEntry", "1.3.6.1.2.1.4.20.1");
        GenJavaCodeTool.genJavaCode("MibIPRouterEntry", "1.3.6.1.2.1.4.21.1");

        //Host-Resoure中重要的MIB
        GenJavaCodeTool.genJavaCode("MibDiskAndMemoEntry", "1.3.6.1.2.1.25.2.3.1");
        GenJavaCodeTool.genJavaCode("MibDeviceEntry", "1.3.6.1.2.1.25.3.2.1");
        GenJavaCodeTool.genJavaCode("MibProcessorEntry", "1.3.6.1.2.1.25.3.3.1");
        GenJavaCodeTool.genJavaCode("MibSoftwareRunEntry", "1.3.6.1.2.1.25.4.2.1");
        GenJavaCodeTool.genJavaCode("MibSoftwareInstallEntry", "1.3.6.1.2.1.25.6.3.1");

        //默认加载了RFC1213和Host-Resoure
        try
        {
            SNMPFactory.loadMib("OSPF-MIB");
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //ospf（用于测试表的添加、删除、修改）
        GenJavaCodeTool.genJavaCode("MibOspfStubAreaEntry", "1.3.6.1.2.1.14.3.1");

    }
}
