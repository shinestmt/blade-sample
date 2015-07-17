package blade.sample;


import blade.Blade;
import blade.BladeApplication;
import blade.kit.log.Logger;
import blade.render.JspRender;

public class App extends BladeApplication{

	Logger logger = Logger.getLogger(App.class);
	
	@Override
	public void init() {
		
		// 设置路由、拦截器包所在包
		Blade.defaultRoute("blade.sample");
			
		Blade.routes("blade.sample.route");
		
		Blade.interceptor("blade.sample.interceptor");
		
		// 设置要扫描的ioc包，可选
		Blade.ioc("blade.sample.service.*");
		
		Blade.view("/WEB-INF/views/", ".jsp");
		
		Blade.viewEngin(JspRender.single());
//		Blade.viewEngin(new JetbrickRender());
		
		Blade.staticFolder("/static");
		
	}
	
	public static void main(String[] args) {
		Blade.run(App.class, 9000);
	}
}