public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> a = new LinkedListDeque<>();
        for(char s : word.toCharArray()) {
            a.addLast(s);
        }
        return a;
    }

    public boolean isPalindrome(String word){
        Deque<Character> wordDeque = wordToDeque(word);
        if(wordDeque.size() <= 1) {return true;}
        return isPalindromeHelper(wordDeque);
    }

    private boolean isPalindromeHelper(Deque<Character> wordDeque) {
        if(wordDeque.size() <= 1) {return true;}
        if(wordDeque.removeFirst() == wordDeque.removeLast()) {
            return isPalindromeHelper(wordDeque);
        }
        return false;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        if(wordDeque.size() <= 1) {return true;}
        return isPalindromeHelper(wordDeque, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> wordDeque, CharacterComparator cc) {
        if(wordDeque.size() <= 1) {return true;}
        if(cc.equalChars(wordDeque.removeFirst(),wordDeque.removeLast())) {
            return isPalindromeHelper(wordDeque,cc);
        }
        return false;
    }
}
