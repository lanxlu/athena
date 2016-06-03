/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午3:08:31
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年4月27日        Initailized
 */
package cn.com.sand.frame.athena.annotation;

import java.util.Set;

import cn.com.sand.frame.athena.util.ScanPackage;

/**
 *
 * @ClassName ：ScanAnnotation
 * @author : SJ
 * @Date : 2016年4月27日 下午3:08:31
 * @version 1.0.0
 *
 */
public class ScanAnnotation
{
    private static ScanAnnotation instance;
    private static ScanPackage    scanPackage;

    public static ScanAnnotation init()
    {
        if (instance == null)
        {
            instance = new ScanAnnotation();
        }
        return instance;
    }

    private ScanPackage getScan()
    {
        if (scanPackage == null)
        {
            scanPackage = new ScanPackage(true, true, null);
        }
        return scanPackage;
    }

    public Set<Class<?>> scan(String packPath)
    {
        return getScan().getPackageAllClasses(packPath, true);
    }
}
