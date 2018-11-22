/**
 * Copyright (C), 2018,  有限公司
 * FileName: BenanAnnotation
 * Author:   zhaomlb
 * Date:     2018/11/22 14:09
 * Description:
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/11/22    14:09           版本号              描述
 */

import org.springframework.context.annotation.Bean;

/**
 * 〈功能描述:〉
 *
 * @author zhaomlb
 * @create 2018/11/22
 * @since 1.0.0
 */

public interface BenanAnnotation {
    @Bean
    default String main() {

        return "";

    }
}
 