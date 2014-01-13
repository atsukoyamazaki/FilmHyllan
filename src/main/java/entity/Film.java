/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ATSUKO
 */
@Entity
@Table(name = "film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findByFilmID", query = "SELECT f FROM Film f WHERE f.filmID = :filmID"),
    @NamedQuery(name = "Film.findByTitle", query = "SELECT f FROM Film f WHERE f.title = :title"),
    @NamedQuery(name = "Film.findByYear", query = "SELECT f FROM Film f WHERE f.year = :year"),
    @NamedQuery(name = "Film.findByLanguage", query = "SELECT f FROM Film f WHERE f.language = :language"),
    @NamedQuery(name = "Film.findByRunTime", query = "SELECT f FROM Film f WHERE f.runTime = :runTime")})
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FilmID")
    private Integer filmID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Title")
    private String title;
    @Column(name = "Year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Size(max = 100)
    @Column(name = "Language")
    private String language;
    @Column(name = "RunTime")
    private Short runTime;
    @Column(name = "Img")
    private String Img;

    @JoinTable(name = "genrefilm", joinColumns = {
        @JoinColumn(name = "FilmID", referencedColumnName = "FilmID")}, inverseJoinColumns = {
        @JoinColumn(name = "GenreID", referencedColumnName = "GenreID")})
    @ManyToMany
    private Collection<Genre> genreCollection;
    @JoinTable(name = "actorfilm", joinColumns = {
        @JoinColumn(name = "FilmID", referencedColumnName = "FilmID")}, inverseJoinColumns = {
        @JoinColumn(name = "ActorID", referencedColumnName = "ActorID")})
    @ManyToMany
    private Collection<Actor> actorCollection;
    @JoinTable(name = "directorfilm", joinColumns = {
        @JoinColumn(name = "FilmID", referencedColumnName = "FilmID")}, inverseJoinColumns = {
        @JoinColumn(name = "DirectorID", referencedColumnName = "DirectorID")})
    @ManyToMany
    private Collection<Director> directorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Collection<Review> reviewCollection;

    public Film() {
    }

    public Film(Integer filmID) {
        this.filmID = filmID;
    }

    public Film(Integer filmID, String title) {
        this.filmID = filmID;
        this.title = title;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Short getRunTime() {
        return runTime;
    }

    public void setRunTime(Short runTime) {
        this.runTime = runTime;
    }

    
    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }
    
    @XmlTransient
    public Collection<Genre> getGenreCollection() {
        return genreCollection;
    }

    public void setGenreCollection(Collection<Genre> genreCollection) {
        this.genreCollection = genreCollection;
    }

    @XmlTransient
    public Collection<Actor> getActorCollection() {
        return actorCollection;
    }

    public void setActorCollection(Collection<Actor> actorCollection) {
        this.actorCollection = actorCollection;
    }

    @XmlTransient
    public Collection<Director> getDirectorCollection() {
        return directorCollection;
    }

    public void setDirectorCollection(Collection<Director> directorCollection) {
        this.directorCollection = directorCollection;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmID != null ? filmID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmID == null && other.filmID != null) || (this.filmID != null && !this.filmID.equals(other.filmID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Film[ filmID=" + filmID + " ]";
    }
    
}
