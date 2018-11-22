/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: myquartz
 * Author:   zhaomlb
 * Date:     2018/10/31 11:33
 * Description: 测试定时器
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/31    11:33           版本号              描述
 */
package quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈功能描述:测试定时器〉
 *
 * @author zhaomlb
 * @create 2018/10/31
 * @since 1.0.0
 */
public class myquartz {

    @Autowired
    private  Scheduler scheduler;
    public void test() {
        try {

            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
 