package TestApp.Data;

import java.util.List;

public class Test {

    private String testName;
    List<Question> questions;
    private double averageScore;
    private String questionfilename;
    List<TestScore> scores;
    private String group;

    public Test(String testName, List<Question> questions, double averageScore, String questionfilename, List<TestScore> scores, String group) {
        this.testName = testName;
        this.questions = questions;
        this.averageScore = averageScore;
        this.questionfilename = questionfilename;
        this.scores = scores;
        this.group = group;
    }

    public Test(String testName, List<Question> questions, double averageScore, String questionfilename, String group) {
        this.testName = testName;
        this.questions = questions;
        this.averageScore = averageScore;
        this.questionfilename = questionfilename;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<TestScore> getScores() {
        return scores;
    }

    public void setScores(List<TestScore> scores) {
        this.scores = scores;
    }

    public String getQuestionfilename() {
        return questionfilename;
    }

    public void setQuestionfilename(String questionfilename) {
        this.questionfilename = questionfilename;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return testName;
    }
}
