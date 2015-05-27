package blade.sample;


import org.apache.log4j.Logger;

import com.blade.BladeApplication;
import com.blade.BladeBase;

public class App implements BladeApplication{

	Logger logger = Logger.getLogger(App.class);
	
	@Override
	public void init() {
		// 设置路由所在包
		BladeBase.routePackages("com.helloworld.route");
		BladeBase.interceptPackage("com.helloworld.interceptor");
		logger.info("初始化...");
	}
	
}