package owu2018.lec_7_bindermultipart.services.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import owu2018.lec_7_bindermultipart.models.Phone;
import owu2018.lec_7_bindermultipart.services.PhoneService;

import java.beans.PropertyEditorSupport;

@Component
public class PhoneEditor extends PropertyEditorSupport {

    @Autowired
    private PhoneService phoneService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Phone phone = new Phone();
        phone.setNumber(text);
        phoneService.save(phone);
        setValue(phone);
    }
}
