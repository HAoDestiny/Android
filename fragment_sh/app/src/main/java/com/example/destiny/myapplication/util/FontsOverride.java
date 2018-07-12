package com.example.destiny.myapplication.util;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * created by DESTINY on 2018/7/12
 */

public final class FontsOverride {

    public static void setDefaultFont(Context context, String staticTypefaceFieldName, String fontAssetName) {

        final Typeface regular = Typeface.createFromAsset(context.getAssets(), fontAssetName);

        replaceFont(staticTypefaceFieldName, regular);
    }

    protected static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
        try {

            final Field staticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);

            staticField.setAccessible(true);
            staticField.set(null, newTypeface);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
