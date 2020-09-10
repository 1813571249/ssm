package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import po.User;
import service.Service;

import javax.servlet.http.HttpServletRequest;
//采用的是注解的适配器和映射器,开发注解的handle
//实现Controller接口的处理器


//使用下面的注解标识这是一个控制器
@Controller
public class Controller1 {

    //获得serviceImp对象
    @Autowired(required=true)
    private Service serviceImp;

    @Autowired(required=true)
    private User user;

    //定义方法   RequestMapping实现对queryItems方法和url进行映射(一般建议将url与方法名一致）（url后后面可加可不加.action）
    @RequestMapping("/login")
    public ModelAndView queryItems() throws Exception{

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        //相当于request的setAttribute,在jsp页面中可以通过getAttribute取数据
        //modelAndView.addObject("list",list );

        //指定视图
        modelAndView.setViewName("WEB-INF/jsp/login.jsp");

        return modelAndView;

    }

    @RequestMapping("/register")
    public ModelAndView register() throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        //指定视图
        modelAndView.setViewName("WEB-INF/jsp/register.jsp");
        return modelAndView;
    }

    //@RequestParam(value="username")注解指定前端页面传入的值的名字与controller参数绑定在一起，如果不使用这个注解，则参数的名称必须和前端页面上所要的值的名称一致
    //@RequestParam(value="username",required=true或false)注解通过required=true或false来决定这个参数是否必须要传入
    //@RequestParam(value="username",required=true或false,defaultValue="")注解通过defaultValue=""给参数传入默认值
    //参数也可以用一个po类来接收。页面上的name与po类中的属性名一致就行。还如果属性中有日期类型，需要在适配器中自己定义转换器。如果属性中还有pojo类，则页面中需要使用属性.属性的方式命名

    @RequestMapping("/LoginHandle")
    public ModelAndView Login(HttpServletRequest request,@RequestParam(value="username") String username,@RequestParam(value="password") String password) throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        if(serviceImp.Login(username, password)){
            modelAndView.setViewName("WEB-INF/jsp/register.jsp");
        }
        else{
            modelAndView.setViewName("WEB-INF/jsp/login.jsp");
            request.setAttribute("message", "用户名或密码错误");
        }

        return modelAndView;
    }

    @RequestMapping("/registerHandle")
    public ModelAndView registerHandle(HttpServletRequest request, String username, String telephone, String email, String password, String password2) throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        user.setUsername(username);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setPassword(password);

        if(password.equals(password2)){
            if(serviceImp.register(user)){
                modelAndView.setViewName("WEB-INF/jsp/login.jsp");
            }
            else{
                modelAndView.setViewName("WEB-INF/jsp/register.jsp");
                request.setAttribute("message", "用户名已存在");
            }
        }
        else{
            modelAndView.setViewName("WEB-INF/jsp/register.jsp");
            request.setAttribute("message", "两次密码不一致");
        }

        return modelAndView;
    }

}
