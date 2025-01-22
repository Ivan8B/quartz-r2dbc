package dev.r2dbc_quartz.demo.job;

import dev.r2dbc_quartz.demo.service.SomethingService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {
    private final SomethingService service;

    public SampleJob(SomethingService service) {
        this.service = service;
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        service.doCreateSomething();
    }
}