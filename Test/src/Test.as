package
{
	import com.iyuanfei.extension.PhoneMessage;
	
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import flash.events.StatusEvent;
	import flash.text.TextField;
	
	public class Test extends Sprite
	{
		private var phoneInfo:PhoneMessage;
		
		public function Test()
		{
			super();
			
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			
			var txt:TextField = new TextField();
			addChild(txt);
			
			phoneInfo = new PhoneMessage();
			
			var imei:String = phoneInfo.getIMEI();
			trace(imei);
			txt.text = imei;
			trace(phoneInfo.getPhoneNumber());
			
			phoneInfo.addEventListener(StatusEvent.STATUS,onStatue);
			phoneInfo.showAlert("Title","Context");
			
		}
		
		protected function onStatue(event:StatusEvent):void
		{
			if(event.code=="positivoButton")
			{
				phoneInfo.showAlert("Title","请点击取消");
			}else if(event.code=="negativeButton"){
				trace("我点击了取消");
			}
		}
	}
}