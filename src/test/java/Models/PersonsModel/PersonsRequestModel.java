package Models.PersonsModel;

import java.util.Map;
import static Utils.TypeOperation.emptyStringTransform;

public class PersonsRequestModel {

    String phoneNumber;
    String personName;

    public PersonsRequestModel(String personName, String phoneNumber) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static PersonsRequestModel createPersonsRequestModel(Map<String,String> TableItems){

        return new PersonsRequestModel(emptyStringTransform(TableItems.get("PersonName")),
                                        emptyStringTransform(TableItems.get("PhoneNumber")));

    }


}
