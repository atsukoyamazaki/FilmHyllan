package entity;

import entity.Film;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T03:04:42")
@StaticMetamodel(Genre.class)
public class Genre_ { 

    public static volatile SingularAttribute<Genre, String> genreName;
    public static volatile SingularAttribute<Genre, Integer> genreID;
    public static volatile CollectionAttribute<Genre, Film> filmCollection;

}