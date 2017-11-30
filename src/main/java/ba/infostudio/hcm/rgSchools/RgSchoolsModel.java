package ba.infostudio.hcm.rgSchools;

import ba.infostudio.hcm.rgRegions.RgRegionsModel;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "RG_SCHOOLS")
public class RgSchoolsModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String description;
    private String address;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    @OneToOne
    @JoinColumn(name = "ID_COUNTRY")
    private RgRegionsModel id_country;

    @OneToOne
    @JoinColumn(name = "ID_REGION")
    private RgRegionsModel id_region;

    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private RgRegionsModel id_city;

    public RgSchoolsModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public RgRegionsModel getId_country() {
        return id_country;
    }

    public void setId_country(RgRegionsModel id_country) {
        this.id_country = id_country;
    }

    public RgRegionsModel getId_region() {
        return id_region;
    }

    public void setId_region(RgRegionsModel id_region) {
        this.id_region = id_region;
    }

    public RgRegionsModel getId_city() {
        return id_city;
    }

    public void setId_city(RgRegionsModel id_city) {
        this.id_city = id_city;
    }

    public RgSchoolsModel(String code, String name, String description, String address, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, RgRegionsModel id_country, RgRegionsModel id_region, RgRegionsModel id_city) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.address = address;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.id_country = id_country;
        this.id_region = id_region;
        this.id_city = id_city;
    }
}


