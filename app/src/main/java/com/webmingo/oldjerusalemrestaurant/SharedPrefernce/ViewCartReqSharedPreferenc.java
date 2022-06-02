package com.webmingo.oldjerusalemrestaurant.SharedPrefernce;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.RequestRepo.ViewCartRequest;

import java.util.List;


import java.lang.reflect.Type;
import java.util.ArrayList;

public class ViewCartReqSharedPreferenc {

    private static final String LIST_KEY = "list_key100";

    public static void writeListInPref(Context context, List<ViewCartRequest> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static List<ViewCartRequest> readListFromPref(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ViewCartRequest>>() {}.getType();
        List<ViewCartRequest> list = gson.fromJson(jsonString, type);
        return list;
    }


    public static void ViewCartReqClear(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(LIST_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        /*

        Intent intent = new Intent(mCtx, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        mCtx.startActivity(intent);*/


    }

}
