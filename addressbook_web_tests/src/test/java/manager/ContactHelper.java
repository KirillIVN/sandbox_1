package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            click(By.linkText("home"));
        }
    }

    public int getCountContact() {
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void createContact(ContactData contact) {
        openContactPage();
        initContactCreation();
        fillContact(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void removeContact(ContactData contact) {
        openContactPage();
        returnToHomePage();
        selectContact(contact);
        removeSelectedContact();
    }

    public void modifyContact(ContactData contact, ContactData modifiedName) {
        openContactPage();
        selectContact(contact);
        contactModification();
        fillContact(modifiedName);
        submitContact();
        returnToHomePage();
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContact() {
        click(By.name("update"));
    }

    private void fillContact(ContactData contact) {
        type(By.name("firstname"), contact.name1());
        type(By.name("lastname"), contact.name2());
    }

    private void contactModification() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public List<ContactData> getList() {
        openContactPage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var td = tr.findElements(By.tagName("td"));
            var id = String.valueOf(Integer.parseInt(td.get(0).findElement(By.cssSelector("input[type='checkbox']"))
                            .getDomAttribute("value")));
            var lastname = td.get(1).getText();
            var firstname  = td.get(2).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstname).withSecondName(lastname));
        }

        return contacts;
    }

//    public boolean isContactPresent() {
//        openContactPage();
//        return manager.isElementPresent(By.name("selected[]"));
//    }
}

