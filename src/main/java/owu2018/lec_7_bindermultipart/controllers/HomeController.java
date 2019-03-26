package owu2018.lec_7_bindermultipart.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import owu2018.lec_7_bindermultipart.models.Contact;
import owu2018.lec_7_bindermultipart.models.Phone;
import owu2018.lec_7_bindermultipart.services.ContactService;
import owu2018.lec_7_bindermultipart.services.PhoneService;
import owu2018.lec_7_bindermultipart.services.editors.PhoneEditor;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class HomeController {

    private ContactService contactService;
    private PhoneService phoneService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        model.addAttribute("contact", new Contact("test", "test@test.com"));
        model.addAttribute("xxx", "hello page");
        return "home";
    }

    @PostMapping("/saveContact")
    public String saveContact(@Valid Contact contact, BindingResult bindingResult,
                              @RequestParam("picture") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        contactService.transferFile(file);
        contact.setAvatar(file.getOriginalFilename());
        System.out.println(contact.getPhoneList());
        contactService.save(contact);
        return "redirect:/";
    }

    @GetMapping("/details-{xxx}")
    public String contactDetails(@PathVariable("xxx") int id, Model model) {
        Contact one = contactService.getOne(id);
        model.addAttribute("contact", one);
        return "contactDetails";
    }

    @PostMapping("/update")
    public String updateContact(Contact contact) {
        contactService.save(contact);
        return "redirect:/";
    }

    @Autowired
    private PhoneEditor phoneDoctor;

    @InitBinder("contact")
    public void initBinder(WebDataBinder binder) {
        System.out.println("!!!!!!!!!!!!");
        binder.registerCustomEditor(Phone.class, phoneDoctor);
//        binder.registerCustomEditor(Phone.class,"phoneList", phoneDoctor);

    }
}
