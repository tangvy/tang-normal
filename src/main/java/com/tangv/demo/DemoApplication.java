package com.tangv.demo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.tangv.demo.dao")
public class DemoApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }


    /*
     *tomcatEmbedded 这段代码是为了解决，上传文件大于10M出现连接重置的问题。此异常内容 GlobalException 也捕获不到。
     * */
    @Bean
    public TomcatServletWebServerFactory tomcatEmbedded(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer)  connector -> {
            if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>){
                ((AbstractHttp11Protocol) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return  tomcat;
    }

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(DemoApplication.class, args);
    }

}
