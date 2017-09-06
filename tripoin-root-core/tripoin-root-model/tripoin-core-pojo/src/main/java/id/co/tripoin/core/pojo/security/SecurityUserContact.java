package id.co.tripoin.core.pojo.security;

import id.co.tripoin.core.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;
import id.co.tripoin.core.pojo.master.country.Country;
import id.co.tripoin.core.pojo.security.SecurityUserProfile;

import javax.persistence.*;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TableNameConstant.Security.SEC_USER_CONTACT)
public class SecurityUserContact extends AAuditTrail {
    private static final long serialVersionUID = 6804239567456143530L;

    @Override
    public String tableName() {
        return TableNameConstant.Security.SEC_USER_CONTACT;
    }

    private String personalNumber;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxNumber;
    private String email;
    private Country country;
    private SecurityUserProfile securityUserProfile;

    @Column(name = "personal_number")
    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Column(name = "phone_number_1")
    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    @Column(name = "phone_number_2")
    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    @Column(name = "fax_number")
    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    @OneToOne(mappedBy = "contact")
	public SecurityUserProfile getSecurityUserProfile() {
		return securityUserProfile;
	}

	public void setSecurityUserProfile(SecurityUserProfile securityUserProfile) {
		this.securityUserProfile = securityUserProfile;
	}

	@Override
    public String toString() {
        return "SecurityContact{" +
                "personalNumber='" + personalNumber + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", email='" + email + '\'' +
                ", country=" + country +
                '}';
    }
}
