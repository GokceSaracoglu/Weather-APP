package com.saracoglu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @JsonProperty("days")
    private List<Day> days;

    // Getter ve Setter
    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }


    // İç içe sınıflar
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Day {
        @JsonProperty("datetime")
        private String datetime;

        @JsonProperty("hours")
        private List<Hour> hours;

        // Getter ve Setter
        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public List<Hour> getHours() {
            return hours;
        }

        public void setHours(List<Hour> hours) {
            this.hours = hours;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hour {
        @JsonProperty("datetime")
        private String datetime;

        @JsonProperty("temp")
        private Double temp;

        @JsonProperty("humidity")
        private Double humidity;

        @JsonProperty("conditions")
        private String conditions;

        // Getter ve Setter
        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public String getConditions() {
            return conditions;
        }

        public void setConditions(String conditions) {
            this.conditions = conditions;
        }
    }
}
