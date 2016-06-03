/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月10日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月10日 下午1:39:54
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月10日        Initailized
 */
package cn.com.sand.frame.athena.rpc;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.thrift.TException;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import cn.com.sand.frame.athena.proxy.service.ProxyCache;
import cn.com.sand.frame.athena.rpc.idl.AthenaRequest;
import cn.com.sand.frame.athena.rpc.idl.AthenaResponse;
import cn.com.sand.frame.athena.rpc.idl.AthenaServiceException;
import cn.com.sand.frame.athena.util.IdGenHelper;

/**
 *
 * @ClassName ：AthenaServiceHandler
 * @author : SJ
 * @Date : 2016年5月10日 下午1:39:54
 * @version 1.0.0
 *
 */
public class AthenaServiceHandler implements cn.com.sand.frame.athena.rpc.idl.AthenaService.Iface
{

    /*
     * (non-Javadoc)
     *
     * @see
     * cn.com.sand.component.rpc.thrift.idl.McService.Iface#call(cn.com.sand
     * .component.rpc.thrift.idl.McRequest)
     */
    @Override
    public AthenaResponse call(AthenaRequest request) throws AthenaServiceException, TException
    {
        try
        {
            String interfaceName = request.getInterfaceName();
            Class<?> clazz = Class.forName(interfaceName, true, this.getClass().getClassLoader());
            String traceId = request.getTraceId();
            IdGenHelper.setTraceId(traceId);
            String methodName = request.getMethodName();
            String returnType = request.getResultType();
            
            List<String> paramTypes = request.getParamTypes();
            List<String> paramValues = request.getParamValues();
            List<Object> values = Lists.newArrayList();
            Class<?>[] cArg = new Class[paramTypes.size()];
            for (int i = 0; i < paramTypes.size(); i++)
            {
                cArg[i] = Class.forName(paramTypes.get(i));
                values.add(JSONObject.parseObject(paramValues.get(i), cArg[i]));
            }
            Method method = clazz.getMethod(methodName, cArg);
            String clazzName = ProxyCache.init().get(interfaceName);
            
            Object resp = method.invoke(Class.forName(clazzName).newInstance(), values.toArray());
            AthenaResponse rep = new AthenaResponse();
            rep.setData(JSONObject.toJSONString(resp));
            return rep;
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
