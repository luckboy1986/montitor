/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: ResultDto
 * Author:   zhaomlb
 * Date:     2018/10/30 16:56
 * Description: 返回
 * History:
 * <author>           <DATE>     <time>          <version>          <desc>
 * zhaomlb           2018/10/30    16:56           版本号              描述
 */
package chain;

import java.io.Serializable;

/**
 * 〈功能描述:返回〉
 *
 * @author zhaomlb
 * @create 2018/10/30
 * @since 1.0.0
 */
public class ResultDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String resultMessage;


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
 