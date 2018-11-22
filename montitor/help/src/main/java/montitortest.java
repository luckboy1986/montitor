/**
 * Copyright (C), 2018,  lucky有限公司
 * FileName: montitortest
 * Author:   zhaomlb
 * Date:     2018/10/18 16:35
 * Description: 测试主入口
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/18    16:35           版本号              描述
 */

import com.dg.zy.qmmd5.QmMd5Service;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import quartz.myjop;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;


/**
 * 〈功能描述:测试主入口〉
 *
 * @author zhaomlb
 * @create 2018/10/18
 * @since 1.0.0
 */

@ComponentScan(value = {"strategy", "chain"})
public class montitortest {

    public static void main(String[] args) {


        // strategyenum.POCREATE.getCl() t1=Ap
     /*   AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("strategy");
        annotationConfigApplicationContext.refresh();
        istrategy i1 = (istrategy) annotationConfigApplicationContext.getBean(strategyenum.getBykey("myaistrategy").getKey());
        i1.test();
        istrategy i2 = (istrategy) annotationConfigApplicationContext.getBean("mybistrategy");
        i2.test();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(montitortest.class);

        InterfaceStatusService istatus = (InterfaceStatusService) applicationContext.getBean("WmPoInterfaceCheckServiceImpl");
        WmInterfaceStatusInput wmInterfaceStatusInput = new WmInterfaceStatusInput();
        ResultDto resultDto = new ResultDto();*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:quartz.xml");
        SchedulerFactoryBean schedulerFactoryBean = (SchedulerFactoryBean) applicationContext.getBean(SchedulerFactoryBean.class);

        System.out.println(schedulerFactoryBean.getScheduler().hashCode());
        System.out.println(schedulerFactoryBean.getScheduler().hashCode());

        try {

            JobDetail jobDetail = JobBuilder.newJob(myjop.class).withIdentity("myjob1", "g1").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myjob1", "g1")
                    .startNow().withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();
            schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, trigger);
            System.out.println(schedulerFactoryBean.getScheduler().isStarted());
            schedulerFactoryBean.getScheduler().start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    /*    try {
            istatus.excute(wmInterfaceStatusInput, resultDto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

      /*  istrategy i3 = (istrategy) applicationContext.getBean("mybistrategy");
        i3.test();*/
    }
}
 