package com.saracoglu;


import java.io.InputStream;
import java.util.Properties;

public class Config {
        private Properties properties = new Properties();

        public Config() {
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (input == null) {
                    System.out.println("Sorry, unable to find config.properties");
                    return;
                }
                properties.load(input);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public String getApiKey() {
            return properties.getProperty("apiKey");
        }

        public String getBaseURL() {
            return properties.getProperty("baseURL");
        }
    }


