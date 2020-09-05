public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> w = new LinkedListDeque<>();
        for(int i=0; i<word.length(); i++) {
            w.addLast(word.charAt(i));
        }
        return w;
    }

    public boolean isPalindrome(String word) {
        char w;
        for(int i=0; i<word.length()/2; i++) {
            if(word.charAt(word.length()-i-1) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for(int i=0; i<word.length()/2; i++) {
            if(!cc.equalChars(word.charAt(word.length()-i-1), word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
