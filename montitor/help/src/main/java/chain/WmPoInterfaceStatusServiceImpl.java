/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: WmPoInterfaceStatusServiceImpl
 * Author:   zhaomlb
 * Date:     2018/10/30 17:02
 * Description: WM入库数据回传
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/30    17:02           版本号              描述
 */
package chain;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈功能描述:WM入库数据回传〉
 *
 * @author zhaomlb
 * @create 2018/10/30
 * @since 1.0.0
 */
@Component("WmPoInterfaceStatusServiceImpl")
public class WmPoInterfaceStatusServiceImpl extends AbstractInterfaceStatusService<WmInterfaceStatusInput, ResultDto> {

    @Resource(name = "WmPoInterfaceConfirmServiceImpl")
    @Override
    public void setNext(AbstractInterfaceStatusService next) {
        super.setNext(next);
    }

    /***
     * 抽取数据
     * @param wmInterfaceStatusInput
     * @param resultDto
     * @return
     */
    @Override
    public void collectdata(WmInterfaceStatusInput wmInterfaceStatusInput, ResultDto resultDto) throws InterruptedException{
        //直接收集状态，必填
        System.out.println("入库状态");
    }

}
 