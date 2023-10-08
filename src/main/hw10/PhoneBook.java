package hw10;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class PhoneBook {
    Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        Set<String> phones = phoneBook.get(name);
        if (phones == null) {
            phones = new HashSet<>();
        }
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public Set<String> find(String name) {
        return phoneBook.get(name);
    }

    public boolean phoneCheck(String checkedPhone) {
        for (Set<String> phones : phoneBook.values()) {
            for (String phone : phones) {
                if (checkedPhone.equals(phone)) {
                    return true;
                }
            }
        }
        return false;
    }
}
