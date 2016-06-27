package com.studevs.mvc.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "FEATURE_PAGE")
public class FeaturePage implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Lob
    @Column(name = "STARTING_GIF_ANIMATION")
    private byte[] startingGifAnimation;

    @Lob
    @Column(name = "COVER_PHOTOS")
    private byte[][] coverPhotos;

    @Lob
    @Column(name = "ABOUT_US_PHOTOS")
    private byte[][] aboutUsPhotos;

    @Lob
    @Column(name = "OUR_SKILLs_PHOTO")
    private byte[] ourSkillsPhoto;

    @Lob
    @Column(name = "SOME_MILESTONE_WORKS_PHOTO")
    private byte[] someMilestoneWorksPhoto;

    @Column(name = "SOME_MILESTONE_WORKS_COUNTER")
    private Integer[] someMilestoneWorksCounter;

    @OneToMany(targetEntity = OurTeam.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "featurePage")
    private List<OurTeam> ourTeamMembers;

    @OneToMany(targetEntity = OurPackages.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "featurePage")
    private List<OurPackages> ourPackages;

    @Lob
    @Column(name = "CONTACT_US_PHOTO")
    private byte[] contactUsPhoto;

    public FeaturePage() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Arrays.hashCode(this.startingGifAnimation);
        hash = 59 * hash + Arrays.deepHashCode(this.coverPhotos);
        hash = 59 * hash + Arrays.deepHashCode(this.aboutUsPhotos);
        hash = 59 * hash + Arrays.hashCode(this.ourSkillsPhoto);
        hash = 59 * hash + Arrays.hashCode(this.someMilestoneWorksPhoto);
        hash = 59 * hash + Arrays.deepHashCode(this.someMilestoneWorksCounter);
        hash = 59 * hash + Objects.hashCode(this.ourTeamMembers);
        hash = 59 * hash + Objects.hashCode(this.ourPackages);
        hash = 59 * hash + Arrays.hashCode(this.contactUsPhoto);
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
        final FeaturePage other = (FeaturePage) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.equals(this.startingGifAnimation, other.startingGifAnimation)) {
            return false;
        }
        if (!Arrays.deepEquals(this.coverPhotos, other.coverPhotos)) {
            return false;
        }
        if (!Arrays.deepEquals(this.aboutUsPhotos, other.aboutUsPhotos)) {
            return false;
        }
        if (!Arrays.equals(this.ourSkillsPhoto, other.ourSkillsPhoto)) {
            return false;
        }
        if (!Arrays.equals(this.someMilestoneWorksPhoto, other.someMilestoneWorksPhoto)) {
            return false;
        }
        if (!Arrays.deepEquals(this.someMilestoneWorksCounter, other.someMilestoneWorksCounter)) {
            return false;
        }
        if (!Objects.equals(this.ourTeamMembers, other.ourTeamMembers)) {
            return false;
        }
        if (!Objects.equals(this.ourPackages, other.ourPackages)) {
            return false;
        }
        return Arrays.equals(this.contactUsPhoto, other.contactUsPhoto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getStartingGifAnimation() {
        return startingGifAnimation;
    }

    public void setStartingGifAnimation(byte[] startingGifAnimation) {
        this.startingGifAnimation = startingGifAnimation;
    }

    public byte[][] getCoverPhotos() {
        return coverPhotos;
    }

    public void setCoverPhotos(byte[][] coverPhotos) {
        this.coverPhotos = coverPhotos;
    }

    public byte[][] getAboutUsPhotos() {
        return aboutUsPhotos;
    }

    public void setAboutUsPhotos(byte[][] aboutUsPhotos) {
        this.aboutUsPhotos = aboutUsPhotos;
    }

    public byte[] getOurSkillsPhoto() {
        return ourSkillsPhoto;
    }

    public void setOurSkillsPhoto(byte[] ourSkillsPhoto) {
        this.ourSkillsPhoto = ourSkillsPhoto;
    }

    public byte[] getSomeMilestoneWorksPhoto() {
        return someMilestoneWorksPhoto;
    }

    public void setSomeMilestoneWorksPhoto(byte[] someMilestoneWorksPhoto) {
        this.someMilestoneWorksPhoto = someMilestoneWorksPhoto;
    }

    public Integer[] getSomeMilestoneWorksCounter() {
        return someMilestoneWorksCounter;
    }

    public void setSomeMilestoneWorksCounter(Integer[] someMilestoneWorksCounter) {
        this.someMilestoneWorksCounter = someMilestoneWorksCounter;
    }

    public List<OurTeam> getOurTeamMembers() {
        return ourTeamMembers;
    }

    public void setOurTeamMembers(List<OurTeam> ourTeamMembers) {
        this.ourTeamMembers = ourTeamMembers;
    }

    public List<OurPackages> getOurPackages() {
        return ourPackages;
    }

    public void setOurPackages(List<OurPackages> ourPackages) {
        this.ourPackages = ourPackages;
    }

    public byte[] getContactUsPhoto() {
        return contactUsPhoto;
    }

    public void setContactUsPhoto(byte[] contactUsPhoto) {
        this.contactUsPhoto = contactUsPhoto;
    }
}
