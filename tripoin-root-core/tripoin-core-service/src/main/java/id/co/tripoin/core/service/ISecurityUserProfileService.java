package id.co.tripoin.core.service;

import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.RequestForgotPasswordDTO;
import id.co.tripoin.core.dto.request.RequestResetPasswordDTO;
import id.co.tripoin.core.dto.request.RequestUpdatePasswordDTO;
import id.co.tripoin.core.dto.request.RequestUpdateProfileDTO;
import id.co.tripoin.core.dto.response.AddressResponseDTO;
import id.co.tripoin.core.dto.response.ContactResponseDTO;
import id.co.tripoin.core.dto.response.ProfileResponseDTO;
import id.co.tripoin.core.dto.response.RequestForgotPasswordResponseDTO;
import id.co.tripoin.core.pojo.security.I18NLocale;
import id.co.tripoin.core.pojo.security.SecurityUserProfile;
import id.co.tripoin.core.service.exception.ServiceException;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;

import javax.transaction.Transactional;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public interface ISecurityUserProfileService extends IScaffoldingService<SecurityUserProfile> {

	SecurityUserProfile findByEmail(String email);

	SecurityUserProfile findByPhone(String phone);

	SecurityUserProfile findByUsername(String username);

	ProfileResponseDTO<AddressResponseDTO, ContactResponseDTO> getProfile(String p_CurrentUserName);

	int setProfileLocale(I18NLocale i18NLocale, String username);

	@Transactional
	ResponseData updateProfile(RequestUpdateProfileDTO p_RequestUpdateProfileDTO) throws ServiceException;
	
	@Transactional
	ResponseData updatePassword(RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO);

	@Transactional
	RequestForgotPasswordResponseDTO requestForgotPassword(RequestForgotPasswordDTO p_RequestForgotPasswordDTO);
	
	@Transactional
	ResponseData resetPassword(RequestResetPasswordDTO p_RequestResetPasswordDTO);
}
