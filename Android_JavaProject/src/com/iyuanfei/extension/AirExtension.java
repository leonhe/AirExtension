package com.iyuanfei.extension;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class AirExtension implements FREExtension {
	
	private static final String EXT_NAME="AIRExtension";
	
	private AirExtensionContext context;
	
	private String tag = EXT_NAME+"AirExtension Class";
	
	
	@Override
	public FREContext createContext(String arg0) {
		Log.i(tag,"Creating Context");
		if(context==null) {
			context = new AirExtensionContext(EXT_NAME);
		}
		return context;
	}

	@Override
	public void dispose() {
		Log.i(tag,"Disposing extension");
	}

	@Override
	public void initialize() {
		Log.i(tag,"Initialize");
	}

}
