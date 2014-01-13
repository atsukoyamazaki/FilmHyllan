package entity;

import entity.Review;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T03:04:42")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> userID;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Date> birthday;
    public static volatile SingularAttribute<User, Integer> adminRight;
    public static volatile CollectionAttribute<User, Review> reviewCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;

}