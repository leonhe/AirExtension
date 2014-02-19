package com.iyuanfei.extension.fun;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.iyuanfei.extension.AirExtensionContext;

public class AlertDialogFunction implements FREFunction {

	
	public static final String KEY = "AlertDialog";
	
	public String tag;
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		AirExtensionContext ctx = (AirExtensionContext) arg0;
		tag = ctx.getIdentifier();
		
		try
		{
			Context context = (Context) ctx.getActivity();
			
			
			
			String titleVal = arg1[0].getAsString(); 
			String message =  arg1[1].getAsString();
			
			AlertDialog.Builder alert=new AlertDialog.Builder(context);
			alert.setTitle(titleVal);
			alert.setMessage(message);
			
			DialogInterface.OnClickListener onPositivoListener=createListener(ctx,"positivoButton","1");
			
			DialogInterface.OnClickListener onNegative=createListener(ctx,"negativeButton","2");
			
			String lab = arg1[2].getAsString();
			if(lab!=null)
			{
				alert.setPositiveButton(lab,onPositivoListener);
			}
			lab = arg1[3].getAsString();
			if(lab!=null)
			{
				alert.setNegativeButton(lab, onNegative);
			}
			alert.show();
			
			
		}catch(Exception e){
			Log.d(tag, e.getMessage());
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	public DialogInterface.OnClickListener createListener(final AirExtensionContext cxt,
														  final String code,
														  final String level)
	{
		DialogInterface.OnClickListener result=null;
		
		try {
			 result=new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						cxt.dispatchStatusEventAsync(code,level);
					}
				};
		} catch (Exception e) {
			Log.d(tag, e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
}
