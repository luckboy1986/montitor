package controller; /**
 * Copyright (C), 2018,  有限公司
 * FileName: VelocityCOntroller
 * Author:   zhaomlb
 * Date:     2018/11/22 16:30
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/22    16:30           版本号              描述
 */

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
    public ModelAndView tem(Model model) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("screen_content", "1111111111");

        mav.setViewName("v1");
        return mav;
    }
}
 