AirExtension
============

Adobe Air Android 扩展

- 可获取移动设备IMEI
- 获取当前移动设备使用的号码

#### 范例

```actionScript
var phoneInfo:PhoneMessage = new PhoneMessage();
var imei:String = phoneInfo.getIMEI();//获取IMEI字符串
trace(imei);
trace(phoneInfo.getPhoneNumber());//获取电话号码
```