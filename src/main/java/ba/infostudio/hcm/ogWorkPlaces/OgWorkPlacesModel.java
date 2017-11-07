package ba.infostudio.hcm.ogWorkPlaces;

import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import ba.infostudio.hcm.ogOrganizations.OgOrganizationsModel;
import ba.infostudio.hcm.ogWorkPlaceTypes.OgWorkPlaceTypes;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private OgWorkPlacesModel parent;
    @OneToMany(mappedBy = "parent")
    @JsonBackReference
    private Collection<OgWorkPlacesModel> children;

    @ManyToOne
    @JoinColumn(name = "ID_ORGANIZATION")
    private OgOrganizationsModel organization;


    @ManyToOne
    @JoinColumn(name="ID_WORK_PLACE_TYPE")
    private OgWorkPlaceTypes workPlaceType;

    @OneToMany(mappedBy = "workPlace")
    @JsonBackReference
    private Collection<AtVacancyModel> vacancies;

    public OgWorkPlacesModel() {
    }

    public OgWorkPlacesModel(String code, String name, String description, OgWorkPlacesModel parent, Collection<OgWorkPlacesModel> children, OgOrganizationsModel organization, OgWorkPlaceTypes workPlaceType, Collection<AtVacancyModel> vacancies) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.parent = parent;
        this.children = children;
        this.organization = organization;
        this.workPlaceType = workPlaceType;
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

    public OgWorkPlacesModel getParent() {
        return parent;
    }

    public void setParent(OgWorkPlacesModel parent) {
        this.parent = parent;
    }

    public Collection<OgWorkPlacesModel> getChildren() {
        return children;
    }

    public void setChildren(Collection<OgWorkPlacesModel> children) {
        this.children = children;
    }

    public OgOrganizationsModel getOrganization() {
        return organization;
    }

    public void setOrganization(OgOrganizationsModel organization) {
        this.organization = organization;
    }

    public OgWorkPlaceTypes getWorkPlaceType() {
        return workPlaceType;
    }

    public void setWorkPlaceType(OgWorkPlaceTypes workPlaceType) {
        this.workPlaceType = workPlaceType;
    }

    public Collection<AtVacancyModel> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Collection<AtVacancyModel> vacancies) {
        this.vacancies = vacancies;
    }
}
