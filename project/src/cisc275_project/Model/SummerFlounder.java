package project.src.cisc275_project.Model;

import java.util.ArrayList;
import java.util.List;

public class SummerFlounder extends Animal{

        public SummerFlounder(int xPos, int yPos){
            super("SummerFlounder",xPos, yPos, 4,1,false);
        }

        public static Animals createSFList(){
            SummerFlounder sf1 = new SummerFlounder(600,100);
            SummerFlounder sf2 = new SummerFlounder(200,400);
            SummerFlounder sf3 = new SummerFlounder(100,300);

            List<Animal> sfList = new ArrayList<>();
            sfList.add(sf1);
            sfList.add(sf2);
            sfList.add(sf3);
            return new Animals("SummerFlounder",sfList);
        }


}
