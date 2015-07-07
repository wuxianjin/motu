package com.baidu.motu;

import java.io.File;
import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
/**
 * 针对素材模块、验证轮播图、各类素材数量、下载按钮展现
 * @author wuxianjin
 *
 * 2014-10-31
 */
public class SuCaiTest extends UiAutomatorTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();
		UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
		try {
			motu.clickAndWaitForNewWindow();
			new UiObject(new UiSelector().text("素材")).click();
			sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 检查素材模块--尝试下载所有素材---todo
	 */
	public void testXiangkuang() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("相框")).click();
			sleep(2000);
			// 浏览全部相框
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.ListView"));
			xiangkuang(list);

			/*
			 * UiObject about = list.getChild(new UiSelector()
			 * .resourceId("cn.jingling.motu.photowonder:id/downloading_icon"
			 * ).index(3)); about.click();
			 */
			sleep(1000);
			// list.scrollTextIntoView("向上拉动加载下一页");
			list.scrollToEnd(9);
			xiangkuang(list);
			list.scrollToEnd(9);
			xiangkuang(list);
			list.scrollToEnd(9);
			xiangkuang(list);
			list.scrollTextIntoView("没有更多的内容");
			xiangkuang(list);

			/*
			 * UiSelector uu = new UiSelector()
			 * .resourceId("cn.jingling.motu.photowonder:id/downloading_icon");
			 * 
			 * UiObject obj = new UiObject(uu);
			 * 
			 * while (obj.exists()) {
			 * 
			 * obj.click(); sleep(500); uu =
			 * uu.resourceId("cn.jingling.motu.photowonder:id/downloading_icon"
			 * ); obj = new UiObject(uu); }
			 */
			/*
			 * UiObject about = list.getChildByText( new
			 * UiSelector().className("android.widget.TextView"), "向上拉动加载下一页");
			 * about.click(); sleep(1000);
			 * 
			 * // 下载按钮 new UiObject( new UiSelector()
			 * .resourceId("cn.jingling.motu.photowonder:id/downloading_icon"))
			 * .click();
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

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

	public void test001Lunbotu() throws UiObjectNotFoundException,
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
	public void test002Tuijian() throws UiObjectNotFoundException,
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
	public void test003Tiezhi() throws UiObjectNotFoundException,
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
	public void test004XiangKuang() throws UiObjectNotFoundException,
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
	public void test005Pintu() throws UiObjectNotFoundException,
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
