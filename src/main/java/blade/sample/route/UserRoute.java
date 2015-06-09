package blade.sample.route;

import blade.annotation.Inject;
import blade.sample.service.UserService;

public class UserRoute {

	@Inject
	UserService userService;
	
	public void run(){
		userService.sayHello();
	}
}
