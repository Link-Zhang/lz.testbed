package cn.sh.lz.hello;

import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/***
 * @author Link
 * @date 2020/05/13
 * @time 17:24
 */
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {
//        Mode 1:
//        SpringApplication.run(HelloApplication.class, args);

//        Mode 2:
//        SpringApplication app = new SpringApplication(HelloApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

//        Mode 3:
        new SpringApplicationBuilder()
                .sources(Parent.class)
                .child(HelloApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

//    @Bean
//    public TomcatServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//
//        tomcat.addAdditionalTomcatConnectors(redirectConnector());
//        return tomcat;
//    }
//
//    private Connector redirectConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8080);
//        connector.setSecure(false);
//        connector.setRedirectPort(8443);
//        return connector;
//    }
}
