/**
 * Copyright : http://www.sandpay.com.cn , 2016年4月27日
 * Project : athena
 * $Id$
 * $Revision$
 * Last Changed by SJ at 2016年4月27日 下午3:55:10
 * $URL$
 *
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * SJ         2016年4月27日        Initailized
 */
package cn.com.sand.frame.athena.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.com.sand.component.discover.zookeeper.core.URL;

/**
 *
 * @ClassName ：AnnotationHelp
 * @author : SJ
 * @Date : 2016年4月27日 下午3:55:10
 * @version 1.0.0
 *
 */
public class AnnotationHelp
{
    public static List<URL> getUrls(String packPath)
    {
        List<URL> urList = new ArrayList<URL>();
        Set<Class<?>> clazzs = ScanAnnotation.init().scan(packPath);
        for (Class<?> clazz : clazzs)
        {
            URL url = ParseAnnotation.parse(clazz);
            if(url != null)
            {
                urList.add(url);
            }
        }
        return urList;
    }
}
