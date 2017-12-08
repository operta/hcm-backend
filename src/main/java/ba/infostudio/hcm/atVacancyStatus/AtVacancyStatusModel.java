package ba.infostudio.hcm.atVacancyStatus;

import ba.infostudio.hcm.atVacancies.AtVacancyModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "AT_VACANCIES_STATUSES")
public class AtVacancyStatusModel {
    @Id
    @SequenceGenerator(name="OID", sequenceName="OID", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="OID")
    private Long id;
    private String status;

    @OneToMany(mappedBy = "status")
    @JsonBackReference
    private Collection<AtVacancyModel> vacancies;

    public AtVacancyStatusModel() {
    }

    public AtVacancyStatusModel(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
