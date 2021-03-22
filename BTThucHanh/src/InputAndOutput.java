import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InputAndOutput {
    Scanner sc = new Scanner(System.in);

    public PhoneBook inputPhoneBook() {
        String phoneNumber = inputPhoneNumber();
        String contactGroup = inputContactGroup();
        String name = inputName();
        String gender = inputGender();
        String address = inputAddress();
        LocalDate dateOfBirth = inputDateOfBirth();
        String email = inputEmail();
        PhoneBook phoneBook = new PhoneBook(phoneNumber, contactGroup, name, gender, address, dateOfBirth, email);
        return phoneBook;
    }

    public String inputPhoneNumber() {
        String PHONENUMBER_REGEX = "[0-9]{10}";
        String phoneNumber = null;
        System.out.println("nhập số điện thoại");
        do {
            try {
                phoneNumber = sc.nextLine();
                if (phoneNumber.equals("")) {
                    System.out.println("nhập lại");
                }
            } catch (Exception o) {
                System.out.println("nhập lại");
            }
        } while (phoneNumber.equals("") && !phoneNumber.matches(PHONENUMBER_REGEX));
        return phoneNumber;
    }

    public String inputContactGroup() {
        String contactGroup = null;
        System.out.println("nhập nhóm danh bạ");
        do {
            try {
                contactGroup = sc.nextLine();
                if (contactGroup.equals("")) {
                    System.out.println("nhập lại");
                }
            } catch (Exception o) {
                System.out.println("nhập lại");
            }
        } while (contactGroup.equals(""));
        return contactGroup;
    }

    public String inputName() {
        String name = null;
        System.out.println("nhập Tên");
        do {
            try {
                name = sc.nextLine();
                if (name.equals("")) {
                    System.out.println("nhập lại");
                }
            } catch (Exception o) {
                System.out.println("nhập lại");
            }
        } while (name.equals(""));
        return name;
    }

    public String inputGender() {
        String gender = null;
        System.out.println("nhập giới tính");
        do {
            try {
                gender = sc.nextLine();
                if (gender.equals("")) {
                    System.out.println("nhập lại");
                }
            } catch (Exception o) {
                System.out.println("nhập lại");
            }
        } while (gender.equals(""));
        return gender;
    }

    public String inputAddress() {
        String address = null;
        System.out.println("nhập địa chỉ");
        do {
            try {
                address = sc.nextLine();
                if (address.equals("")) {
                    System.out.println("nhập lại");
                }
            } catch (Exception o) {
                System.out.println("nhập lại");
            }
        } while (address.equals(""));
        return address;
    }

    public LocalDate inputDateOfBirth() {
        do {
            try {
                System.out.println("nhập năm");
                int year = Integer.parseInt(sc.nextLine());
                System.out.println("nhập tháng");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("nhập ngày");
                int day = Integer.parseInt(sc.nextLine());
                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("nhập lại đi bạn ei");
            }
        } while (true);
    }

    public String inputEmail() {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\ @([\\w]+\\.)+[\\w]+[\\w]$";
        String email = null;
        System.out.println("Nhập email");
        do {
            try {
                email = sc.nextLine();
                if (email.equals("")) {
                    System.out.println("nhập lại");
                }
            } catch (Exception o) {
                System.out.println("nhập lại");
            }
        } while (email.equals("") && !email.matches(EMAIL_REGEX));
        return email;
    }

    public void displayPhoneBook() {
        Scanner sc = new Scanner(System.in);
        if (ManageContacts.phoneBookList.size() != 0) {
            for (int i = 0; i < ManageContacts.phoneBookList.size(); i++) {
                System.out.println(ManageContacts.phoneBookList.get(i));
                System.out.println("----------------------------------------");
                if (i % 5 == 4 && i != ManageContacts.phoneBookList.size() - 1) {
                    System.out.println("bấm enter để xem tiếp");
                    sc.nextLine();
                }
            }
        } else {
            System.out.println("không có số điện thoại nàọ");
        }
    }

    public void writeFile() {
        try {
            FileOutputStream fosPhoneBook = new FileOutputStream("PhoneBook.txt");
            ObjectOutputStream oosPhoneBook = new ObjectOutputStream(fosPhoneBook);
            oosPhoneBook.writeObject(ManageContacts.phoneBookList);
            oosPhoneBook.close();
            fosPhoneBook.close();
        } catch (IOException e) {

        }
    }

    public void readFile() {
        try {
            FileInputStream fisPhoneBook = new FileInputStream("IPhoneBook.txt");
            ObjectInputStream oisPhoneBook = new ObjectInputStream(fisPhoneBook);
            ManageContacts.phoneBookList = (List<PhoneBook>) oisPhoneBook.readObject();
            oisPhoneBook.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }
}
