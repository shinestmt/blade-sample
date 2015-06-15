package blade.sample.interceptor;

import blade.annotation.After;
import blade.annotation.Before;
import blade.annotation.Interceptor;
import blade.http.Request;

@Interceptor
public class BaseInterceptor {
	
	@Before("/*")
	public void baseLanJie(){
		System.out.println("before...");
	}
	
	@After("/*")
	public void after(Request request){
		// 设置context path
		request.attribute("ctx", request.contextPath());
		
		System.out.println("after...");
	}
}
