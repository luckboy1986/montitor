/**
 * Copyright (C), 2018,  lucky有限公司
 * FileName: mylock
 * Author:   zhaomlb
 * Date:     2018/10/18 16:39
 * Description: 测试lock
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/18    16:39           版本号              描述
 */
package lockhelp;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈功能描述:测试lock〉
 *
 * @author zhaomlb
 * @create 2018/10/18
 * @since 1.0.0
 */
public class mylock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    public static int a = 0;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    @Override
    public  void run() {
        for (int i = 0; i < 10; i++) {
           //lock.lock();
            try {
                synchronized(this) {
                    Thread.sleep(100L);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(a++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
              //  lock.unlock();
            }
        }
    }
}
 