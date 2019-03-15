package com.example.service.domainModel;

/**
 * title：Time
 * description:
 *
 * @author yumengjie
 * @date 2019/2/25 10:14
 */

public final class Time {


    private static final int HOUR_PER_DAY=24;

    private static final int MINUTES_PER_HOUR=60;

    public final int hour;

    public final int minue;

    public Time(int hour, int minue) {

        if(hour<0||hour>=HOUR_PER_DAY){
            throw new IllegalArgumentException("Hour:"+hour);
        }if (minue<0||minue>=MINUTES_PER_HOUR){
            throw new IllegalArgumentException("Min:"+minue);
        }
        this.hour = hour;
        this.minue = minue;
    }
}