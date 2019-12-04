package infnet.group.project.interceptor;

import infnet.group.project.repository.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorLogin implements HandlerInterceptor {

    @Autowired
    ClientSession clientSession;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        Client client = clientSession.getLoggedUser();
        if(client != null) {
            return true;
        } else if(url.contains("/client/create") || url.contains("login")) {
            return true;
        }
        String loginPage = httpServletRequest.getContextPath() + "/login/doLogin";
        httpServletResponse.sendRedirect(loginPage);
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
