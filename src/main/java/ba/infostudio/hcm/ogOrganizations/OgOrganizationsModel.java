package ba.infostudio.hcm.ogOrganizations;


import ba.infostudio.hcm.ogWorkPlaces.OgWorkPlacesModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "OG_ORGANIZATIONS")
public class OgOrganizationsModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String description;
//LEGALENTITY PLACEHOLDER
    @ManyToOne
    @JoinColumn(name = "ID_PARENT")
    private OgOrganizationsModel parent;
    @OneToMany(mappedBy = "parent")
    @JsonBackReference
    private Collection<OgOrganizationsModel> children;
    private String created_by;
    private String created_at;
    private String updated_by;
    private String updated_at;

    @OneToMany(mappedBy = "organization")
    @JsonBackReference
    private Collection<OgWorkPlacesModel> workPlaces;

    public OgOrganizationsModel() {
    }

    public OgOrganizationsModel(String code, String name, String description, OgOrganizationsModel parent, Collection<OgOrganizationsModel> children, String created_by, String created_at, String updated_by, String updated_at, Collection<OgWorkPlacesModel> workPlaces) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.parent = parent;
        this.children = children;
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

    public OgOrganizationsModel getParent() {
        return parent;
    }

    public void setParent(OgOrganizationsModel parent) {
        this.parent = parent;
    }

    public Collection<OgOrganizationsModel> getChildren() {
        return children;
    }

    public void setChildren(Collection<OgOrganizationsModel> children) {
        this.children = children;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Collection<OgWorkPlacesModel> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(Collection<OgWorkPlacesModel> workPlaces) {
        this.workPlaces = workPlaces;
    }
}
