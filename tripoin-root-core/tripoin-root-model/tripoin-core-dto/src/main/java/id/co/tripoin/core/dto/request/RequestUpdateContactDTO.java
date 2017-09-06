package id.co.tripoin.core.dto.request;

import java.io.Serializable;

/**
 * created on 1/30/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RequestUpdateContactDTO implements Serializable {
    private static final long serialVersionUID = 607608532465184157L;

    private String personalNumber;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxNumber;
    private String email;
    private String countryId;
    private String name;
    private String remarks;

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "RequestUpdateContactDTO{" +
                "personalNumber='" + personalNumber + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", email='" + email + '\'' +
                ", countryId='" + countryId + '\'' +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
