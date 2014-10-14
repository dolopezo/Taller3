package forum

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
	void "Test name 1"() {
		
		when: 'name length is lowest than 3'
		def user = new User(name:"Ri", lastName:"Contreras", age: 14, username:"richi", password:"Mypass01")

		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test name 2"() {
		
		 when: 'name length is greater than 50'
		 def user = new User(name:"RicharrichRicharrichRicharrichRicharrichRicharrichRicharrich", lastName:"Contreras", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	void "Test name 3"() {
		
		when: 'the name is blank'
		def user = new User(name:"", lastName:"Contreras", age: 14, username:"richi", password:"Mypass01")

		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test name 4"() {
		
		 when: 'the name is correct'
		 def user = new User(name:"Richar", lastName:"Contreras", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname 1"() {		

		when: 'lastname length is lowest than 3'
		def user = new User(name:"Richar", lastName:"Co", age: 14, username:"richi", password:"Mypass01")

		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test lastname 2"() {
		
		 when: 'lastname length is greater than 50'
		 def user = new User(name:"Richar", lastName:"ContrerassContrerassContrerassContrerassContrerassContrerass", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname 3"() {
		
		 when: 'the lastname is blank'
		 def user = new User(name:"Richar", lastName:"", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname 4"() {
		
		 when: 'the lastname is correct'
		 def user = new User(name:"Richar", lastName:"Contreras", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	
	void "Test age 1"() {
		
		when: 'age is lowest than 13'
		def user = new User(name:"Richar", lastName:"contreras", age: 10, username:"richi", password:"Mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test age 2"() {
		
		when: 'age is  blank'
		def user = new User(name:"Richar", lastName:"contreras", age:"", username:"richi", password:"Mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test age 3"() {
		
		 when: 'The age is correct'
		 def user = new User(name:"Richar", lastName:"Contreras", age: 14, username:"richi2", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
	}
	
	void "Test username 1"() {
		
		def existingPerson = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"Mypass01")
		mockForConstraintsTests(User, [existingPerson])
		
		when: 'username is duplicate'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"Mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test username 2"() {
		
		def existingPerson = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"Mypass01")
		mockForConstraintsTests(User, [existingPerson])
		
		when: 'username is not duplicate'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi2", password:"Mypass01")

		 then: 'validation should pass'
		 user.validate()
		
	}
	
	void "Test password 1"() {
		
		when: 'the password does not contain an uppercase'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test password 2"() {
		
		
		when: 'the password does not contain an lowercase'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"MYPASS01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test password 3"() {
		
		when: 'the password length is lowest than 8'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"mySS01")
	
		 then:  'validation should fail'
		 user.validate()
		
	}
	
	void "Test password 4"() {
		
		when: 'the password is blank'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"")
	
		 then:  'validation should fail'
		 user.validate()
		
	}
	
	void "Test password 5"() {
		
		when: 'the password is correct'
		def user = new User(name:"Richar", lastName:"contreras", age: 14, username:"richi", password:"Mypass01")
	
		 then: 'validation should pass'
		 user.validate()		
	}

	
/*
    void testConstraints() {
		def user = new User(name:"Richar", lastName:"Contreras", age: 14, username:"richi", password:"Mypass01")
		mockForConstraintsTests(User, [user])
		
		user = new User()
		assertFalse user.validate()
		assertEquals 'El campo name no es null', 'nullable', user.errors['name']

		user = new User(name:"")
		assertFalse user.validate()
		assertEquals 'El campo name no es blank', 'blank', user.errors['name']
		
		user = new User(username:"richi")
		assertFalse user.validate()
		assertEquals 'El campo name no puede ser duplicado', 'unique', user.errors['name']
		
		user = new User(age:11)
		assertFalse user.validate()
		assertEquals 'El campo age debe ser mayor a 17', 'min', user.errors['age']
		
		user = new User(name:"jnjvjvhnjskdnvjsvknvjnvnvbjsnvknlsdnladsnfvjsdnvlsdknsjvnlkasnsdnvxnvknxjvvknxvjvnjjkshfuhlkyjhfghdsbvhdfjkgbjvnjkvbhsjvbhbvjkvxhnbvbxjvkbshbfvjksdbvhsbvjsjkvbhsbvksbdvjskdbvhbvxvujslfsjvkbshkvbkjvbxnvbjksvjksbvhksbvjksbvshkvksjbvjsbvkhsbvjkhsjkcvbhkbgvlskdfhnskdfdjosfskjdgvbksjbvhksfsndfbsdhbgvsklnfbshdbvkjhnasjkfnqhdfhifnkhzlñgbshgbbvhjakjfbuahñdfawefhwuihfsjbfñañfawbfvjasdhlcvjasdbv")
		assertFalse user.validate()
		assertEquals 'El campo name debe ser menor a 50', 'maxSize', user.errors['name']
		
		user = new User(password:"ahbvsxvsd01")
		assertFalse user.validate()
		assertEquals 'El campo password debe tener 1 mayuscula', 'matches', user.errors['password']
		
		user = new User(name:"chuck", lastName:"Contreras", age: 14, username:"chuki", password:"Mypass01")
		assertTrue 'La instancia Chuck SIEMPRE debe ser válida', user.validate()
	}*/
	
	
}
