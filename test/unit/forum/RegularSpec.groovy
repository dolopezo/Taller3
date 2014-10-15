package forum

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Regular)
class RegularSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
	
	void "Test postViews"() {
		
		when: 'postViews is lowest than 0'
		def regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:-1, strikesNumber:2, starsNumber:2)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'postViewslevel is blank'
		regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:"  ", strikesNumber:2, starsNumber:2)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'postViewslevel is  in range [0..inf]'
		regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:2, starsNumber:2)

		then: 'validation should pass'
		regular.validate()
	}
	
	void "Test strikesNumber"() {
		
		when: 'strikesNumber is lowest than 0'
		def regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:-2, starsNumber:2)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'strikesNumber is greater than 3'
		regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:5, starsNumber:2)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'strikesNumber is blank'
		regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:"  ", starsNumber:2)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'strikesNumber is  in range [0..3]'
		regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:2, starsNumber:2)

		then: 'validation should pass'
		regular.validate()		
	}
	
	void "Test starsNumber"() {
		
		when: 'starsNumber is lowest than 0'
		def regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:2, starsNumber:-5)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'starsNumber is greater than 5'
		regular = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:5, starsNumber:20)

		then: 'validation should fail'
		!regular.validate()
		
		when: 'starsNumber is blank'
		regular  = new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:2, starsNumber:"  ")

		then: 'validation should fail'
		!regular.validate()
		
		when: 'starsNumber is  in range [0..5]'
		regular= new Regular(name:"TestName", lastName:"Testlastname", age: 14, username:"TestUsername", password:"Mypass01",postViews:50, strikesNumber:2, starsNumber:5)

		then: 'validation should pass'
		regular.validate()
	}
}
