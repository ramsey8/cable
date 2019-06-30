package cn.cyf;

import cn.cyf.common.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequiresPermissions("article:list")
    @GetMapping("/a")
    public ResponseData test() {
        return ResponseData.ok();
    }
}
