package BE.licenta.Config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MesajConf {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(
                "classpath:/messages/validator_error_messages",
                "classpath:/messages/secrets"
        );
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
