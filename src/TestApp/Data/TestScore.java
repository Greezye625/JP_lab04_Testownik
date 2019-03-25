package TestApp.Data;

public class TestScore {
    String test_user_name;
    double score;

    public TestScore(String test_user_name, double score) {
        this.test_user_name = test_user_name;
        this.score = score;
    }

    public String getTest_user_name() {
        return test_user_name;
    }

    public void setTest_user_name(String test_user_name) {
        this.test_user_name = test_user_name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
