package com.prac.gateway.fallback;

import com.netflix.client.ClientException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) throws ClientException {
        System.out.println("IN custom-error handler....");
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("custom-error");
        if(status == 500) {
            modelAndView.addObject("message", "Sorry! Please try later");
        } else if (status == 400) {
            modelAndView.addObject("message", "The page you are looking for is not found");
        }
        return "custom-error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
