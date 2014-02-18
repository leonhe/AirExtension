package com.iyuanfei.extension
{
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;

	public class PhoneMessage
	{
		private const extensionID:String = "com.iyuanfei.getimei.extension";
		private var extensionContext:ExtensionContext;
		public function PhoneMessage()
		{
			extensionContext =  ExtensionContext.createExtensionContext(extensionID,null);
		}
		/**
		 * 返回电话的16位标识符 
		 * @return String
		 * 
		 */		
		public function getIMEI():String
		{
			 var retValue:String = String(extensionContext.call("getIMEI"));
			return retValue;
		}
		/**
		 * 返回当前手机使用的电话号码 
		 * @return String
		 * 
		 */		
		public function getPhoneNumber():String
		{
			var result:String= String(extensionContext.call("getPhoneNumber"));
			return result;
		}
		
		
	}
}