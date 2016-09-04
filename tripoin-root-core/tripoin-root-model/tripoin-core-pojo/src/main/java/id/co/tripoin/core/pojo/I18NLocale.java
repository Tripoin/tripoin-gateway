package id.co.tripoin.core.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import id.co.tripoin.constant.statics.TableNameConstant;
import id.co.tripoin.core.pojo.base.AAuditTrail;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name=TableNameConstant.MST_LOCALE)
public class I18NLocale extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6939714779428715474L;
	
	private Long id;
	private String code;
	private String language;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="locale_id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="locale_code", unique=true, length=10)
    @NotNull
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="locale_language")
    @NotNull
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String tableName() {
		return TableNameConstant.MST_LOCALE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		I18NLocale other = (I18NLocale) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "I18NLocale [id=" + id + ", code=" + code + ", language=" + language + "]";
	}

}
