package strategy; /**
 * Copyright (C), 2018,  zml有限公司
 * FileName: strategy.bistrategy
 * Author:   zhaomlb
 * Date:     2018/10/25 21:23
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/25    21:23           版本号              描述
 */

import org.springframework.stereotype.Component;

/**
 * 〈功能描述:〉
 *
 * @author zhaomlb
 * @create 2018/10/25
 * @since 1.0.0
 */
@Component("mybistrategy")
public class bistrategy implements istrategy {
    @Override
    public void test() {
        System.out.println(this.getClass().getName());
    }
}
 