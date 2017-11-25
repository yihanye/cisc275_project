package project.src.cisc275_project.Model;

import java.util.ArrayList;

public class Quiz {
    private String question;
    private String option1;
    private String option2;
    private ArrayList<String>  optionList;
    private int answer;

    public Quiz(String question, String option1, String option2, int answer){
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        ArrayList<String> optionList = new ArrayList<>(2);
        optionList.add(option1);
        optionList.add(option2);
        this.optionList = optionList;
        this.answer = answer;
    }

    public String getQuestion() {

        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public boolean checkAnswer(boolean option1, boolean option2){
        return (answer==0 && option1) || (answer == 1 && option2 );
    }


}
