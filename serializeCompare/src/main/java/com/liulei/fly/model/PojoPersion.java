package com.liulei.fly.model;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import io.protostuff.Exclude;
import io.protostuff.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: liulei
 * @Date: 2019/1/5 $time
 * @Description: 序列化对象
 */
@ProtobufClass
public class PojoPersion {
    //@FieldSerializer.Optional("")
    //@Exclude
    private Map<String, String> map = new HashMap<>();
    private List<String> list = new ArrayList<>();
    //@FieldSerializer.Optional("")
    @Exclude
    private String school;
    private String name;
    private double height;
    private double weight;
    private String descript1;
    private String descript2;
    private String descript3;
    private String descript4;
    private String descript5;
    private String descript6;
    private String descript7;
    private String descript8;
    private String descript9;
    private String descript10;
    private String descript11;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescript1() {
        return descript1;
    }

    public void setDescript1(String descript1) {
        this.descript1 = descript1;
    }

    public String getDescript2() {
        return descript2;
    }

    public void setDescript2(String descript2) {
        this.descript2 = descript2;
    }

    public String getDescript3() {
        return descript3;
    }

    public void setDescript3(String descript3) {
        this.descript3 = descript3;
    }

    public String getDescript4() {
        return descript4;
    }

    public void setDescript4(String descript4) {
        this.descript4 = descript4;
    }

    public String getDescript5() {
        return descript5;
    }

    public void setDescript5(String descript5) {
        this.descript5 = descript5;
    }

    public String getDescript6() {
        return descript6;
    }

    public void setDescript6(String descript6) {
        this.descript6 = descript6;
    }

    public String getDescript7() {
        return descript7;
    }

    public void setDescript7(String descript7) {
        this.descript7 = descript7;
    }

    public String getDescript8() {
        return descript8;
    }

    public void setDescript8(String descript8) {
        this.descript8 = descript8;
    }

    public String getDescript9() {
        return descript9;
    }

    public void setDescript9(String descript9) {
        this.descript9 = descript9;
    }

    public String getDescript10() {
        return descript10;
    }

    public void setDescript10(String descript10) {
        this.descript10 = descript10;
    }

    public String getDescript11() {
        return descript11;
    }

    public void setDescript11(String descript11) {
        this.descript11 = descript11;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PojoPersion{" +
                "map=" + map +
                ", list=" + list +
                ", school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", descript1='" + descript1 + '\'' +
                ", descript2='" + descript2 + '\'' +
                ", descript3='" + descript3 + '\'' +
                ", descript4='" + descript4 + '\'' +
                ", descript5='" + descript5 + '\'' +
                ", descript6='" + descript6 + '\'' +
                ", descript7='" + descript7 + '\'' +
                ", descript8='" + descript8 + '\'' +
                ", descript9='" + descript9 + '\'' +
                ", descript10='" + descript10 + '\'' +
                ", descript11='" + descript11 + '\'' +
                '}';
    }
}
