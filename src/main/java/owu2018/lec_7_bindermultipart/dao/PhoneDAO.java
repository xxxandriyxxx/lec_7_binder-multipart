package owu2018.lec_7_bindermultipart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu2018.lec_7_bindermultipart.models.Phone;


public interface PhoneDAO extends JpaRepository<Phone,Integer> {
}
