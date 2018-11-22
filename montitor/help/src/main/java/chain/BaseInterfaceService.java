/**
 * Copyright (C), 2018, zml有限公司
 * FileName: BaseInterfaceService
 * Author:   zhaomlb
 * Date:     2018/10/30 16:12
 * Description: 责任链
 * History:
 * <author>          <time>          <version>          <desc>
 * zhaomlb           16:12           版本号              描述
 */
package chain;

/**
 * 〈功能简述〉
 * 〈责任链〉
 *
 * @author zhaomlb
 * @create 2018/10/30
 * @since 1.0.0
 */
public interface BaseInterfaceService<T, R>  {
    /***
     * 数据校验
     * @param t
     * @return
     */
    R excute(T t);

    /***
     * 抽取数据
     * @param t
     * @return
     */
    R collectdata(T t);
}
