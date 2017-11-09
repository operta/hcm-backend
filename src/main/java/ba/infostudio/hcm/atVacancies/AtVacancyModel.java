package ba.infostudio.hcm.atVacancies;

import ba.infostudio.hcm.ogWorkPlaces.OgWorkPlacesModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ID_LOCATION")
    private RgRegionsModel id_location;
    private Date date_from;
    private Date date_to;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_WORK_PLACE")
    private OgWorkPlacesModel id_work_place;

    private Timestamp updated_at;


    public AtVacancyModel() {
    }

    public AtVacancyModel(String code, String name, String description, RgRegionsModel id_location, Date date_from, Date date_to, OgWorkPlacesModel id_work_place, Timestamp updated_at) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.id_location = id_location;
        this.date_from = date_from;
        this.date_to = date_to;
        this.id_work_place = id_work_place;
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

    public RgRegionsModel getId_location() {
        return id_location;
    }

    public void setId_location(RgRegionsModel id_location) {
        this.id_location = id_location;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public OgWorkPlacesModel getId_work_place() {
        return id_work_place;
    }

    public void setId_work_place(OgWorkPlacesModel id_work_place) {
        this.id_work_place = id_work_place;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }


}
