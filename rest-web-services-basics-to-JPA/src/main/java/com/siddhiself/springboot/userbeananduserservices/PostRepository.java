package com.siddhiself.springboot.userbeananduserservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Notes
 * The Repository represents the DAO layer, which typically does all the database operations.
 * @author Siddhi Diwane
 *
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
