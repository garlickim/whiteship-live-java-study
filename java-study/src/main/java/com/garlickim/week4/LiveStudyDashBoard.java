package com.garlickim.week4;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveStudyDashBoard {

    private final static String TOKEN = "";

    public static void main(String[] args) {
        LiveStudyDashBoard liveStudyDashBoard = new LiveStudyDashBoard();
        liveStudyDashBoard.run();
    }

    private void run() {
        try {
            GitHub github = new GitHubBuilder().withOAuthToken(TOKEN).build();

            // Get Repository
            GHRepository repository = github.getRepository("garlickim/whiteship-live-java-study");

            // Get Issues
            List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);

            // Count of attendance by person
            Map<String, Integer> countOfAttendance = calculateCountOfAttendance(issues);

            // Rate of attendance by person
            Map<String, String> rateOfAttendance = calculateRateOfAttendance(countOfAttendance);

            // print
            System.out.println("이름 | 참여율");
            for (String name : rateOfAttendance.keySet()) {
                System.out.println(name + " : " + rateOfAttendance.get(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Integer> calculateCountOfAttendance(List<GHIssue> issues) {
        Map<String, Integer> countOfAttendance = new HashMap<>();

        try {
            for (GHIssue issue : issues) {
                for (GHIssueComment comment : issue.getComments()) {
                    String name = comment.getUser().getName();

                    Integer count = countOfAttendance.containsKey(name) ? countOfAttendance.get(name) : 0;
                    countOfAttendance.put(name, ++count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOfAttendance;
    }

    private Map<String, String> calculateRateOfAttendance(Map<String, Integer> countOfAttendance) {
        Map<String, String> rateOfAttendance = new HashMap<>();

        for (String name : countOfAttendance.keySet()) {
            Double avg = (countOfAttendance.get(name) / 18.0) * 100;
            rateOfAttendance.put(name, String.format("%.2f", avg));
        }
        return rateOfAttendance;
    }
}
