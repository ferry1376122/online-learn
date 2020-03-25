package org.online.learn.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@EnableEurekaServer
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OnlineLearnEureka {
    public static void main(String[] args) {
        log.debug("OnlineLearnEureka startup main");
        SpringApplication application = new SpringApplication(OnlineLearnEureka.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
