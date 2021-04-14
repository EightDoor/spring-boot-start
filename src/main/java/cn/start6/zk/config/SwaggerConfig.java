package cn.start6.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author zhoukai swagger配置
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        // apis api swagger接口提取范围
        return new Docket(DocumentationType.OAS_30).apiInfo(this.apiInfo()).enable(true).select()
            .apis(RequestHandlerSelectors.basePackage("cn.start6.zk")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring-boot-admin 后台管理").description("后台管理系统")
            .contact(new Contact("周凯", "https://github.com/EightDoor/spring-boot-start", "851708184@qq.com"))
            .version("1.0").build();
    }
}
