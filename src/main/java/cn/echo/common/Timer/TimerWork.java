package cn.echo.common.Timer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/15.
 */
@Component
public class TimerWork {
	@Value("#{moduleProperties['task.switch']}")
	private String taskSwitch;

	@Scheduled(cron = "0/10 * *  * * ? ") // 每5秒执行一次
	public void work() {
		if (taskSwitch.equals("close")) {
			return;
		} else {
			System.out.println("hello world");
		}
	}
}
