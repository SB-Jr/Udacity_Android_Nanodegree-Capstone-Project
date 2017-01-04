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

public class Util {


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
        if(getUserIdFromSharedPreference(context)!=null){
            return true;
        }
        return false;
    }

    public static String getUsernameFromSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        if (sharedPreferences.contains("user") && sharedPreferences.getString("user", "").length() > 0) {
            return sharedPreferences.getString("user", null);
        }
        return null;
    }

    public static String getUserPassFromSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        if (sharedPreferences.contains("pass") && sharedPreferences.getString("pass", "").length() > 0) {
            return sharedPreferences.getString("pass", null);
        }
        return null;
    }

    public static String getUserUidFromSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        if (sharedPreferences.contains("user") && sharedPreferences.getString("user", "").length() > 0) {
            return sharedPreferences.getString("useruid", null);
        }
        return null;
    }

    public static String getUserIdFromSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        if (sharedPreferences.contains("userid") && sharedPreferences.getString("userid", "").length() > 0) {
            return sharedPreferences.getString("userid", null);
        }
        return null;
    }

    public static void setUserNameInSharedPreference(Context context,String user){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user",user);
        editor.commit();
    }

    public static void setUserIdInSharedPreference(Context context,String userid){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userid",userid);
        editor.commit();
    }

    public static void setUserPassInSharedPreference(Context context,String pass){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("pass",pass);
        editor.commit();
    }

    public static void setUserUIDInSharedPreference(Context context,String useruid){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ShowLedger", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("useruid",useruid);
        editor.commit();
    }

    public static class FireBaseConstants{
        public final static String USER="user";
        public final static String MOVIE="movies";
        public final static String TVSHOW="tvshows";
        public final static String WATCHED ="watched";
        public final static String WISHLIST = "watchLater";
        public final static String INCOMPLETE ="incomplete";
    }

}
