package ba.infostudio.hcm.leLegalEntities;

import ba.infostudio.hcm.ogOrganizations.OgOrganizationsModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table (name = "LE_LEGAL_ENTITIES")
public class LeLegalEntitiesModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String id_number;
    private String duty_number;
    private Long country;
    private Long region;
    private Long city;
    private String address;
    private String postal_number;
    private Long id_entity_type;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    @JsonBackReference(value = "id_legal_entity")
    @OneToMany(mappedBy = "id_legal_entity")
    private Collection<OgOrganizationsModel> organizations;

    public LeLegalEntitiesModel() {
    }

    public LeLegalEntitiesModel(String code, String name, String id_number, String duty_number, Long country, Long region, Long city, String address, String postal_number, Long id_entity_type, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Collection<OgOrganizationsModel> organizations) {
        this.code = code;
        this.name = name;
        this.id_number = id_number;
        this.duty_number = duty_number;
        this.country = country;
        this.region = region;
        this.city = city;
        this.address = address;
        this.postal_number = postal_number;
        this.id_entity_type = id_entity_type;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.organizations = organizations;
    }

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

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getDuty_number() {
        return duty_number;
    }

    public void setDuty_number(String duty_number) {
        this.duty_number = duty_number;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_number() {
        return postal_number;
    }

    public void setPostal_number(String postal_number) {
        this.postal_number = postal_number;
    }

    public Long getId_entity_type() {
        return id_entity_type;
    }

    public void setId_entity_type(Long id_entity_type) {
        this.id_entity_type = id_entity_type;
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

    public Collection<OgOrganizationsModel> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Collection<OgOrganizationsModel> organizations) {
        this.organizations = organizations;
    }
}
