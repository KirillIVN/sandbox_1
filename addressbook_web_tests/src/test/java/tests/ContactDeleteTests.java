package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class ContactDeleteTests extends TestBase {

    @Test
    public void deleteContactTest() {
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("", "name1", "name2", "photo"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedListContacts = new ArrayList<>(oldContacts);
        expectedListContacts.remove(index);
        Assertions.assertEquals(newContacts, expectedListContacts);
    }
}
