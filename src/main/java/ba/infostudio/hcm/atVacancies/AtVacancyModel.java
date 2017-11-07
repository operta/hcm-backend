package ba.infostudio.hcm.atVacancies;

import ba.infostudio.hcm.ogWorkPlaces.OgWorkPlacesModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AT_VACANCIES")
public class AtVacancyModel implements Serializable{
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String code;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name="id_location")
    private RgRegionsModel region;
    private String date_from;
    private String date_to;

    @ManyToOne
    @JoinColumn(name = "ID_WORK_PLACE")
    private OgWorkPlacesModel workPlace;

    private String updated_at;


    public AtVacancyModel() {
    }

    public AtVacancyModel(String code, String name, String description, RgRegionsModel region, String date_from, String date_to, OgWorkPlacesModel workPlace, String updated_at) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.region = region;
        this.date_from = date_from;
        this.date_to = date_to;
        this.workPlace = workPlace;
        this.updated_at = updated_at;
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

    public RgRegionsModel getRegion() {
        return region;
    }

    public void setRegion(RgRegionsModel region) {
        this.region = region;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public OgWorkPlacesModel getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(OgWorkPlacesModel workPlace) {
        this.workPlace = workPlace;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
}
