package br.com.lis2b.voos.infra;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class AmadeusFeignConfiguration {
    private final TokenGenerator tokenGenerator;

    @Bean
    public RequestInterceptor requestInterceptor() {
        log.debug("[start] AmadeusFeignConfiguration - requestInterceptor");
        return template -> {
            String authorizationToken = tokenGenerator.generateAuthorizationToken();
            log.debug("[authorizationToken] {}",authorizationToken);
            template.header("Authorization", authorizationToken);
            log.debug("[finish] AmadeusFeignConfiguration - requestInterceptor");
        };
    }
}
