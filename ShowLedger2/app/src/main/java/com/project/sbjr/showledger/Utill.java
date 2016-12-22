package com.project.sbjr.showledger;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sbjr on 22/12/16.
 */

public class Utill {


    public static void checkInternet(Context context, CoordinatorLayout coordinatorLayout){
        if(!isInternetConnected(context)) {
            Snackbar.make(coordinatorLayout, R.string.no_internet, Snackbar.LENGTH_LONG).show();
        }
    }

    public static boolean isInternetConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo.isConnected()) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isUserDataPresent(Context context){
        if(usernameFromSharedPreference(context)!=null){
            return true;
        }
        return false;
    }

    public static String usernameFromSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        if (sharedPreferences.contains("user") && sharedPreferences.getString("user", "").length() > 0) {
            return sharedPreferences.getString("user", null);
        }
        return null;
    }

    public static void setUserNameInSharedPreference(Context context,String user){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user",user);
        editor.commit();
    }

}
