package hw10;

public class hw10 {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Jeka","123");
        myPhoneBook.add("Jeka1","1234");
        myPhoneBook.add("Jeka2","12345");

        System.out.println(myPhoneBook.find("Jeka"));
        System.out.println(myPhoneBook.find("jeka"));

        System.out.println(myPhoneBook.phoneCheck("123"));
        System.out.println(myPhoneBook.phoneCheck("12"));
    }
}
