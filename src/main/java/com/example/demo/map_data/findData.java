package com.example.demo.map_data;

import com.example.demo.domain.Member;
import java.util.HashMap;
import java.util.Map;

public class findData {
    public static void main(String[] args){
        Map<String, String> data = new HashMap<>();
        data.put("dataA", "DataAA");
        data.put("dataB", "DataBB");
        data.put("dataC", "DataCC");
        data.put("dataD", "DataDD");

        String findvalue = "DataBB";
        for (String s : data.keySet()){
            if (data.get(s).equals(findvalue)){
                System.out.println(s);
            }
        }
        data.values()
                .stream()
                .filter(s -> s.equals(findvalue))
                .findAny();


        Map<String, Member> data2 = new HashMap<>();
        data2.put("dataA", new Member(1L, "name1"));
        data2.put("dataB", new Member(1L, "name2"));
        data2.put("dataC", new Member(1L, "name3"));
        data2.put("dataD", new Member(1L, "name4"));

        String findvalue2 = "name3";

        for (String s:data2.keySet()){
            Member m = data2.get(s);
            if (m.getName().equals(findvalue2)){
                System.out.println(m.getId() +" // " + m.getName());
            }
        }


        data2.values()
                .stream()
                .filter(member -> member.getName().equals(findvalue2))
                .findAny();
    }
}