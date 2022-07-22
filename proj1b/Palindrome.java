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

}
