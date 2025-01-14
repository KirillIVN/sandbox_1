package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    void createContactTest() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withSecondName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var name1 : List.of("", "name1")) {
            for (var name2 : List.of("name2", "")) {
                    result.add(new ContactData().withFirstName(name1).withSecondName(name2));
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(CommonFunctions.randomString(i * 10))
                    .withSecondName(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createMultipleContactTest(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedListContacts = new ArrayList<>(oldContacts);
        expectedListContacts.add(contact.withId(newContacts.get(newContacts.size() - 1).id()));
        expectedListContacts.sort(compareById);
        Assertions.assertEquals(newContacts, expectedListContacts);
    }

//    @Test
//    public void createContactTest() {
//        app.contacts().createContact(new ContactData("name1", "name2"));
//    }
//
//    @Test
//    public void createContactWithEmptyDateTest() {
//        app.contacts().createContact(new ContactData());
//    }
//
//    @Test
//    public void createContactWithNameDateTest() {
//        app.contacts().createContact(new ContactData().withFirstName("some name"));
//    }
}
