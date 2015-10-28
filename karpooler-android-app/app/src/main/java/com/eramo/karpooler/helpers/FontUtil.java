package com.eramo.karpooler.helpers;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Mohamed.Gaber on 7/21/2015.
 */
public class FontUtil {

    public final static int MONTSERRAT_REGULAR = 1;
    public final static int MONTSERRAT_LIGHT = 2;
    public final static int MONTSERRAT_BOLD = 3;

    public static Typeface getFont(Context context, int fontType) {

        Typeface typeface;
        String fontFilePath = "";

        switch (fontType){

            case 1:
                fontFilePath = "fonts/Montserrat-Regular.ttf";
                break;

            case 2:
                fontFilePath = "fonts/Montserrat-Light.otf";
                break;

            case 3:
                fontFilePath = "fonts/Montserrat-Bold.otf";
                break;

        }

        typeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), fontFilePath);

        return typeface;
    }

}
