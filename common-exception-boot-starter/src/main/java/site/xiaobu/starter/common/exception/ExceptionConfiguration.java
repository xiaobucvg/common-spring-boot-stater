package site.xiaobu.starter.common.exception;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.Bean;
import site.xiaobu.starter.common.exception.handler.BasicExceptionHandler;
import site.xiaobu.starter.common.exception.handler.DataAccessExceptionHandler;
import site.xiaobu.starter.common.exception.handler.ServletExceptionHandler;
import site.xiaobu.starter.common.exception.handler.ValidationExceptionHandler;

/**
 * 统一异常处理处理器配置
 *
 */
@SpringBootConfiguration
@ConditionalOnMissingBean(ExceptionConfiguration.class)
@ConditionalOnProperty(name = "common.exception-handler.enable", matchIfMissing = true, havingValue = "true")
public class ExceptionConfiguration {
    @Bean
    @ConditionalOnBean(ValidationAutoConfiguration.class)
    @ConditionalOnMissingBean(ValidationExceptionHandler.class)
    public ValidationExceptionHandler validationExceptionHandler() {
        return new ValidationExceptionHandler();
    }

    @Bean
    @ConditionalOnBean(DataSourceAutoConfiguration.class)
    @ConditionalOnMissingBean(DataAccessExceptionHandler.class)
    public DataAccessExceptionHandler dataAccessExceptionHandler() {
        return new DataAccessExceptionHandler();
    }

    @Bean
    @ConditionalOnWebApplication
    @ConditionalOnMissingBean(ServletExceptionHandler.class)
    public ServletExceptionHandler servletExceptionHandler() {
        return new ServletExceptionHandler();
    }

    @Bean
    @ConditionalOnMissingBean(BasicExceptionHandler.class)
    public BasicExceptionHandler basicExceptionHandler() {
        return new BasicExceptionHandler();
    }
}
