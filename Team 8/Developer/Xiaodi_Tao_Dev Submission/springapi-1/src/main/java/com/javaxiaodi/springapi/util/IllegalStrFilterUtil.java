package com.javaxiaodi.springapi.util;

import org.slf4j.LoggerFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Xiaodi Tao
 * @className: IllegalStrFilterUtil
 * @packageName: util
 * @description: This class is used for intercept potential SQL Injection input
 * @data: 2019-10-25
 **/
public class IllegalStrFilterUtil {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IllegalStrFilterUtil.class);

    private static final String REGX = "!|！|@|◎|#|＃|(\\$)|￥|%|％|(\\^)|……|(\\&)|※|(\\*)|×|(\\()|（|(\\))|）|_|——|(\\+)|＋|(\\|)|§ ";

    // Intercept the SQL Injection, return true means it doesn't have the threat of SQL Injection,
    // false otherwise
    public static Boolean sqlStrFilter(String sInput) {
        if (sInput == null || sInput.trim().length() == 0) {
            return false;
        }
        sInput = sInput.toUpperCase();

        if (sInput.indexOf("DELETE") >= 0 || sInput.indexOf("ASCII") >= 0 || sInput.indexOf("UPDATE") >= 0 || sInput.indexOf("SELECT") >= 0
                || sInput.indexOf("'") >= 0 || sInput.indexOf("SUBSTR(") >= 0 || sInput.indexOf("COUNT(") >= 0 || sInput.indexOf(" OR ") >= 0
                || sInput.indexOf(" AND ") >= 0 || sInput.indexOf("DROP") >= 0 || sInput.indexOf("EXECUTE") >= 0 || sInput.indexOf("EXEC") >= 0
                || sInput.indexOf("TRUNCATE") >= 0 || sInput.indexOf("INTO") >= 0 || sInput.indexOf("DECLARE") >= 0 || sInput.indexOf("MASTER") >= 0) {
            Logger.error("The parameter has SQL Injection risk：sInput=" + sInput);
            return false;
        }
        Logger.info("SQL Injection test passed!");
        return true;
    }

    // Check if the input is legal, true means legal, false means illegal
    public static Boolean isIllegalStr(String sInput) {

        if (sInput == null || sInput.trim().length() == 0) {
            return false;
        }
        sInput = sInput.trim();
        Pattern compile = Pattern.compile(REGX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(sInput);
        Logger.info("The input is valid!");
        return matcher.find();
    }

}

