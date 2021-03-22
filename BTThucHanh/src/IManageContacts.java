public interface IManageContacts {
    public void add(PhoneBook phoneBook);
    public PhoneBook findPhoneBookByPhoneNumber(String phoneNumber);
    public void update(PhoneBook phoneBook);
    public void delete(String phoneNumber);
}
