/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Review;
import entity.ReviewPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.PathSegment;
import org.eclipse.persistence.oxm.JSONWithPadding;

/**
 *
 * @author ATSUKO
 */
@Stateless
@Path("entity.review")
public class ReviewFacadeREST extends AbstractFacade<Review> {

    @PersistenceContext(unitName = "com.mycompany_FilmHyllan_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private ReviewPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;filmID=filmIDValue;userID=userIDValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entity.ReviewPK key = new entity.ReviewPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> filmID = map.get("filmID");
        if (filmID != null && !filmID.isEmpty()) {
            key.setFilmID(new java.lang.Integer(filmID.get(0)));
        }
        java.util.List<String> userID = map.get("userID");
        if (userID != null && !userID.isEmpty()) {
            key.setUserID(new java.lang.Integer(userID.get(0)));
        }
        return key;
    }

    public ReviewFacadeREST() {
        super(Review.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Review entity) {
        super.create(entity);
    }


    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Review entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entity.ReviewPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/javascript"})
    public Review find(@PathParam("id") PathSegment id) {
        entity.ReviewPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Review> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Review> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("reviewlist/{userid}")
    @Produces({"application/xml", "application/json"})
    public List<Review> listFindByUserID(@PathParam("userid") Integer userid) {

        return getEntityManager().createNamedQuery("Review.findByUserID").setParameter("userID", userid).getResultList();
    }

    @GET
    @Path("reviewlist2/{userid}")
    @Produces({"application/javascript"})
    public JSONWithPadding findRangeJsonP(@PathParam("userid") int userid,
            @QueryParam("callback") String callback) {
        List<Review> employees = getEntityManager().createNamedQuery("Review.findByUserID").setParameter("userID", userid).getResultList();
        return new JSONWithPadding(employees, callback);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
