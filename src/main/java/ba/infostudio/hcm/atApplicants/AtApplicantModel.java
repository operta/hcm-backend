package ba.infostudio.hcm.atApplicants;

import ba.infostudio.hcm.apUsers.ApUserModel;
import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
import ba.infostudio.hcm.rgQualifications.RgQualificationsModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")*/
@JsonIdentityInfo(generator=JSOGGenerator.class)
@Entity
@Table(name = "AT_APPLICANTS")
public class AtApplicantModel {
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
    @OneToOne
    @JoinColumn(name = "ID_COUNTRY")
    private RgRegionsModel id_country;

    @OneToOne
    @JoinColumn(name = "ID_REGION")
    private RgRegionsModel id_region;

    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private RgRegionsModel id_city;

    @OneToOne
    @JoinColumn(name = "ID_QUALIFICATION")
    private RgQualificationsModel id_qualification;
    private String employed;
    private String description;
    private String employment_position;
    private String industry;


    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private String phone_number;
    private String email;

    private Long id_employee;

    @OneToOne
    @JoinColumn(name = "ID_USER")
    private ApUserModel idUser;


    @OneToMany(mappedBy = "applicantid")
    private Collection<AtJobApplicationModel> jobApplications;

    private String image_link;


    public AtApplicantModel() {
    }

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

    public RgRegionsModel getId_country() {
        return id_country;
    }

    public void setId_country(RgRegionsModel id_country) {
        this.id_country = id_country;
    }

    public RgRegionsModel getId_region() {
        return id_region;
    }

    public void setId_region(RgRegionsModel id_region) {
        this.id_region = id_region;
    }

    public RgRegionsModel getId_city() {
        return id_city;
    }

    public void setId_city(RgRegionsModel id_city) {
        this.id_city = id_city;
    }

    public RgQualificationsModel getId_qualification() {
        return id_qualification;
    }

    public void setId_qualification(RgQualificationsModel id_qualification) {
        this.id_qualification = id_qualification;
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

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public ApUserModel getIdUser() {
        return idUser;
    }

    public void setIdUser(ApUserModel idUser) {
        this.idUser = idUser;
    }

    public Collection<AtJobApplicationModel> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Collection<AtJobApplicationModel> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public AtApplicantModel(String name, String surname, String middle_name, String maiden_name, String gender, Date birthdate, String marital_status, String address, RgRegionsModel id_country, RgRegionsModel id_region, RgRegionsModel id_city, RgQualificationsModel id_qualification, String employed, String description, String employment_position, String industry, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, String phone_number, String email, Long id_employee, ApUserModel idUser, Collection<AtJobApplicationModel> jobApplications, String image_link) {
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.maiden_name = maiden_name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.marital_status = marital_status;
        this.address = address;
        this.id_country = id_country;
        this.id_region = id_region;
        this.id_city = id_city;
        this.id_qualification = id_qualification;
        this.employed = employed;
        this.description = description;
        this.employment_position = employment_position;
        this.industry = industry;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.phone_number = phone_number;
        this.email = email;
        this.id_employee = id_employee;
        this.idUser = idUser;
        this.jobApplications = jobApplications;
        this.image_link = image_link;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
}
