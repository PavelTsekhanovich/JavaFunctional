package com.tsekhanovich.functional.practice29;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Pavel Tsekhanovcih 18.11.2018
 *
 * There is a LogEntry class for monitoring user activity on your site. The class has three fields:
 * created: Date - the date of creating log entry
 * login: String - a user login
 * url: String - a url that the user clicked
 * The class have getters for all fields with the corresponding names (getCreated(), getLogin(), getUrl()).
 * Write a collector that calculates how many times was clicked each url by users.
 * The collector will be applied to a stream of log entries for creating a map: url -> click count.
 * The class LogEntry will be available during testing. You can create your own classes for local testing.
 */

public class Task1 {

    public static void main(String[] args) {
        List<LogEntry> logs = new ArrayList<>();
        logs.add(new LogEntry(new Date(), "Pavel", "http://"));

        Map<String, Long> clickCount = logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
    }
}

class LogEntry {

    private Date created;
    private String login;
    private String url;

    public LogEntry(Date created, String login, String url) {
        this.created = created;
        this.login = login;
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}