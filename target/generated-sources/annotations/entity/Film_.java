package entity;

import entity.Actor;
import entity.Director;
import entity.Genre;
import entity.Review;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T03:04:42")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, String> title;
    public static volatile CollectionAttribute<Film, Genre> genreCollection;
    public static volatile CollectionAttribute<Film, Review> reviewCollection;
    public static volatile SingularAttribute<Film, String> Img;
    public static volatile CollectionAttribute<Film, Director> directorCollection;
    public static volatile SingularAttribute<Film, Date> year;
    public static volatile SingularAttribute<Film, Short> runTime;
    public static volatile SingularAttribute<Film, String> language;
    public static volatile SingularAttribute<Film, Integer> filmID;
    public static volatile CollectionAttribute<Film, Actor> actorCollection;

}