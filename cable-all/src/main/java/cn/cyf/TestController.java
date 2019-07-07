package cn.cyf;

import cn.cyf.common.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试")
public class TestController {

    @RequiresPermissions("article:list")
    @GetMapping("/a")
    @ApiOperation(httpMethod = "POST", value="测试api")
    public ResponseData test() {
        return ResponseData.ok();
    }
}
