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
		def user = new User(name:"Te", lastName:"Testlastname", age: 14, username:"richi", password:"Mypass01")

		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test name 2"() {
		
		 when: 'name length is greater than 50'
		 def user = new User(name:"TestUserTestUserTestUserTestUserTestUserTestUserTestUser", lastName:"Testlastname", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test name 3"() {
		
		when: 'the name is blank'
		def user = new User(name:'     ',lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")

		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test name 4"() {
		
		 when: 'Missing attribute name'
		 def user = new User(lastName:"Testlastname", age:14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should fail'
		 user.validate()
		
	}
	
	void "Test name 5"() {
		
		 when: 'the information is correct'
		 def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname 1"() {		

		when: 'lastname length is lowest than 3'
		def user = new User(name:"TestUser", lastName:"Te", age: 14, username:"TestUsername", password:"Mypass01")

		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test lastname 2"() {
		
		 when: 'lastname length is greater than 50'
		 def user = new User(name:"TestUser", lastName:"TestlastnamesTestlastnamesTestlastnamesTestlastnamesTestlastnamesTestlastnames", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname 3"() {
		
		 when: 'the lastname is blank'
		 def user = new User(name:"TestUser", lastName:"           ", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname 4"() {
		
		 when: 'the lastname is correct'
		 def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test age 1"() {
		
		when: 'age is lowest than 13'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 10, username:"TestUsername", password:"Mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test age 2"() {
		
		when: 'age is  blank'
		def user = new User(name:"TestUser", lastName:"Testlastname", age:"   ", username:"TestUsername", password:"Mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test age 3"() {
		
		 when: 'The age is correct'
		 def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername2", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
	}
	
	void "Test username 1"() {
		
		def existingPerson = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
		mockForConstraintsTests(User, [existingPerson])
		
		when: 'username is duplicate'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test username 2"() {
		
		def existingPerson = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
		mockForConstraintsTests(User, [existingPerson])
		
		when: 'username is not duplicate'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername2", password:"Mypass01")

		 then: 'validation should pass'
		 user.validate()
		
	}
	
	void "Test password 1"() {
		
		when: 'the password does not contain an uppercase'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"mypass01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test password 2"() {
		
		
		when: 'the password does not contain an lowercase'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"MYPASS01")
	
		then: 'validation should fail'
		user.validate()
		
	}
	
	void "Test password 3"() {
		
		when: 'the password length is lowest than 8'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"mySS01")
	
		 then:  'validation should fail'
		 user.validate()
		
	}
	
	void "Test password 4"() {
		
		when: 'the password is blank'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"")
	
		 then:  'validation should fail'
		 user.validate()
		
	}
	
	void "Test password 5"() {
		
		when: 'the password is correct'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
	
		 then: 'validation should pass'
		 user.validate()		
	}

	
	
}
