package eu.senla.configuration;

import eu.senla.interceptor.RequestInterceptor;
import eu.senla.interceptor.RequestInterceptorImpl;
import eu.senla.interceptor.ResponseInterceptor;
import eu.senla.interceptor.ResponseInterceptorImpl;
import eu.senla.service.RequestService;
import eu.senla.service.ResponseService;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = "eu.senla")
@EnableMongoRepositories({"eu.senla.repository"})
@EnableConfigurationProperties(StarterSelfMadeProperties.class)
public class StarterSelfMadeConfiguration {

    private final RequestService requestService;
    private final ResponseService responseService;


//    @Bean(name = "filterRegistrationBeanRequest")
//    @ConditionalOnMissingBean(RequestInterceptor.class)
//    public FilterRegistrationBean<Filter> filterFilterRegistrationBeanRequest(){
//        var filterRegistrationBean = new FilterRegistrationBean<Filter>();
//        filterRegistrationBean.setFilter(new RequestInterceptorImpl(requestService));
//        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
//        return  filterRegistrationBean;
//    }
    @Bean(name = "filterRegistrationBeanResponse")
    @ConditionalOnMissingBean(ResponseInterceptor.class)
    public FilterRegistrationBean<Filter> filterFilterRegistrationBeanResponse(){
        var filterRegistrationBean = new FilterRegistrationBean<Filter>();
        filterRegistrationBean.setFilter(new ResponseInterceptorImpl(responseService));
        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
        return  filterRegistrationBean;
    }
}
