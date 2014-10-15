<<<<<<< HEAD

import anuncialo.*
import grails.util.GrailsUtil

class BootStrap {

  def init = { servletContext ->
	switch(GrailsUtil.environment){
	  case "development":
		def jdoe = new InternalUser(id:12546589, email:"jdoe@unal.edu.co", username:"jdoe", password:"password", name:"John Doe",
									publishedAnnouncements:0, role:"Student", buyerRank:0.0, sellerRank:0.0)
		jdoe.save()
		
		def jsmith = new ExternalUser(id:12546585, email:"jsmith@mail.com", username:"jsmith", password:"keyword", name:"Jane Smith",
									  isEmployer:true, isLessor:false,rank:0.0)
		jsmith.save()
	  break

	  case "production":
	  break
	}

  }
  def destroy = {
  }
}
=======
class BootStrap {

    def init = { servletContext ->
    }
    def destroy = {
    }
}
>>>>>>> 365c3c9272a31ae581e4e78a977e8f5012d8d5af
