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
        Quiz quiz1 = new Quiz("Estuaries typically occur when fresh water" +
                "\nmeets salt water" +
                "\n\n A.True \n\n B.False", 0,
                "Most estuaries are found in coastal regions where" +
                        "\nrivers meet the sea");
        Quiz quiz2 = new Quiz("Estuaries only exist in warm climate."+
                "\n\n A.True \n\n B.False", 1,
                "Estuaries are found along almost every coastline" +
                        "\nworld-wide");
        Quiz quiz3 = new Quiz("There are many different types of estuaries"+
                "\n\n A.True \n\n B.False", 0,
                "Different types of estuaries are formed by different" +
                        "\ngeological events");
        Quiz quiz4 = new Quiz("Estuaries are geological structures"+
                "\n\n A.True \n\n B.False",0,
                "Estuaries are formed form interactions between" +
                        "\nwater and land masses");
        Quiz quiz5 = new Quiz("All estuaries contain brackish water"+
                "\n\n A.True \n\n B.False",1,
                "Some estuaries are formed where rivers meet large\n" +
                        "bodies of fresh water, such as in the Great Lakes");
        ArrayList<Quiz> ql = new ArrayList<>(3);
        ql.add(quiz1);
        ql.add(quiz2);
        ql.add(quiz3);
        ql.add(quiz4);
        ql.add(quiz5);
        return new QuizList(ql,0);
    }

    public Quiz getCurrentQuiz(){
            return getQuizList().get(getCurrentNum());
    }

    public void nextQuiz(){
        currentNum = (currentNum+1)%5;
    }

}
