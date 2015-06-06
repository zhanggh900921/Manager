package com.zhtelecom.common.snmp.test;

import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;

/**
 * 测试RFC1213-MIB和HostResoure的数据获取。
 * 在Windows XP上启用SNMP Agent服务后，可执行此测试。
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class GetObjectTest
{
    SNMPAPI snmpapi;

    SNMPTarget nodeParam;

    public GetObjectTest()
    {
        try
        {
            /**
             * 初始化系统日志文件。
             */
            MyLog.initLogParam("SNMPTest");
            //使用客户端模式。需要先启用ObjectSNMP的RMI服务（例如：运行RMISNMPServer.java）。
            //SNMPFactory.init(SNMPFactory.Mode_Client, "127.0.0.1");

            //使用本地模式。
            SNMPFactory.init(SNMPFactory.Mode_Local, null);

            //默认已加载
            //SNMPFactory.loadMib("RFC1213-MIB");
            //SNMPFactory.loadMib("HOST-RESOURCES-MIB");

            // 获取SNMP API
            snmpapi = SNMPFactory.getSNMPAPI();

            //设置SNMP Agent连接参数
            nodeParam = new SNMPTarget();
            nodeParam.nodeIP = "127.0.0.1";
            nodeParam.port = 161;

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    /**
     * 测试从MIB组获取数据
     */
    public void testGetMibGroup(Object mib)
    {
        try
        {

            Object mibobj = snmpapi.getMibObject(mib, nodeParam);
            System.out.println(mib.getClass());
            System.out.println(mibobj);
            System.out.println("--------------");
        } catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }

    /**
     * 测试从MIB表获取数据
     */
    public void testGetMibTable(Class tableclass)
    {
        try
        {

            java.util.List list = snmpapi.getAllTableData(tableclass,
                nodeParam);

            System.out.println(tableclass + " 表数据个数：" + list.size());
            for (int i = 0; i < list.size(); i++)
            {
                Object mibobj = list.get(i);
                System.out.println(mibobj);
            }
            System.out.println("--------------");

        } catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }

    /**
     * 在本机测试从windows xp的SNMP Agent查询数据。（参见如何启动xp的SNMP Agent服务）
     * @param args String[]
     */
    public static void main(String args[])
    {
        try
        {

            GetObjectTest test = new GetObjectTest();

            //获取RFC1213-MIB中数据
            test.testGetMibGroup(new MibSystem());
            test.testGetMibTable(MibIfEntry.class);
            test.testGetMibGroup(new MibIP());
            test.testGetMibTable(MibIPAddrEntry.class);
            test.testGetMibTable(MibIPRouterEntry.class);
            test.testGetMibTable(MibTCPConnEntry.class);
            test.testGetMibTable(MibUDPEntry.class);
            test.testGetMibGroup(new MibSNMP());

            //获取Resource-Host中的数据
            test.testGetMibTable(MibDiskAndMemoEntry.class);
            test.testGetMibTable(MibDeviceEntry.class);
            test.testGetMibTable(MibProcessorEntry.class);
            test.testGetMibTable(MibSoftwareRunEntry.class);
            test.testGetMibTable(MibSoftwareInstallEntry.class);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
