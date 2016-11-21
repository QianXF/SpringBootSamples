package com.qianxuefeng.spring.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 错误页面配置
 * @author qianxuefeng
 * @since 2016年10月8日
 */
@Configuration
public class ErrorConfig {
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new MyCustomizer();
	}

	private static class MyCustomizer implements EmbeddedServletContainerCustomizer {
		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
			container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
		}
	}

}