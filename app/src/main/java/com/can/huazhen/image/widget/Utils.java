package com.can.huazhen.image.widget;

import android.content.Context;

/**
 * Created by CAN on 19-1-4.
 *
 */

class Utils {

    static int dp2px(Context context, float dp) {
        return (int) (getDensity(context) * dp + 0.5f);
    }

    static int sp2px(Context context, float sp) {
        return (int) (getFontDensity(context) * sp + 0.5f);
    }

    private static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static float getFontDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }
}
