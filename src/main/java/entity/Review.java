/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/** p.authorId.relationCollection r
 *
 * @author ATSUKO
 */
@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByFilmID", query = "SELECT r FROM Review r WHERE r.reviewPK.filmID = :filmID"),
    @NamedQuery(name = "Review.findByUserID", query = "SELECT r FROM Review r WHERE r.reviewPK.userID = :userID"),
    @NamedQuery(name = "Review.findByReview", query = "SELECT r FROM Review r WHERE r.review = :review"),
    @NamedQuery(name = "Review.findByRating", query = "SELECT r FROM Review r WHERE r.rating = :rating"),
    @NamedQuery(name = "Review.listFindByUserID", query ="SELECT r, d FROM Review r LEFT JOIN r.film.directorCollection d  WHERE r.reviewPK.userID = :userID GROUP BY r.film.filmID order by r.date desc"),
    @NamedQuery(name = "Review.listFindByUserID2", query ="SELECT r, d FROM Review r LEFT JOIN r.film.directorCollection d  WHERE r.reviewPK.userID = :userID ")})

public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReviewPK reviewPK;
    @Size(max = 10000)
    @Column(name = "Review")
    private String review;
    @Size(max = 6)
    @Column(name = "Rating")
    private String rating;
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "FilmID", referencedColumnName = "FilmID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;

    public Review() {
    }

    public Review(ReviewPK reviewPK) {
        this.reviewPK = reviewPK;
    }

    public Review(int filmID, int userID) {
        this.reviewPK = new ReviewPK(filmID, userID);
    }

    public ReviewPK getReviewPK() {
        return reviewPK;
    }

    public void setReviewPK(ReviewPK reviewPK) {
        this.reviewPK = reviewPK;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewPK != null ? reviewPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.reviewPK == null && other.reviewPK != null) || (this.reviewPK != null && !this.reviewPK.equals(other.reviewPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Review[ reviewPK=" + reviewPK + " ]";
    }
    
}
