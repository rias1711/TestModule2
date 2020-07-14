import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<Contract> contractList = new ArrayList<>();
    static Contract contract = new Contract();
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONE_REGEX = "^(0|84)?[0-9]{9}$";

    public static boolean validEmail(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validPhone(String regex) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
            System.out.println("Chọn chức năng theo số để tiếp tục: ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    show();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                default:
                    System.out.println("Lỗi. Mời nhập lại");
            }


        } while (choice != 8);

    }

    public static void show() {
            System.out.println(contractList.toString());
    }

    public static void add() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = "";
        String emailAddress = "";
        System.out.println("Thông tin của danh bạ: ");
        do {
            System.out.print("- Số điện thoại: ");
            phoneNumber = sc.nextLine();
            if (!validPhone(phoneNumber)) {
                System.out.println("\nSố điện thoại không khả dụng. Vui lòng nhập lại");
            }
        } while (!validPhone(phoneNumber));
        System.out.print("\n- Nhóm của danh bạ: ");
        String groupName = sc.nextLine();
        System.out.print("\n- Họ tên: ");
        String name = sc.nextLine();
        System.out.print("\n- Giới tính: ");
        String gender = sc.nextLine();
        System.out.print("\n- Địa chỉ: ");
        String address = sc.nextLine();
        System.out.print("\n- Ngày sinh: ");
        String dateOfBirth = sc.nextLine();
        do {
            System.out.print("\n- Email: ");
            emailAddress = sc.nextLine();
            if (!validEmail(emailAddress)) {
                System.out.println("\nEmail không khả dụng. Vui lòng nhập lại: ");
            }
        } while (!validEmail(emailAddress));
        Contract contract = new Contract(phoneNumber, groupName, name, gender, address, dateOfBirth, emailAddress);
        contractList.add(contract);
        System.out.println("Thêm thành công");
    }

    public static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại của người cần tìm: ");
        String searchPhone = sc.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            if (searchPhone.equals(contract.getPhoneNumber())) {
                System.out.println(contract.toString());
                break;
            }
        }
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại người cần sửa: ");
        String searchPhone = sc.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            if (searchPhone.equals(contract.getPhoneNumber())) {
                System.out.print("Nhóm của danh bạ mới: ");
                String newGroup = sc.nextLine();
                contract.setGroupName(newGroup);
                System.out.print("\nHọ tên: ");
                String newName = sc.nextLine();
                contract.setName(newName);
                System.out.print("\nGiới tính:");
                String newGender = sc.nextLine();
                contract.setGender(newGender);
                System.out.print("\nĐịa chỉ: ");
                String newAddress = sc.nextLine();
                contract.setAddress(newAddress);
                System.out.println("\nNgày sinh: ");
                String newDateOfBirth = sc.nextLine();
                contract.setDateOfBirth(newDateOfBirth);
                System.out.println("\nEmail: ");
                String newEmail = sc.nextLine();
                contract.setEmailAdress(newEmail);
                contractList.add(contract);
                System.out.println("Update thành công");
                break;
            }
        }
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại người cần xóa: ");
        String searchPhone = sc.nextLine();
        for (int i = 0; i < contractList.size(); i++) {
            if (searchPhone.equals(contract.getPhoneNumber())) {
                System.out.println("Bạn có chắc muốn xóa không? Nhập Y(Yes) hoặc N(No)");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    contractList.remove(i);
                    System.out.println("Xóa thành công số điện thoại");
                    break;
                } else if (choice.equals("N")) {
                    break;
                } else {
                    System.out.println("Lỗi");
                    break;
                }
            }
        }
    }

    public static void writeFile() throws IOException {
        FileWriter writer = new FileWriter("src/contract.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(contract.toString());
        bufferedWriter.close();
        System.out.println("Thêm thành công");
    }

    public static void readFile() throws IOException {
        FileReader reader = new FileReader("src/contract.csv");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int i = bufferedReader.read();
        while (i != -1) {
            System.out.println((char) i);
        }
        bufferedReader.close();
        reader.close();
    }

}
