package com.example.demo.appUser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class  AppUser implements UserDetails {
    // Attributes of AppUser
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    private String testColumn;

    // Constructor for class AppUser
    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   AppUserRole appUserRole,
                   String testColumn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
        this.testColumn = testColumn;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        In generic code, the question mark (?), called the wildcard, represents an unknown type.
        The wildcard can be used in a variety of situations: as the type of a parameter, field, or local variable;
        sometimes as a return type

        The Collection in Java is a framework that provides an architecture to store and manipulate the group of objects.
        Java Collections can achieve all the operations that you perform on a data such as
        searching, sorting, insertion, manipulation, and deletion.
        Java Collection means a single unit of objects.
        Java Collection framework provides many interfaces (Set, List, Queue, Deque)
        and classes (ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet).

        GrandAuthority Represents an authority granted to an Authentication object.

        The singleton() method of Java Collections class is used to get an immutable set which contains only the specified object.
         */
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTestColumn() {
        return testColumn;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
