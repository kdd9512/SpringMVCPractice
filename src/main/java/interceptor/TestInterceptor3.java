package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor3 implements HandlerInterceptor {
    // Controller 의 메서드가 호출되기 이전에 호출
    // return 값이 false 이면 요청 처리에 대한 진행이 중단됩니다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TestInterceptor3 - preHandle");
        return true;
    }

    // Controller 의 메서드가 호출된 이후 호출.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TestInterceptor3 - postHandle");
    }

    // View 처리까지 완료되면 호출된다.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TestInterceptor3 - afterCompletion");
    }
}
