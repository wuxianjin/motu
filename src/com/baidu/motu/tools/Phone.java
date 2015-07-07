package com.baidu.motu.tools;

import java.io.IOException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Phone extends UiAutomatorTestCase {
	
	public static UiObject findByName(String s) {
		// TODO Auto-generated method stub
		UiObject uiobj = new UiObject(new UiSelector().text(s));
		return uiobj;
	}
	

	public void test02MeiHua() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		UiObject meihua = new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/pick_image"));
		meihua.click();
		// getUiDevice().click(100, 300);// 根据不同手机相册的展示选取一张照片
		getUiDevice().click(540, 324);// 根据不同手机相册的展示选取一张照片
		getUiDevice().click(540, 324);
		sleep(1000);
		UiObject back = new UiObject(new UiSelector().text("返回"));
		UiObject share = new UiObject(new UiSelector().text("保存/分享"));
		UiObject bianji = new UiObject(new UiSelector().text("编辑"));
		UiObject meiRong = new UiObject(new UiSelector().text("美容"));
		UiObject zhuangShi = new UiObject(new UiSelector().text("装饰"));
		UiObject teXiao = new UiObject(new UiSelector().text("特效"));
		UiObject xiangKuang = new UiObject(new UiSelector().text("相框"));

		try {
			assertTrue("编辑不存在", bianji.exists());
			assertTrue("美容不存在", meiRong.exists());
			assertTrue("装饰不存在", zhuangShi.exists());
			assertTrue("特效不存在", teXiao.exists());
			assertTrue("相框不存在", xiangKuang.exists());
			assertTrue("返回不存在", back.exists());
			assertTrue("分享不存在", share.exists());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 编辑模块UI
		bianji.click();
		UiObject bianji1 = new UiObject(new UiSelector().text("马赛克"));
		UiObject bianji2 = new UiObject(new UiSelector().text("调色"));
		UiObject bianji3 = new UiObject(new UiSelector().text("裁剪"));
		UiObject bianji4 = new UiObject(new UiSelector().text("旋转"));
		UiObject bianji5 = new UiObject(new UiSelector().text("锐化"));
		UiObject bianji6 = new UiObject(new UiSelector().text("背景虚化"));
		assertTrue("马赛克不存在", bianji1.exists());
		assertTrue("调色不存在", bianji2.exists());
		assertTrue("裁剪不存在", bianji3.exists());
		assertTrue("旋转不存在", bianji4.exists());
		assertTrue("锐化不存在", bianji5.exists());
		assertTrue("虚化不存在", bianji6.exists());
		// 美容模块UI
		meiRong.click();
		UiObject meiRong1 = new UiObject(new UiSelector().text("一键变美"));
		UiObject meiRong6 = new UiObject(new UiSelector().text("祛黑眼圈"));
		assertTrue("虚化不存在", meiRong1.exists());
		assertTrue("祛黑眼圈不存在", meiRong6.exists());
		UiScrollable list = new UiScrollable(
				new UiSelector().className("android.widget.AdapterView"));
		list.setAsHorizontalList();

		list.scrollTextIntoView("去红眼");
		UiObject meiRong11 = new UiObject(new UiSelector().text("彩妆"));
		assertTrue("彩妆不存在", meiRong11.exists());

		// 装饰模块UI
		zhuangShi.click();
		UiObject zhuangShi1 = new UiObject(new UiSelector().text("饰品"));
		UiObject zhuangShi3 = new UiObject(new UiSelector().text("文字泡泡"));
		assertTrue("饰品no", zhuangShi1.exists());
		assertTrue("文字泡泡no", zhuangShi3.exists());

		// 检查特效模块UI
		teXiao.click();
		sleep(2000);
		UiObject renXiang = new UiObject(new UiSelector().text("人像"));
		UiObject jingDian = new UiObject(new UiSelector().text("经典"));
		UiObject qingJing = new UiObject(new UiSelector().text("情景"));
		UiObject art = new UiObject(new UiSelector().text("艺术"));
		assertTrue("特效--renXiang no", renXiang.exists());
		assertTrue("特效--jingDian no", jingDian.exists());
		assertTrue("特效--qingJing no", qingJing.exists());
		assertTrue("特效--art no", art.exists());
		// 特效-人像模块
		UiObject renXiang1 = new UiObject(new UiSelector().text("自然"));
		assertTrue("特效-人像-自然 no", renXiang1.exists());

		UiScrollable renList = new UiScrollable(
				new UiSelector().className("android.widget.AdapterView"));
		renList.setAsHorizontalList();
		renList.scrollTextIntoView("回忆");
		UiObject renXiang6 = new UiObject(new UiSelector().text("复古"));
		assertTrue("特效-人像-自然 no", renXiang6.exists());
		getUiDevice().pressBack();// 返回美化界面

		// 美化--相框界面UI
		xiangKuang.click();

		UiObject more = new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/docoration_bottom_paws"));
		assertTrue("相框--下载 no", more.exists());
		UiScrollable moreList = new UiScrollable(
				new UiSelector().className("android.widget.AdapterView"));
		moreList.setAsHorizontalList();
		moreList.scrollToEnd(3, 1);
		// 返回主界面
		getUiDevice().pressBack();
		getUiDevice().pressBack();
	}

	public void test07BiaoQingUI() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		new UiObject(new UiSelector().text("表情实验室")).click();
		UiObject lishi = new UiObject(new UiSelector().text("历史头像"));
		if (lishi.exists()) {
			lishi.click();

			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/back"))
					.click();

		}
		new UiObject(new UiSelector().text("表情相册")).click();
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/back"))
				.click();

		new UiObject(new UiSelector().text("选照片")).click();
		getUiDevice().click(540, 324);// 根据不同手机相册的展示选取一张照片
		getUiDevice().click(540, 324);

		for (int i = 4; i > 0; i--) {
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/emoji_hair"
									+ i + "_bg")).click();

		}

		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/btn_beautify"))
				.click();
		sleep(4000);

		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();

	}
}
