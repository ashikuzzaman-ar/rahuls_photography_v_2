package com.studevs.mvc.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "OUR_PACKAGES")
public class OurPackages implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PACKAGE_NAME", unique = true)
    private String packageName;

    @Column(name = "PACKAGE_PRICE")
    private Integer packagePrice;

    @Column(name = "FEATURE_LIST")
    private String[] featureList;

    @ManyToOne(targetEntity = FeaturePage.class, cascade = CascadeType.ALL)
    private FeaturePage featurePage;
    
    @OneToMany(targetEntity = Orders.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ourPackages")
    private List<Orders> orderses;

    public OurPackages() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.packageName);
        hash = 71 * hash + Objects.hashCode(this.packagePrice);
        hash = 71 * hash + Arrays.deepHashCode(this.featureList);
        hash = 71 * hash + Objects.hashCode(this.featurePage);
        hash = 71 * hash + Objects.hashCode(this.orderses);
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
        if (!Arrays.deepEquals(this.featureList, other.featureList)) {
            return false;
        }
        if (!Objects.equals(this.featurePage, other.featurePage)) {
            return false;
        }
        return Objects.equals(this.orderses, other.orderses);
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

    public String[] getFeatureList() {
        return featureList;
    }

    public void setFeatureList(String[] featureList) {
        this.featureList = featureList;
    }

    public FeaturePage getFeaturePage() {
        return featurePage;
    }

    public void setFeaturePage(FeaturePage featurePage) {
        this.featurePage = featurePage;
    }

    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }
}
