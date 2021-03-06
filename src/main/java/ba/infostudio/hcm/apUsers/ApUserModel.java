package ba.infostudio.hcm.apUsers;

import ba.infostudio.hcm.apUserDeviceTokens.apUserDeviceTokenModel;
import ba.infostudio.hcm.apUserStatuses.ApUserStatusModel;
import ba.infostudio.hcm.rgRegions.RgRegionsModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
@Entity
@Table(name = "AP_USERS")
public class ApUserModel implements Serializable {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
    private String image_path;

    @OneToOne
    @JoinColumn(name = "ID_STATUS")
    private ApUserStatusModel id_status;

    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;


    public ApUserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public ApUserStatusModel getId_status() {
        return id_status;
    }

    public void setId_status(ApUserStatusModel id_status) {
        this.id_status = id_status;
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


    public ApUserModel(String username, String email, String password, String role, String image_path, ApUserStatusModel id_status, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.image_path = image_path;
        this.id_status = id_status;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }

}

