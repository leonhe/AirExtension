package com.iyuanfei.extension.fun;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PhoneInfo {

	private TelephonyManager telephony;
	
	public void remove()
	{
		telephony=null;
	}
	
	public PhoneInfo(Context context)
	{
		telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
	}
	/**
	 * 返回电话唯一标示符IMEI
	 * @return String
	 */
	public String getIMIE()
	{
		return telephony.getDeviceId();
	}
	/**
	 * 返回当前移动设备使用的号码
	 * @return
	 */
	public String getPhoneNumber()
	{
		return telephony.getLine1Number();
	}
	
}
