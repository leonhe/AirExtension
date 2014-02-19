package com.iyuanfei.extension;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.iyuanfei.extension.fun.AlertDialogFunction;
import com.iyuanfei.extension.fun.GetIMEIFunction;
import com.iyuanfei.extension.fun.GetPhoneNumber;

public class AirExtensionContext extends FREContext {

	private static final String CTX_NAME = "AirExtensionContext";
	
	private String tag;
	
	public  AirExtensionContext(String name)
	{
		tag = name+"."+CTX_NAME;
		Log.i(tag, "Creating context");
	}
	
	@Override
	public void dispose() {
		Log.i(tag,"Dispose context");
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Log.i(tag, "Creating function Map");
		Map<String,FREFunction> functionMap = new HashMap<String, FREFunction>();
		functionMap.put(GetIMEIFunction.KEY, new GetIMEIFunction());//移动设备信息管理
		functionMap.put(GetPhoneNumber.KEY, new GetPhoneNumber());//获取当前激活号码
		functionMap.put(AlertDialogFunction.KEY, new AlertDialogFunction());
		return functionMap;
	}
	
	public String getIdentifier()
	{
		return tag;
	}
	
}
