package id.co.tripoin.core.dto.response;

import java.io.Serializable;

/**
 * created on 1/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ContactResponseDTO implements Serializable {
    private static final long serialVersionUID = 77978089164101168L;

    private String code;
    private String personalNumber;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxNumber;
    private String email;
    private CountryResponseDTO country;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public CountryResponseDTO getCountry() {
        return country;
    }

    public void setCountry(CountryResponseDTO country) {
        this.country = country;
    }
}
