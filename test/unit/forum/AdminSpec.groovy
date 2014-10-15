package forum

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Admin)
class AdminSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

	void "Test level"() {
		
		when: 'level is lowest than 1'
		def admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:0, rating: 2.5)

		then: 'validation should fail'
		!admin.validate()
		
		when: 'level is greater than 5'
		admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:10, rating: 2.5)

		then: 'validation should fail'
		!admin.validate()
		
		when: 'level is blank'
		admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:"  ", rating: 2.5)

		then: 'validation should fail'
		!admin.validate()
		
		when: 'level is  in range [0..5]'
		admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:3, rating: 2.5)

		then: 'validation should pass'
		admin.validate()		
	}
	
	void "Test rating "() {
		
		when: 'rating is lowest than 0'
		def admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:2, rating: -2.5)

		then: 'validation should fail'
		!admin.validate()
		
		when: 'rating is greater than 100'
		admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:2, rating: 110)

		then: 'validation should fail'
		!admin.validate()
				
		when: 'rating is blank'
		admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:2, rating:"  ")

		then: 'validation should fail'
		!admin.validate()
		
		when: 'rating is  in range [0..100]'
		admin = new Admin(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",level:3, rating: 50)

		then: 'validation should pass'
		admin.validate()

}
	
}
