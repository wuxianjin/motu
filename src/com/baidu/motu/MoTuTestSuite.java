package com.baidu.motu;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * todo 在junit3下测试集
 * 
 * @author wuxianjin
 * 
 *         2014-10-31
 */
public class MoTuTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Sample Tests");

		/* 逐一添加testCase类 */
		suite.addTestSuite(FirstStart.class);
		suite.addTestSuite(UITest.class);
		suite.addTestSuite(MeiHuaTest.class);
		suite.addTestSuite(PinTuTest.class);

		return suite;
	}

}
