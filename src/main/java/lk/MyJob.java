package lk;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by {lknny@163.com} on 2017/11/21.
 */
public class MyJob implements Job {
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		JobDetail jobDetail = jobExecutionContext.getJobDetail();
		String name = jobDetail.getJobDataMap().getString("name");
		System.out.println("你好，" + name);
	}
}
