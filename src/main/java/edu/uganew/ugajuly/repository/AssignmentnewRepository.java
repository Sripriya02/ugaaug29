package edu.uganew.ugajuly.repository;

import edu.uganew.ugajuly.entity.Advisor;
import edu.uganew.ugajuly.entity.Assignmentnew;
import edu.uganew.ugajuly.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AssignmentnewRepository extends JpaRepository<Assignmentnew,Integer> {

//    @Query("select ad from Advisor ad where ad.id = "80100")
//    List<Assignmentnew> findByStuLastName(String last2Char, String majorname);

    @Query(value="select * from assignment A join advisors ad on A.advisor_id = ad.id where ad.first_name like %:keyword% or ad.last_name like %:keyword%",nativeQuery = true)
    List<Assignmentnew> findByKeyword(@Param("keyword") String keyword);



}
