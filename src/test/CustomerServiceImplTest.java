package test;

import com.aia.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)//把原有的main函数替换掉，换成由Spring提供的
@ContextConfiguration(locations = {"classpath:bean.xml"})//告知Spring配置文件的位置
public class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void saveCustomer() {
        customerService.saveCustomer();
    }
}