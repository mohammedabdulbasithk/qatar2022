package com.basith.qatar2022.Models;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class GlobalMethods {
    Context context;

    public static GlobalMethods sharedInstance = new GlobalMethods();

    public boolean isProduction =  true;

    public GlobalMethods(Context context){
        this.context = context;
    }

    AlertDialog.Builder builder;

    public GlobalMethods() {

    }

    public void showInterNetAlert(Context context){
        builder = new AlertDialog.Builder(context);
        builder.setMessage("ഈ ആപ്പ് പ്രവർത്തിക്കുന്നതിന് ഇന്റർനെറ്റ് നിർബന്ധമാണ്. ദയവായി ഇന്റർനെറ്റ് ഓൺ ചെയ്യുക. ")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Please turn on internet");
        alert.show();
    }

    public void showCustomAlert(Context context, String message, String title){
        builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle(title);
        alert.show();
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ){
            return true;
        }
        else {
            return false;
        }
    }
}
