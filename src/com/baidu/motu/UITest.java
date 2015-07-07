package com.baidu.motu;

import java.io.File;
import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 主要检查魔图界面UI，包括PK、大咖配、穿越、表情实验室的功能
 * 
 * @author wuxianjin
 * 
 *         2014-10-31
 */
public class UITest extends UiAutomatorTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();
		UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
		try {
			motu.clickAndWaitForNewWindow();
			sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 检查推荐应用
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test01TuiJian() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		// getUiDevice().pressBack();//第一次安装时打开，跳过引导页
		//取消升级弹窗
		/*new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/btn_cancel"))
				.click();*/
		UiObject tuijian = new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/welcome_recommand_box"));

		tuijian.click();

		UiScrollable list = new UiScrollable(
				new UiSelector().className("android.widget.ListView"));

		list.scrollTextIntoView("金山手机助手");
		// list.scrollTextIntoView("百度");
		try {
			UiObject about = list.getChildByText(
					new UiSelector().className("android.widget.TextView"),
					"百度音乐");

			about.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressBack();

		}

	}

	/**
	 * 测试美化模块UI
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
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

		try {
			UiObject back = new UiObject(new UiSelector().text("返回"));
			UiObject share = new UiObject(new UiSelector().text("保存/分享"));
			UiObject bianji = new UiObject(new UiSelector().text("编辑"));
			UiObject meiRong = new UiObject(new UiSelector().text("美容"));
			UiObject zhuangShi = new UiObject(new UiSelector().text("装饰"));
			UiObject teXiao = new UiObject(new UiSelector().text("特效"));
			UiObject xiangKuang = new UiObject(new UiSelector().text("相框"));

			// assertTrue("编辑不存在", bianji.exists());
			assertTrue("====================================美容不存在", meiRong.exists());
			assertTrue("====================================装饰不存在", zhuangShi.exists());
			assertTrue("====================================特效不存在", teXiao.exists());
			assertTrue("====================================相框不存在", xiangKuang.exists());
			assertTrue("====================================返回不存在", back.exists());
			assertTrue("====================================分享不存在", share.exists());

			// 编辑模块UI
			bianji.click();
			UiObject bianji1 = new UiObject(new UiSelector().text("马赛克"));
			UiObject bianji2 = new UiObject(new UiSelector().text("调色"));
			UiObject bianji3 = new UiObject(new UiSelector().text("裁剪"));
			UiObject bianji4 = new UiObject(new UiSelector().text("旋转"));
			UiObject bianji5 = new UiObject(new UiSelector().text("锐化"));
			UiObject bianji6 = new UiObject(new UiSelector().text("背景虚化"));

			assertTrue("====================================马赛克不存在", bianji1.exists());
			assertTrue("====================================调色不存在", bianji2.exists());
			assertTrue("====================================裁剪不存在", bianji3.exists());
			assertTrue("====================================旋转不存在", bianji4.exists());
			assertTrue("====================================锐化不存在", bianji5.exists());
			assertTrue("====================================虚化不存在", bianji6.exists());

			// 美容模块UI
			meiRong.click();
			UiObject meiRong1 = new UiObject(new UiSelector().text("一键变美"));
			UiObject meiRong6 = new UiObject(new UiSelector().text("祛黑眼圈"));
			assertTrue("====================================虚化不存在", meiRong1.exists());
			assertTrue("====================================祛黑眼圈不存在", meiRong6.exists());
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.AdapterView"));
			list.setAsHorizontalList();

			list.scrollTextIntoView("去红眼");
			UiObject meiRong11 = new UiObject(new UiSelector().text("彩妆"));
			assertTrue("====================================彩妆不存在", meiRong11.exists());

			// 装饰模块UI
			zhuangShi.click();
			UiObject zhuangShi1 = new UiObject(new UiSelector().text("饰品"));
			UiObject zhuangShi3 = new UiObject(new UiSelector().text("文字泡泡"));
			assertTrue("饰品no", zhuangShi1.exists());
			assertTrue("====================================文字泡泡no", zhuangShi3.exists());

			// 检查特效模块UI
			teXiao.click();
			sleep(3000);
			UiObject renXiang = new UiObject(new UiSelector().text("人像"));
			UiObject jingDian = new UiObject(new UiSelector().text("经典"));
			UiObject qingJing = new UiObject(new UiSelector().text("情景"));
			UiObject art = new UiObject(new UiSelector().text("艺术"));
			assertTrue("====================================特效--renXiang no", renXiang.exists());
			assertTrue("====================================特效--jingDian no", jingDian.exists());
			assertTrue("====================================特效--qingJing no", qingJing.exists());
			assertTrue("====================================特效--art no", art.exists());
			// 特效-人像模块
			UiObject renXiang1 = new UiObject(new UiSelector().text("自然"));
			assertTrue("====================================特效-人像-自然 no", renXiang1.exists());

			UiScrollable renList = new UiScrollable(
					new UiSelector().className("android.widget.AdapterView"));
			renList.setAsHorizontalList();
			renList.scrollTextIntoView("回忆");
			UiObject renXiang6 = new UiObject(new UiSelector().text("复古"));
			assertTrue("====================================特效-人像-自然 no", renXiang6.exists());

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 返回主界面
			getUiDevice().pressBack();
			getUiDevice().pressBack();
		}

	}

	/**
	 * 拼图模块Ui检查
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test03PinTu() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		UiObject pintu = new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/jigsaw_image"));
		pintu.click();

		try {
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.ListView"));
			UiObject about = list.getChild(new UiSelector()
					.textContains("Camera"));
			about.click();

			sleep(1000);
			// 选择2张图片

			UiObject aa = new UiObject(new UiSelector().className(
					"android.widget.ImageView").index(0));
			aa.click();
			new UiObject(new UiSelector().className("android.widget.ImageView")
					.index(1)).click();
			// new UiObject(new UiSelector().text("开始拼图")).click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/top_btn_right"))
					.click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/jigsaw_left_arrow"))
					.click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/jigsaw_right_arrow"))
					.click();
			new UiObject(new UiSelector().text("自由")).click();
			new UiObject(new UiSelector().text("影楼")).click();
			new UiObject(new UiSelector().text("拼接")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			// System.out.println("开始拼图失败");

		}

	}

	/**
	 * 检查特效相机模块UI
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void test04XiangJi() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(new UiSelector().text("特效相机")).click();
			// 判读是否首次打开
			UiObject sure = new UiObject(new UiSelector().text("确定"));
			if (sure.exists()) {
				sure.click();
			}

			new UiObject(new UiSelector().text("LOMO")).click();
			new UiObject(new UiSelector().text("秋色")).click();
			new UiObject(new UiSelector().text("黑白")).click();
			new UiObject(new UiSelector().text("回忆")).click();

			UiScrollable list = new UiScrollable(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/camera_filters"));
			list.setAsHorizontalList();
			list.scrollTextIntoView("湖蓝");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	/**
	 * 检查特效视频模块UI
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void test05shipin() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("特效视频")).click();
			sleep(800);
			// 进行拍摄
			UiObject paishe = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/btn_recorder_video"));
			paishe.longClick();
			paishe.longClick();
			paishe.longClick();
			paishe.longClick();
			paishe.longClick();
			sleep(800);
			// 确定所拍摄的视频
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/btn_recorder_finish"))
					.click();
			sleep(4000);

			/*
			 * new UiObject(new UiSelector().text("LOMO")).click(); new
			 * UiObject(new UiSelector().text("秋色")).click(); new UiObject(new
			 * UiSelector().text("黑白")).click(); new UiObject(new
			 * UiSelector().text("回忆")).click();
			 */
			UiScrollable list = new UiScrollable(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/mv_filter_gallery"));
			list.setAsHorizontalList();
			list.scrollTextIntoView("美白");
			sleep(500);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			sleep(500);
			getUiDevice().pressBack();
			sleep(500);
			new UiObject(new UiSelector().text("确定")).click();
			sleep(500);
		}

	}

	/**
	 * 检查素材模块UI
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test06SuCai() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("素材")).click();

			new UiObject(new UiSelector().text("贴纸")).click();
			new UiObject(new UiSelector().text("相框")).click();
			// 特殊情况 拼图两字不识别
			// new UiObject(new UiSelector().text("拼图")).click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_jigsaw_relative_layout"))
					.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	/**
	 * 检查美容秘籍模块ui 广告位变动、只检查非空白
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test07MiJiUI() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// cn.jingling.motu.photowonder:id/inmobi_image
			UiObject miji = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/tips_image"));
			if (miji.exists()) {
				miji.click();
			} else {// android.view.View
				UiObject ad = new UiObject(new UiSelector().className(
						"android.view.View").index(4));
				if (ad.exists()) {
					ad.click();
				}
			}
			getUiDevice().pressBack();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	/**
	 * 检查设置模块ui
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test08SetingUI() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		try {
			
			// 点击设置
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_setting"))
					.click();
			// 未登录状态---登录账号
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_cloud_gallery_login"))
					.click();

			getUiDevice().pressBack();
			// 素材管理
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_material_layout"))
					.click();
			getUiDevice().pressBack();
			// 美化图片质量
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_image_size_layout"))
					.click();
			getUiDevice().pressBack();
			// new UiObject(new UiSelector().text("存储路径")).click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_save_path_layout"))
					.click();
			getUiDevice().pressBack();

			//
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.ScrollView"));

			list.scrollTextIntoView("关于");
			// new UiObject(new UiSelector().text("分享帐号设置")).click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_share_layout"))
					.click();
			getUiDevice().pressBack();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
		}

	}

	/**
	 * 检查PK大咖ui
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test09PKUI() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		try {
			sleep(500);
			// 翻到第二屏幕
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_right_arrow_shine"))
					.click();

			// 点击PK
			new UiObject(new UiSelector().text("PK大咖")).click();
			new UiObject(new UiSelector().text("拍摄照片")).click();

			// getUiDevice().click(100, 300);// 根据不同手机相册的展示选取一张照片
			// 三星s5
			/*
			 * new UiObject(new UiSelector().resourceId("android:id/content"))
			 * .click();
			 */
			// N5
			new UiObject(
					new UiSelector()
							.resourceId("com.android.camera2:id/shutter_button"))
					.click();
			sleep(1000);
			new UiObject(
					new UiSelector()
							.resourceId("com.android.camera2:id/done_button"))
					.click();
			sleep(3000);

			UiObject xing = new UiObject(new UiSelector().text("明星脸"));
			UiObject share = new UiObject(new UiSelector().text("快来分享骄人战绩吧!"));
			assertTrue("====================================PK--明星脸 no", xing.exists());
			assertTrue("====================================PK--分享 no", share.exists());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();

		}

	}

	/**
	 * 检查大咖配ui
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test10DaGaUI() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// 点击PK
			new UiObject(new UiSelector().text("大咖配")).click();
			new UiObject(new UiSelector().text("拍摄照片")).click();

			new UiObject(
					new UiSelector()
							.resourceId("com.android.camera2:id/shutter_button"))
					.click();
			sleep(1000);
			new UiObject(
					new UiSelector()
							.resourceId("com.android.camera2:id/done_button"))
					.click();
			sleep(4000);
			UiObject xing = new UiObject(new UiSelector().text("夫妻相"));
			UiObject share = new UiObject(new UiSelector().text("快来分享骄人战绩吧!"));
			assertTrue("大咖配--夫妻相 no", xing.exists());
			assertTrue("大咖配--分享 no", share.exists());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
		}

	}

	/**
	 * 检查穿越
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test11ChuanYue() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// 点击穿越
			new UiObject(new UiSelector().text("穿越")).click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/face_pass_camera"))
					.click();

			// getUiDevice().click(100, 300);// 根据不同手机相册的展示选取一张照片
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/capture_layout"))
					.click();
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/btn_beautify"))
					.click();

			sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressBack();

		}

		/*
		 * UiObject share=new UiObject(new UiSelector().text("快来分享骄人战绩吧!"));
		 * assertTrue("PK--分享 no", share.exists());
		 */

	}

	/**
	 * 检查表情实验室模块ui
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test12BiaoQingUI() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			// 返回第一屏幕
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_left_arrow"))
					.click();
		}

	}

}
