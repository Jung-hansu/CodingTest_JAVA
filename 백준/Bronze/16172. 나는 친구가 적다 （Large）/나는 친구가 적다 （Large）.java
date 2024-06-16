import java.io.*;

public class Main {

    private static int[] arr;

    private static String readNumberlessString() throws IOException{
        StringBuilder sb = new StringBuilder();
        int c;

        while ((c = System.in.read()) > 32){
            if (c > '9') sb.append((char)c);
        }
        return sb.toString();
    }

    private static void getKMPArr(String s){
        arr = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = arr[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                arr[i] = ++j;
            }
        }
    }

    private static boolean kmp(String s1, String s2){
        int j = 0;

        getKMPArr(s2);
        for (int i = 0; i < s1.length(); i++){
            while(j > 0 && s1.charAt(i) != s2.charAt(j)){
                j = arr[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)){
                if (j == s2.length() - 1){
                    return true;
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        String s1 = readNumberlessString();
        String s2 = readNumberlessString();

        System.out.println(kmp(s1, s2) ? 1 : 0);
    }

}