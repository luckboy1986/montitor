/**
 * Copyright (C), 2018,  zml有限公司
 * FileName: strategyenum
 * Author:   zhaomlb
 * Date:     2018/10/25 21:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * zhaomlb           21:25           版本号              描述
 */

import strategy.aistrategy;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author zhaomlb
 * @create 2018/10/25
 * @since 1.0.0
 */
public enum strategyenum {
    POCREATE("myaistrategy", aistrategy.class);
    private String key;
    private Class cla;


    strategyenum(String key, Class c) {
        this.key = key;
        this.cla = c;
    }

    public String getKey() {
        return this.key;
    }

    public Class getCl() {
        return this.cla;
    }

   public static strategyenum getBykey(String key) {
        for (strategyenum s : strategyenum.values()) {
            if (s.key.equals(key)) {
                return s;
            }
        }
        return null;
    }

}

