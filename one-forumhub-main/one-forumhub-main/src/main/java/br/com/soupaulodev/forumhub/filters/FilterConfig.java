package br.com.soupaulodev.forumhub.filters;

import br.com.soupaulodev.forumhub.security.utils.JwtUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Filter Configurations.
 * This class is responsible for registering the filters in the application.
 * The filters are registered in the order they are added to the FilterRegistrationBean.
 *
 * @author <a href="https://soupaulodev.com.br">soupaulodev</a>
 */
@Configuration
public class FilterConfig {

    private final JwtUtil jwtUtil;
    private final StringRedisTemplate redisTemplate;

    public FilterConfig(JwtUtil jwtUtil, StringRedisTemplate redisTemplate) {
        this.jwtUtil = jwtUtil;
        this.redisTemplate = redisTemplate;
    }

    @Bean
    public RateLimitFilter rateLimitFilter() {
        return new RateLimitFilter(jwtUtil, redisTemplate);
    }

    @Bean
    public FilterRegistrationBean<RateLimitFilter> rateLimitFilterRegistration(RateLimitFilter rateLimitFilter) {
        FilterRegistrationBean<RateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(rateLimitFilter);
        registrationBean.addUrlPatterns("/api/v1/**");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
