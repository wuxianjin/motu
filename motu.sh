#!/bin/bash
svn up
adb push /root/jenkins/workspace/motu_dabao/motu/motu/bin/motu.jar data/local/tmp
echo "***** 导入最新jar包 ... *****"
adb uninstall cn.jingling.motu.photowonder
echo "***** 上一个版本卸载完毕 ... *****"
adb install /root/tomcat/webapps/ROOT/motu.apk
echo "***** 最新魔图包安装 成功 ... *****"
adb shell am start -n cn.jingling.motu.photowonder/cn.jingling.motu.photowonder.SplashActivity
echo "***** 最新魔图包启动成功 ... *****"
adb shell uiautomator runtest motu.jar -c com.baidu.motu.UITest
adb shell uiautomator runtest motu.jar -c com.baidu.motu.MeiHuaTest
adb shell uiautomator runtest motu.jar -c com.baidu.motu.PinTuTest
adb shell uiautomator runtest motu.jar -c com.baidu.motu.XiangJiTest
adb shell uiautomator runtest motu.jar -c com.baidu.motu.SuCaiTest
adb shell uiautomator runtest motu.jar -c com.baidu.motu.SettingTest
