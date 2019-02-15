package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	ClassroomService service;
	
	@POST
	@Path("/createClassroom")
	@Produces({ "application/json" })
	public String createClassroom(String trainerName){
		return service.createClassroom(trainerName);
	}
	
	@GET
	@Path("/getAllClassrooms")
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@GET
	@Path("/getAClassroom/{classroomId}")
	@Produces({ "application/json" })
	public String getAClassroom(@PathParam("classroomId")int classroomId) {
		return service.getAClassroom(classroomId);
	}
	
	@PUT
	@Path("/updateClassroom/{classroomId}")
	@Produces({ "application/json" })
	public String updateClassroom(String trainerName, @PathParam("classroomId") int classroomId) {
		return service.updateClassroom(trainerName, classroomId);
	}
	
	@DELETE
	@Path("/deleteClassroom/{classroomId}")
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("classroomId") int classroomId) {
		return service.deleteClassroom(classroomId);
	}
	
	@GET
	@Path("/cycleClassrooms/{traineeName}")
	@Produces({ "application/json" })
	public int cycleClassrooms(@PathParam("traineeName")String trainerName) {
		return service.cycleClassrooms(trainerName);
	}

}
