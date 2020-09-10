package pers.vv.study.schedule.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class HelloJob implements Job {

    public void execute(JobExecutionContext context) {
        System.out.println("Hello Quartz~~~");
    }

}
