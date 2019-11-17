package by.academy.it.rest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@ToString(exclude = {"employees"})
@Entity
public class Meeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;
    private String subject;
    @CreationTimestamp
    private LocalDateTime startDate;
    @ManyToMany(mappedBy = "meetings", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Meeting(String subject) {
        this.subject = subject;
    }
}
