package ba.infostudio.hcm.dmDocumentLinks;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name="DM_DOCUMENT_LINKS")
public class DmDocumentLinkModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String document_name;
    private String file_name;
    private String file_path;
    private String uri;
    @Lob
    private byte[] document_blob;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;

    public DmDocumentLinkModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public byte[] getDocument_blob() {
        return document_blob;
    }

    public void setDocument_blob(byte[] document_blob) {
        this.document_blob = document_blob;
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

    public DmDocumentLinkModel(String document_name, String file_name, String file_path, String uri, byte[] document_blob, String created_by, Timestamp created_at, String updated_by, Timestamp updated_at) {
        this.document_name = document_name;
        this.file_name = file_name;
        this.file_path = file_path;
        this.uri = uri;
        this.document_blob = document_blob;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }
}