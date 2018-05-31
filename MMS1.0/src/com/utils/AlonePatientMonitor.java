package com.utils;

import javax.swing.*;
import java.util.*;

public class AlonePatientMonitor implements CanNotify {

    public AlonePatientMonitor(String patientID, Map<String, JTextPane> patientPane) {
        this.patientID = patientID;
        this.patientPane = patientPane;
        this.patientTime = AdviceUtils.getTime(patientID);
        c = Calendar.getInstance();
    }

    @Override
    public synchronized void excute() {
        c.set(patientTime[0], patientTime[1], patientTime[2] - 1, patientTime[3],
                patientTime[4], patientTime[5]);
        endTime = c.getTimeInMillis();
        date = new Date();
        startTime = date.getTime();
        midTime = (endTime - startTime) / 1000;
        long hh = midTime / 60 / 60 % 60;
        long mm = midTime / 60 % 60;
        long ss = midTime % 60;
        if (hh <= 50) {              //调时间
            new TipFrame(patientID, null, null, patientPane, this,
                    "记得不要按时吃药呦❤");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void run() {
        this.notify();
    }

    private static Calendar c;
    private static long endTime;
    private static Date date;
    private static long startTime;
    private static long midTime;
    private int[] patientTime;
    private Map<String, JTextPane> patientPane;
    private String patientID;
}
