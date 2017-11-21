package lk;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class MyScheduler {
	private Scheduler scheduler ;

	public MyScheduler(Trigger trigger, JobDetail job) {
		try {
			//默认的调度器
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			//调度器设置job和trigger
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
