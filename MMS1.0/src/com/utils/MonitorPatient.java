package com.utils;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 监控医嘱
 *@author dutz
 */
public class MonitorPatient implements CanNotify{
    private static Calendar c;
    private static long endTime;
    private static Date date;
    private static long startTime;
    private static long midTime;
    private List<Map<String, int[]>> patientTime;
    private Map<String, JTextPane> patientPane;

    public MonitorPatient(List<Map<String, int[]>> patientTime, Map<String, JTextPane> patientPane) {
        this.patientTime = patientTime;
        this.patientPane = patientPane;
        c = Calendar.getInstance();


    }

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

    /**
     * 传病人ID 返回病人的时间
     * @param pID
     * @return
     */
    public static int[] getTime(String pID) {
        String sql = "select EffectiveTime from DoctorsAdviceInfo where PatientID = '" + pID + "'";
        String time = null;
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult(sql, null);
            time = maps.get("EffectiveTime".toUpperCase()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("\\d{2,5}");
        Matcher m = p.matcher(time);
        int arr[] = new int[7];
        int i = 0;
        while(m.find()) {
            arr[i++] = Integer.parseInt(m.group());
        }
        return arr;
    }

    @Override
    public synchronized void run() {
        this.notify();
    }
}