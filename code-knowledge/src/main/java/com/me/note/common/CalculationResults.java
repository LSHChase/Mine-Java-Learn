/*
 * ------------------------------------------------------------------
 * Copyright © 2018 DtDream Science and Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *       Product: ASR
 *   Module Name: alarm-rule
 *  Date Created: 2018-09-20
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018-09-20      sx-9524
 * ------------------------------------------------------------------
 */
package com.me.note.common;

public class CalculationResults {
    //是否报警:true: 报警, false: 不报警
    private Boolean whetherToAlarm = false;
    //报警内容
    private String alarmContent;

    public Boolean getWhetherToAlarm() {
        return whetherToAlarm;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setWhetherToAlarm(Boolean whetherToAlarm) {
        this.whetherToAlarm = whetherToAlarm;
    }

    @Override
    public String toString() {
        return "CalculationResults{" +
                "whetherToAlarm=" + whetherToAlarm + '\'' +
                ", alarmContent=" + alarmContent +
                '}';
    }
}
