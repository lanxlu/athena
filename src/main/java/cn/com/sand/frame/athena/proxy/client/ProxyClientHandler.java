/**
 * Copyright : http://www.sandpay.com.cn , 2016年5月11日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年5月11日 下午2:16:36
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年5月11日        Initailized
 */
package cn.com.sand.frame.athena.proxy.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import cn.com.sand.frame.athena.rpc.AthenaClientHandler;
import cn.com.sand.frame.athena.rpc.idl.AthenaRequest;
import cn.com.sand.frame.athena.rpc.idl.AthenaResponse;
import cn.com.sand.frame.athena.util.IdGenHelper;

/**
 *
 * @ClassName ：ProxyClientHandler
 * @author : SJ
 * @Date : 2016年5月11日 下午2:16:36
 * @version 1.0.0
 *
 */
public class ProxyClientHandler implements InvocationHandler
{
    /*
     * (non-Javadoc)
     *
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
     * java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        String interfaceName = method.getDeclaringClass().getName();
        String methodName = method.getName();
        Class<?>[] paramTypes = method.getParameterTypes();
        Class<?> returnType = method.getReturnType();
        List<String> typs = Lists.newArrayList();
        for (int i = 0; i < paramTypes.length; i++)
        {
            typs.add(paramTypes[i].getName());
        }
        AthenaRequest request = new AthenaRequest();
        request.setInterfaceName(interfaceName);
        request.setMethodName(methodName);
        request.setResultType(returnType.getName());
        request.setTraceId(IdGenHelper.getTraceId());
        List<String> vals = Lists.newArrayList();
        for (int i = 0; i < args.length; i++)
        {
            vals.add(JSONObject.toJSONString(args[i],false));
        }
        request.setParamValues(vals);
        request.setParamTypes(typs);
        AthenaClientHandler handler = new AthenaClientHandler(interfaceName);
        AthenaResponse response = handler.doHandle(request);
        return JSONObject.parseObject(response.getData(), returnType);
    }

}
