package blade.sample.route;

import blade.annotation.Inject;
import blade.annotation.Path;
import blade.annotation.Route;
import blade.render.ModelAndView;
import blade.render.R;
import blade.route.HttpMethod;
import blade.sample.service.UserService;
import blade.wrapper.Request;
import blade.wrapper.Response;

@Path("/index")
public class Hello {
	
	@Inject
	UserService userService;
	
	@Route("/hello")
	public String hello() {
		System.out.println("hello");
		userService.sayHello();
		
		return R.render("hello.jsp");
	}
	
	@Route(value = "/post", method = HttpMethod.POST)
	public void post() {
		System.out.println("post");
	}
	
	@Route("/rock/:id")
	public void rock2() {
		System.out.println("rock2");
	}
	
	@Route("/users/:name")
	public void users(Request request, Response response) {
		System.out.println("users");
		String name = request.pathParam(":name");
//		ModelAndView modelAndView = new ModelAndView("/users.jsp");
//		modelAndView.add("name", name);
		request.attribute("name", name);
		R.render("/users.jsp");
	}

	@Route("/index")
	public void index() {
		ModelAndView modelAndView = new ModelAndView("/index.jsp");
		modelAndView.add("name", "jack");
		R.render(modelAndView);
	}
	
}