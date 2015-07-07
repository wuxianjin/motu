package com.baidu.motu;

import java.io.File;
import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
/**
 * 主要针对魔图--美化模块的功能检查
 * @author wuxianjin
 *
 * 2014-08-16
 */
public class MeiHuaTest extends UiAutomatorTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();
		UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
		try {
			motu.clickAndWaitForNewWindow();
			UiObject meihua = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/pick_image"));
			meihua.click();
			sleep(500);
			// getUiDevice().click(100, 300);// 根据不同手机相册的展示选取一张照片
			getUiDevice().click(540, 324);// 根据不同手机相册的展示选取一张照片
			getUiDevice().click(540, 324);
			sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	/**
	 * 测试美化---编辑模块
	 */
	public void test01() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(new UiSelector().text("编辑")).click();
			new UiObject(new UiSelector().text("马赛克")).click();
			// 画笔调到最大
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/degree_bar_small"))
					.swipeRight(3);
			// 画笔
			UiObject huaBi = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/image"));
			// 涂鸦动作
			huaBi.swipeUp(5);
			sleep(500);
			huaBi.swipeRight(1);
			sleep(500);
			huaBi.swipeDown(3);
			/*
			 * // 回退一步 new UiObject( new UiSelector()
			 * .resourceId("cn.jingling.motu.photowonder:id/image")) .click();
			 * // 还原 new UiObject( new UiSelector()
			 * .resourceId("cn.jingling.motu.photowonder:id/btnRedo")) .click();
			 */
			ok();

			new UiObject(new UiSelector().text("调色")).click();
			// 增大亮度
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/degree_bar_small"))
					.swipeRight(3);
			ok();
			// 裁剪
			new UiObject(new UiSelector().text("裁剪")).click();
			new UiObject(new UiSelector().text("比例")).click();
			new UiObject(new UiSelector().text("1:2")).click();
			ok();

			new UiObject(new UiSelector().text("旋转")).click();
			new UiObject(new UiSelector().text("逆时针转")).click();
			new UiObject(new UiSelector().text("顺时针转")).click();
			new UiObject(new UiSelector().text("左右翻转")).click();
			new UiObject(new UiSelector().text("上下翻转")).click();
			ok();
			new UiObject(new UiSelector().text("背景虚化")).click();

			// 放大

			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/degree_bar_small"))
					.swipeRight(3);
			saveMeiHua();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void ok() throws UiObjectNotFoundException {
		// 点击确定
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/top_btn_ok"))
				.click();
	}

	public void saveMeiHua() throws UiObjectNotFoundException {
		ok();

		// 点击 保存分享

		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/top_btn_right"))
				.click();
		sleep(1000);
		UiObject name = new UiObject(new UiSelector().className(
				"android.widget.TextView").textContains("IMG"));
		System.out.println(name.getText());
	}

	/**
	 * 测试美化---美容模块
	 */
	public void test02() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(new UiSelector().text("美容")).click();
			new UiObject(new UiSelector().text("一键变美")).click();
			sleep(2000);
			// 画笔
			UiObject huaBi = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/image"));
			huaBi.pinchIn(2, 2);
			// 底部操作
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/auto_linearlayout"))
					.getChild(
							new UiSelector().className(
									"android.widget.ImageView").index(0))
					.click();

			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/auto_linearlayout"))
					.getChild(
							new UiSelector().className(
									"android.widget.ImageView").index(8))
					.click();
			ok();
			// 美腿
			new UiObject(new UiSelector().text("美腿")).click();
			UiObject tui = new UiObject(new UiSelector().text("对比"));
			if (!tui.exists()) {
				getUiDevice().pressBack();
			}

			// 放大

			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/vartical_seeker_bar"))
					.swipeUp(2);

			saveMeiHua();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	/**
	 * 测试美化---装饰模块
	 */
	public void test03() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(new UiSelector().text("装饰")).click();
			new UiObject(new UiSelector().text("饰品")).click();

			// 选择文字饰品
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/text_view"))
					.click();

			// 选择 sweet
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/decoration_item2"))
					.click();
			ok();
			// 涂鸦
			new UiObject(new UiSelector().text("涂鸦")).click();

			// 拉大画笔
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/degree_bar_small"))
					.swipeRight(2);
			// 画笔
			UiObject huaBi = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/image"));
			// 涂鸦动作
			huaBi.swipeUp(5);
			sleep(500);
			huaBi.swipeRight(1);
			sleep(500);
			huaBi.swipeDown(3);
			ok();
			new UiObject(new UiSelector().text("文字泡泡")).click();
			new UiObject(new UiSelector().resourceId(
					"cn.jingling.motu.photowonder:id/decorate_item").index(2))
					.click();
			saveMeiHua();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	/**
	 * 测试美化---特效模块
	 */
	public void test04() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(new UiSelector().text("特效")).click();
			sleep(1000);
			new UiObject(new UiSelector().text("美白")).click();
			sleep(4000);

			UiScrollable renList = new UiScrollable(
					new UiSelector().className("android.widget.AdapterView"));
			renList.setAsHorizontalList();
			renList.scrollTextIntoView("回忆");
			UiObject renXiang6 = new UiObject(new UiSelector().text("复古"));
			renXiang6.click();

			// 拉小画笔
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/vartical_seeker_bar"))
					.swipeDown(2);

			saveMeiHua();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	/**
	 * 测试美化---相框模块
	 */
	public void test05() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			// 检查相框
			for (int i = 1; i < 5; i++) {
				new UiObject(new UiSelector().text("相框")).click();
				new UiObject(new UiSelector().resourceId(
						"cn.jingling.motu.photowonder:id/decorate_frame_item")
						.index(i)).click();

				if (i == 4) {
					saveMeiHua();
				} else {
					ok();
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

}
