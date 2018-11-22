/**
 * Copyright (C), 2018,  有限公司
 * FileName: OnlineCounter
 * Author:   zhaomlb
 * Date:     2018/11/20 20:29
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/20    20:29           版本号              描述
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 〈功能描述:〉 
 *
 * @author zhaomlb
 * @create 2018/11/20
 * @since 1.0.0
 */
public class OnlineCounter {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void rize() {
          count.incrementAndGet();
    }

    public static void reduce() {
        count.decrementAndGet();
    }
}
 