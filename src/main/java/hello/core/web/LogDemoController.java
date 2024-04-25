package hello.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	// 생존범위가 request가 들어와서 나갈 때인데, 컨테이너가 뜨는 시점에 HttpRequest가 존재 x
	// provider가 해결책
	private final MyLogger myLogger;
	// private final ObjectProvider<MyLogger> myLoggerProvider;


	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) throws InterruptedException {
		String requestURL = request.getRequestURI().toString();
		// MyLogger myLogger = myLoggerProvider.getObject();
		System.out.println("myLogger = " + myLogger.getClass());
		myLogger.setRequestURL(requestURL);

		myLogger.log("controller test");
		Thread.sleep(1000);
		logDemoService.logic("testId");
		return "OK";
	}
}
