package com.epic.demo.guest;


import com.epic.demo.guest.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


//public interface GuestRepository extends CrudRepository<Guest, Integer> {
//    public Long countById(Integer id);
//
//
//}


public interface GuestRepository
        extends JpaRepository<Guest,Integer> {

    @Query("SELECT e FROM Guest e WHERE e.email=?1")
    Optional<Guest> findGuestByEmail(String email);
}

