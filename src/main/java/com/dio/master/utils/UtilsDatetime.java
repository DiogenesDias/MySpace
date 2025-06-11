package com.dio.master.utils;

import java.time.LocalDateTime;

public class UtilsDatetime {

    public static String dateTimeNOW_serverFormat() {
        /**/
        return LocalDateTime.now().format(UtilsObjects.formatterLocaldatetimeServer());
    }

}