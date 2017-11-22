package ba.infostudio.hcm.atApplicants;

import ba.infostudio.hcm.apUsers.ApUserModel;
import ba.infostudio.hcm.ogWorkPlaces.OgWorkPlacesModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "AT_APPLICANTS")
public class AtApplicantModel implements  Serializable{
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String name;
    private String surname;
    private String middle_name;
    private String maiden_name;
    private String gender;
    private Date birthdate;
    private String marital_status;
    private String address;
    private String employed;
    private String description;
    private String employment_position;
    private String industry;
    private String phone_number;
    private String email;

    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;


    @OneToOne
    @JoinColumn(name = "ID_USER")
    private ApUserModel idUser;

    @ManyToOne
    @JoinColumn(name = "ID_REGION")
    private RgRegionsModel id_region;


//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "ID_COUNTRY")
//    private RgRegionsModel id_country;
//
//
//
//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "ID_CITY")
//    private RgRegionsModel id_city;
////
//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "ID_QUALIFICATION")
//    private long id_qualification;

    public AtApplicantModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getMaiden_name() {
        return maiden_name;
    }

    public void setMaiden_name(String maiden_name) {
        this.maiden_name = maiden_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployed() {
        return employed;
    }

    public void setEmployed(String employed) {
        this.employed = employed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployment_position() {
        return employment_position;
    }

    public void setEmployment_position(String employment_position) {
        this.employment_position = employment_position;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public ApUserModel getIdUser() {
        return idUser;
    }

    public void setIdUser(ApUserModel idUser) {
        this.idUser = idUser;
    }

    public RgRegionsModel getId_region() {
        return id_region;
    }

    public void setId_region(RgRegionsModel id_region) {
        this.id_region = id_region;
    }

    public AtApplicantModel(String name, String surname, String middle_name, String maiden_name, String gender, Date birthdate, String marital_status, String address, String employed, String description, String employment_position, String industry, String phone_number, String email, String created_by, Date created_at, String updated_by, Date updated_at, ApUserModel idUser, RgRegionsModel id_region) {
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.maiden_name = maiden_name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.marital_status = marital_status;
        this.address = address;
        this.employed = employed;
        this.description = description;
        this.employment_position = employment_position;
        this.industry = industry;
        this.phone_number = phone_number;
        this.email = email;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.idUser = idUser;
        this.id_region = id_region;
    }
}
