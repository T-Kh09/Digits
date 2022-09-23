
import java.util.ArrayList;
import java.util.Scanner;


public class Digits {
    
    
    public static int digitZero(int n) {
        return n % 10;
    }
    
    public static int digitAt(int n, int i) {
        for (int j = 0; j < i; j++) {
            n /= 10;   
        }
        return n % 10;
    }
    
    public static int digitSumLargerThan(int n, int limit) {
        int sum = 0;
        while (n != 0) {            
            int digit = n %10;
            n /= 10;
            if (digit > limit)
                sum += digit;
        }
        return sum;
    }
    
    public static int digitCount(int n, int digit) {
        int count = 0; 
        if (n == digit)
            return 1;  //for (0,0)
        else
            while (n != 0) {                
                if ((n % 10) == digit)
                    count ++;
                n /= 10;
            }
        return count; 
    }
    
    public static int digitRemoveAt(int n, int i) {
        int num = 0;
        for (int j = 0; j < i; j++) {
           num = (n % 10) + (num * 10); 
           n /= 10;
        }
        n /= 10;
        while (n != 0) {            
           num = (n % 10) + (num * 10); 
           n /= 10; 
        }
        return reverse(num);
    }
    
    public static int digitRemoveAll(int n, int digit) {
        int num = 0;
        while (n != 0) {
            int remainder = n % 10;
            if (remainder != digit)
                num =(num * 10) + remainder;
            n /= 10;
        }
        return reverse(num);
    }
    
    public static int randomNumber(int k) {
        int num = 0;
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i <k; i++) {
            while (true) {                
                int n = (int) (Math.random()*10);
                if(!digits.contains(n)){
                digits.add(n);
                break;
                }            
            }
        }    
        
        for (int i =0; i<digits.size(); i++) {
            num = num*10+digits.get(i);            
        }
        return num ;
    }
    
    public static int reverse(int n) {
        int num = 0;
        while (n != 0) {
            int remainder = n % 10;            
            num = (num * 10) + remainder;
            n /= 10;
        }
        return num;    
    }
    
    public static boolean isPalindrome(int n) {
        return n == (reverse(n));
    }
    
    public static int charDigitSum(String str) {
        // when we change the letter from char to int we get the ascii value for that letter
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            sum += letter;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int action = 0;
        
        while (action != 11) {  
            System.out.println("___________________________________________________________");
            System.out.println("Digits Library Menu: ");
            System.out.println("1. Least significant digit\n2. ith digit\n3. Sum of digits\n4. Count digits\n5. Remove digit(I)\n6. Remove digit with value \n7. Generate random number\n8. Reverse digits\n9. Check palindrome\n10. CharDigitSum\n11. Quit  ");
            System.out.print("Choose action to perform: ");    
            action = scn.nextInt();
        
            if (action == 1){
                System.out.print("Enter a number to find its least significant digit: ");
                int n = scn.nextInt();
                System.out.println("Least significant digit is: " + digitZero(n));
            }
        
            else if (action == 2){
                System.out.print("Enter a number to find its ith digit: ");
                int n = scn.nextInt();
                System.out.print("Enter the digit you want to find (ith): ");
                int i = scn.nextInt();
                System.out.println("The ith digit of the number is : " + digitAt(n, i));
            }            
        
            else if (action == 3){
                System.out.print("Enter the number to find digit sum: ");
                int n = scn.nextInt();
                System.out.print("Enter a limit: ");
                int limit = scn.nextInt();
                System.out.println("The limit digit sum is calculated as: " + digitSumLargerThan(n, limit));
            }   
            
            else if (action == 4){
                System.out.print("Enter the number to count the number of digits that equals to a number: ");
                int n = scn.nextInt();
                System.out.print("Which number to count? ");
                int digit = scn.nextInt();
                System.out.println("The times the number is repeated is: " + digitCount(n, digit));
            }    
            
            else if (action == 5){
                System.out.print("Enter the number to remove digit: ");
                int n = scn.nextInt();
                System.out.print("Which digit to remove? ");
                int i = scn.nextInt();
                System.out.println("The number after we removed the digit is: " + digitRemoveAt(n, i));
            }

            else if (action == 6){
                System.out.print("Enter the number to remove the digits with a specific value: ");
                int n = scn.nextInt();
                System.out.print("Enter the value: ");
                int digit = scn.nextInt();
                System.out.println("The number after we removed the digits is: " + digitRemoveAll(n, digit));
            }

            else if (action == 7){
                System.out.print("Enter the number of digits: ");
                int k = scn.nextInt();
                System.out.println("The random number is: " + randomNumber(k));
            }

            else if (action == 8){
                System.out.print("Enter the number to invert: ");
                int n = scn.nextInt();
                System.out.println("Reverse is found as: " + reverse(n));
            }

            else if (action == 9){
                System.out.print("Enter the number to check: ");
                int n = scn.nextInt();
                if (isPalindrome(n)) 
                    System.out.println("This number is a palindrome.");
                
                else
                    System.out.println("This number is not a palindrome.");
            }

            else if (action == 10){
                System.out.print("Enter the String : ");
                String str = scn.next();
                System.out.println("Characters digit sum is: " + charDigitSum(str));
            }

            else 
                System.out.println("Ok, good bye.");
        }  
    }
}
