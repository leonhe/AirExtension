unzip AirExtension.swc
rm catalog.xml
mv library.swf Android-ARM/library.swf

F:/AIRSDK_Compiler/bin/adt -package -storetype pkcs12 -keystore yuanfei.p12 -storepass 123456 -target ane AirExtension.ane extension.xml -swc *.swc -platform Android-ARM -C Android-ARM .