package gom.cave.sleep.helloWorld.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sleepbear on 2016. 5. 19..
 */
@Controller
public class HelloController {
    @RequestMapping("/spring/hello")
    public void hello(Model model) {
        model.addAttribute("hello gom");
    }
}
