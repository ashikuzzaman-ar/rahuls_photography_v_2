package com.studevs.mvc.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "OUR_PACKAGES")
public class OurPackages implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id ;
    
    @Column(name = "PACKAGE_NAME")
    private String packageName ;
    
    @Column(name = "PACKAGE_PRICE")
    private Integer packagePrice ;
    
    @Column(name = "FEATURE_LIST")
    private List<String> featureList ;
    
    @ManyToOne(targetEntity = FeaturePage.class)
    private FeaturePage featurePage ;

    public OurPackages() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.packageName);
        hash = 79 * hash + Objects.hashCode(this.packagePrice);
        hash = 79 * hash + Objects.hashCode(this.featureList);
        hash = 79 * hash + Objects.hashCode(this.featurePage);
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
        final OurPackages other = (OurPackages) obj;
        if (!Objects.equals(this.packageName, other.packageName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.packagePrice, other.packagePrice)) {
            return false;
        }
        if (!Objects.equals(this.featureList, other.featureList)) {
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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(Integer packagePrice) {
        this.packagePrice = packagePrice;
    }

    public List<String> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<String> featureList) {
        this.featureList = featureList;
    }

    public FeaturePage getFeaturePage() {
        return featurePage;
    }

    public void setFeaturePage(FeaturePage featurePage) {
        this.featurePage = featurePage;
    }
}
