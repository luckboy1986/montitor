/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: WmPoInterfaceConfirmServiceImpl
 * Author:   zhaomlb
 * Date:     2018/10/30 17:08
 * Description: 入库确认
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/30    17:08           版本号              描述
 */
package chain;

import org.springframework.stereotype.Component;

/**
 * 〈功能描述:入库确认〉
 *
 * @author zhaomlb
 * @create 2018/10/30
 * @since 1.0.0
 */
@Component("WmPoInterfaceConfirmServiceImpl")
public class WmPoInterfaceConfirmServiceImpl extends AbstractInterfaceStatusService<WmInterfaceStatusInput, ResultDto> {

    /***
     * 抽取数据
     * @param wmInterfaceStatusInput
     * @param resultDto

     * @return
     */
    @Override
    public void collectdata(WmInterfaceStatusInput wmInterfaceStatusInput, ResultDto resultDto) throws InterruptedException{

        //当前节点如果需要回传确认数据，校验是否允许分批回传，如果允许，抽取数据回传，如果不允许判断是否已经全部入库完毕，之后按单回传
        System.out.println("入库确认");
    }


}
 