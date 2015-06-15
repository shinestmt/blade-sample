package blade.sample;


import org.apache.log4j.Logger;

import blade.Blade;
import blade.BladeApplication;
import blade.render.VelocityRender;

public class App implements BladeApplication{

	Logger logger = Logger.getLogger(App.class);
	
	@Override
	public void init() {
		
		// 设置路由、拦截器包所在包
		Blade.defaultRoute("blade.sample");
		
		// 设置要扫描的ioc包，可选
		Blade.ioc("blade.sample.service.*");
		
		Blade.view("/WEB-INF/views/", ".jsp");
		
		Blade.viewEngin(new VelocityRender());
//		Blade.viewEngin(new JetbrickRender());
		
		Blade.staticFolder("/static");
		
	}
	
	public static void main(String[] args) {
		Blade.run(App.class, 9000);
	}
}