package ba.infostudio.hcm.ogWorkPlaces;

import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import ba.infostudio.hcm.ogOrganizations.OgOrganizationsModel;
import ba.infostudio.hcm.ogWorkPlaceTypes.OgWorkPlaceTypes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
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

    @JsonBackReference
    @OneToMany(mappedBy = "id_work_place")
    private Collection<AtVacancyModel> vacancies;

    public OgWorkPlacesModel() {
    }

    public OgWorkPlacesModel(String code, String name, String description, OgWorkPlacesModel id_parent, Collection<OgWorkPlacesModel> children, OgOrganizationsModel id_organization, OgWorkPlaceTypes id_work_place_type, Collection<AtVacancyModel> vacancies) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.id_parent = id_parent;
        this.children = children;
        this.id_organization = id_organization;
        this.id_work_place_type = id_work_place_type;
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

    public Collection<AtVacancyModel> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Collection<AtVacancyModel> vacancies) {
        this.vacancies = vacancies;
    }
}
