package blade.sample.interceptor;

import com.blade.annotation.After;
import com.blade.annotation.Before;
import com.blade.annotation.Interceptor;
import com.blade.wrapper.Request;

@Interceptor
public class BaseInterceptor {
	
	@Before("/qqq/*")
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
