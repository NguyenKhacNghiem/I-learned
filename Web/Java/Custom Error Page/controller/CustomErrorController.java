package ex1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;

@Controller
public class CustomErrorController implements ErrorController {
	private int getErrorCode(HttpServletRequest httpRequest) {
        Object errorCode = httpRequest.getAttribute(ERROR_STATUS_CODE);
        return errorCode == null ? 0 : (Integer)errorCode;
    }
	
	@RequestMapping("/error") // mặc định là GET
    public String errorPage(HttpServletRequest httpRequest, Model model) {
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
        
        // Dựa vào mã lỗi của HTTP được trả về mà hiển thị message tương ứng
        switch (httpErrorCode) {
            case 400:
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            case 401: 
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            case 404: 
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            case 500: 
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            default: 
                errorMsg = "Error";
                break;
        }
        
        model.addAttribute("errorMsg", errorMsg);
        return "errorPage";
    }
}
