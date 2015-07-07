package com.baidu.motu;

import java.io.File;
import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
/**
 * 不同特效下面前后摄像头交换拍照
 * @author wuxianjin
 *
 * 2014-10-31
 */
public class XiangJiTest extends UiAutomatorTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();
		UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
		try {
			motu.clickAndWaitForNewWindow();
			new UiObject(new UiSelector().text("特效相机")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 检查特效相机模块
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void test01() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// 判读是否首次打开
			UiObject sure = new UiObject(new UiSelector().text("确定"));
			if (sure.exists()) {
				sure.click();
			}

			new UiObject(new UiSelector().text("原图").index(1)).click();
			paiZhao();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void paiZhao() throws UiObjectNotFoundException {

		// 切换成前摄像头
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/btn_switch"))
				.click();
		// 点击拍照
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/btn_capture"))
				.click();

		// 点击保存
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/btn_beautify"))
				.click();
		// 保存分享
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/top_btn_right"))
				.click();
		sleep(500);
		// IMG验证图片保存成功
		UiObject name = new UiObject(new UiSelector().className(
				"android.widget.TextView").textContains("IMG"));
		System.out.println(name.getText());
		// assertTrue(name.exists());

	}

	/**
	 * 检查特效相机---LOMO
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void test02() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(new UiSelector().text("LOMO").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void test03() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("秋色").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void test04() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("黑白").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void test05() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("回忆").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	// 滚动
	public void test06() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			gunDong();
			
			new UiObject(new UiSelector().text("复古").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void gunDong() throws UiObjectNotFoundException {
		UiScrollable list = new UiScrollable(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/camera_filters"));
		list.setAsHorizontalList();
		list.scrollTextIntoView("湖蓝");
	}

	public void test07() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			gunDong();
			new UiObject(new UiSelector().text("流年").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void test08() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			gunDong();
			new UiObject(new UiSelector().text("漏光").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void test09() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			gunDong();
			new UiObject(new UiSelector().text("哥特").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}

	public void test10() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			gunDong(); 
			new UiObject(new UiSelector().text("湖蓝").index(1)).click();
			paiZhao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new UiObject(new UiSelector().text("首页")).click();
		}

	}
}
