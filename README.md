# SpringBoot_KingICT

config -- AmadeusConfig.java looks like:

```
@Configuration
public class AmadeusConfig {
    @Bean
    public Amadeus getAmadeus(){
        return Amadeus
                .builder("API KEY", "API SECRET")
                .build();
    }
}
```
