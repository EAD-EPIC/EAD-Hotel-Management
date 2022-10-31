package com.epic.demo.guest;

import com.epic.demo.employee.Employee;
import com.epic.demo.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
//@RequestMapping(path = "guest")
//@Controller
//public class GuestController {
//    @Autowired private GuestService service;
//
//    @GetMapping()
//    public List<Guest> showGuestList() {
//        List<Guest> listGuests = service.listAll();
//        return listGuests;
//    }
//
//
//
//    @PostMapping("/save")
//    public String saveGuest(Guest guest, RedirectAttributes ra){
//        service.save(guest);
//        ra.addFlashAttribute("message", "The guest has been saved successfully. ");
//        return "redirect:/guest";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
//        try {
//            Guest guest = service.get(id);
//            model.addAttribute("guest", guest);
//            model.addAttribute("pageTitle", "Edit Guest (ID: "+id+")");
//            return "guest_form";
//        } catch (UserNotFoundException e) {
//            ra.addFlashAttribute("message", e.getMessage());
//            return "redirect:/guest";
//        }
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteGuest(@PathVariable("id") Integer id, RedirectAttributes ra){
//        try {
//            service.delete(id);
//            ra.addFlashAttribute("message", "The guest ID " + id + " has been deleted. ");
//        } catch (UserNotFoundException e) {
//            ra.addFlashAttribute("message", e.getMessage());
//        }
//        return "redirect:/guest";
//    }
//}

@RestController
@CrossOrigin
@RequestMapping(path = "guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public void registerGuest(@RequestBody Guest guest){
        guestService.addGuest(guest);
    }

    @GetMapping
    public List<Guest> getGuest(){
        return guestService.getGuest();
    }

    @DeleteMapping(path = "{id}")
    public void deleteGuest(@PathVariable("id")Integer id){
        guestService.deleteGuest(id);
    }

    @PutMapping(path = "{id}")
    public void updateGuest(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String mobile
    ){
        guestService.updateGuest(id,firstName,lastName,country,email,mobile);
    }


}
