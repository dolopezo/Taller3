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
	
	void "Test name"() {
		
		when: 'name length is lowest than 3'
		def user = new User(name:"Te", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")

		then: 'validation should fail'
		!user.validate()
		
		 when: 'name length is greater than 50'
		 user = new User(name:"TestUserTestUserTestUserTestUserTestUserTestUserTestUser", lastName:"Testlastname", age: 14, username:"richi", password:"Mypass01")
 
		 then: 'validation should pass'
		 !user.validate()
		
		when: 'the name is blank'
		user = new User(name:'     ',lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")

		then: 'validation should fail'
		!user.validate()
		
		 when: 'Missing attribute name'
		 user = new User(lastName:"Testlastname", age:14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should fail'
		 !user.validate()
		
		 when: 'the information is correct'
		 user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test lastname"() {		

		when: 'lastname length is lowest than 3'
		def user = new User(name:"TestUser", lastName:"Te", age: 14, username:"TestUsername", password:"Mypass01")

		then: 'validation should fail'
		!user.validate()
		
		 when: 'lastname length is greater than 50'
		 user = new User(name:"TestUser", lastName:"TestlastnamesTestlastnamesTestlastnamesTestlastnamesTestlastnamesTestlastnames", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 !user.validate()
		
		 when: 'the lastname is blank'
		 user = new User(name:"TestUser", lastName:"           ", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should fail'
		 !user.validate()		
		
		 when: 'the lastname is correct'
		 user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
		}
	
	void "Test age"() {
		
		when: 'age is lowest than 13'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 10, username:"TestUsername", password:"Mypass01")
	
		then: 'validation should fail'
		!user.validate()
		
		when: 'age is  blank'
		user = new User(name:"TestUser", lastName:"Testlastname", age:"   ", username:"TestUsername", password:"Mypass01")
	
		then: 'validation should fail'
		!user.validate()
		
		 when: 'The age is correct'
		 user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername2", password:"Mypass01")
 
		 then: 'validation should pass'
		 user.validate()
		
	}
	
	void "Test username"() {
		
		def existingPerson = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
		mockForConstraintsTests(User, [existingPerson])
		
		when: 'username is duplicate'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
	
		then: 'validation should fail'
		!user.validate()
		
		
		when: 'username is not duplicate'
		user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername2", password:"Mypass01")

		 then: 'validation should pass'
		 user.validate()
		
	}
	
	void "Test password"() {
		
		when: 'the password does not contain an uppercase'
		def user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"mypass01")
	
		then: 'validation should fail'
		!user.validate()		
		
		when: 'the password does not contain an lowercase'
		user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"MYPASS01")
	
		then: 'validation should fail'
		!user.validate()
		
		when: 'the password length is lowest than 8'
		user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"mySS01")
	
		 then:  'validation should fail'
		 !user.validate()
		
		when: 'the password is blank'
		user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"")
	
		 then:  'validation should fail'
		 !user.validate()
		
		when: 'the password is correct'
		user = new User(name:"TestUser", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01")
	
		 then: 'validation should pass'
		 user.validate()		
	}

	
	
}
