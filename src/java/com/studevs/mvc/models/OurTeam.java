package com.studevs.mvc.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "OUR_TEAM")
public class OurTeam implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Lob
    @Column(name = "PROFILE_PICTURE")
    private byte[] profilePicture;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "SOCIAL_MEDIA_LINKS")
    private String[] socialMediaLinks;
    
    @ManyToOne(targetEntity = FeaturePage.class, cascade = CascadeType.ALL)
    private FeaturePage featurePage;

    public OurTeam() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Arrays.hashCode(this.profilePicture);
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.position);
        hash = 11 * hash + Objects.hashCode(this.message);
        hash = 11 * hash + Arrays.deepHashCode(this.socialMediaLinks);
        hash = 11 * hash + Objects.hashCode(this.featurePage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OurTeam other = (OurTeam) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.equals(this.profilePicture, other.profilePicture)) {
            return false;
        }
        if (!Arrays.deepEquals(this.socialMediaLinks, other.socialMediaLinks)) {
            return false;
        }
        return Objects.equals(this.featurePage, other.featurePage);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(String[] socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public FeaturePage getFeaturePage() {
        return featurePage;
    }

    public void setFeaturePage(FeaturePage featurePage) {
        this.featurePage = featurePage;
    }
}
