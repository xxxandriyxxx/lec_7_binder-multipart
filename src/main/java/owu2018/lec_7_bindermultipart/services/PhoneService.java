package owu2018.lec_7_bindermultipart.services;


import org.springframework.stereotype.Service;
import owu2018.lec_7_bindermultipart.dao.PhoneDAO;
import owu2018.lec_7_bindermultipart.models.Phone;


@Service
public class PhoneService {

    private PhoneDAO phoneDAO;

    public PhoneService(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    public void save(Phone phone) {
        phoneDAO.save(phone);
    }

}
