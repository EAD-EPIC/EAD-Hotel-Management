//package com.epic.demo.guest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class GuestService {
//    @Autowired private GuestRepository repo;
//
//    public List<Guest> listAll() {
//        return (List<Guest>) repo.findAll();
//    }
//
//    public void save(Guest guest) {
//        repo.save(guest);
//    }
//
//    public Guest get(Integer id) throws UserNotFoundException {
//        Optional<Guest> result = repo.findById(id);
//        if (result.isPresent()){
//            return result.get();
//        }
//        throw new UserNotFoundException("Could not find any guest with ID "+id);
//    }
//
//    public void delete(Integer id) throws UserNotFoundException {
//        Long count = repo.countById(id);
//        if(count == null || count == 0){
//            throw new UserNotFoundException("Could not find any guest with ID "+id);
//        }
//        repo.deleteById(id);
//
//    }
//
//
//}


package com.epic.demo.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository studentRepository) {
        this.guestRepository = studentRepository;
    }

    public List<Guest> getGuest(){
        return guestRepository.findAll();
    }

    public void addGuest(Guest guest) {
        Optional<Guest> guestOptional = guestRepository.findGuestByEmail(guest.getEmail());

        if(guestOptional.isPresent()){
            throw new IllegalStateException("Email already exist");
        }
        guestRepository.save(guest);
    }

    public void deleteGuest(Integer id) {
        boolean exist = guestRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Student with id "+id+" does nt exist");
        }
        guestRepository.deleteById(id);
    }

//    public EditGuest updateGuest(EditGuest editGuest){
//        guestRepository.save(modelMapper.map(editGuest,Guest.class));
//        return editGuest;
//    }

    @Transactional
    public void updateGuest(Integer id, String firstName, String lastName, String country,String email,String mobile,String password) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "Student with id "+id+" does nt exist"
                ));

        if (firstName != null &&
                firstName.length()>0 &&
                !Objects.equals(guest.getFirstName(),firstName)){
            guest.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length()>0 &&
                !Objects.equals(guest.getLastName(),lastName)){
            guest.setLastName(lastName);
        }
        if (country != null &&
                country.length()>0 &&
                !Objects.equals(guest.getCountry(),country)){
            guest.setCountry(country);
        }

        if (mobile != null &&
                mobile.length()>0 &&
                !Objects.equals(guest.getMobile(),mobile)){
            guest.setMobile(mobile);
        }
        if (password != null &&
                password.length()>0 &&
                !Objects.equals(guest.getPassword(),password)){
            guest.setPassword(password);
        }


        if (email != null &&
                email.length()>0 &&
                !Objects.equals(guest.getEmail(),email)){
            Optional<Guest> guestOptional = guestRepository.findGuestByEmail(email);
            if (guestOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            guest.setEmail(email);
        }
    }
}