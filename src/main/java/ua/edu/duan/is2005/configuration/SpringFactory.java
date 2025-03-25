package ua.edu.duan.is2005.configuration;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.edu.duan.is2005.filter.StudentFilter;


@Configuration
public class SpringFactory {

    @Bean
    public FilterRegistrationBean<StudentFilter> studentFilter() {
        FilterRegistrationBean<StudentFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new StudentFilter());
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

}
