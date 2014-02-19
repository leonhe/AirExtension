package com.iyuanfei.dialog;

import com.example.getimei.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DefaulteDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceStage)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.dialog_context);
		return builder.create();
	}
	
}
