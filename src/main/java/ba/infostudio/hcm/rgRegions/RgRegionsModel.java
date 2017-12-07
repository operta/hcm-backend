package ba.infostudio.hcm.rgRegions;

import ba.infostudio.hcm.atJobApplicationInterview.AtJobApplicationInterviewModel;
import ba.infostudio.hcm.atJobApplicationTest.AtJobApplicationTestModel;
import ba.infostudio.hcm.rgRegionTypes.RgRegionTypesModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "RG_REGIONS")
public class RgRegionsModel implements Serializable {
    @Id
    @SequenceGenerator(name = "OID", sequenceName = "OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OID")
    private Long id;
    private String code;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="ID_TYPE")
    private RgRegionTypesModel idType;

    @ManyToOne
    @JoinColumn(name = "ID_PARENT")
    private RgRegionsModel id_parent;

    @OneToMany(mappedBy = "id_parent")
    @JsonBackReference(value = "parentChild")
    private Collection<RgRegionsModel> children;

    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    @OneToMany(mappedBy = "location_id")
    @JsonBackReference(value = "testsReference")
    private Collection<AtJobApplicationTestModel> tests;

    @OneToMany(mappedBy = "location_id")
    @JsonBackReference(value = "interviewReference")
    private Collection<AtJobApplicationInterviewModel> interviews;

    public RgRegionsModel() {}

    public RgRegionsModel(String code, String name, String description, RgRegionTypesModel idType, RgRegionsModel id_parent, Collection<RgRegionsModel> children, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, Collection<AtJobApplicationTestModel> tests, Collection<AtJobApplicationInterviewModel> interviews) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.idType = idType;
        this.id_parent = id_parent;
        this.children = children;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.tests = tests;
        this.interviews = interviews;
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

    public RgRegionTypesModel getIdType() {
        return idType;
    }

    public void setIdType(RgRegionTypesModel idType) {
        this.idType = idType;
    }

    public RgRegionsModel getId_parent() {
        return id_parent;
    }

    public void setId_parent(RgRegionsModel id_parent) {
        this.id_parent = id_parent;
    }

    public Collection<RgRegionsModel> getChildren() {
        return children;
    }

    public void setChildren(Collection<RgRegionsModel> children) {
        this.children = children;
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

    public Collection<AtJobApplicationTestModel> getTests() {
        return tests;
    }

    public void setTests(Collection<AtJobApplicationTestModel> tests) {
        this.tests = tests;
    }

    public Collection<AtJobApplicationInterviewModel> getInterviews() {
        return interviews;
    }

    public void setInterviews(Collection<AtJobApplicationInterviewModel> interviews) {
        this.interviews = interviews;
    }
}