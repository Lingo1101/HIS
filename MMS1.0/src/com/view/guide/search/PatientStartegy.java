package com.view.guide.search;

import com.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class PatientStartegy implements CondicateStrategy {
    @Override
    public List<String> matchPrefix(String prefix) {
        List<String> list = new ArrayList<>();
        try {
            List<Map<String, Object>> result = JDBCUtils.findModeResult("select PATIENTID from PATIENTINFO",
                    null);
            for(Map<String, Object> map : result) {
                parse(map, list, prefix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void parse(Map<String, Object> map, List<String> list, String prefix) {
        if(list.size() > 4) return;
        String s = map.get("PATIENTID").toString();
        String matches = ".*";
        for(int i = 0; i < prefix.length(); i++) {
            matches += prefix.charAt(i) + ".*";
        }
        Pattern p = Pattern.compile(matches,CASE_INSENSITIVE );
        Matcher m = p.matcher(s);
        if(m.matches()) {
            list.add(s);
        }
    }
}
