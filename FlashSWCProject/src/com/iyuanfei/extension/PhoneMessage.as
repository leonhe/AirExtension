package com.iyuanfei.extension
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;

	public class PhoneMessage extends EventDispatcher
	{
		private const extensionID:String = "com.iyuanfei.getimei.extension";
		private var extensionContext:ExtensionContext;
		public function PhoneMessage()
		{
			extensionContext =  ExtensionContext.createExtensionContext(extensionID,null);
			extensionContext.addEventListener(StatusEvent.STATUS,onStatus);
		}
		
		/**
		 * 返回电话的16位标识符 
		 * @return String
		 * 
		 */		
		public function getIMEI():String
		{
			 var retValue:String = String(extensionContext.call(KeyConst.IMEI));
			return retValue;
		}
		/**
		 * 返回当前手机使用的电话号码 
		 * @return String
		 * 
		 */		
		public function getPhoneNumber():String
		{
			var result:String= String(extensionContext.call(KeyConst.PHONE_NUMBER));
			return result;
		}
		
		/**
		 * 弹出对话框 
		 * @param title:String 标题
		 * @param message:String 信息内容
		 * 
		 */		
		public function showAlert(title:String,
								  context:String,
								  firstButtonLab:String="Submit",
								  secondeButtonLab:String="Cancel"):void
		{
			extensionContext.call(KeyConst.ALERT,title,context,firstButtonLab,secondeButtonLab);
		}
		protected function onStatus(event:StatusEvent):void
		{
			dispatchEvent(event.clone());
		}
		
		
		public function remove():void
		{
			extensionContext.removeEventListener(StatusEvent.STATUS,onStatus);
			extensionContext.dispose();
			extensionContext=null;
		}
	}
}