import java.util.Comparator;
import java.util.Map;

public class ValuesComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if(o1.getValue() < o2.getValue()) return -1;
        else if (o1.getValue().equals(o2.getValue())) {
            String o1Key = o1.getKey();
            String o2Key = o2.getKey();

            if(o1Key.length() == o2Key.length()){
                return compareKeys(o1Key,o2Key);
            }else{
                return o1Key.length() < o2Key.length() ? -1:1;
            }
        }else return 1;
    }

    private int compareKeys(String o1Key, String o2Key) {
        for(int i = 0; i<o1Key.length(); i++){
            if(o1Key.charAt(i) != o2Key.charAt(i)){
                return o1Key.charAt(i) - o2Key.charAt(i) > 0 ? 1:-1;
            }
        }
        return 1;
    }
}
