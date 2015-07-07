package com.baidu.motu;

import java.io.IOException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 初次安装完成后、引导页等一次性出现的界面再此类中验证
 * 
 * @author wuxianjin
 * 
 *         2014-09-31
 */
public class FirstStart extends UiAutomatorTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getUiDevice().pressHome();

		try {
			UiObject motu = new UiObject(new UiSelector().text("百度魔图"));
			motu.clickAndWaitForNewWindow();
			sleep(3000);
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
		getUiDevice().pressBack();// 第一次安装时打开，跳过引导页
		sleep(1000);
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

}
