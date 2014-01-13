package entity;

import entity.Film;
import entity.ReviewPK;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T03:04:42")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, Film> film;
    public static volatile SingularAttribute<Review, ReviewPK> reviewPK;
    public static volatile SingularAttribute<Review, String> rating;
    public static volatile SingularAttribute<Review, User> user;
    public static volatile SingularAttribute<Review, String> review;

}