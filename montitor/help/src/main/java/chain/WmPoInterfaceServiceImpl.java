/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: WmPoInterfaceCheckServiceImpl
 * Author:   zhaomlb
 * Date:     2018/10/30 19:25
 * Description: 校验
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/30    19:25           版本号              描述
 */
package chain;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈功能描述:校验〉
 *
 * @author zhaomlb
 * @create 2018/10/30
 * @since 1.0.0
 */
@Component("WmPoInterfaceServiceImpl")
public class WmPoInterfaceServiceImpl extends AbstractInterfaceStatusService<WmInterfaceStatusInput, ResultDto> {


    @Resource(name = "WmPoInterfaceStatusServiceImpl")
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
    public void collectdata(WmInterfaceStatusInput wmInterfaceStatusInput, ResultDto resultDto) throws InterruptedException {

        //校验是否存在当前配置节点，如果不存在,throw InterruptedException
    }

}
 