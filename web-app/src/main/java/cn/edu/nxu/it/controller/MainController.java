package cn.edu.nxu.it.controller;

import cn.edu.nxu.it.aop.LoginValidator;
import cn.edu.nxu.it.aop.RegisterValidator;
import cn.edu.nxu.it.model.Movie;
import cn.edu.nxu.it.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Kv;
import com.jfinal.kit.LogKit;
import com.jfinal.plugin.activerecord.ActiveRecordException;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class MainController extends Controller {

    //首页
//    public void index() {
//        renderFreeMarker("index.ftl");
//    }

    //显示登录页面
    public void login() {
        /*将传入的redirect参数传入模板 相当于
            String redirectUrl = getPara("redirectUrl");
            setAttr("redirectUrl", redirectUrl):
         */
        keepPara("redirectUrl"); //跳转url
       renderFreeMarker("login.ftl");
    }

    public void index(){
        int p = getParaToInt("p",1);
        Page<Movie> page = Movie.dao.paginate(p, 5,
                "SELECT *", "FROM t_movie");
        setAttr("page",page);
        renderFreeMarker("index.ftl");
    }

    //退出登录
    public void logout() {
        removeSessionAttr("username");
        redirect("/login");
    }

    //注册
    public void register(){
        renderFreeMarker("register.ftl");
    }

//文件上传访问路径
    public void up(){
        renderFreeMarker("upload.ftl");
    }

    //系统首页
    public void home(){
        renderFreeMarker("index.ftl");
    }

public void showMovies(){
        renderFreeMarker("show_movies.ftl");
}

/**
 * 注册判断
 */
@Before(RegisterValidator.class)
    public void registerCheck(){
        String username = getPara("username");
        String password = getPara("password");
        String repassword = getPara("repassword");
        String email = getPara("email");
        Boolean gender = getParaToBoolean("gender");
        String captcha = getPara("captcha");
        System.out.println(username+password+email+gender+captcha+repassword);

        User user = new User();
        user.setUsername(username);
        user.setPassword(HashKit.md5(password));
        user.setEmail(email);
        user.setGender(gender);
        boolean success = false;
        String message = "注册失败";
        try {
            user.save();
            success=true;
        }catch (ActiveRecordException e){
            LogKit.error("用户注册失败，原因："+ e.getMessage());
            e.printStackTrace();
        }
        Kv result = Kv.create();
        result.set("message",message);
        result.set("success",success);
        renderJson(result);



    }
    /**
     * 登录判断
     */
    @Before(LoginValidator.class)
    public void loginCheck() {

        String username = getPara("username");
        String password = getPara("password");
        String redirectUrl = getPara("redirectUrl", "/");
        Kv result = Kv.create();
        boolean success = false;
        String message = "用户名或密码错误";
        //TODO: 需要从数据库中判断用户名和密码的正确
        String sql = "select * from t_user where username = ? and password = md5(?)";
        List<User> users = User.dao.find(sql,username,password);
        System.out.println(users);

        if (users.size() != 0){
            message = "登录成功";
            success = true;
            result.set("redirectUrl", redirectUrl);
            //登录成功则将用户名写入session中以在之后判断用户登录状态
            User user = users.get(0);
            setSessionAttr("user", user);
        }
        result.set("message", message).set("success", success);
        renderJson(result);
    }

    //显示验证码
    public void captcha() {
        renderCaptcha();
    }

}