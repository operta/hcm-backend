package ba.infostudio.hcm.rgRegions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    private Long id_type;

    @ManyToOne
    @JoinColumn(name = "ID_PARENT")
    private RgRegionsModel id_parent;

    @OneToMany(mappedBy = "id_parent")
    @JsonBackReference(value= "parentChild")
    private Collection<RgRegionsModel> children;



    public RgRegionsModel(){

    }

    public RgRegionsModel(String code, String name, String description, Long id_type, RgRegionsModel id_parent, Collection<RgRegionsModel> children) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.id_type = id_type;
        this.id_parent = id_parent;
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

    public Long getId_type() {
        return id_type;
    }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
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
}
