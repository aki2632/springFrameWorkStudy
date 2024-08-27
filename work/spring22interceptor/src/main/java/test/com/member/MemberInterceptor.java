package test.com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle()...");
		
		String sPath = request.getServletPath();
		log.info("sPath: {}", sPath);
		log.info("session user_id: {}", session.getAttribute("user_id"));
		
		if(sPath.equals("/selectAll.do") || sPath.equals("/selectOne.do")) {
			if(session.getAttribute("user_id") == null) {
				response.sendRedirect("login.do");
				return false;
			}
			
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle()...");
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
