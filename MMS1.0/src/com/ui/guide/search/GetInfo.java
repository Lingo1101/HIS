package com.ui.guide.search;

import com.utils.JDBCUtils;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInfo {

    /**
     * 提供一个显示的textPanel 要查询的关键字 以及在哪个表
     */
    public GetInfo(JTextPane jTextPane, String table, String key, String value) {
        this.table = table;
        String sql = "select *  from " + table + " where " + key + " = ?";
        List<Object> params = new ArrayList<>();
        params.add(value);
        try {
            Map<String, Object> map = JDBCUtils.findSimpleResult(sql, params);
            jTextPane.setText(toHTML(map.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String toHTML(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile("\\w*=.+?(?=[,}])");
        Matcher m =  pattern.matcher(s);
        stringBuffer.append(
                "<style type=\"text/css\">" +
                    "table.hovertable {" +
                        "font-family: verdana,arial,sans-serif;" +
                        "font-size:11px;" +
                        "color:#333333;" +
                        "border-color: #999999;" +
                        "border-collapse: collapse;" +
                    "}" +
                    "table.hovertable th {" +
                        "background-color:#c3dde0;" +
                        "border-width: 1px;" +
                        "padding: 8px;" +
                        "width: 100px;" +
                        "border-style: solid;" +
                        "border-color: #a9c6c9;" +
                    "}" +
                    "table.hovertable tr {" +
                        "background-color:#d4e3e5;" +
                        "}" +
                        "table.hovertable td {" +
                        "border-width: 1px;" +
                        "padding: 8px;" +
                        "border-style: solid;" +
                        "border-color: #a9c6c9;" +
                    "}" +
                "</style>" + "<div align=left>" +
                "<table class=\"hovertable\" width=800>");
        while(m.find()) {
            stringBuffer.append("<tr>");
            stringBuffer.append(td(m.group()));
            stringBuffer.append("</tr>");
        }
        stringBuffer.append("</table ></div>");
        return stringBuffer.toString();
    }

    private StringBuffer td(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile("((\\w*)=(.*))");
        Matcher matcher = pattern.matcher(s);
        String key  = "";
        String value = "";
        if(matcher.find()) {
            key = decode(matcher.group(2));
            value = matcher.group(3);
        }
        stringBuffer.append(
                "<th> "+ "<font size=\"5\">" + key +  "</font>" + "</th>" +
                "<td> "+ "<font size=\"5\">" + value  + "</th>" + "</td>" );
        return stringBuffer;
    }
    private String decode(String s) {
        switch (table) {
            case "PATIENTINFO":
                s = decodePATIENTINFO(s);
                break;
            case "COSTSCHEDULE":
                s = decodeCOSTSCHEDULE(s);
                break;
            case "DOCTORSADVICEINFO":
                s = decodeDOCTORSADVICEINFO(s);
                break;
        }
        return s;
    }
    private String decodePATIENTINFO(String s) {
        switch (s) {
            case "PATIENTNAME":
                s = "姓名";
                break;
            case "PHONENUMBER":
                s = "电话";
                break;
            case "ADDRESS":
                s = "地址";
                break;
            case "GENDER":
                s = "性别";
                break;
            case "PATIENTID":
                s = "病人ID";
                break;
            case "IDNUMBER":
                s = "ID号";
                break;
            case "BIRTHDAY":
                s = "出生日期";
                break;
        }
        return s;
    }

    private String decodeCOSTSCHEDULE(String s) {
        switch (s) {
            case "PATIENTNAME":
                s = "姓名";
                break;
            case "UNIT":
                s = "单位";
                break;
            case "PRICE":
                s = "单价";
                break;
            case "COSTSCHEDULE":
                s = "总价";
                break;
            case "TIME":
                s = "时间";
                break;
            case "PROJECTNAME":
                s = "项目";
                break;
            case "PATIENTID":
                s = "ID";
                break;
            case "SPECIFICATION":
                s = "规格";
                break;
        }
        return s;
    }

    private String decodeDOCTORSADVICEINFO(String s) {
        switch (s) {
            case "EMPLOYEEID":
                s = "医生ID";
                break;
            case "ISEXECUTED":
                s = "是否执行";
                break;
            case "DOCTORSADVICEID":
                s = "医嘱ID";
                break;
            case "MEDICALCONTENT":
                s = "医嘱内容";
                break;
            case "EFFECTIVETIME":
                s = "有效时间";
                break;
            case "IDNUMBER":
                s = "ID号";
                break;
            case "BIRTHDAY":
                s = "出生日期";
                break;
            case "PATIENTID":
                s = "病人ID";
                break;
        }
        return s;
    }

    private String table;
}
