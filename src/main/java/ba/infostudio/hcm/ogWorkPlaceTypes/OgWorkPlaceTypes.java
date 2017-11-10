package ba.infostudio.hcm.ogWorkPlaceTypes;

import ba.infostudio.hcm.ogWorkPlaces.OgWorkPlacesModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "OG_WORK_PLACE_TYPES")

public class OgWorkPlaceTypes {
    @Id
    @SequenceGenerator(name = "OID", sequenceName = "OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OID")
    private Long id;

    private String code;

    private String name;

    private String description;

    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    @JsonBackReference(value = "id_work_place_type")
    @OneToMany(mappedBy = "id_work_place_type")
    private Collection<OgWorkPlacesModel> workPlaces;

    public OgWorkPlaceTypes() {
    }

    public OgWorkPlaceTypes(String code, String name, String description, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Collection<OgWorkPlacesModel> workPlaces) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.workPlaces = workPlaces;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Collection<OgWorkPlacesModel> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(Collection<OgWorkPlacesModel> workPlaces) {
        this.workPlaces = workPlaces;
    }
}

