import com.cloud.springcloud.Consoumer80Appllication;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @create 2021-01-29 21:28
 */
@SpringBootTest(classes = Consoumer80Appllication.class)
@RunWith(SpringRunner.class)
public class TestConsumer {

    @Autowired
    private RestTemplate restTemplate;
    private  static  final  String prfex="http://localhost:8001";
    @Test
    public void test1(){
        Payment payment = new Payment();
        payment.setSerial("李四");
        CommonResult forObject = restTemplate.postForObject(prfex + "/payment/create",payment, CommonResult.class);
        System.out.println(forObject.toString());
    }
    @Test
    public void test2(){
        CommonResult forObject = restTemplate.getForObject(prfex + "/payment/get/"+2,CommonResult.class);
        System.out.println(forObject.toString());
    }
}
