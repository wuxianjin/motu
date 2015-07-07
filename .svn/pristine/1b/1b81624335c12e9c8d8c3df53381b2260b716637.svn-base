d: & cd workspace\motu 
call motu_build.bat
echo "编译最新代码完成"
call motu_push.bat
echo "jar包已经导入手机"
adb uninstall cn.jingling.motu.photowonder
echo "***** 上一个版本卸载完毕 ... *****"
adb install D:\workspace\motu\motu.apk
echo "***** 最新魔图包安装 成功 ... *****"
adb shell am start -n cn.jingling.motu.photowonder/cn.jingling.motu.photowonder.SplashActivity
echo "***** 最新魔图包启动成功 ... *****"
adb shell uiautomator runtest motu.jar -c com.baidu.motu.FirstStart
adb shell uiautomator runtest motu.jar -c com.baidu.motu.UITest
pause
