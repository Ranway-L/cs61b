public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
		int temp = 0;
        while (temp <= 45) {
            System.out.print(temp + " ");
			
            x = x + 1;
			temp = temp + x;
        }
    }
}