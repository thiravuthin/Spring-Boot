package com.example.springboot.feature.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CityId implements Serializable {

    @Column(name = "ntnl_cd", length = 2)
    private String nationalCode;

    @Column(name = "city_cd", length = 4)
    private String countryCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CityId cityId = (CityId) o;
        return getNationalCode() != null && Objects.equals(getNationalCode(), cityId.getNationalCode())
                && getCountryCode() != null && Objects.equals(getCountryCode(), cityId.getCountryCode());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(nationalCode, countryCode);
    }
}