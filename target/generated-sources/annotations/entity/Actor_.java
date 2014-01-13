package entity;

import entity.Film;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T03:04:42")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile SingularAttribute<Actor, Integer> actorID;
    public static volatile SingularAttribute<Actor, String> actorName;
    public static volatile CollectionAttribute<Actor, Film> filmCollection;

}