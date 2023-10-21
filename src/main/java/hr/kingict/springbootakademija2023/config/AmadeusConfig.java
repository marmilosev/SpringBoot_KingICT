package hr.kingict.springbootakademija2023.config;

import com.amadeus.Amadeus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmadeusConfig {
    @Bean
    public Amadeus getAmadeus(){
        return Amadeus
                .builder("lspUSnbSJ3kdrZHriJUX1QDHT3QW3YCk", "ltDR62UdsJIbuht3")
                .build();
    }
}
