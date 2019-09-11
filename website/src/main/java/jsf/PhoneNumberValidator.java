package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@FacesValidator("jsf.PhoneNumber")
public class PhoneNumberValidator implements Validator {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("00[0-9]{2}-[0-9]{2}-[0-9]{7,11}");

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        String phoneNumber = (String) value;
        if (phoneNumber != null && !phoneNumber.equals("")) {
            checkPattern(phoneNumber);
            checkCountryCode(phoneNumber.substring(0, 4));
            checkAreaCode(phoneNumber.substring(5, 8));
        }
    }

        private void checkPattern(String phoneNumber) {
            if (!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
                throw new ValidatorException(
                        new FacesMessage("Please enter a valid phone number of the form: 0046-76-5647891"));
            }
        }

        private void checkCountryCode(String areaCode) {
            int firstDigit = Character.digit(areaCode.charAt(0), 10);
            int secondDigit = Character.digit(areaCode.charAt(1), 10);
            if (firstDigit != 0 && secondDigit != 0) {
                throw new ValidatorException(
                        new FacesMessage("The first two digit of the country code of your phone number must " +
                                "be 0."));
            }
        }

        private void checkAreaCode(String officeCode) {
            int firstDigit = Character.digit(officeCode.charAt(0), 10);
            if (firstDigit == 0) {
                throw new ValidatorException(
                        new FacesMessage("The first digit of the area code of your phone number must not be " +
                                "0."));
            }
        }
}
