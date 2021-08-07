package edu.uganew.ugajuly.repository;

import edu.uganew.ugajuly.entity.Assignmentnew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentnewRepository extends JpaRepository<Assignmentnew,Integer> {

//    @Query("select ad from Advisor ad where ad.id = "80100")
//    List<Assignmentnew> findByStuLastName(String last2Char, String majorname);
}
