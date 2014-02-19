package com.iyuanfei;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;

import com.example.getimei.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		TelephonyManager telphonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
//		String imei=telphonyManager.getDeviceId();
//		Log.d("imei:",imei);
		confirmFireMissiles();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void confirmFireMissiles() {
	    
		new AlertDialog.Builder(this)
		.setMessage("消息")
		.setTitle("标题")
		.setPositiveButton("确定", null)
		.setNegativeButton("取消", null)
		.show();
		
		
		
	}

}
