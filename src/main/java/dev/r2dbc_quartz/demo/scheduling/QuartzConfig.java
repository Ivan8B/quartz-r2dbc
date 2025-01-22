package dev.r2dbc_quartz.demo.scheduling;

import jakarta.annotation.PostConstruct;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartzConfig {
    private final Logger logger = LoggerFactory.getLogger(QuartzConfig.class);
    private final Scheduler scheduler;
    private final SampleJob job;

    public QuartzConfig(Scheduler scheduler, SampleJob job) {
        this.scheduler = scheduler;
        this.job = job;
    }

    @PostConstruct
    public void scheduleJob() throws SchedulerException {
        try {
            JobBuilder jobBuilder = JobBuilder.newJob(SampleJob.class);
            jobBuilder.withIdentity("Some job 1", "Some group 1");
            JobDetail jobDetail = jobBuilder
                    .withIdentity("Some job 1", "Some group 1")
                    .usingJobData("id", "1")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("Some Trigger 1", "Some group 1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * *"))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (org.quartz.ObjectAlreadyExistsException e) {
            logger.error("Trigger already exists");
        }
    }
}

