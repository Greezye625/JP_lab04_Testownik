package TestApp.Data;

import java.util.List;

public class User {

    private String username;
    List<TestScore> scores;
    private double avgScore;

    public User(String username, double avgScore) {
        this.username = username;
        this.avgScore = avgScore;
    }

    public User(String username, double avgScore, List<TestScore> scores) {
        this.username = username;
        this.scores = scores;
        this.avgScore = avgScore;
    }

    public List<TestScore> getScores() {
        return scores;
    }

    public void setScores(List<TestScore> scoreList) {
        this.scores = scoreList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}
