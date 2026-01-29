import java.util.Scanner;
import java.util.regex.Pattern;

public class thuchanh {

    public static final int MAX = 100;
    public static String[] studentIds = new String[MAX];
    public static int size = 0;
    public static final Pattern MSSV_PATTERN = Pattern.compile("^B\\d{7}$");
    public static Scanner sc = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\n========= QUAN LY MSSV =========");
        System.out.println("1. Hien thi danh sach MSSV");
        System.out.println("2. Them moi MSSV (Regex)");
        System.out.println("3. Cap nhat MSSV theo index (Regex)");
        System.out.println("4. Xoa MSSV (don mang)");
        System.out.println("5. Tim kiem MSSV (khong phan biet hoa thuong)");
        System.out.println("0. Thoat");
        System.out.println("================================");
    }

    public static String inputValidateValue(String message) {
        while (true) {
            System.out.print(message);
            String id = sc.nextLine().trim();
            if (MSSV_PATTERN.matcher(id).matches()) {
                return id;
            }
            System.out.println("Sai dinh dang! MSSV phai dang: B + 7 chu so (VD: B2101234). Nhap lai!");
        }
    }

    public static void showList() {
        System.out.println("Danh sach MSSV: ");
        if (size == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(studentIds[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
    }

    public static void addNew() {
        if (size >= MAX) {
            System.out.println("Mang da day (100 phan tu). Khong the them!");
            return;
        }
        String newId = inputValidateValue("Nhap MSSV moi: ");
        studentIds[size] = newId;
        size++;
        System.out.println("Them MSSV thanh cong!");
    }

    public static void updateByIndex() {
        if (size == 0) {
            System.out.println("Danh sach rong khong the cap nhat!");
            return;
        }
        showList();
        System.out.print("Vui long nhap vi tri ban muon cap nhat: ");
        int index = sc.nextInt();
        if (index < 0 || index > size) {
            System.out.println("Vi tri ban muon cap nhat khong hop le!");
            return;
        }
        String newId = inputValidateValue("Nhap MSSV moi cho vi tri " + index + ": ");
        studentIds[index] = newId;
        System.out.println("Cap nhat thanh cong!");
    }

    public static void deleteById(){
        if(size == 0){
            System.out.print("Danh sach trong khong the thuc hien xoa!");
            return;
        }
        System.out.print("Nhap MSSV can xoa: ");
        String id = sc.nextLine().trim();
        int pos = findExacl(id);
        if (pos == -1) {
            System.out.println("Khong tim thay MSSV: " + id);
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            studentIds[i] = studentIds[i + 1];
        }
        studentIds[size - 1] = null;
        size--;

        System.out.println("Xóa thành công MSSV: " + id);
    }

    public static void main(String[] args) {
        System.out.println("--- CHUONG TRINH QUAN LY MSSV ---");
        int choice;
        do {
            printMenu();
            System.out.print("Vui long chon chuc nang: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showList();
                    break;
                case 2:
                    addNew();
                    break;
                case 3:
                    updateByIndex();
                    break;
                case 4:
                    deleteById();
                    break;
                case 5:
                    searchContainsIgnoreCase();
                    break;
                case 0:
                    System.out.println("Đa thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (choice != 0);

        sc.close();
    }
}
