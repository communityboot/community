package com.muchi.community.quartz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yuzq
 * @since 2019-09-25
 */
public class SysQrtzCron implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * cronId
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 定时任务名称
     */
    @TableField("scheName")
    private String scheName;

    /**
     * 任务名称
     */
    @TableField("jobName")
    private String jobName;

    /**
     * 触发器名称
     */
    @TableField("triggerName")
    private String triggerName;

    /**
     * 触发器组
     */
    @TableField("triggerGroup")
    private String triggerGroup;

    /**
     * cron表达式
     */
    @TableField("cronExpression")
    private String cronExpression;

    /**
     * 时区
     */
    @TableField("timeZone")
    private String timeZone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheName() {
        return scheName;
    }

    public void setScheName(String scheName) {
        this.scheName = scheName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "SysQrtzCron{" +
                "id=" + id +
                ", scheName=" + scheName +
                ", jobName=" + jobName +
                ", triggerName=" + triggerName +
                ", triggerGroup=" + triggerGroup +
                ", cronExpression=" + cronExpression +
                ", timeZone=" + timeZone +
                "}";
    }
}
