/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: InterfaceStatusService
 * Author:   zhaomlb
 * Date:     2018/10/30 16:13
 * Description: 装填抽象类
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/30    16:13           版本号              描述
 */
package chain;

/**
 * 〈功能描述:装填抽象类〉
 *
 * @author zhaomlb
 * @create 2018/10/30
 * @since 1.0.0
 */
public abstract class AbstractInterfaceStatusService<I, R> {
    /***
     * 链式结构：状态，确认
     */
    private AbstractInterfaceStatusService next;

    public void setNext(AbstractInterfaceStatusService next) {
        this.next = next;
    }

    public void excute(I i, R r)throws InterruptedException {
        collectdata(i, r);
        //状态报文写总线
        if (next != null) {
            next.excute(i, r);
        }
        //确认报文写总线
    }

    /***
     * 抽取数据
     * @param i
     * @param r
     * @throws InterruptedException
     */
    public abstract void collectdata(I i, R r)throws InterruptedException;


}
 