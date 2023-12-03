package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Enric
 */
public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    public static String format(Date date) {
        return DATE_FORMAT.format(date);
    }
}
