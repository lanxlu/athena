/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014 Project :
 * multichannel-core-common-util $Id$ $Revision$ Last Changed by SJ at
 * 2015年11月3日 下午1:43:38 $URL$
 * 
 * Change Log Author Change Date Comments
 * ------------------------------------------------------------- SJ 2015年11月3日
 * Initailized
 */
package cn.com.sand.frame.athena.util;

/**
 *
 * @ClassName ：IdGenHelper
 * @author : SJ
 * @Date : 2015年11月3日 下午1:43:38
 * @version 2.0.0
 *
 */
public class IdGenHelper
{
    public synchronized static String createTraceId()
    {
        String traceId = String.valueOf(IdGen.get().nextId());
        Thread.currentThread().setName(traceId);
        return traceId;
    }

    public synchronized static String getTraceId()
    {
        return Thread.currentThread().getName();
    }

    public synchronized static void setTraceId(String traceId)
    {
        Thread.currentThread().setName(traceId);
    }

    public synchronized static String GetTraceId(String sysId)
    {
        return String.valueOf(IdGen.get().nextId()) + sysId;
    }

    public synchronized static String GetTraceId(String sysId, String traceId)
    {
        return traceId + sysId;
    }
}
