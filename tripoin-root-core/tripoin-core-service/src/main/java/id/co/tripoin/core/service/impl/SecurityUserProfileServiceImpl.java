package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.CommonConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dao.security.ISecurityUserProfileDao;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.RequestForgotPasswordDTO;
import id.co.tripoin.core.dto.request.RequestResetPasswordDTO;
import id.co.tripoin.core.dto.request.RequestUpdatePasswordDTO;
import id.co.tripoin.core.dto.request.RequestUpdateProfileDTO;
import id.co.tripoin.core.dto.response.*;
import id.co.tripoin.core.pojo.master.city.City;
import id.co.tripoin.core.pojo.master.country.Country;
import id.co.tripoin.core.pojo.master.district.District;
import id.co.tripoin.core.pojo.master.province.Province;
import id.co.tripoin.core.pojo.master.village.Village;
import id.co.tripoin.core.pojo.security.*;
import id.co.tripoin.core.service.*;
import id.co.tripoin.core.service.exception.ServiceException;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * created on 12/28/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SecurityUserProfileServiceImpl extends AScaffoldingService<SecurityUserProfile> implements ISecurityUserProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserProfileServiceImpl.class);

    @Autowired
    ISecurityUserProfileDao securityUserProfileDao;

    @Autowired
    ISecurityUserAddressService securityUserAddressService;

    @Autowired
    ISecurityUserContactService securityUserContactService;

    @Autowired
    ICityService cityService;

    @Autowired
    ICountryService countryService;

    @Autowired
    IDistrictService districtService;

    @Autowired
    IProvinceService provinceService;

    @Autowired
    IVillageService villageService;

    @Autowired
    II18NLocaleService ii18NLocaleService;
    
    @Autowired
    ISecurityOAuthClientDetailsService securityOAuthClientDetailsService;
    
    @Autowired
    ISecurityUserVerificationService securityUserVerificationService;
    
    @Autowired
    IUserService userService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityUserProfileDao;
    }

    //==================================================TRANSACTION==================================================//
    @Override
    public int setProfileLocale(I18NLocale i18NLocale, String username) {
        return securityUserProfileDao.setProfileLocale(i18NLocale, username);
    }

    @Transactional
    @Override
    public ResponseData updateProfile(RequestUpdateProfileDTO p_RequestUpdateProfileDTO) throws ServiceException {
        ResponseData responseData = generateSuccessUpdateProfile();;
        if (p_RequestUpdateProfileDTO != null && p_RequestUpdateProfileDTO.getId() != null){
            try{
            	SecurityUserProfile sup = securityUserProfileDao.findById(Long.valueOf(p_RequestUpdateProfileDTO.getId()));
            	if (sup != null){
            		SecurityUserAddress securityUserAddress = null;
                    SecurityUserContact securityUserContact = null;
                    if (p_RequestUpdateProfileDTO.getUserName() != null){
                    	User user = sup.getUser();
                    	SecurityOAuthClientDetails socd = securityOAuthClientDetailsService.findByClientId(user.getUsername());
                    	
                    	user.setUsername(p_RequestUpdateProfileDTO.getUserName());                	                	
                    	socd.setClientId(p_RequestUpdateProfileDTO.getUserName());
                    	
                    	userService.update(user);
                    	securityOAuthClientDetailsService.update(socd);
                    	            	                
                    }
                    if (p_RequestUpdateProfileDTO.getName() != null){
                    	sup.setName(p_RequestUpdateProfileDTO.getName());	
                    }
                    if (p_RequestUpdateProfileDTO.getBirthPlace() != null){
                    	sup.setBirthPlace(p_RequestUpdateProfileDTO.getBirthPlace());	
                    }
                    if (p_RequestUpdateProfileDTO.getGender() != null){
                    	sup.setGender(p_RequestUpdateProfileDTO.getGender());
                    }
                    if (p_RequestUpdateProfileDTO.getBirthDate() != null){
                    	try {
                            sup.setBirthDate(new SimpleDateFormat(CommonConstant.DATE_FORMAT).parse(p_RequestUpdateProfileDTO.getBirthDate()));
                        } catch (ParseException e) {
                            LOGGER.error("Error parsing Date");
                        }
                    }
                    if (p_RequestUpdateProfileDTO.getProfilePhoto() != null){
                    	sup.setPhoto(p_RequestUpdateProfileDTO.getProfilePhoto());
                    }
                    if (p_RequestUpdateProfileDTO.getLocale() != null){
                        I18NLocale locale = ii18NLocaleService.findById(Long.valueOf(p_RequestUpdateProfileDTO.getLocale()));
                        if (locale != null){
                            sup.setI18NLocale(locale);
                        }	
                    }       
                    Country country = null;
                    if (sup.getAddress() != null){
    					securityUserAddress = sup.getAddress();
    				}else{
    					securityUserAddress = new SecurityUserAddress();
    				}
                    if (p_RequestUpdateProfileDTO.getAddress() != null){
        				if (p_RequestUpdateProfileDTO.getAddress().getCountryId() != null){
        					country = countryService.findById(Long.valueOf(p_RequestUpdateProfileDTO.getAddress().getCountryId()));
            			    if (country != null){
            			        securityUserAddress.setCountry(country);
            			    }
        				}
        				if (p_RequestUpdateProfileDTO.getAddress().getProvinceId() != null){
        					Province province = provinceService.findById(Long.valueOf(p_RequestUpdateProfileDTO.getAddress().getProvinceId()));
            			    if (province != null){
            			        securityUserAddress.setProvince(province);
            			    }
        				}
        			    if (p_RequestUpdateProfileDTO.getAddress().getCityId() != null){
        			    	City city = cityService.findById(Long.valueOf(p_RequestUpdateProfileDTO.getAddress().getCityId()));
            			    if (city != null){
            			        securityUserAddress.setCity(city);
            			    }	
        			    }
        			    if (p_RequestUpdateProfileDTO.getAddress().getDistrictId() != null){
        			    	District district = districtService.findById(Long.valueOf(p_RequestUpdateProfileDTO.getAddress().getDistrictId()));
            			    if (district != null){
            			        securityUserAddress.setDistrict(district);
            			    }	
        			    }
        			    if (p_RequestUpdateProfileDTO.getAddress().getVillageId() != null){
            			    Village village = villageService.findById(Long.valueOf(p_RequestUpdateProfileDTO.getAddress().getVillageId()));
            			    if (village != null){
            			        securityUserAddress.setVillage(village);
            			    }	
        			    }
        			    if (p_RequestUpdateProfileDTO.getAddress().getDetailAddress() != null){
        			    	securityUserAddress.setDetailAddress(p_RequestUpdateProfileDTO.getAddress().getDetailAddress());	
        			    }
        			    if (p_RequestUpdateProfileDTO.getAddress().getPostalCode() != null ){
        			    	securityUserAddress.setPostalCode(p_RequestUpdateProfileDTO.getAddress().getPostalCode());	
        			    }    			    
        			    securityUserAddressService.update(securityUserAddress);
        			}
                    if (sup.getContact() != null){
    					securityUserContact = sup.getContact();
    				}else{
    					securityUserContact = new SecurityUserContact();
    				}
        			if (p_RequestUpdateProfileDTO.getContact() != null){    				
        			    if (country != null){
        			        securityUserContact.setCountry(country);
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getEmail() != null){
        			    	securityUserContact.setEmail(p_RequestUpdateProfileDTO.getContact().getEmail());	
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getFaxNumber() != null){
        			    	securityUserContact.setFaxNumber(p_RequestUpdateProfileDTO.getContact().getFaxNumber());	
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getPersonalNumber() != null){
        			    	securityUserContact.setPersonalNumber(p_RequestUpdateProfileDTO.getContact().getPersonalNumber());
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getPhoneNumber1() != null){
        			    	securityUserContact.setPhoneNumber1(p_RequestUpdateProfileDTO.getContact().getPhoneNumber1());	
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getPhoneNumber2() != null){
        			    	securityUserContact.setPhoneNumber2(p_RequestUpdateProfileDTO.getContact().getPhoneNumber2());	
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getName() != null){
        			    	securityUserContact.setName(p_RequestUpdateProfileDTO.getContact().getName());	
        			    }
        			    if (p_RequestUpdateProfileDTO.getContact().getRemarks() != null){
        			    	securityUserContact.setRemarks(p_RequestUpdateProfileDTO.getContact().getRemarks());	
        			    }    			    
        			    securityUserContactService.update(securityUserContact);
        			}
                    sup.setAddress(securityUserAddress);
                    sup.setContact(securityUserContact);     
                    securityUserProfileDao.save(sup);	
            	}else{
            		LOGGER.error("Update Profile Error - SecUserProfile Data Not Found");
                    responseData = generateUserIsNotFound();
            	}                
            }catch (Exception e) {
            	LOGGER.error("Update Profile Error "+e.toString());
                responseData = generateFailedUpdateProfile();
			}
        }else{
            LOGGER.error("Payload is null");
            responseData = generateFailedUpdateProfile();
        }
        return responseData;
    }

    ResponseData generateFailedGetProfile(){
        return new ResponseData(EResponseCode.RC_GET_PROFILE_FAILED.getResponseCode(), EResponseCode.RC_GET_PROFILE_FAILED.getResponseMsg());
    }
    
    ResponseData generateSuccessGetProfile(){
        return new ResponseData(EResponseCode.RC_GET_PROFILE_SUCCESS.getResponseCode(), EResponseCode.RC_GET_PROFILE_SUCCESS.getResponseMsg());
    }
    
    ResponseData generateFailedUpdateProfile(){
        return new ResponseData(EResponseCode.RC_UPDATE_PROFILE_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PROFILE_FAILED.getResponseMsg());
    }
    
    ResponseData generateSuccessUpdateProfile(){
        return new ResponseData(EResponseCode.RC_UPDATE_PROFILE_SUCCESS.getResponseCode(), EResponseCode.RC_UPDATE_PROFILE_SUCCESS.getResponseMsg());
    }
    
    ResponseData generateFailedUpdatePassword(){
        return new ResponseData(EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseMsg());
    }    
    
    ResponseData generateUserIsNotFound(){
        return new ResponseData(EResponseCode.RC_USER_NOT_EXISTS.getResponseCode(), EResponseCode.RC_USER_NOT_EXISTS.getResponseMsg());
    }
    
    ResponseData generateOldPasswordIsNotCorrect(){
        return new ResponseData(EResponseCode.RC_OLD_PASSWORD_FALSE.getResponseCode(), EResponseCode.RC_OLD_PASSWORD_FALSE.getResponseMsg());
    }
    
    ResponseData generateNewPasswordNotEqualRetype(){
        return new ResponseData(EResponseCode.RC_NEW_PASSWORD_NOT_EQUAL_RETYPE.getResponseCode(), EResponseCode.RC_NEW_PASSWORD_NOT_EQUAL_RETYPE.getResponseMsg());
    }    
    
    ResponseData generateSuccessRequestForgotPassword(){
        return new ResponseData(EResponseCode.RC_REQUEST_FORGOT_PASSWORD_SUCCESS.getResponseCode(), EResponseCode.RC_REQUEST_FORGOT_PASSWORD_SUCCESS.getResponseMsg());
    }
    
    ResponseData generateSuccessUpdatePassword(){
        return new ResponseData(EResponseCode.RC_UPDATE_PASSWORD_SUCCESS.getResponseCode(), EResponseCode.RC_UPDATE_PASSWORD_SUCCESS.getResponseMsg());
    }
    
    ResponseData generateFailedRequestForgotPassword(){
        return new ResponseData(EResponseCode.RC_REQUEST_FORGOT_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_REQUEST_FORGOT_PASSWORD_FAILED.getResponseMsg());
    }
    
    ResponseData generateSuccessResetPassword(){
        return new ResponseData(EResponseCode.RC_RESET_PASSWORD_SUCCESS.getResponseCode(), EResponseCode.RC_RESET_PASSWORD_SUCCESS.getResponseMsg());
    }
    
    ResponseData generateFailedResetPassword(){
        return new ResponseData(EResponseCode.RC_RESET_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_RESET_PASSWORD_FAILED.getResponseMsg());
    }


    //==================================================INQUIRY==================================================//
    @Override
    public SecurityUserProfile findByEmail(String p_Email) {
        return securityUserProfileDao.findByEmail(p_Email);
    }

    @Override
    public SecurityUserProfile findByPhone(String p_Phone) {
        return securityUserProfileDao.findByPhone(p_Phone);
    }

    @Override
    public SecurityUserProfile findByUsername(String username) {
        return securityUserProfileDao.findByUsernameOrEmail(username, null);
    }

    @Override
    public ProfileResponseDTO<AddressResponseDTO, ContactResponseDTO> getProfile(String p_CurrentUserName) {
        ProfileResponseDTO<AddressResponseDTO, ContactResponseDTO> profileResponseDTO = new ProfileResponseDTO<>();
        try {                        
            SecurityUserProfile profile = securityUserProfileDao.findByUsernameOrEmail(p_CurrentUserName, p_CurrentUserName);
            if (profile != null){
            	profileResponseDTO.setId(profile.getId());
            	profileResponseDTO.setResponseData(generateSuccessGetProfile());
            	if (profile.getAddress() != null){         	
                    AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
                    addressResponseDTO.setDetailAddress(profile.getAddress().getDetailAddress());
                    addressResponseDTO.setPostalCode(profile.getAddress().getPostalCode());
                    if (profile.getAddress().getCountry() != null){
                        CountryResponseDTO countryResponseDTO = new CountryResponseDTO();
                        countryResponseDTO.setId(profile.getAddress().getCountry().getId());
                        countryResponseDTO.setCode(profile.getAddress().getCountry().getCode());
                        countryResponseDTO.setName(profile.getAddress().getCountry().getName());
                        countryResponseDTO.setRemarks(profile.getAddress().getCountry().getRemarks());
                        countryResponseDTO.setStatus(profile.getAddress().getCountry().getStatus());
                        addressResponseDTO.setCountry(countryResponseDTO);
                    }else{
                    	LOGGER.info("Profile Address - Country - is NULL");
                    }
                    if (profile.getAddress().getProvince() != null){
                        ProvinceResponseDTO provinceResponseDTO = new ProvinceResponseDTO();
                        provinceResponseDTO.setId(profile.getAddress().getProvince().getId());
                        provinceResponseDTO.setCode(profile.getAddress().getProvince().getCode());
                        provinceResponseDTO.setName(profile.getAddress().getProvince().getName());
                        provinceResponseDTO.setRemarks(profile.getAddress().getProvince().getRemarks());
                        provinceResponseDTO.setStatus(profile.getAddress().getProvince().getStatus());
                        addressResponseDTO.setProvince(provinceResponseDTO);
                    }else{
                    	LOGGER.info("Profile Address - Province - is NULL");
                    }
                    if (profile.getAddress().getCity() != null){
                        CityResponseDTO cityResponseDTO = new CityResponseDTO();
                        cityResponseDTO.setId(profile.getAddress().getCity().getId());
                        cityResponseDTO.setCode(profile.getAddress().getCity().getCode());
                        cityResponseDTO.setName(profile.getAddress().getCity().getName());
                        cityResponseDTO.setRemarks(profile.getAddress().getCity().getRemarks());
                        cityResponseDTO.setStatus(profile.getAddress().getCity().getStatus());
                        addressResponseDTO.setCity(cityResponseDTO);
                    }else{
                    	LOGGER.info("Profile Address - City - is NULL");
                    }
                    if (profile.getAddress().getDistrict() != null){
                        DistrictResponseDTO districtResponseDTO = new DistrictResponseDTO();
                        districtResponseDTO.setId(profile.getAddress().getDistrict().getId());
                        districtResponseDTO.setCode(profile.getAddress().getDistrict().getCode());
                        districtResponseDTO.setName(profile.getAddress().getDistrict().getName());
                        districtResponseDTO.setRemarks(profile.getAddress().getDistrict().getRemarks());
                        districtResponseDTO.setStatus(profile.getAddress().getDistrict().getStatus());
                        addressResponseDTO.setDistrict(districtResponseDTO);
                    }else{
                    	LOGGER.info("Profile Address - District - is NULL");
                    }
                    if (profile.getAddress().getVillage() != null){
                        VillageResponseDTO villageResponseDTO = new VillageResponseDTO();
                        villageResponseDTO.setId(profile.getAddress().getVillage().getId());
                        villageResponseDTO.setCode(profile.getAddress().getVillage().getCode());
                        villageResponseDTO.setName(profile.getAddress().getVillage().getName());
                        villageResponseDTO.setRemarks(profile.getAddress().getVillage().getRemarks());
                        villageResponseDTO.setStatus(profile.getAddress().getVillage().getStatus());
                        addressResponseDTO.setVillage(villageResponseDTO);
                    }else{
                    	LOGGER.info("Profile Address - Village - is NULL");
                    }
                    profileResponseDTO.setAddress(addressResponseDTO);                
                }else{
                	LOGGER.info("Profile Address is NULL");
                }
            	profileResponseDTO.setId(profile.getId());
            	if (profile.getBirthDate() != null){
            		profileResponseDTO.setBirthdate(new SimpleDateFormat(CommonConstant.DATE_FORMAT).format(profile.getBirthDate()));	
            	}                
                profileResponseDTO.setGender(profile.getGender());
                profileResponseDTO.setName(profile.getName());
                profileResponseDTO.setPhoto(profile.getPhoto());
                if (profile.getUser() != null){
                	if (profile.getUser().getUsername() != null){
                		profileResponseDTO.setUsername(profile.getUser().getUsername());
                	}else{
                    	LOGGER.info("Profile User Name NULL");
                    }
                	if (profile.getUser().getRole() != null){
                    	RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
                        roleResponseDTO.setCode(profile.getUser().getRole().getCode());
                        profileResponseDTO.setAuthority(roleResponseDTO);	
                    }else{
                    	LOGGER.info("Profile User Role is NULL");
                    }
                }else{
                	LOGGER.info("Profile User is NULL");
                }
                
                if (profile.getI18NLocale() != null){
                    I18NLocaleResponseDTO i18NLocaleResponseDTO = new I18NLocaleResponseDTO();
                    i18NLocaleResponseDTO.setCode(profile.getI18NLocale().getCode());
                    i18NLocaleResponseDTO.setLanguage(profile.getI18NLocale().getName());
                    profileResponseDTO.setLocale(i18NLocaleResponseDTO);
                }else{
                	LOGGER.info("Profile Locale is NULL");
                }
                if (profile.getContact() != null){
                    ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
                    contactResponseDTO.setCode(profile.getContact().getCode());
                    if (profile.getContact().getCountry() != null ){
                        CountryResponseDTO countryResponseDTO = new CountryResponseDTO();
                        countryResponseDTO.setCode(profile.getContact().getCountry().getCode());
                        countryResponseDTO.setName(profile.getContact().getCountry().getName());
                        contactResponseDTO.setCountry(countryResponseDTO);
                    }else{
                    	LOGGER.info("Profile Contact - Country is NULL");
                    }
                    contactResponseDTO.setEmail(profile.getContact().getEmail());
                    contactResponseDTO.setFaxNumber(profile.getContact().getFaxNumber());
                    contactResponseDTO.setPersonalNumber(profile.getContact().getPersonalNumber());
                    contactResponseDTO.setPhoneNumber1(profile.getContact().getPhoneNumber1());
                    contactResponseDTO.setPhoneNumber2(profile.getContact().getPhoneNumber2());
                    profileResponseDTO.setContact(contactResponseDTO);
                }else{
                	LOGGER.info("Profile Contact is NULL");
                }
            }else{
            	profileResponseDTO.setResponseData(generateFailedGetProfile());
            }
        } catch (Exception e) {
            LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, e);
            profileResponseDTO.setResponseData(generateFailedGetProfile());
        }
        return profileResponseDTO;
    }

    //==================================================TRANSACTION==================================================//
    
	@Transactional
	@Override
	public ResponseData updatePassword(RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO) {
    	if (p_RequestUpdatePasswordDTO.getUserName() != null && p_RequestUpdatePasswordDTO.getNewPassword() != null && p_RequestUpdatePasswordDTO.getOldPassword() != null && p_RequestUpdatePasswordDTO.getRetypeNewPassword() != null){
    		if (p_RequestUpdatePasswordDTO.getNewPassword().equals(p_RequestUpdatePasswordDTO.getRetypeNewPassword())){
    			if(securityOAuthClientDetailsService.checkPassword(p_RequestUpdatePasswordDTO.getUserName(), p_RequestUpdatePasswordDTO.getOldPassword())){
    				securityOAuthClientDetailsService.updatePassword(p_RequestUpdatePasswordDTO.getUserName(), p_RequestUpdatePasswordDTO.getNewPassword());
    				return generateSuccessUpdatePassword();	
    			}else{
    				LOGGER.info("Old password is not correct");
    				return generateOldPasswordIsNotCorrect();
    			}
    		}else{
    			LOGGER.info("New password doesnot equals to Retype Password");
    			return generateNewPasswordNotEqualRetype();
    		}
    	}else{
    		LOGGER.info("Request data is not complete");
    		return generateFailedUpdatePassword();
    	}
	}

	@Transactional
	@Override
	public RequestForgotPasswordResponseDTO requestForgotPassword(RequestForgotPasswordDTO p_RequestForgotPasswordDTO) {
    	RequestForgotPasswordResponseDTO rfprd = new RequestForgotPasswordResponseDTO();
    	if (p_RequestForgotPasswordDTO.getEmail() != null){
    		rfprd.setResponseData(generateSuccessRequestForgotPassword());
    		User user = userService.findByEmail(p_RequestForgotPasswordDTO.getEmail());
    		if (user != null){
    			SecurityUserVerification suv = new SecurityUserVerification();
    			suv.setUser(user);
    			String tokenVerification = securityUserVerificationService.insert(suv);
    			if (tokenVerification != null){
    				rfprd.setResponseData(generateSuccessRequestForgotPassword());
    				rfprd.setToken(tokenVerification);
    			}else{
    				rfprd.setResponseData(generateFailedRequestForgotPassword());
    			}
    		}else{
    			rfprd.setResponseData(new ResponseData(EResponseCode.RC_USER_NOT_EXISTS.getResponseCode(), EResponseCode.RC_USER_NOT_EXISTS.getResponseMsg()));    			
    		}
    	}else{
    		rfprd.setResponseData(generateFailedRequestForgotPassword());
    	}
		return rfprd;
	}

	@Transactional
	@Override
	public ResponseData resetPassword(RequestResetPasswordDTO p_RequestResetPasswordDTO) {
		ResponseData responseData = new ResponseData();
		if (p_RequestResetPasswordDTO.getToken() != null && p_RequestResetPasswordDTO.getNewPassword() != null && p_RequestResetPasswordDTO.getRetypeNewPassword() != null){
			boolean tokenValid = securityUserVerificationService.verifyToken(p_RequestResetPasswordDTO.getToken());
			if (tokenValid){
				if (!p_RequestResetPasswordDTO.getNewPassword().equals(p_RequestResetPasswordDTO.getRetypeNewPassword())){
					User user = securityUserVerificationService.findUserByToken(p_RequestResetPasswordDTO.getToken());
					if (user != null){
						securityOAuthClientDetailsService.updatePassword(user.getUsername(), p_RequestResetPasswordDTO.getNewPassword());
						responseData = new ResponseData(EResponseCode.RC_RESET_PASSWORD_SUCCESS.getResponseCode(), EResponseCode.RC_RESET_PASSWORD_SUCCESS.getResponseMsg());
					}else{
						LOGGER.error("User is not found");
						responseData = new ResponseData(EResponseCode.RC_USER_NOT_EXISTS.getResponseCode(),
								EResponseCode.RC_USER_NOT_EXISTS.getResponseMsg());
					}
				}else{
					LOGGER.error("Password Not Match");
					responseData = new ResponseData(EResponseCode.RC_PASSWORD_NOT_MATCH.getResponseCode(),
							EResponseCode.RC_PASSWORD_NOT_MATCH.getResponseMsg());
				}
			}else{
				LOGGER.error("Token is expired for reset password");
				responseData = new ResponseData(EResponseCode.RC_TOKEN_EXPIRED.getResponseCode(),
						EResponseCode.RC_TOKEN_EXPIRED.getResponseMsg());
			}
		}else{
			responseData = generateFailedResetPassword();
		}
		return responseData;
	}
}
