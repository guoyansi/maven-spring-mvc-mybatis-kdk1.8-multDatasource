package com.gys.sm.item.bean;


public class BaseSession{
    //开始时间
    private long startTime;
    //生命周期(默认30分钟，单位为毫秒  30*80*1000)
    private int cycle=1800000;

    private String accessToken;

    public BaseSession() {
        this.startTime=System.currentTimeMillis();
    }



    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
