import com.cloud.PayMentApplication8001;
import com.cloud.pojo.Payment;
import com.cloud.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Administrator
 * @create 2021-01-29 20:53
 */
@SpringBootTest(classes = PayMentApplication8001.class)
@RunWith(value = SpringRunner.class)
public class TestService {



    @Autowired
    private PaymentService paymentService;
    @Test
    public void test1(){


        Payment payment = new Payment();
        payment.setSerial("张三");
        int i = this.paymentService.create(payment);
        System.out.println(i);

    }

    @Test
    public void test2(){
        List<Payment> selects = this.paymentService.selects(1);
        selects.forEach(System.out::println);

    }
}
