package Target100Days;
import java.util.*;

public class Day43 {
    //Arraylist
    public void addNames(List<String> sampleNames){
//        ArrayList<String> names=new ArrayList<>();
//        names.add("Ragni");
//        names.add("Anshu");
//        names.add("Dimple");
//        names.add("Chirag");
//        for(String name:names){
//            System.out.println(name);
//        }
//        if(names.contains("Chirag")){
//            System.out.println("Hiiii!!!!!!!!!!");
//        }
//        return names;

        for(String name:sampleNames){
            sampleNames.remove("Chirag");
        }

    }
    public static void main(String[] args) {
        List<String> sampleNames = Arrays.asList(
                "Sumathi", "Malathi", "Karthick", "Rajendiran", "Tamilselvi"
        );

        for(String name : sampleNames){
            if(name.contains("Malathi")){
                System.out.println("Yes! Malathi exists!!!!");
                return;
            }
        }
        Day43 example = new Day43();
//        example.addNames();
    }
}
