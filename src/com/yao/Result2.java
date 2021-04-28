package com.yao;

import java.util.Map;

public class Result2 {

    private String measurement;
    private Map<String, String> tags;
    private Map<String, String> fields;
    private String timestamp;

    public Result2() {
    }

    public Result2(String measurement, Map<String, String> tags, Map<String, String> fields, String timestamp) {
        this.measurement = measurement;
        this.tags = tags;
        this.fields = fields;
        this.timestamp = timestamp;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMeasurement() {
        return measurement;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
