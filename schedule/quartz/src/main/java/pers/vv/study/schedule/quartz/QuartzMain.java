package pers.vv.study.schedule.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job41", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1)).build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

}
