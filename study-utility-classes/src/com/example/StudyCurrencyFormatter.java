package com.example;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyCurrencyFormatter {
    public static void main(String[] args) {
        double money = 1_234_567.89;
        Locale tr = new Locale("tr","TR");
        DecimalFormat df = (DecimalFormat)
                DecimalFormat.getCurrencyInstance(Locale.CHINA);
        /*
        DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(tr);
        dfs.setCurrencySymbol("\u20BA");
        df.setDecimalFormatSymbols(dfs);
        */

        System.out.println(df.format(money));
    }
}
