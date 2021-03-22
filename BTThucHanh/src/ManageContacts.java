import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageContacts implements IManageContacts {
    static List<PhoneBook> phoneBookList = new ArrayList<>();
    static {
        phoneBookList.add(new PhoneBook("1234567890", "anh", "alo","nam","hà Nội", LocalDate.of(1995,10,23), "abc@gmail.com"));
    }

    @Override
    public void add(PhoneBook phoneBook) {
        phoneBookList.add(phoneBook);
    }

    @Override
    public PhoneBook findPhoneBookByPhoneNumber(String phoneNumber) {
        PhoneBook phoneBook = null;
        for (PhoneBook p : phoneBookList) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                phoneBook = p;
            }
        }
        return phoneBook;
    }
//    public PhoneBook findPhoneBookByName(String name){
//        PhoneBook phoneBook = null;
//        for (PhoneBook p : phoneBookList) {
//            if (p.getPhoneNumber().equals(name)) {
//                phoneBook = p;
//            }
//        }
//        return phoneBook;
//    }

    @Override
    public void update(PhoneBook phoneBook) {
        boolean check = true;
        while (check) {
            for (PhoneBook p : phoneBookList) {
                if (p.getPhoneNumber().equals(phoneBook.getPhoneNumber())) {
                    p.setContactGroup(phoneBook.getContactGroup());
                    p.setName(phoneBook.getName());
                    p.setGender(phoneBook.getGender());
                    p.setAddress(phoneBook.getAddress());
                    p.setDateOfBirth(phoneBook.getDateOfBirth());
                    p.setEmail(phoneBook.getEmail());
                    check = false;
                } else {
                    System.out.println("không tìm được danh bạ với số điện thoại trên");
                }
            }
        }
    }

    @Override
    public void delete(String phoneNumber) {
        for (int i=0; i<phoneBookList.size();i++){
            if(phoneBookList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBookList.remove(i);
                i--;
            }
        }
    }
}

