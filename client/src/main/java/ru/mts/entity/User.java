package ru.mts.entity;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

//import javax.persistence.*;


//@Entity
//@Table(name = "User")
@Data
//@ToString
@Builder
public class User {
    //    @Id
//    @GeneratedValue
//    @Column(name = "Id", nullable = false)
    private long id;
    //    @Column(name = "name", nullable = false)
    private String name;
    //    @Column(name = "phone", nullable = false)
    private String phone;
    //    @Column(name = "email", nullable = false)
    private String email;

}