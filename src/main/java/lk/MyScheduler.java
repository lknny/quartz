package lk;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class MyScheduler {
	private Scheduler scheduler ;

	public MyScheduler(Trigger trigger, JobDetail job) {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(job,trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	public void start(){
		try {
			this.scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void shutdown() {
		try {
			this.scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
