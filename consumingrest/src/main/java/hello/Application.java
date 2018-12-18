package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 执行程序
 * @author CKH
 * @date 2018/12/18 22:06
 */
public class Application {
    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        /*
        {
           type: "success",
           value: {
              id: 10,
              quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
           }
        }
         */
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    }
}
