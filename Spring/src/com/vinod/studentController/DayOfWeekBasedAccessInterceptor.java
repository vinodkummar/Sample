package com.vinod.studentController;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception{
		
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek == 1){
			response.getWriter().write("Site cant be accessed on Sunday. Try accessing site later");
			return false;
		}
		return true;
	}
}
