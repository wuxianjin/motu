package com.baidu.motu;

import java.io.File;
import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 调试类
 * 
 * @author wuxianjin
 * 
 *         2014-10-31
 */
public class SuCai extends UiAutomatorTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();
		UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
		try {
			motu.clickAndWaitForNewWindow();
			sleep(500);
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/btn_cancel"))
					.click();
			// 美化
			UiObject meihua = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/pick_image"));
			meihua.click();
			sleep(500);
			getUiDevice().click(540, 324);// 根据不同手机相册的展示选取一张照片
			getUiDevice().click(540, 324);
			sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 *
	 */
	public void test001() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		try {
			zhunbei();
			// 开始分享逻辑功能----微信
			sleep(500);
			new UiObject(new UiSelector().text("微信")).click();
			sleep(500);
			new UiObject(new UiSelector().text("Xianjin")).click();
			sleep(500);
			// 输入文案
			UiObject bander1 = new UiObject(
					new UiSelector().resourceId("com.tencent.mm:id/wn"));
			bander1.setText("motumotu");
			new UiObject(new UiSelector().text("分享")).click();
			sleep(500);
			new UiObject(new UiSelector().text("返回百度魔图")).click();
			sleep(500);
			// 朋友圈
			new UiObject(new UiSelector().text("朋友圈")).click();
			sleep(500);
			// 输入文案
			UiObject bander2 = new UiObject(
					new UiSelector().resourceId("com.tencent.mm:id/wn"));
			bander2.setText("motumotu");
			new UiObject(new UiSelector().text("分享")).click();
			sleep(500);
			// 新浪微博
			new UiObject(new UiSelector().text("新浪微博")).click();
			UiObject bander3 = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/input_edit_box"));
			bander3.setText("motuweibo");
			new UiObject(new UiSelector().text("发送")).click();
			sleep(3000);
			//QQ空间
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void zhunbei() throws UiObjectNotFoundException {
		new UiObject(new UiSelector().text("编辑")).click();
		new UiObject(new UiSelector().text("马赛克")).click();
		// 画笔调到最大
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/degree_bar_small"))
				.swipeRight(3);
		// 点击确定
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/top_btn_ok"))
				.click();
		sleep(500);
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

	public void xiangkuang(UiScrollable list) {
		int aa = list
				.getChildCount(new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/downloading_icon"));
		int bb = list.getChildCount(new UiSelector()
				.resourceId("cn.jingling.motu.photowonder:id/gooditem"));

		System.out.println("================");
		System.out.println(bb);
		System.out.println(aa);
	}

	public void ttest001Lunbotu() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		// i代表有几张轮播图、由于线上每次轮播图的数量都不一样，注意区分，本次版本3.2.3

		try {

			for (int i = 1; i < 6; i++) {
				if (i == 1) {// 断言第一张轮播图wenzi1代表第一张轮播图的名称
					UiObject bander1 = new UiObject(
							new UiSelector()
									.resourceId("cn.jingling.motu.photowonder:id/banner_full_img"));
					bander1.click();
					UiObject name1 = new UiObject(
							new UiSelector().text("just had me~ baby!"));
					assertTrue("第" + i + "张轮播图异常", name1.exists());
					getUiDevice().pressBack();

				} else if (i == 5) {// 断言第一张轮播图wenzi1代表第一张轮播图的名称
					UiObject bander2 = new UiObject(
							new UiSelector()
									.resourceId("cn.jingling.motu.photowonder:id/banner_full_img"));
					bander2.swipeRight(2);
					bander2.swipeRight(2);
					bander2.swipeRight(2);
					bander2.swipeRight(2);
					bander2.click();
					UiObject name1 = new UiObject(
							new UiSelector().text("Hello Halloween"));
					assertTrue("第" + i + "张轮播图异常", name1.exists());
					getUiDevice().pressBack();

				} else if (i == 4) {// 断言第一张轮播图wenzi1代表第一张轮播图的名称
					UiObject bander3 = new UiObject(
							new UiSelector()
									.resourceId("cn.jingling.motu.photowonder:id/banner_full_img"));
					bander3.swipeRight(2);// 滑动到第二张轮播图
					bander3.swipeRight(2);
					bander3.swipeRight(2);
					bander3.click();
					UiObject name1 = new UiObject(
							new UiSelector().text("万圣派对2"));
					assertTrue("第" + i + "张轮播图异常", name1.exists());
					getUiDevice().pressBack();

				} else if (i == 3) {// 断言第一张轮播图wenzi1代表第一张轮播图的名称
					UiObject bander4 = new UiObject(
							new UiSelector()
									.resourceId("cn.jingling.motu.photowonder:id/banner_full_img"));
					bander4.swipeRight(2);// 滑动到第二张轮播图
					bander4.swipeRight(2);
					bander4.click();
					UiObject name1 = new UiObject(new UiSelector().text("阿坨"));
					assertTrue("第" + i + "张轮播图异常", name1.exists());
					getUiDevice().pressBack();

				} else if (i == 2) {// 断言第2张轮播图wenzi1代表第一张轮播图的名称
					UiObject bander2 = new UiObject(
							new UiSelector()
									.resourceId("cn.jingling.motu.photowonder:id/banner_full_img"));
					bander2.swipeRight(2);// 滑动到第二张轮播图
					bander2.click();
					UiObject name2 = new UiObject(new UiSelector().text("闺蜜帮"));
					assertTrue("第" + i + "张轮播图异常", name2.exists());
					getUiDevice().pressBack();

				} else {
					System.out.println("轮播图有变动");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}
	}

	/**
	 * 素材推荐页--素材空白检查
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void ttest002Tuijian() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			sleep(500);
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.ListView"));

			int bb = list.getChildCount(new UiSelector()
					.resourceId("cn.jingling.motu.photowonder:id/item_name"));
			System.out.println("=====素材推荐页=============");
			System.out.println(bb);
			assertEquals(5, bb);

			list.scrollTextIntoView("热门贴纸");
			sleep(500);
			int bb2 = list.getChildCount(new UiSelector()
					.resourceId("cn.jingling.motu.photowonder:id/item_name"));
			System.out.println("===================");
			System.out.println(bb2);
			assertEquals(6, bb2);
			list.scrollTextIntoView("没有更多的内容");
			sleep(500);
			int hot = list.getChildCount(new UiSelector()
					.resourceId("cn.jingling.motu.photowonder:id/item_name"));
			System.out.println("===================");
			System.out.println(hot);
			assertEquals(5, hot);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();

		}

	}

	/**
	 * 素材--贴纸--素材首屏检查
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void ttest003Tiezhi() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			sleep(500);
			new UiObject(new UiSelector().text("贴纸")).click();
			System.out.println("=====贴纸主页====");
			tiezhi();
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(1)).click();
			System.out.println("=====贴纸--胡子贴纸====");
			tiezhi();
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(2)).click();
			System.out.println("=====贴纸--五角星贴纸====");
			tiezhi();
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(3)).click();
			System.out.println("=====贴纸--文字贴纸====");
			tiezhi();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();

		}

	}

	public void tiezhi() throws UiObjectNotFoundException {
		UiScrollable list = new UiScrollable(
				new UiSelector().className("android.widget.ListView"));

		int bb = list.getChildCount(new UiSelector()
				.resourceId("cn.jingling.motu.photowonder:id/item_name"));
		System.out.println("===================");
		System.out.println(bb);
		assertEquals(5, bb);

		/*
		 * list.scrollTextIntoView("向上拉动加载下一页"); sleep(500); int bb2 =
		 * list.getChildCount(new UiSelector()
		 * .resourceId("cn.jingling.motu.photowonder:id/item_name"));
		 * System.out.println("==================="); System.out.println(bb2);
		 * assertEquals(5, bb2);
		 */
	}

	/**
	 * 素材--相框--首屏检查
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void ttest004XiangKuang() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			sleep(500);
			new UiObject(new UiSelector().text("相框")).click();
			System.out.println("=================素材--相框--空白检查=============");
			pinKuang();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();

		}

	}

	public void pinKuang() {
		UiScrollable list = new UiScrollable(
				new UiSelector().className("android.widget.ListView"));

		int downloading = list
				.getChildCount(new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/downloading_icon"));
		int bb = list.getChildCount(new UiSelector()
				.resourceId("cn.jingling.motu.photowonder:id/gooditem"));
		System.out.println("===================");
		System.out.println(bb);
		System.out.println(downloading);
		if (12 != bb || 12 != downloading) {
			File storeFile = new File("/data/local/tmp/motu/" + "pinKuang.png");
			getUiDevice().takeScreenshot(storeFile);
		}
		assertEquals(12, bb);
		assertEquals(9, downloading);
	}

	/**
	 * 素材--拼图--首屏检查
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void ttest005Pintu() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			sleep(500);
			// new UiObject(new UiSelector().text("拼图")).click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_jigsaw_relative_layout"))
					.click();
			System.out
					.println("=================素材--拼图--背景拼图--首屏检查=============");
			pinKuang();
			System.out
					.println("=================素材--拼图--相框拼图--首屏检查=============");
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(1)).click();
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.ListView"));

			int downloading = list
					.getChildCount(new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/downloading_icon"));
			int bb = list.getChildCount(new UiSelector()
					.resourceId("cn.jingling.motu.photowonder:id/gooditem"));
			System.out.println("===================");
			System.out.println(bb);
			System.out.println(downloading);
			if (4 != bb || 4 != downloading) {
				File storeFile = new File("/data/local/tmp/push/motu/"
						+ "pinKuang.png");
				getUiDevice().takeScreenshot(storeFile);
			}
			assertEquals(4, bb);
			assertEquals(4, downloading);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();

		}

	}
}
