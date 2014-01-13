/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ATSUKO
 */
@Embeddable
public class ReviewPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FilmID")
    private int filmID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserID")
    private int userID;

    public ReviewPK() {
    }

    public ReviewPK(int filmID, int userID) {
        this.filmID = filmID;
        this.userID = userID;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) filmID;
        hash += (int) userID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewPK)) {
            return false;
        }
        ReviewPK other = (ReviewPK) object;
        if (this.filmID != other.filmID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReviewPK[ filmID=" + filmID + ", userID=" + userID + " ]";
    }
    
}
