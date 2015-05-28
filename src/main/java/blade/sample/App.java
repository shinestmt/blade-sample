package blade.sample;


import org.apache.log4j.Logger;

import blade.Blade;
import blade.BladeApplication;

public class App implements BladeApplication{

	Logger logger = Logger.getLogger(App.class);
	
	@Override
	public void init() {
		
		// 设置路由所在包
		Blade.routes("blade.sample.route");
		
		// 设置拦截器包
		Blade.interceptor("blade.sample.interceptor");
		
		
	}
	
}