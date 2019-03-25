package TestApp.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestAppData {
    private static TestAppData instance = new TestAppData();
    private static String usersfilename = "UserListDataFile.txt";
    private static String testsfilename = "TestListDataFile.txt";


    private List<User> users;
    private ObservableList<Test> tests;
    public static TestAppData getInstance() {
        return instance;
    }

    private TestAppData() {
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addTest(Test test){
        tests.add(test);
    }
    public static String getTestsfilename() {
        return testsfilename;
    }

    public static void setTestsfilename(String testsfilename) {
        TestAppData.testsfilename = testsfilename;
    }

    public ObservableList<Test> getTests() {
        return tests;
    }

    public void setTests(ObservableList<Test> tests) {
        this.tests = tests;
    }

    public void setUsers(List<User> userList){
        this.users = userList;
    }

    public static void setInstance(TestAppData instance) {
        TestAppData.instance = instance;
    }

    public static String getUsersfilename() {
        return usersfilename;
    }

    public static void setUsersfilename(String usersfilename) {
        TestAppData.usersfilename = usersfilename;
    }

    public List<User> getUsers() {
        return users;
    }

    public void loadUsers() throws IOException {
        users = FXCollections.observableArrayList();
        Path path = Paths.get(usersfilename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while((input = br.readLine()) != null) {
                String[] userpieces = input.split("\t");

                String username = userpieces[0];
                double avg = Double.parseDouble(userpieces[1]);

                List<TestScore> testScores = new ArrayList<>();

                if (userpieces.length == 3){
                    String scorelist = userpieces[2];
                    String[] scores = scorelist.split("~");

                    for (int i=0; i<scores.length; i++){
                        String[] details = scores[i].split("-");
                        String name = details[0];
                        double score = Double.parseDouble(details[1]);
                        TestScore newscore = new TestScore(name,score);
                        testScores.add(newscore);
                    }
                }
                User user = new User(username,avg,testScores);
                users.add(user);
            }
        }finally{
            if(br !=null){
                br.close();
            }
        }
    }

    public void storeUsers() throws  IOException {
        Path path = Paths.get(usersfilename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<User> iter = users.iterator();

            while (iter.hasNext()){
                User user = iter.next();
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<user.scores.size();i++){
                    sb.append(user.scores.get(i).test_user_name);
                    sb.append("-");
                    sb.append(user.scores.get(i).score);
                    if(i < (user.scores.size()-1)){
                        sb.append("~");
                    }
                }
                bw.write(String.format("%s\t%s\t%s",
                        user.getUsername(),
                        0.0,
                        sb));
                bw.newLine();
            }
        }finally {
            if(bw != null){
                bw.close();
            }
        }
    }
    public void loadTests() throws IOException {
        tests = FXCollections.observableArrayList();
        Path path = Paths.get(testsfilename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null ){
                ObservableList<Question> questions = FXCollections.observableArrayList();
                String[] testpieces = input.split("\t");


                String testname = testpieces[0];
                double avg = Double.parseDouble(testpieces[1]);
                String file = testpieces[2];
                String group = testpieces[3];

                List<TestScore> testScores = new ArrayList<>();
                if(testpieces.length == 5) {
                    String scorelist = testpieces[4];
                    String[] scores = scorelist.split("~");

                    for (int i=0; i<scores.length; i++){
                        String[] details = scores[i].split("-");
                        String name = details[0];
                        double score = Double.parseDouble(details[1]);
                        TestScore newscore = new TestScore(name,score);
                        testScores.add(newscore);
                    }
                }

                Path path1 = Paths.get(file);
                BufferedReader br1 = Files.newBufferedReader(path1);

                String input1;

                try{
                    while((input1 = br1.readLine()) != null){
                        String[] questionpieces = input1.split("\t");

                        String questiontext = questionpieces[0];
                        String answerA = questionpieces[1];
                        String answerB = questionpieces[2];
                        String answerC = questionpieces[3];
                        String answerD = questionpieces[4];
                        int rightans = Integer.parseInt(questionpieces[5]);

                        Question question = new Question(questiontext,answerA,answerB,answerC,answerD,rightans);

                        questions.add(question);

                    }
                }finally {
                    if(br1 != null){
                        br1.close();
                    }
                }



                Test test = new Test(testname,questions,avg,file,testScores,group);
                tests.add(test);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
    public void storeTests() throws IOException{
        Path path = Paths.get(testsfilename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<Test> iter = tests.iterator();

            while (iter.hasNext()){
                StringBuilder sb = new StringBuilder();
                Test test = iter.next();
                for(int i=0; i<test.scores.size();i++){
                    sb.append(test.scores.get(i).test_user_name);
                    sb.append("-");
                    sb.append(test.scores.get(i).score);
                    if(i < (test.scores.size()-1)){
                        sb.append("~");
                    }
                }
                bw.write(String.format("%s\t%s\t%s\t%s\t%s",
                        test.getTestName(),
                        0.0,
                        test.getQuestionfilename(),
                        test.getGroup(),
                        sb));
                bw.newLine();

                Path path1 = Paths.get(test.getQuestionfilename());
                BufferedWriter bw1 = Files.newBufferedWriter(path1);
//                List<Question> questions = new ArrayList<>();
//                for(int i=0; i<test.questions.size(); i++){
//                    questions.add(test.questions.get(i));
//                }
                Iterator<Question> iter1 = test.questions.iterator();

                while (iter1.hasNext()){
                    Question question = iter1.next();
                    bw1.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",
                            question.getQuestion(),
                            question.getAnswer_A(),
                            question.getAnswer_B(),
                            question.getAnswer_C(),
                            question.getAnswer_D(),
                            question.getRightAnswer()));
                    bw1.newLine();
                }
                try{

                }finally {
                    if(bw1 != null){
                        bw1.close();
                    }
                }
            }
        }finally {
            if(bw != null){
                bw.close();
            }
        }
    }

}
