package com.example.mohamedramadan;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mohamed Ramadan on 26/01/2018.
 */

public class DataSaved {
    /**
     * save the size of the text view
     * @param context
     * @param value
     */
    public static void saveSize(Context context ,int value)
    {

        SharedPreferences sharedPreferences =context.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("UserName", value);
        editor.commit();
    }

    /**
     * get the size of the text view
     * @param context
     * @return
     */
    public static float getDataSaved(Context context)
    {
        int DEFULTE=0;
        float Size=0;
        SharedPreferences sharedPreferences= context.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        Size=(float) sharedPreferences.getInt("UserName",DEFULTE);
        return Size;
    }
}
