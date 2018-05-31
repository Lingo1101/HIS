package com.utils;

import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdviceUtils {
    public static Color getMyColor(String patientID) {
        String a="select IsExecuted from DoctorsAdviceInfo where PatientID='"+ patientID+"'";
        String aaaa = "";
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult(a, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        aaaa = maps.get("IsExecuted".toUpperCase()).toString();

        if(aaaa.equals("否")) {
            return Color.red;
        }
        else{
            return Color.green;
        }
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
}
