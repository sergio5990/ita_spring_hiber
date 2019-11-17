package by.academy.it.rest.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@ToString(exclude = {"employees"})
@Entity
public class EmployeeDetail implements Serializable {
    @Id @GenericGenerator(name = "one-one",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "employee"))
    @GeneratedValue(generator = "one-one")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Employee employee;
}
