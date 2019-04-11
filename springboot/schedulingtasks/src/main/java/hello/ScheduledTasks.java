package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author CKH
 * @date 2018/12/17 19:29
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
     * 可以使用@Scheduled(cron=". . .")
     *
     * 在例子中，使用了@Scheduled(fixedRate = 5000) 注解来定义每过5秒执行的任务，对于@Scheduled的使用可以总结如下几种方式：
     *
     */
     //@Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     //@Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     //@Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     // @Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", DATE_FORMAT.format(new Date()));
    }
}
