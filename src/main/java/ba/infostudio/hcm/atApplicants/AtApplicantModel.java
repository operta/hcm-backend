package ba.infostudio.hcm.atApplicants;

import ba.infostudio.hcm.apUsers.ApUserModel;
import ba.infostudio.hcm.atJobApplications.AtJobApplicationModel;
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
    private Long id_country;
    private Long id_region;
    private Long id_city;
    private String address;
    private Long id_employee;
    private String description;
    private String employment_position;
    private String industry;
    @OneToOne
    @JoinColumn(name = "ID_USER")
    private ApUserModel idUser;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private String phone_number;
    private String email;


    @OneToMany(mappedBy = "id_applicant", fetch = FetchType.LAZY)
    private Collection<AtJobApplicationModel> jobApplications;


    public AtApplicantModel() {
    }

    public AtApplicantModel(String name, String surname, String middle_name, String maiden_name, String gender, Date birthdate, String marital_status, Long id_country, Long id_region, Long id_city, String address, Long id_employee, String description, String employment_position, String industry, ApUserModel idUser, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at, String phone_number, String email, Collection<AtJobApplicationModel> jobApplications) {
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.maiden_name = maiden_name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.marital_status = marital_status;
        this.id_country = id_country;
        this.id_region = id_region;
        this.id_city = id_city;
        this.address = address;
        this.id_employee = id_employee;
        this.description = description;
        this.employment_position = employment_position;
        this.industry = industry;
        this.idUser = idUser;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.phone_number = phone_number;
        this.email = email;
        this.jobApplications = jobApplications;
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

    public Long getId_country() {
        return id_country;
    }

    public void setId_country(Long id_country) {
        this.id_country = id_country;
    }

    public Long getId_region() {
        return id_region;
    }

    public void setId_region(Long id_region) {
        this.id_region = id_region;
    }

    public Long getId_city() {
        return id_city;
    }

    public void setId_city(Long id_city) {
        this.id_city = id_city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
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

    public ApUserModel getIdUser() {
        return idUser;
    }

    public void setIdUser(ApUserModel idUser) {
        this.idUser = idUser;
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

    public Collection<AtJobApplicationModel> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Collection<AtJobApplicationModel> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
