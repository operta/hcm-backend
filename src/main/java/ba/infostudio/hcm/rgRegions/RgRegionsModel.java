package ba.infostudio.hcm.rgRegions;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "RG_REGIONS")
public class RgRegionsModel implements Serializable {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;

    private String name;

    private String description;

    private Long idType;

    @ManyToOne
    @JoinColumn(name = "ID_PARENT")

    private RgRegionsModel idParent;
    @OneToMany(mappedBy = "idParent")
    @JsonBackReference
    private Collection<RgRegionsModel> children;



    public RgRegionsModel(){

    }

    public RgRegionsModel(String code, String name, String description, RgRegionsModel idParent, Collection<RgRegionsModel> children) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.idParent = idParent;
        this.children = children;
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

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public RgRegionsModel getIdParent() {
        return idParent;
    }

    public void setIdParent(RgRegionsModel idParent) {
        this.idParent = idParent;
    }

    public Collection<RgRegionsModel> getChildren() {
        return children;
    }

    public void setChildren(Collection<RgRegionsModel> children) {
        this.children = children;
    }
}
