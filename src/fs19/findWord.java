package src.fs19;

public class findWord {
    public static void main(String[] args) {

    }

    public static void findeWort(String word) {
        String[][] c = new String[5][9];
        char[] bibabup = new char[word.length()];
        int l = word.length();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (c[i][j] == word.substring(0, 1)){
                    // go to the right and check for word
                    int[] pairs = new int[l];
                    for(int k = 0; k < l; k++){
                        if(c[i][j+k] == word.substring(k, k+1)){
                            pairs[k] = 1;
                        } else break;
                    }
                    // go to the bottom and check for word
                    // go to the diagonal and check for word
                }
            }
        }
    }
}
