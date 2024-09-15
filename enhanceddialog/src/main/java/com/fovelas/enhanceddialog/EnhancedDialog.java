package com.fovelas.enhanceddialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class EnhancedDialog
{
    private final Context context;
    private final LayoutInflater inflater;
    private Dialog dialog;

    public EnhancedDialog(@NonNull Context context)
    {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    protected final Context getContext()
    {
        return this.context;
    }

    protected final LayoutInflater getInflater()
    {
        return this.inflater;
    }

    protected final void show(
        View v
    )
    {
        showDialog(v, true);
    }

    protected final void show(
        View v,
        boolean isCancelable
    )
    {
        showDialog(v, isCancelable);
    }

    private void showDialog(
        View v,
        boolean isCancelable
    )
    {
        dialog = new Dialog(context);

        if (dialog.getWindow() == null) return;

        dialog.setContentView(v);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(isCancelable);

        if (!((Activity) context).isFinishing())
        {
            dialog.show();
        }

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public void dismiss()
    {
        if (dialog != null) dialog.dismiss();
    }
}