package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {

	@Inject
	TraineeService service;

	@POST
	@Path("/createTrainee")
	@Produces({ "application/json" })
	public String createTrainee(String traineeName) {
		return service.createTrainee(traineeName);

	}

	@GET
	@Path("/getAllTrainees")
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();

	}

	@GET
	@Path("/getATrainee/{traineeId}")
	@Produces({ "application/json" })
	public String getATrainee(@PathParam("traineeId") int traineeId) {
		return service.getATrainee(traineeId);

	}

	@PUT
	@Path("/updateTrainee/{traineeId}")
	@Produces({ "application/json" })
	public String updateTrainee(String traineeName, @PathParam("traineeId") int traineeId) {
		return service.updateTrainee(traineeName, traineeId);
	}

	@DELETE
	@Path("deleteTrainee/{traineeId}")
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("traineeId") int traineeId) {
		return service.deleteTrainee(traineeId);
	}

	@GET
	@Path("CycleTrainees/{traineeName}")
	@Produces({ "application/json" })
	public int cycleTrainees(@PathParam("traineeName") String traineeName) {
		return service.cycleTrainees(traineeName);
	}
}
