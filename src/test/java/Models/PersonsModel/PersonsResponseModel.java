package Models.PersonsModel;

import java.util.Map;

import static Utils.TypeOperation.emptyStringTransform;

public class PersonsResponseModel {

    int id;
    String personName;
    String phoneNumber;

    public PersonsResponseModel(int id, String personName, String phoneNumber) {
        this.id = id;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public static PersonsResponseModel createPersonsResponseModel(Map<String,String> TableItems){

        return new PersonsResponseModel(Integer.parseInt(TableItems.get("id")),
                emptyStringTransform(TableItems.get("PersonName")),
                emptyStringTransform(TableItems.get("PhoneNumber")));

    }

}
