package project.src.cisc275_project.Model;

import java.util.ArrayList;

public class QuizList {

    private ArrayList<Quiz> quizList = new ArrayList<>(3);
    private int currentNum;

    public QuizList(ArrayList<Quiz> ql, int currentNum){
        this.quizList = ql;
        this.currentNum = currentNum;
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public static QuizList createQuizList(){
        Quiz quiz1 = new Quiz("Estuaries typically occur when fresh water meets salt water",
                "true", "false",0,
                "Most estuaries are found in coastal\nregions where rivers meet the sea");
        Quiz quiz2 = new Quiz("Question 2: choose option 2",
                "option 1","option 2", 1,
                "option 2 is correct");
        Quiz quiz3 = new Quiz("Question 3: choose true",
                "true","false",0,
                " true is correct answer");
        ArrayList<Quiz> ql = new ArrayList<>(3);
        ql.add(quiz1);
        ql.add(quiz2);
        ql.add(quiz3);
        return new QuizList(ql,0);
    }

    public Quiz getCurrentQuiz(){
            return getQuizList().get(getCurrentNum());
    }

    public void nextQuiz(){
        currentNum = (currentNum+1)%3;
    }

}
