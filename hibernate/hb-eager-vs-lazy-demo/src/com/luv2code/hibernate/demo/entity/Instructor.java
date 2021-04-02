package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	/*"cascade = CascadeType.All" significa che
	 * ogni operazione applicata alla tabella principale 
	 * si ripercuoterà sulla tabella connessa
	 */
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	/*un istruttore può avere molti corsi; la mappatura fa riferimento
	 * al campo instructor della classe course. Vale sempre lo stesso discorso
	 * che se salta il prof non devono saltare i corsi
	 */
	
	/*impostando la fetch a LAZY, il sistema stamperà i dati sui corsi solo su richiesta,
	 * mentre impostandolo a EAGER le stamperà senza richiederlo
	 */
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="instructor", cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	@SuppressWarnings("unused")
	private Instructor() {
		
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//aggiungiamo un metodo per la bidirezionalità
	
	public void add(Course tempCourse) {
		
		//se la lista non è stata ancora creata allora creala
		
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		
		//aggiungi il corso
		courses.add(tempCourse);
		
		//imposta l'insegnante
		tempCourse.setInstructor(this);
		
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	

}
