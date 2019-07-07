package cn.cyf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Desc :swagger的ui的设置
 * @Auther : G.D Chen
 * @Create : 2019-06-30 16:39
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.address:}")
    private String swaggerAddress;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    /**
     * 功能描述 : 设置swagger的文件名称
     * @param
     * @return : springfox.documentation.service.ApiInfo
     * @Auther : G.D Chen
     * @Date : 2019-06-30 16:39
     */
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Boot测试")
                .description("接口文档")
                .version("V_1.0")
//                .licenseUrl(swaggerAddress)
                .build();
    }


}
