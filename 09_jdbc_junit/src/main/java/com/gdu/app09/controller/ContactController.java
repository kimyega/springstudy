package com.gdu.app09.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app09.dto.ContactDto;
import com.gdu.app09.service.ContactServiece;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//   private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
@Controller
@RequiredArgsConstructor
public class ContactController {

  // ContactController를 실행할 때 org.slf4j.Logger가 동작한다.
  
   private final ContactServiece contactServiece;
      
   @RequestMapping(path = "/contact/list.do", method = RequestMethod.GET)
   public String list(Model model) {
     List<ContactDto> contactList = contactServiece.getContactList();
     model.addAttribute("contactList", contactList);
     return "contact/list";
   }
   @RequestMapping(value = "/contact/write.do", method = RequestMethod.GET)
   public String write() {
     return "contact/write";
   }
   @RequestMapping(value = "/contact/add.do", method = RequestMethod.POST)
   public String add(ContactDto contactDto, RedirectAttributes redirectAttributes) {
     log.info("add: " + contactDto.toString());
     int addResult = contactServiece.addContact(contactDto);
     redirectAttributes.addFlashAttribute("addResult", addResult);
     return "redirect:/contact/list.do"; 
   }
   @RequestMapping(value = "/contact/detail.do", method = RequestMethod.GET)
   public String detail(@RequestParam(value = "contact_no", required = false, defaultValue = "0") int contact_no, Model model) {
     log.info("detail: " + contact_no);     
     model.addAttribute("contact", contactServiece.getContactByNo(contact_no));
     return "contact/detail";
   }
   @RequestMapping(value = "/contact/modify.do", method = RequestMethod.POST)
   public String modify(ContactDto contactDto, RedirectAttributes redirectAttributes) {
     log.info("modify: " + contactDto.toString());
     int modifyResult = contactServiece.modifyContact(contactDto);
     redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
     return "redirect:/contact/detail.do?contact_no=" + contactDto.getContact_no();
   }
   @RequestMapping(value = "/contact/delete.do", method = RequestMethod.POST)
   public String delete(@RequestParam(value = "contact_no", required = false, defaultValue = "0") int contact_no, RedirectAttributes redirectAttributes) {
     log.info("delete: " + contact_no);  
     int deleteResult = contactServiece.deleteContact(contact_no);
     redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
     return "redirect:/contact/list.do";
   }
}
