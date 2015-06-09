package blade.sample.route;

import blade.annotation.Path;
import blade.annotation.Route;
import blade.render.ModelAndView;
import blade.wrapper.Response;

@Path
public class R {
	
	@Route("/aaa")
	public String aaa(){
		System.out.println("进入aaa");
		return "aaa";
	}
	
	@Route("/bbb")
	public void bbb(Response response){
		System.out.println("进入bbb");
		response.render("bbb");
	}
	
	@Route("/ccc")
	public ModelAndView bbb(){
		System.out.println("进入ccc");
		ModelAndView modelAndView = new ModelAndView("ccc");
		return modelAndView;
	}
	
}
