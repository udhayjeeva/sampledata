package com.uk.sampledata;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.github.ybq.android.spinkit.SpinKitView;

public class Constants {

    static ProgressDialog progressDialog;
    static Dialog cancel_dialog;
    static ProgressDialog m_Dialog;
    static Dialog coming_soon_dialog;

   static SpinKitView spinKitView;



    public static void showProgress(Context context) {
        if(context != null) {
            spinKitView = new SpinKitView(context);
            spinKitView.getIndeterminateDrawable();
            progressDialog = new ProgressDialog(context, R.styleable.SpinKitView_SpinKit_Color);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.getWindow().getAttributes().windowAnimations = R.styleable.SpinKitView_SpinKit_Style;
            progressDialog.setProgressDrawable(context.getResources().getDrawable(R.drawable.custom_progressbar));
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }



    public static void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }



    public static void showAlertDialog(final Context mContext, String title, String message) {

        final AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.white);
    }



}
