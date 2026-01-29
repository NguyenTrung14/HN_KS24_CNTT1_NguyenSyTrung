

import java.util.*;

public class miniproject {

    static Scanner sc = new Scanner(System.in);

    // ================== 1. TWO SUM ==================
    public static void twoSum() {
        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Nhap target: ");
        int target = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Vi tri: [" + i + ", " + j + "]");
                    return;
                }
            }
        }
        System.out.println("Khong tim thay cap phan tu!");
    }

    // ================== 2. MOVE ZEROES ==================
    public static void moveZeroes() {
        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }

        System.out.print("Ket qua: ");
        printArray(arr);
    }

    // ================== 3. VALID PALINDROME ==================
    public static void validPalindrome() {
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine();

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println("KHONG phai Palindrome");
                return;
            }
            left++;
            right--;
        }
        System.out.println("LA Palindrome");
    }

    // ================== 4. REVERSE WORDS ==================
    public static void reverseWords() {

        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine().trim();

        String[] words = s.trim().split("\\s+");
        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {
            result = result + words[i];
            if (i > 0) {
                result = result + " ";
            }
        }
        System.out.println("Ket qua: " + result);
    }

    // ================== 5. HAPPY NUMBER ==================
    public static void isHappyNumber() {
        System.out.print("Nhap mot so: ");
        int n = sc.nextInt();
        int first = n;
        while (n != 1) {
            int sum = 0;
            int temp = n;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }

            n = sum;
        }

        if (n == 1) {
            System.out.println("la so hanh phuc");
        } else {
            System.out.println("ko phai so hanh phuc");
        }
    }

    // ================== IN MANG ==================
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // ================== MAIN MENU ==================
    public static void main(String[] args) {
        String choice;

        do {
            System.out.println("\n========== MENU CHINH ==========");
            System.out.println("1. Two Sum");
            System.out.println("2. Move Zeroes");
            System.out.println("3. Valid Palindrome");
            System.out.println("4. Reverse Words");
            System.out.println("5. Happy Number");
            System.out.println("0. Thoat");
            System.out.println("================================");
            System.out.print("Chon chuc nang: ");

            choice = sc.nextLine().trim();

            switch (choice) {

                case "1":
                    twoSum();
                    sc.nextLine();
                    break;
                case "2":
                    moveZeroes();
                    sc.nextLine();
                    break;
                case "3":
                    validPalindrome();
                    break;
                case "4":
                    reverseWords();
                    break;
                case "5":
                    isHappyNumber();
                    sc.nextLine();
                    break;
                case "0":
                    System.out.println("Thoat chuong trinh. Bye!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (!choice.equals("0"));

        sc.close();
    }
}
