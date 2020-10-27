package gov.mendoza.salud.hvt.attendance.model.attendance.filters;

import java.io.IOException;

import io.vertx.core.http.HttpServerRequest;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;


@Provider
public class AttendanceFilter implements ContainerRequestFilter {
    @Context UriInfo info;
    @Context HttpServerRequest request;
    @Inject  JsonWebToken jwt;
    private static final Logger LOG = Logger.getLogger(AttendanceFilter.class);

    //TODO: ask to user-service if username exist.
    @Override
    public void filter(ContainerRequestContext context) throws IOException {        
        final String method = context.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        jwt.getClaim("username");
        //LOG.infof("Request %s %s from IP %s", method, path, address);
    }
    
}
