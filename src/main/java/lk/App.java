package lk;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;

/**
 * Created by ${lknny@163.com} on 2017/11/15.
 */
public class App {

	public static void main(String[] args) {

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.build();

		JobDetail job = new JobDetailImpl().getJobBuilder().ofType(MyJob.class)
				.withIdentity("group1","job1")
				.usingJobData("name","liukun")
				.build();


		MyScheduler scheduler=new MyScheduler(trigger,job);
		try {
			scheduler.start();
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			scheduler.shutdown();
		}
	}

}
