package blade.sample.route;

import blade.annotation.Inject;
import blade.annotation.Path;
import blade.annotation.Route;
import blade.render.ModelAndView;
import blade.route.HttpMethod;
import blade.sample.service.UserService;
import blade.servlet.Request;
import blade.servlet.Response;

@Path
public class Hello {
	
	@Inject
	UserService userService;
	
	@Route("/hello")
	public void hello(Response response) {
		System.out.println("hello");
		userService.sayHello();
		
		response.render("hello");
	}
	
	@Route(value = "/post", method = HttpMethod.POST)
	public void post() {
		System.out.println("post");
	}
	
	@Route(value = "/test", method = HttpMethod.GET)
	public String test() {
		return "test.jsp";
	}
	
	@Route("/rock/:id")
	public void rock2() {
		System.out.println("rock2");
	}
	
	@Route("/users/:name")
	public void users(Request request, Response response) {
		System.out.println("users");
		String name = request.pathParam(":name");
		request.attribute("name", name);
		response.render("/users.jsp");
	}

	@Route("/index")
	public void index(Response response) {
		ModelAndView modelAndView = new ModelAndView("/index.jsp");
		modelAndView.add("name", "jack");
		response.render(modelAndView);
	}
	
	
	@Route("/you/:username")
	public void you(Request request, Response response) {
		ModelAndView modelAndView = new ModelAndView("/you.jsp");
		modelAndView.add("username", request.pathParam(":username"));
		response.render(modelAndView);
	}
	
}