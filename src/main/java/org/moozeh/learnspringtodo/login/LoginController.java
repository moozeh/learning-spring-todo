package org.moozeh.learnspringtodo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * JSP 에서 Model 이라는 것에 대해 알아보자
     *
     * 컨트롤러에서 JSP로 무언가를 전달하려고 할때, 우리는 이것을 모델에 넣어서 전달할 수 있다.
     * ModelMap 이라는 Bean 이 스프링에 정의되어 있으며 의존성 주입으로 쉽게 받아올 수 있다.
     * 이 ModelMap 에 넣어서, jsp 에서 ${} 와 같이 JS 템플릿 문자열에서 변수를 넣는것처럼 사용하면 된다.
     *
     * 여기서 실제로 사용하려면 깊게 이해를 해야한다. name이 정의되지 않았을 때는 어떤 일이 일어날까?
     * @param name
     * @return
     */
    @RequestMapping("login")
    public String login(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        logger.debug("Request param is {}", name); // logger 를 이용하여 로깅 수준을 조절할 수 있다. 단순 print 를 사용하지 않아야하는 이유.
        return "login";
    }
}
