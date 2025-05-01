package org.moozeh.learnspringtodo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    // "say-hello" => "Hello! What are you learning today?"

    @RequestMapping("say-hello") // 단순 리퀘스트 매핑을 사용하여 라우팅을 시켜줄 수 있다.
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody // response body를 붙이지 않으면 정적파일을 참조하게 되므로 붙여주어야한다.
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>Hello World!</h1>");
        return "<html><head> <title> My first HTML Page</title> </head> <body>My first html page with body</body></html>";
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        /**
         * 중요한 점은, 정적 리소스로 뷰를 보내줄 수 있는데, 이때 thymeleaf, jsp 를 사용할 수 있다.
         * 아래처럼 할 경우, 이렇게 정의하게 되면 resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp 에 참조하게 된다.
         * 중요한 점은, .jsp 가 아니라 이름만을 명시해주고 있다. -> suffix를 정의해두어야한다.
         * 이런건 어떻게 바로 알게 할 수 있을까?
         * application.properties 에 정의해야한다.
         * prefix, suffix 가 이를 정의해줄 수 있다.
         * 스프링의 경우 META-INF/resources 까지를 알고 있으므로, jsp 파일의 위치를 명시해주기 위해
         * /WEB-INF/jsp 까지만 명시해주면 된다. (jsp 파일을 어디 두는지 참고하기)
         */
        return "sayHello";
    }
}
