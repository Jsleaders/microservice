package tn.esprit.spring;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.nom like :nom")
	public Page<User> userByNom(@Param("nom") String n,Pageable pageable);

}