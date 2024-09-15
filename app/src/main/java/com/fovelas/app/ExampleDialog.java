package com.fovelas.app;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.fovelas.app.databinding.DialogExampleBinding;
import com.fovelas.enhanceddialog.EnhancedDialog;

public final class ExampleDialog extends EnhancedDialog
{
    public ExampleDialog(@NonNull Context context)
    {
        super(context);
    }

    public void show()
    {
        DialogExampleBinding binding = DialogExampleBinding.inflate(getInflater());

        binding.exampleDialogBtnClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });

        show(binding.getRoot());
    }
}