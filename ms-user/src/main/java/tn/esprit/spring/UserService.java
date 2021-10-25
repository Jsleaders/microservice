package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository UserRepository;
	
	public User addUser(User c) {
		return UserRepository.save(c);
	}
    public User updateUser(User newc , int id) {
    	if(UserRepository.findById(id).isPresent()) {
    		User user=UserRepository.findById(id).get();
    		user.setNom(newc.getNom());
    		user.setPrenom(newc.getPrenom());
    		user.setEmail(newc.getEmail());
    		return UserRepository.save(user);
    	}
    	else return null;
    	
    }
    public String deleteUser(int id)
    { 	if(UserRepository.findById(id).isPresent()) {
    	UserRepository.deleteById(id);
    	return "User supprime !";
	}
    else return "User non supprimé !";
    	
    }
}
