package ba.infostudio.hcm.ogWorkPlaces;

import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import ba.infostudio.hcm.ogOrganizations.OgOrganizationsModel;
import ba.infostudio.hcm.ogWorkPlaceTypes.OgWorkPlaceTypes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "OG_WORK_PLACES")
public class OgWorkPlacesModel implements Serializable {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_PARENT")
    private OgWorkPlacesModel id_parent;

    @OneToMany(mappedBy = "id_parent")
    @JsonBackReference
    private Collection<OgWorkPlacesModel> children;


    @ManyToOne
    @JoinColumn(name = "ID_ORGANIZATION")
    private OgOrganizationsModel id_organization;

    @ManyToOne
    @JoinColumn(name="ID_WORK_PLACE_TYPE")
    private OgWorkPlaceTypes id_work_place_type;

    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    @JsonBackReference
    @OneToMany(mappedBy = "id_work_place")
    private Collection<AtVacancyModel> vacancies;

    public OgWorkPlacesModel() {
    }

    public OgWorkPlacesModel(String code, String name, String description, OgWorkPlacesModel id_parent, Collection<OgWorkPlacesModel> children, OgOrganizationsModel id_organization, OgWorkPlaceTypes id_work_place_type, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Collection<AtVacancyModel> vacancies) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.id_parent = id_parent;
        this.children = children;
        this.id_organization = id_organization;
        this.id_work_place_type = id_work_place_type;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.vacancies = vacancies;
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

    public OgWorkPlacesModel getId_parent() {
        return id_parent;
    }

    public void setId_parent(OgWorkPlacesModel id_parent) {
        this.id_parent = id_parent;
    }

    public Collection<OgWorkPlacesModel> getChildren() {
        return children;
    }

    public void setChildren(Collection<OgWorkPlacesModel> children) {
        this.children = children;
    }

    public OgOrganizationsModel getId_organization() {
        return id_organization;
    }

    public void setId_organization(OgOrganizationsModel id_organization) {
        this.id_organization = id_organization;
    }

    public OgWorkPlaceTypes getId_work_place_type() {
        return id_work_place_type;
    }

    public void setId_work_place_type(OgWorkPlaceTypes id_work_place_type) {
        this.id_work_place_type = id_work_place_type;
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

    public Collection<AtVacancyModel> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Collection<AtVacancyModel> vacancies) {
        this.vacancies = vacancies;
    }
}
