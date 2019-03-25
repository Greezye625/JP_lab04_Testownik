package TestApp;

import TestApp.Data.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private User CurrentUser;

    @FXML
    private GridPane panenext;

    @FXML
    private GridPane paneprevious;

    @FXML
    private TextField userLoginField;

    @FXML
    private Button log_inButton;

    @FXML
    private Label currentUserLabel;

    @FXML
    private Label zalogowano_dodano;

    @FXML
    private ListView<Test> testListView;

    @FXML
    private Label QuestionLabel;

    @FXML
    private RadioButton Answer1Button;

    @FXML
    private RadioButton Answer2Button;

    @FXML
    private RadioButton Answer3Button;

    @FXML
    private RadioButton Answer4Button;

    @FXML
    private Button EndTestButton;

    @FXML
    private Button AcceptQuestionButton;

    @FXML
    private Label groupLabel;

    @FXML
    private TextArea QuestionTextArea;

    @FXML
    private TextField Answer1TextField;

    @FXML
    private TextField Answer2TextField;

    @FXML
    private TextField Answer3TextField;

    @FXML
    private TextField Answer4TextField;

    @FXML
    private RadioButton Answer1RadioButton;

    @FXML
    private RadioButton Answer2RadioButton;

    @FXML
    private RadioButton Answer3RadioButton;

    @FXML
    private RadioButton Answer4RadioButton;

    @FXML
    private TextField TestNameTextField;

    @FXML
    private TextField TestGroupTextField;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private ListView<Test> testListView1;

    @FXML
    private Label groupLabel1;

    @FXML
    private Label useravglabel;

    @FXML
    private Label group1label;

    @FXML
    private Label group2label;

    @FXML
    private Label group3label;

    @FXML
    private Label userAverageScore;

    @FXML
    private Label group1scorelabel;

    @FXML
    private Label group2scorelabel;

    @FXML
    private Label group3scorelabel;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn namecolumn;

    @FXML
    private TableColumn groupcolumn;

    @FXML
    private TableColumn avgcolumn;



    private Test CurrentTest;

    @FXML
    public void initialize(){
        log_inButton.setDisable(true);
//        tab1.setDisable(true);
//        tab2.setDisable(true);
//        tab3.setDisable(true);
//        tab4.setDisable(true);

        testListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Test>() {
            @Override
            public void changed(ObservableValue<? extends Test> observable, Test oldValue, Test newValue) {
                if(newValue != null){
                    Test item = testListView.getSelectionModel().getSelectedItem();
                    groupLabel.setText(item.getGroup());
                }
            }
        });

        testListView.setItems(TestAppData.getInstance().getTests());
        testListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        testListView.getSelectionModel().selectFirst();
        groupLabel.setText(testListView.getSelectionModel().getSelectedItem().getGroup());


        testListView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Test>() {
            @Override
            public void changed(ObservableValue<? extends Test> observable, Test oldValue, Test newValue) {
                if(newValue != null){
                    Test item = testListView1.getSelectionModel().getSelectedItem();
                    groupLabel1.setText(item.getGroup());
                }
            }
        });

        testListView1.setItems(TestAppData.getInstance().getTests());
        testListView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        testListView1.getSelectionModel().selectFirst();
        groupLabel1.setText(testListView1.getSelectionModel().getSelectedItem().getGroup());
//
//        tableView.setItems(TestAppData.getInstance().getTests());
//        for(int i=0; i<TestAppData.getInstance().getTests().size(); i++) {
//            namecolumn.setce
//                    setText(TestAppData.getInstance().getTests().get(i).getTestName());

    }

    private int questionnumber;
    @FXML
    public void StartTestButtonPressed(){
        panenext.toFront();
        panenext.setOpacity(100);
        paneprevious.setOpacity(0);

        CurrentTest = testListView.getSelectionModel().getSelectedItem();

        questionnumber = 0;

        QuestionLabel.setText(CurrentTest.getQuestions().get(questionnumber).getQuestion());

        Answer1Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_A());
        Answer2Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_B());
        Answer3Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_C());
        Answer4Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_D());

        EndTestButton.setDisable(true);
    }




    private double rightanswers = 0;
    private double score;

    @FXML
    public void AcceptQuestionButtonPressed(){
        int op = CurrentTest.getQuestions().get(questionnumber).getRightAnswer();

        switch (op){
            case 1:{
                if(Answer1Button.isSelected()){
                    rightanswers++;
                }
                break;
            }
            case 2:{
                if(Answer2Button.isSelected()){
                    rightanswers++;
                }
                break;
            }
            case 3:{
                if(Answer3Button.isSelected()){
                    rightanswers++;

                }
                break;
            }
            case 4:{
                if(Answer4Button.isSelected()){
                    rightanswers++;

                }
                break;
            }
        }

        Answer1Button.setSelected(false);
        Answer2Button.setSelected(false);
        Answer3Button.setSelected(false);
        Answer4Button.setSelected(false);

        if(questionnumber < (CurrentTest.getQuestions().size()-1)){
           questionnumber++;

           QuestionLabel.setText(CurrentTest.getQuestions().get(questionnumber).getQuestion());

           Answer1Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_A());
           Answer2Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_B());
           Answer3Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_C());
           Answer4Button.setText(CurrentTest.getQuestions().get(questionnumber).getAnswer_D());
        }
        else if (questionnumber == (CurrentTest.getQuestions().size()-1)){
            AcceptQuestionButton.setDisable(true);
            EndTestButton.setDisable(false);

            Answer1Button.setOpacity(0);
            Answer1Button.setDisable(true);

            Answer2Button.setOpacity(0);
            Answer2Button.setDisable(true);

            Answer3Button.setOpacity(0);
            Answer3Button.setDisable(true);

            Answer4Button.setOpacity(0);
            Answer4Button.setDisable(true);

            score = (rightanswers/CurrentTest.getQuestions().size()*100);

            double sc=0;
            int count=0;
            for(int i=0; i<CurrentTest.getScores().size();i++){
                sc+= CurrentTest.getScores().get(i).getScore();
                count++;
            }

            if(count==0)count=1;

            CurrentTest.setAverageScore(sc/count);

            String relatscore;
            double relat = score-CurrentTest.getAverageScore();
            if(relat < 0){
                relat = -relat;
                relatscore = relat+"% ponizej sredniej";
            }
            else{
                relatscore = relat+"% powyzej sredniej";
            }
            QuestionLabel.setText("Wynik Testu: "+score+"%  "+relatscore);
        }
    }

    @FXML
    public void EndTestButtonPressed(){
        paneprevious.toFront();
        paneprevious.setOpacity(100);
        panenext.setOpacity(0);

        boolean assigned = false;
        for(int i = 0;i<CurrentTest.getScores().size();i++){
            if(CurrentTest.getScores().get(i).getTest_user_name().equalsIgnoreCase(CurrentUser.getUsername())){
                if(score > CurrentTest.getScores().get(i).getScore()){
                    CurrentTest.getScores().get(i).setScore(score);
                }
                assigned = true;
                break;
            }
        }
        if (!assigned){
            TestScore testScore = new TestScore(CurrentUser.getUsername(),score);
            CurrentTest.getScores().add(testScore);
        }

        assigned = false;
        for(int i = 0;i<CurrentUser.getScores().size();i++){
            if(CurrentUser.getScores().get(i).getTest_user_name().equalsIgnoreCase(CurrentTest.getTestName())){
                if(score > CurrentUser.getScores().get(i).getScore()){
                    CurrentUser.getScores().get(i).setScore(score);
                }
                assigned = true;
                break;
            }
        }
        if (!assigned){
            TestScore testScore = new TestScore(CurrentTest.getTestName(),score);
            CurrentUser.getScores().add(testScore);
        }


        CurrentTest=null;

        AcceptQuestionButton.setDisable(false);

        Answer1Button.setOpacity(1);
        Answer1Button.setDisable(false);

        Answer2Button.setOpacity(1);
        Answer2Button.setDisable(false);

        Answer3Button.setOpacity(1);
        Answer3Button.setDisable(false);

        Answer4Button.setOpacity(1);
        Answer4Button.setDisable(false);

        score = 0;
        rightanswers = 0;
    }

    @FXML
    public void handleKeyReleased(){
        String text = userLoginField.getText();
        boolean disablebuttons = text.isEmpty() || text.trim().isEmpty();
        log_inButton.setDisable(disablebuttons);
    }

    @FXML
    public void Log_in_Click(){
        int check = -1;
        for(int i = 0; i< TestAppData.getInstance().getUsers().size(); i++){
            if(userLoginField.getText().equalsIgnoreCase(TestAppData.getInstance().getUsers().get(i).getUsername())){
                check = i;
            }
        }
        if(check != -1){
            CurrentUser = TestAppData.getInstance().getUsers().get(check);
            zalogowano_dodano.setText("Logged In");
        }
        else{
            User newUser = new User(userLoginField.getText(),0);
            TestAppData.getInstance().addUser(newUser);
            CurrentUser = newUser;
            zalogowano_dodano.setText("New User Added");
        }

        currentUserLabel.setText(CurrentUser.getUsername());
//        tab1.setDisable(false);
//        tab2.setDisable(false);
//        tab3.setDisable(false);
//        tab4.setDisable(false);
    }

    private List<Question> questionList = new ArrayList<>();

    @FXML
    public void AddQuestionButtonPressed(){
        String question = QuestionTextArea.getText();
        String answer1 = Answer1TextField.getText();
        String answer2 = Answer2TextField.getText();
        String answer3 = Answer3TextField.getText();
        String answer4 = Answer4TextField.getText();

        int rightans = 0;

        if(Answer1RadioButton.isSelected()) rightans = 1;
        if(Answer2RadioButton.isSelected()) rightans = 2;
        if(Answer3RadioButton.isSelected()) rightans = 3;
        if(Answer4RadioButton.isSelected()) rightans = 4;

        Question quest = new Question(question,answer1,answer2,answer3,answer4,rightans);
        questionList.add(quest);

        QuestionTextArea.clear();
        Answer1TextField.clear();
        Answer2TextField.clear();
        Answer3TextField.clear();
        Answer4TextField.clear();

        Answer1RadioButton.setSelected(false);
        Answer2RadioButton.setSelected(false);
        Answer3RadioButton.setSelected(false);
        Answer4RadioButton.setSelected(false);
    }

    @FXML
    public void AddTestButtonPressed(){
        String testname = TestNameTextField.getText();
        String group = TestGroupTextField.getText();

        String filename = testname+"_questionlist.txt";

        List<TestScore> scoreList = new ArrayList<>();
        Test test = new Test(testname,questionList,0,filename,scoreList,group);
        TestAppData.getInstance().addTest(test);

        TestNameTextField.clear();
        TestGroupTextField.clear();
    }

    @FXML
    public void CancelButtonPressed(){
        questionList.clear();

        TestNameTextField.clear();
        TestGroupTextField.clear();

        QuestionTextArea.clear();
        Answer1TextField.clear();
        Answer2TextField.clear();
        Answer3TextField.clear();
        Answer4TextField.clear();

        Answer1RadioButton.setSelected(false);
        Answer2RadioButton.setSelected(false);
        Answer3RadioButton.setSelected(false);
        Answer4RadioButton.setSelected(false);
    }

    @FXML
    public void DeleteTestButtonPressed(){
        TestAppData.getInstance().getTests().remove(testListView1.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void ShowStatsButtonPressed(){
        useravglabel.setOpacity(1);
        group1label.setOpacity(1);
        group2label.setOpacity(1);
        group3label.setOpacity(1);

        double avg=0;
        for (int i=0; i<CurrentUser.getScores().size(); i++){
            avg += CurrentUser.getScores().get(i).getScore();
        }

        double count = CurrentUser.getScores().size();
        if(count==0)count=1;
        CurrentUser.setAvgScore(avg/count);
        userAverageScore.setText(String.format("%.2f",CurrentUser.getAvgScore())+"%");


        int count1=0;
        int count2=0;
        int count3=0;
        double group1score=0;
        double group2score=0;
        double group3score=0;
        for (int i=0; i<TestAppData.getInstance().getTests().size();i++){
            if(TestAppData.getInstance().getTests().get(i).getGroup().equalsIgnoreCase("grupa1")){
                for(int j=0;j<TestAppData.getInstance().getTests().get(i).getScores().size();j++){
                    group1score+= TestAppData.getInstance().getTests().get(i).getScores().get(j).getScore();
                    count1++;
                }
            }
            else if(TestAppData.getInstance().getTests().get(i).getGroup().equalsIgnoreCase("grupa2")){
                for(int j=0;j<TestAppData.getInstance().getTests().get(i).getScores().size();j++){
                    group2score+= TestAppData.getInstance().getTests().get(i).getScores().get(j).getScore();
                    count2++;
                }
            }
            else if(TestAppData.getInstance().getTests().get(i).getGroup().equalsIgnoreCase("grupa3")){
                for(int j=0;j<TestAppData.getInstance().getTests().get(i).getScores().size();j++){
                    group3score+= TestAppData.getInstance().getTests().get(i).getScores().get(j).getScore();
                    count3++;
                }
            }
        }

        if(count1==0)count1=1;
        if(count2==0)count2=1;
        if(count3==0)count3=1;
        group1scorelabel.setText(String.format("%.2f",group1score/count1)+"%");
        group2scorelabel.setText(String.format("%.2f",group2score/count2)+"%");
        group3scorelabel.setText(String.format("%.2f",group3score/count3)+"%");

    }
}