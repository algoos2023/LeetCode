class Solution {
    public String reorganizeString(String s) {
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i)-'a']++;
        }

        int max = 0; int letter = 0;
        for (int i = 0; i < alpha.length; i++) {
            if(alpha[i] > max) {
                max = alpha[i];
                letter = i;
            }
        }

        if(max > (s.length()+1)/2) return "";

        char[] chs = new char[s.length()];
        int idx = 0;
        while(alpha[letter] > 0) {
            chs[idx] = (char) (letter+'a');
            idx+=2;
            alpha[letter]--;
        }

        for (int i = 0; i < alpha.length; i++) {
            while(alpha[i] > 0){
                if(idx >= chs.length) idx = 1;

                chs[idx] = (char)(i+'a');
                idx+=2;
                alpha[i]--;
            }
        }
        return String.valueOf(chs);
    }
}