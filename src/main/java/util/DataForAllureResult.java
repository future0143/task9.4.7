package util;

import com.codeborne.selenide.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataForAllureResult {

    public static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String getCurrentBrowser() {
        return Configuration.browser = "chrome";
    }
}