package com.aia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//使用这种方法可以代替Spring的xml配置文件， ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
@ComponentScan("com.aia")
@Import({JdbcConfig.class})//导入其他配置类。当我们需要JdbcConfig中的对象时，此时让Spring帮助我们创建对象并且存放在容器中，而不是直接就创建
@PropertySource({"classpath:com/aia/config/springConfig.properties"})// 用于从配置文件中读取数据，并使用@Value("${name}")，即Spring的el表达式将数据注入。

public class SpringConfig {

    //@Bean(name="")把方法的返回值存入到Spring容器中。name用于指定bean的id，当不指定时，值为方法名称
    @Value("${name}")
    private String name;
}
