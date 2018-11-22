/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: myjop
 * Author:   zhaomlb
 * Date:     2018/10/31 15:18
 * Description: job实现
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/31    15:18           版本号              描述
 */
package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 〈功能描述:job实现〉
 *
 * @author zhaomlb
 * @create 2018/10/31
 * @since 1.0.0
 */
public class myjop implements Job {

    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     * <p>
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @param context
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getTrigger().getJobKey());
        System.out.println(context.getJobDetail().getKey());
        System.out.println(context.getJobRunTime());
    }
}
 