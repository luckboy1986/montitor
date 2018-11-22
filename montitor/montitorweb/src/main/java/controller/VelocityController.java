/**
 * Copyright (C), 2018,  有限公司
 * FileName: VelocityCOntroller
 * Author:   zhaomlb
 * Date:     2018/11/22 16:30
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/22    16:30           版本号              描述
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈功能描述:〉
 *
 * @author zhaomlb
 * @create 2018/11/22
 * @since 1.0.0
 */
@Controller
@RequestMapping
public class VelocityController {

    @RequestMapping("/map")
    public String tem() {
        return "views/default";
    }
}
 