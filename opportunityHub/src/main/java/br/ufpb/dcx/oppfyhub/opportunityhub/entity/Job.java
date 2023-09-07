package br.ufpb.dcx.oppfyhub.opportunityhub.entity;

import br.ufpb.dcx.oppfyhub.opportunityhub.enums.TypeJob;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    Integer numberVacancies;
    Integer hoursWeek;
    Double scholarshipValue;
    @CreationTimestamp
    LocalDate registrationData;
    LocalDate openingDate;
    String benefits;
    String titleJob;
    String pdfLink;
    LocalDate closingDate;
    @ManyToOne(fetch = FetchType.EAGER)
    User userCreator;
    @ManyToMany(fetch = FetchType.EAGER)
    List<User> interestedUsers;
    @Enumerated(EnumType.STRING)
    TypeJob typeJob;
    String nameProject;
    String linkJob;

    public Job(Integer numberVacancies,
               Integer hoursWeek,
               Double scholarshipValue,
               LocalDate openingDate,
               String benefits,
               String titleJob,
               String pdfLink,
               LocalDate closingDate,
               User userCreator,
               TypeJob typeJob,
               String nameProject,
               String linkJob) {
        this.numberVacancies = numberVacancies;
        this.hoursWeek = hoursWeek;
        this.scholarshipValue = scholarshipValue;
        this.openingDate = openingDate;
        this.benefits = benefits;
        this.titleJob = titleJob;
        this.pdfLink = pdfLink;
        this.closingDate = closingDate;
        this.userCreator = userCreator;
        this.typeJob = typeJob;
        this.nameProject = nameProject;
        this.linkJob = linkJob;
        this.interestedUsers = new ArrayList<>();
    }

    public boolean userInterested(User user) {
        return this.interestedUsers.contains(user);
    }

    public void addUserInterested(User user) {
        this.interestedUsers.add(user);
    }

    public void removeUserInterested(User user) {
        this.interestedUsers.remove(user);
    }
}
