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
	 * ���ص绰Ψһ��ʾ��IMEI
	 * @return String
	 */
	public String getIMIE()
	{
		return telephony.getDeviceId();
	}
	/**
	 * ���ص�ǰ�ƶ��豸ʹ�õĺ���
	 * @return
	 */
	public String getPhoneNumber()
	{
		return telephony.getLine1Number();
	}
	
}
