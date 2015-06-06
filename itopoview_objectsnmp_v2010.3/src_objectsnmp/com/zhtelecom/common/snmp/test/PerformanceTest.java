package com.zhtelecom.common.snmp.test;

import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;

/**
 * 基础测试性能：1万个MIBSystem(7万个OID获取)时间<=5秒。(PC服务器)
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: zhtelecom.com</p>
 * @author lisl
 * @version 1.0
 */
public class PerformanceTest
{
    public static void main(String args[])
    {
        try
        {
            SNMPTarget target = new SNMPTarget();
            target.nodeIP = "127.0.0.1";
            SNMPFactory.init(SNMPFactory.Mode_Local, null);
            SNMPAPI snmpapi = SNMPFactory.getSNMPAPI();
            MibSystem mibsystem = new MibSystem();
            System.out.println("开始获取数据");
            long timeStart = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++)
            {
                Object obj = snmpapi.getMibObject(mibsystem, target);

            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("获取1万个MIBSystem的时间:" + (timeEnd - timeStart) / 1000 + "秒");
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
