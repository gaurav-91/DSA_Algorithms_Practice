import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {

        //kyckyckk - kyc
        //pnnben - nbe
        //kyckyckkabcd - kabcd
// kycdee f
        //kycde f
        System.out.println(find("kyckyckkabcd"));
        System.out.println(find("pnnben"));
        System.out.println(find("kyckyckk"));
        System.out.println(find("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkaaaaaa"));
    }


    private static String find(String word){
        int i = 0;
        int j = 0;
        Map<Character,Integer> frequency = new HashMap<>();
        StringBuilder res = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int max = Integer.MIN_VALUE;
        while(j < word.length()){
            if(!frequency.containsKey(word.charAt(j))) {
                ans.append(word.charAt(j));
                frequency.put(word.charAt(j), (frequency.get(word.charAt(j))==null?0:frequency.get(word.charAt(j))) + 1);
            }else{
                while(frequency.get(word.charAt(j)) != 0){
                    frequency.put(word.charAt(i), frequency.get(word.charAt(i)) - 1);
                    ans = new StringBuilder(ans.substring(1));
                    i++;
                }
                frequency.put(word.charAt(j), (frequency.get(word.charAt(j))==null?0:frequency.get(word.charAt(j))) + 1);
                ans = ans.append(word.charAt(j));
            }
            int length = j - i + 1;
            if(length > max){
                max = length;
                res = ans;
            }
            j++;
        }
        return res.toString();
    }
}
