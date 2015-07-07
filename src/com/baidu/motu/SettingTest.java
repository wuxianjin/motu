package com.baidu.motu;

import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SettingTest extends UiAutomatorTestCase {
	// @Override
	protected void ssetUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();

		try {
			UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
			motu.clickAndWaitForNewWindow();
			sleep(500);
			// 点击设置
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_setting"))
					.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 设置--登录账号
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test001Login() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		// 点击登录
		try {
			getUiDevice().pressHome();
			UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
			motu.clickAndWaitForNewWindow();
			sleep(500);
			// 取消升级
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/btn_cancel"))
					.click();
			// 点击设置
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/welcome_setting"))
					.click();
			// 点击登录
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_cloud_gallery_login"))
					.click();
			sleep(800);
			// 输入用户名密码
			UiObject name = new UiObject(new UiSelector().className(
					"android.widget.EditText").index(3));
			name.click();
			sleep(500);
			name.setText("yunxiangce_qa");

			UiObject pass = new UiObject(new UiSelector().className(
					"android.widget.EditText").index(5));
			pass.click();
			pass.setText("yunxiangceqa");

			new UiObject(new UiSelector().className("android.widget.Button")
					.index(6)).click();
			sleep(1000);
			UiObject rongliang = new UiObject(new UiSelector().text("已用空间"));
			assertTrue("======================登陆后已用空间丢失", rongliang.exists());
			if (!rongliang.exists()) {
				getUiDevice().pressBack();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 设置--素材管理
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test002sucai() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// 素材管理
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_material_layout"))
					.click();
			// todo 检查已经下载的素材
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(3)).click();
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(2)).click();
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(1)).click();
			new UiObject(new UiSelector().className(
					"android.widget.ImageButton").index(0)).click();
			UiObject sucai = new UiObject(new UiSelector().text("我的素材"));
			assertTrue("======================登陆后我的素材丢失", sucai.exists());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	/**
	 * 设置--视频管理
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test003shipin() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// 视频管理
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/mv_manager_layout"))
					.click();
			UiObject sucai = new UiObject(new UiSelector().text("视频管理"));
			assertTrue("======================登陆后视频管理丢失", sucai.exists());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	/**
	 * 设置--美化图片质量
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test004meihua() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			// 美化图片质量
			meihua();
			sleep(300);
			new UiObject(new UiSelector().text("一般")).click();
			sleep(500);
			meihua();
			new UiObject(new UiSelector().text("高清")).click();
			meihua();
			sleep(300);
			new UiObject(new UiSelector().text("标准")).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void meihua() throws UiObjectNotFoundException {
		new UiObject(
				new UiSelector()
						.resourceId("cn.jingling.motu.photowonder:id/setting_image_size_layout"))
				.click();
	}

	/**
	 * 设置--存贮路径
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test006() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_save_path_layout"))
					.click();
			sleep(300);
			UiObject sucai = new UiObject(new UiSelector().text("手动选择"));
			assertTrue("======================手动选择按钮丢失", sucai.exists());
			new UiObject(new UiSelector().text("取消")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置--保存格式、默认相机、相机声音
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test007() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			new UiObject(new UiSelector().text("jpg")).click();
			new UiObject(new UiSelector().text("png")).click();
			sleep(300);
			new UiObject(new UiSelector().text("系统相机")).click();
			new UiObject(new UiSelector().text("特效相机")).click();
			sleep(300);
			new UiObject(new UiSelector().text("关")).click();
			new UiObject(new UiSelector().text("开")).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置--摄像头方向矫正
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test008fangxiang() throws UiObjectNotFoundException,
			InterruptedException, IOException {
		try {
			// 滑动到底部
			UiScrollable list = new UiScrollable(
					new UiSelector().className("android.widget.ScrollView"));
			list.scrollTextIntoView("关于");
			sleep(300);
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_camera_correct"))
					.click();
			sleep(300);
			new UiObject(new UiSelector().text("前摄像头纠正")).click();
			sleep(300);
			new UiObject(new UiSelector().text("开始纠正")).click();
			sleep(300);
			new UiObject(new UiSelector().text("正确")).click();
			new UiObject(new UiSelector().text("拍照")).click();
			sleep(300);
			new UiObject(new UiSelector().text("正确")).click();
			sleep(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 设置--分享账号设置
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test009fenxiang() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			// 分享账号设置
			new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/setting_share_layout"))
					.click();
			new UiObject(new UiSelector().text("绑定")).click();
			new UiObject(new UiSelector().text("确定")).click();
			sleep(500);
			new UiObject(new UiSelector().text("绑定")).click();
			sleep(4000);
			sleep(3000);
			sleep(3000);
			sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	/**
	 * 设置--反馈
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test010fankui() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			// 反馈
			new UiObject(new UiSelector().text("反馈")).click();
			//
			UiObject fankui = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/feedback_content"));
			fankui.setText("i love motu");
			UiObject email = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/feedback_email"));
			email.setText("wuxianjin@163.com");
			new UiObject(new UiSelector().text("发送")).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置--更新、关于
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void test011up() throws UiObjectNotFoundException,
			InterruptedException, IOException {

		try {

			// 更新
			new UiObject(new UiSelector().text("更新")).click();
			// 有更新的情况
			UiObject up = new UiObject(
					new UiSelector()
							.resourceId("cn.jingling.motu.photowonder:id/btn_cancel"));
			if (up.exists()) {
				up.click();
			}

			// 没有更新的情况弹出tost 短时间内消失不好捕捉
			UiObject zui = new UiObject(new UiSelector().text("程序已经是最新版"));
			// assertTrue(zui.exists());

			// 关于
			new UiObject(new UiSelector().text("关于")).click();
			new UiObject(new UiSelector().text("确定")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
		}

	}

	// 注销登录账号
	public void test012logout() throws Exception {

		UiObject zz = new UiObject(new UiSelector().text("注销"));
		if (zz.exists()) {
			zz.click();
		}
		sleep(500);
		new UiObject(new UiSelector().text("确定")).click();

	}

	// 注销绑定账号
	public void test013jiechu() throws Exception {
		try {
			new UiObject(new UiSelector().text("分享帐号设置")).click();
			sleep(500);
			new UiObject(new UiSelector().text("注销")).click();
			new UiObject(new UiSelector().text("注销")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
		}

	}
}
