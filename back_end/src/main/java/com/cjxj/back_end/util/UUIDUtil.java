package com.cjxj.back_end.util;

import java.util.UUID;

/**
 *
 * @author cjxjzzz
 * @since 2022-06-25
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
