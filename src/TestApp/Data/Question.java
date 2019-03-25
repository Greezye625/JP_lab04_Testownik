package TestApp.Data;

public class Question {

    private String question;
    private String answer_A;
    private String answer_B;
    private String answer_C;
    private String answer_D;
    private int rightAnswer;

    public Question(String question, String answer_A, String answer_B, String answer_C, String answer_D, int rightAnswer) {
        this.question = question;
        this.answer_A = answer_A;
        this.answer_B = answer_B;
        this.answer_C = answer_C;
        this.answer_D = answer_D;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_A() {
        return answer_A;
    }

    public void setAnswer_A(String answer_A) {
        this.answer_A = answer_A;
    }

    public String getAnswer_B() {
        return answer_B;
    }

    public void setAnswer_B(String answer_B) {
        this.answer_B = answer_B;
    }

    public String getAnswer_C() {
        return answer_C;
    }

    public void setAnswer_C(String answer_C) {
        this.answer_C = answer_C;
    }

    public String getAnswer_D() {
        return answer_D;
    }

    public void setAnswer_D(String answer_D) {
        this.answer_D = answer_D;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
