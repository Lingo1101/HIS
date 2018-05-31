package com.utils;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 监控医嘱
 *@author dutz
 */
public class ManyPatientMonitor implements CanNotify{
    private static Calendar c;
    private static long endTime;
    private static Date date;
    private static long startTime;
    private static long midTime;
    private List<Map<String, int[]>> patientTime;
    private Map<String, JTextPane> patientPane;

    public ManyPatientMonitor(List<Map<String, int[]>> patientTime, Map<String, JTextPane> patientPane) {
        this.patientTime = patientTime;
        this.patientPane = patientPane;
        c = Calendar.getInstance();
    }

    @Override
    public synchronized void excute() {
        for(Map<String, int[]> map : patientTime) {
            String patientID = parse(map.toString());
            int[] arr = map.get(patientID);
            c.set(arr[0], arr[1], arr[2]-1, arr[3], arr[4], arr[5]);// 注意月份的设置，0-11表示1-12月
            endTime = c.getTimeInMillis();
            date = new Date();
            startTime = date.getTime();
            midTime = (endTime - startTime) / 1000;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            if(hh <= 50) {              //调时间
                new TipFrame(patientID, map, patientTime, patientPane, this, null);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private  String parse(String mapStr) {
        Pattern p = Pattern.compile("P\\d+");
        Matcher m = p.matcher(mapStr);
        if(m.find()) {
            return m.group();
        }
        return  null;
    }

    @Override
    public synchronized void run() {
        this.notify();
    }
}