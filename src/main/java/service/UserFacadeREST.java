/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Review;
import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ATSUKO
 */
@Stateless
@Path("entity.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "com.mycompany_FilmHyllan_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private String password;
    private Integer userID;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Path("login")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public List<Review> login(User entity, @Context HttpServletRequest request) {


        HttpSession session = request.getSession(true);
        // Object foo = session.getAttribute("foo");
        System.out.println("myId:" + session.getAttribute("myId"));
System.out.println("getUserName" + entity.getUserName());
        User user = getUserByName(entity.getUserName());

        if (user != null) {
            System.out.println("user:" + user.getUserID());
            //this.password = Util.hashPassword(entity.getPassword();
            this.password = entity.getPassword();
            this.userID = user.getUserID();

            if (user.getPassword().equals(this.password)) {
                session.setAttribute("myId", userID);
                return getEntityManager().createNamedQuery("Review.listFindByUserID").setParameter("userID", userID).getResultList();
            } else {
               throw new NotAuthorizedException("You Don't Have Permission");
            }

        } else {
            throw new NotAuthorizedException("You Don't Have Permission");
        }
    }

    public class NotAuthorizedException extends WebApplicationException {

        public NotAuthorizedException(String message) {
            super(Response.status(Response.Status.BAD_REQUEST)
                    .entity(message).type(MediaType.TEXT_PLAIN).build());
        }
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private User getUserByName(String userName) {
        try {
            User user = (User) getEntityManager().
                    createNamedQuery("User.findByUserName").
                    setParameter("userName", userName).
                    getSingleResult();
            return user;
        } catch (NoResultException e) {
            System.err.println("NoResultException" + e.getMessage());
            return null;
        }
    }
}
