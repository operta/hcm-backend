package ba.infostudio.hcm.apUserDeviceTokens;


import ba.infostudio.hcm.apUsers.ApUserModel;
import ba.infostudio.hcm.atApplicants.AtApplicantModel;
import ba.infostudio.hcm.rgContactTypes.RgContactTypeModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "AP_DEVICE_TOKENS")
public class apUserDeviceTokenModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "USERID")
    private ApUserModel idUser;

    private String content;

    public apUserDeviceTokenModel(ApUserModel idUser, String content) {
        this.idUser = idUser;
        this.content = content;
    }

    public apUserDeviceTokenModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApUserModel getIdUser() {
        return idUser;
    }

    public void setIdUser(ApUserModel idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


