package com.iyuanfei.extension.fun;

import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.iyuanfei.extension.AirExtensionContext;

public class GetPhoneNumber implements FREFunction {

	public static final String KEY = "getPhoneNumber";
	
	public String tag;
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		AirExtensionContext ctx = (AirExtensionContext) arg0;
		tag = ctx.getIdentifier();
		
		FREObject result = null;
		try{
			Context context = ctx.getActivity();
			PhoneInfo phoneInfo = new PhoneInfo(context);
			String phoneNumber = phoneInfo.getPhoneNumber();
			if(phoneNumber!=null)
			{
				Log.d(tag, phoneNumber);
			}
			result=FREObject.newObject(phoneNumber);
			phoneInfo.remove();
			phoneInfo=null;
		}catch(Exception e){
			Log.d(tag,e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}

}
