package com.microlistics.wms;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    OracleService oracleService;

    //FIXME please use camel case for class name and method name, method should be started by smaller case, and class started by Capital case
//    @Inject
//    Iw_web_userService iw_web_userService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Assalamualaikum Ukhti";
    }

    @Path("/oracle")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getVersion() {
        return oracleService.getDatabaseVersion();
    }


    //FIXME please use camel case for class name and method name, method should be started by smaller case, and class started by Capital case
//    @Path("/user-management")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Iw_web_user> getAllUsers() {
//        return iw_web_userService.listAllIw_web_user();
//    }
}
