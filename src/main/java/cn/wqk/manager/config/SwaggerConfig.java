package cn.wqk.manager.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/*
*
                @Api(tags = "xxx模块说明")	作用在模块类上
                @ApiOperation("xxx接口说明")	作用在接口方法上
                @ApiModel("xxxPOJO说明")	作用在模型类上：如VO、BO
                @ApiModelProperty(value = "xxx属性说明",hidden = true)	作用在类方法和属性上，
                                                                        hidden设置为true可以隐藏该属性
                @ApiParam("xxx参数说明")	作用在参数、方法和字段上，类似@ApiModelProperty
                访问/swagger-ui.html
*
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(@Qualifier("apiInfo") ApiInfo apiInfo){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                //开启Swagger，默认是false
                .enable(true)
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                //扫描所有接口
                //.apis(RequestHandlerSelectors.any())
                //不扫描任何接口
                //.apis(RequestHandlerSelectors.none())
                //扫描控制器类方法上带有GetMapping注解的接口
                //.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                //扫描控制器类上带有RequestMapping注解的接口
                //.apis(RequestHandlerSelectors.withClassAnnotation(RequestMapping.class))
                //扫描这个包里的接口
                .apis(RequestHandlerSelectors.basePackage("cn.wqk.manager.controller"))
                //扫描这个请求路径的接口
                //.paths(PathSelectors.ant("/wx/**"))
                .build();
    }
    //配置自定义作者信息apiInfo
    @Bean(name = "apiInfo")
    public ApiInfo apiInfo(){
        return new ApiInfo(
                "吴青珂的swaggerAPI配置文档",
                "Api接口配置文档",
                "v1.0",
                "urn:tos",
                new Contact("吴青珂", "", "a954278478@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}