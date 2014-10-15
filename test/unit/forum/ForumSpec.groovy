package forum

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Forum)
class ForumSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test name"() {
		
		def existingForum = new Forum(name:"TestName2", dateCreated: new Date().next(),category:"math")
		mockForConstraintsTests(Forum, [existingForum])
		
		when: 'name length is lowest than 3'
		def forum = new Forum(name:"Te", dateCreated: new Date().next(), category:"math")
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'name length is greater than 20'
		forum = new Forum(name:"TestNameTestNameTestName", dateCreated: new Date().next(),category:"math")
		
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'name is blank'
		forum = new Forum(name:"        ", dateCreated: new Date().next(),category:"math")
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'name is duplicate'
		forum = new Forum(name:"TestName2", dateCreated: new Date().next(),category:"math")
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'name is correct'
		forum = new Forum(name:"TestName", dateCreated: new Date().next(),category:"math")
		
		then: 'validation should pass'
		forum.validate()
    }
	
	void "test date"() {
		
		/*
		when: 'dateCreated is blank'
		def forum = new Forum(name:"TestName", dateCreated: "    ",category:"math")
		
		then: 'validation should fail'
		!forum.validate()*/
		
		when: 'dateCreated is correct'
		def forum = new Forum(name:"TestName", dateCreated: new Date().next(),category:"math")
		
		then: 'validation should pass'
		forum.validate()
	}
	
	void "test category"() {		
		
		when: 'category length is lowest than 3'
		def forum = new Forum(name:"TestName", dateCreated: new Date().next(), category:"ma")
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'cathegory length is greater than 15'
		forum = new Forum(name:"TestNameTestNameTestName", dateCreated: new Date().next(),category:"mathmathmathmathmath")
		
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'category is blank'
		forum = new Forum(name:"TestName", dateCreated: new Date().next(),category:"     ")
		
		then: 'validation should fail'
		!forum.validate()
		
		when: 'Category is correct'
		forum = new Forum(name:"TestName", dateCreated: new Date().next(),category:"math")
		
		then: 'validation should pass'
		forum.validate()
	}
	
}
