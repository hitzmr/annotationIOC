package com.aia.service.impl;

import com.aia.dao.CustomerDao;
import com.aia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;


/*
 * 注解的分类
 *      1.用于创建bean对象
 *          @Component
 *              作用：相当于配置了一个bean标签
 *              位置：类上
 *              属性：value。 用于指定bean的id，当不写时，默认为首字母小写的类名
 *
 *          由此注解衍生的三个注解：
 *              @Controller:表现层
 *              @Service：业务层
 *              @Repository：持久层
 *              这三个和 @Component的使用是一样的
 *      2.用于注入数据
 *          @Autowired
 *              作用：自动按照类型注入。主要有唯一的类型匹配就能注入成功。不要求必须有setter方法
 *              Spring首先会在容器中按照类型找对应的bean，如果找到多个类型匹配的bean，那么再按照声明的变量名去找对应的bean
 *              在此例中，由于实现了CustomerDao的类有两个，当Spring尝试从容器中找到多个实现了CustomerDao接口的bean时，就会转而用变量名称去找，
 *              即使用customerDaoImpl1(使用@Service注入时默认按照首字母小写的变量名称)找
 *          @Qualifier
 *              作用：在自动按照类型注入的基础上，再按照bean的id注入。
 *              它给类成员注入时，不能独立使用，但是当给方法的形参注入数据时可以单独使用。
 *          @Resource
 *              作用：直接按照bean的id注入
 *              属性：
 *                  name：用于指定bean的id
 *          *****************以上都是用于注入其它类型的bean，当需要注入基本数据类型和String类型的数据时，需要使用@Value
 *          @Value
 *              作用：用于注入基本类型和String类型的数据。它可以借助Spring和el表达式读取properties文件中的配置
 *              属性：
 *                  value：用于注入要注入的数据
 *
 *      3.用于改变作用范围
 *          @Scope
 *             作用：改变bean的作用范围
 *             取值范围：和xml中的scope属性取值一样
 *      4.和生命周期相关的
 *      5.spring新注解
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    /*
     * 解决找到多个同类型的bean时无法注入的方式
     *      1.使用变量名称指定为对应的类名，首字母小写
     *      2.使用@Qualifier指定类名，首字母小写
     *      3.直接使用@Resource
     */
    @Autowired
    private CustomerDao customerDaoImpl1;

    @Autowired
    @Qualifier("customerDaoImpl2")
    private CustomerDao customerDao;

//    @Resource(name="customerDaoImpl1")
//    private CustomerDao customerDao3;

    @Value("@Value注入")
    private String name;

    @Override
    public void saveCustomer() {
        System.out.println("业务层" + name);
        customerDaoImpl1.saveCustomer();
        customerDao.saveCustomer();
    }
}
