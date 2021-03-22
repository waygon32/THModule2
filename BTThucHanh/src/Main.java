import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputAndOutput inputAndOutput = new InputAndOutput();
        ManageContacts manageContacts = new ManageContacts();
        boolean endProgram = false;
        while (!endProgram) {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
            System.out.println("Chọn chức năng theo số(để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            int num = 0;
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException o) {
                System.out.println("nhập sai rồi" + "\n" + "\n" + "\n");
            }
            switch (num) {
                case 1:
                    inputAndOutput.displayPhoneBook();
                    break;
                case 2:
                    if (manageContacts.findPhoneBookByPhoneNumber(inputAndOutput.inputPhoneBook().getPhoneNumber()) == null) {
                        manageContacts.add(inputAndOutput.inputPhoneBook());
                    }
                    break;
                case 3:
                    manageContacts.update(inputAndOutput.inputPhoneBook());
                    break;
                case 4:
                    boolean check = true;
                    while (check) {
                        String phoneNumber = inputAndOutput.inputPhoneNumber();
                        if (manageContacts.findPhoneBookByPhoneNumber(phoneNumber) != null) {
                            manageContacts.delete(phoneNumber);
                            check = false;
                        } else {
                            System.out.println("không tìm thấy số trên");
                        }
                    }
                case 5:
                    PhoneBook phoneBook1 = manageContacts.findPhoneBookByPhoneNumber(inputAndOutput.inputPhoneNumber());
                    if(phoneBook1!=null){
                        System.out.println(phoneBook1);
                    }else {
                        System.out.println("không tìm thấy");
                    }
                    break;
                case 6:
                    inputAndOutput.writeFile();
                    break;
                case 7:
                    inputAndOutput.readFile();
                    break;
                case 8:
                    endProgram=true;
                    break;
                default:
                    System.out.println("nhập lại");
            }
        }
    }
}
