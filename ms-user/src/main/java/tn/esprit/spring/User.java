package tn.esprit.spring;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private static final long serialVersionUID = 6;
    public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public User(Integer userId, String username, String nom, String prenom, String email, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String password;
    public Integer getUserId() {
        return userId;
    }
    public User(String nom) {
		super();
		this.nom = nom;
	}
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User() {}
}