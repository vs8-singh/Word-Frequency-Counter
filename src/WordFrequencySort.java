import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencySort {
    public void sort(){
        System.out.println("Welcome to the word frequency calculator");
        Scanner in = new Scanner(System.in);
        showOptions(in);
    }

    private static void showOptions(Scanner in) {
        int option = 0;
        System.out.println("Choose one option :- \n" +
                "1. Find Word Frequencies\n" +
                "2. Exit");
        option = in.nextInt();
        if(option == 1){
            findFrequencies();
        }else if(option == 2){
            System.out.println("Exiting the program");
        }else{
            System.out.println("Please select a valid option");
            showOptions(in);
        }
    }

    private static void findFrequencies() {
        System.out.println("Starting to find frequencies");
        System.out.println("Please enter the string: ");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        inputString = inputString.replaceAll("[.!?,]", "").trim();
        String[] splitString = inputString.split("\\s");
        Map<String,Integer> frequencyMap = new HashMap<>();
        for(String s : splitString) {
            if(!s.isEmpty()){
                if (frequencyMap.containsKey(s)) {
                    Integer i = frequencyMap.get(s);
                    frequencyMap.put(s, i + 1);
                } else {
                    frequencyMap.put(s.toLowerCase(), 1);
                }
            }
        }
        List<String> sortedList = sortByFrequencies(frequencyMap);
        System.out.println();
        for(String s: sortedList){
            System.out.print(s+" ");
        }
        System.out.println();
        showOptionsForRepeat(in);
    }

    private static List<String> sortByFrequencies(Map<String, Integer> frequencyMap) {
        List<Map.Entry<String,Integer>> sortedFreq = new ArrayList<>(frequencyMap.entrySet());
        sortedFreq.sort(new ValuesComparator());
        return sortedFreq.stream().map(Map.Entry::getKey).collect(Collectors.toList());

    }

    private static void showOptionsForRepeat(Scanner in) {
        System.out.println("Want to try again ? (1/yes or 0/no)");
        String ans = in.next();
        if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("1")){
            findFrequencies();
        }else if(ans.equalsIgnoreCase("no") || ans.equalsIgnoreCase("0")){
            System.out.println("Exiting the program");
        }
        else{
            System.out.println("Please select a valid option");
            showOptionsForRepeat(in);
        }
    }
}
