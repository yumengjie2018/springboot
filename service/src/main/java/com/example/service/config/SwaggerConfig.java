package com.example.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Controller
@ApiIgnore
public class SwaggerConfig {
	@Value("${swaggerEnable}")
	private Boolean enableSwagger;

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("测试app").description("").termsOfServiceUrl("http://www.boco.com/")
				.version("1.0").build();
	}

	@RequestMapping("/api")
	public void api(HttpServletResponse response) {
		try {
			String rUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/swagger-ui.html").build()
					.toUriString();
			response.sendRedirect(rUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Bean
	public Docket api() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<>();
		tokenPar.name("authorization").description("token").modelRef(new ModelRef("string")).defaultValue("")
				.parameterType("header").required(false).build();
		pars.add(tokenPar.build());
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				 //.paths(PathSelectors.regex("/ap(i|p)/((?!login).)*"))
				.paths(PathSelectors.regex("/ap(i|p)/.*")).build().globalOperationParameters(pars).apiInfo(apiInfo());
	}

	public SwaggerConfig() {
		System.out.println("TestConfiguration容器启动初始化。。。");
	}
}
