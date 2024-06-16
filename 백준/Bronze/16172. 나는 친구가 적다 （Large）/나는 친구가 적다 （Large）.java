import java.io.*;

public class Main {

    private static String readNumberlessString() throws IOException{
        StringBuilder sb = new StringBuilder();
        int c;

        while ((c = System.in.read()) > 32){
            if (c > '9') sb.append((char)c);
        }
        return sb.toString();
    }

    private static int[] getKMPArr(String s){
        int[] arr = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = arr[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                arr[i] = ++j;
            }
        }
        return arr;
    }

    private static int kmp(String s1, String s2){
        int[] arr = getKMPArr(s2);
        int j = 0;

        for (int i = 0; i < s1.length(); i++){
            while(j > 0 && s1.charAt(i) != s2.charAt(j)){
                j = arr[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)){
                if (j == s2.length() - 1){
                    return 1;
                } else {
                    j++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        String s1 = readNumberlessString();
        String s2 = readNumberlessString();

        System.out.println(kmp(s1, s2));
    }

}