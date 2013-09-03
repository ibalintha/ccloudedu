package com.ccloudedu.system.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.utils.string.EncodeUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.JsonResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.system.entity.SysRuleSetting;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.entity.UserLoginLog;
import com.ccloudedu.system.service.RuleSettingService;
import com.ccloudedu.system.service.UserLoginLogService;
import com.ccloudedu.system.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录与退出action
 * @author wade
 * 2009-03-20晚
 */
@Controller("system.action.LoginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport{   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final Log log = LogFactory.getLog(LoginAction.class);
    
    private String loginName;   
    private String password;   
    private String cookieRememberme;//cookie字符串
    private YN rememberMe;  
    private YN forceLogin;//是否强制登录，Y:是，N:否
    private String loginMessage;
    
	@Autowired
    private UserService userService;
	@Autowired
    private UserLoginLogService userLoginLogService;
	@Autowired
	private RuleSettingService LoginRuleSettingService;
	
	//@Autowired
	//private MyMailSender myMailSender;
	
	public String create(){
		return null;
	}
	/**
     * 登录
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public String login()throws Exception{ 
		
        try {   
        	HttpSession session =  Servlets.getSession();
        	SysUser sysUser = Sessions.getSysUser();
        	
            if(sysUser != null && StringUtils.isNotEmpty(sysUser.getId())){//session存在，重新登录
            	session.removeAttribute(Constants.USER_SESSION_KEY); 
            	sysUser = null;
            }
            Map<String,String> paramMap = new HashMap<String, String>();
            //cookie自动登录
            if(StringUtils.isNotBlank(cookieRememberme)){
            	byte[] bv =  EncodeUtils.decodeHex(cookieRememberme);
                String loginNameAndPassword = new String(bv);
                if (StringUtils.isNotEmpty(loginNameAndPassword)) {   
                    String[] split = loginNameAndPassword.split("\\|");   
                    if(split.length==2){
                    	System.out.println(split[1]);
                    	paramMap = new FastMap().newHashMap().set("loginName", split[0]).set("passWord",split[1]);
                        sysUser = userService.findOne("system.findUsers",paramMap);
                    }
                }
            }else{
            	 //非cookie登录
            	System.out.println(EncodeUtils.encodeMd5(password));
            	 paramMap = new FastMap().newHashMap().set("loginName",loginName).set("passWord",EncodeUtils.encodeMd5(password));
            	 sysUser = userService.findOne("system.findUsers",paramMap); 
            }
            
            if(rememberMe==YN.Y){   
            	String cookieValue =  sysUser.getLoginName()+"|"+sysUser.getPassWord();
                Cookie cookie = new Cookie(Constants.COOKIE_REMEMBERME_KEY,EncodeUtils.encodeHex(cookieValue.getBytes()));   
                cookie.setPath(Servlets.getRequest().getContextPath());
                cookie.setMaxAge(7*24*60*60);//7天*24小时*60分*60秒
                Servlets.getResponse().addCookie(cookie);
            } 
            if(sysUser!=null){
            	if(forceLogin==YN.N){
            		 //查询登录规则
	               	 SysRuleSetting loginRuleSetting = LoginRuleSettingService.findOne("login");
	               	 //同一个账号不可重复登录
	               	 if(loginRuleSetting.getRuleCode()==YN.N){
	               		 Map<String,SysUser> onlineUserMap = (Map<String, SysUser>) EhCacheManager.getAll(CacheConstants.HTTP_SESSION_CACHE);
	       	       		 if(onlineUserMap!=null && onlineUserMap.size()>0){
	       	       			  for(String sessionId : onlineUserMap.keySet()){
	       	       				  if(sysUser.getId().equals(onlineUserMap.get(sessionId).getId())){
	       	       					  Renders.renderJson(new JsonResult("repeatLogin"));
	                               	  return NONE;
	       	       				  }
	       	       			  }
	       	       		 }
	               	 }
            	}
                 sysUser.setSysRole(sysUser.getSysRoles().get(0));
                 sysUser.setRoleId(sysUser.getSysRoles().get(0).getId());
                 sysUser.setDepeId(sysUser.getSysDept().getId());
                 sysUser.setLoginTime(DateUtils.getCurrentDate());
                 
                 session.setAttribute(Constants.USER_SESSION_KEY, sysUser);
                 
                 //myMailSender.sendMail(sysUser.getMailbox(), sysUser.getMailboxPassword(),new String[]{"372566232@qq.com"}, "我登录了", "我登录了");
                 Renders.renderJson(new JsonResult("success"));
              
             	 return NONE;
            }else{
            	Renders.renderJson(new JsonResult("用户名或密码不正确"));
            	return NONE;
            }
        }catch (Exception e){   
        	e.printStackTrace();
            Renders.renderJson(new JsonResult("系统出现异常"));
        	return NONE;
        }   
    }   
    /**
     * 注销
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public String logout() throws Exception{   
    	HttpServletRequest request = Servlets.getRequest();
        HttpSession session = request.getSession(false); 
        //清空session
        if (session!=null){
        	  SysUser sysUser = Sessions.getSysUser();
        	  Map<String, YN> ruleSettingMap = (Map<String, YN>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.SYS_RULE_SETTING_KEY);
        	  if(sysUser!=null && ruleSettingMap.get("loginLog")==YN.Y){
        		  //记录登录日志，如果用户直接点击浏览器的关闭按钮，将无法记录登录日志
            	  UserLoginLog userLog = new UserLoginLog();
                  userLog.setLoginIp(Servlets.getClientIp());
                  userLog.setLoginTime(sysUser.getLoginTime());
                  userLog.setCreateTime(sysUser.getLoginTime());
                  userLog.setCreateUser(sysUser);
                  userLog.setLoginUser(sysUser);
                  userLog.setLogoutTime(DateUtils.getCurrentDate());
        		  userLog.setOnlineTimeLength(DateUtils.getTimeLength(userLog.getLoginTime(), userLog.getLogoutTime(), "3"));
        		  
        		  userLoginLogService.save(userLog);
        		
        		  session.removeAttribute(Constants.USER_SESSION_KEY);   
        	  }
    		 
              session.invalidate();
        }   
        //清理cookie 
        /*Cookie[] cookies = request.getCookies();   
        if (cookies!=null && cookies.length>0) {   
            for (Cookie cookie : cookies) {   
                if (Constants.COOKIE_REMEMBERME_KEY.equals(cookie.getName())) {   
                    cookie.setValue("");   
                    cookie.setMaxAge(0);   
                    cookie.setPath(Servlets.getRequest().getContextPath());
                    Servlets.getResponse().addCookie(cookie);   
                    return "logout";   
                }   
            }   
        }   */
        return "logout";   
    }
    //--------------------以下是getter/setter方法----------------------------------------
   
    public String getLoginName() {   
        return loginName;   
    }   
    public YN getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(YN rememberMe) {
		this.rememberMe = rememberMe;
	}
	public void setLoginName(String loginName) {   
        this.loginName = loginName;   
    }   
    public String getPassword() {   
        return password;   
    }   
    public void setPassword(String password) {   
        this.password = password;   
    }   

	public String getLoginMessage() {
		return loginMessage;
	}
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	public YN getForceLogin() {
		return forceLogin;
	}
	public void setForceLogin(YN forceLogin) {
		this.forceLogin = forceLogin;
	}
	public String getCookieRememberme() {
		return cookieRememberme;
	}
	public void setCookieRememberme(String cookieRememberme) {
		this.cookieRememberme = cookieRememberme;
	}
}  
