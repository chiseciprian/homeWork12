package ro.fasttrackit.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fasttrackit.fanout");
    }
}
