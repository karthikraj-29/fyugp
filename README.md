# Managing User Roles and Permissions in Spring Boot

## Introduction
In modern applications, managing user roles and permissions is crucial for maintaining security and access control. In an **Education Management System**, we need to differentiate between **students** and **staff**, with staff having multiple roles like **Teacher, HOD, Principal**, etc.

In this blog, we will explore how to implement **Role-Based Access Control (RBAC)** in a Spring Boot application. We'll design a structured database model and integrate **Spring Security** for authentication and authorization.

---

## Understanding Role-Based Access Control (RBAC)
RBAC is a method of restricting access based on roles assigned to users. Each role has specific permissions that define what actions a user can perform.

### **Key Components:**
- **Users** (e.g., students, staff)
- **Roles** (e.g., Student, Teacher, HOD, Admin)
- **Permissions** (e.g., View Courses, Edit Courses, Manage Users)
- **Staff Type** (e.g., Teacher, HOD, Principal) – Separate from system roles

Our goal is to:
- Assign **students** the role of "STUDENT"
- Assign **staff** different roles based on their **Staff Type** (e.g., "TEACHER", "ADMIN")
- Define **permissions** for each role
- Use **Spring Security** to enforce access control

---

## **Database Schema Design**
### **1. User Entity** (Base class for all users)
```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
```

### **2. Student Entity**
```java
@Entity
public class Student extends User {
    @Column(nullable = false, unique = true)
    private String registrationNumber;
    private String firstName;
    private String lastName;
}
```

### **3. Staff Profile (Basic Staff Information)**
```java
@Entity
public class StaffProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String staffId;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "staff_type_id")
    private StaffType staffType;
}
```

### **4. Staff Type (Defines Staff Roles)**
```java
@Entity
public class StaffType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String typeName; // e.g., "Teacher", "HOD", "Principal"
}
```

### **5. Role and Permission Management**
#### **Role Entity**
```java
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roleName;
}
```

#### **Permission Entity**
```java
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String permissionName;
}
```

---

## **Spring Security Configuration**
### **Defining Role-Based Access in SecurityConfig**
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/teacher/**").hasRole("TEACHER")
                .requestMatchers("/hod/**").hasRole("HOD")
                .requestMatchers("/student/**").hasRole("STUDENT")
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .logout()
            .permitAll();

        return http.build();
    }
}
```

---

## **Assigning Staff Type and Roles in Service Class**
```java
@Service
public class StaffService {
    private final StaffProfileRepository staffProfileRepository;
    private final StaffTypeRepository staffTypeRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public StaffService(StaffProfileRepository staffProfileRepository, StaffTypeRepository staffTypeRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.staffProfileRepository = staffProfileRepository;
        this.staffTypeRepository = staffTypeRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public StaffProfile registerStaff(String username, String email, String password, String staffId, Long staffTypeId) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        StaffType staffType = staffTypeRepository.findById(staffTypeId).orElseThrow();
        Role staffRole = roleRepository.findByRoleName(staffType.getTypeName().toUpperCase()).orElseThrow();
        user.setRoles(Set.of(staffRole));
        userRepository.save(user);

        StaffProfile staff = new StaffProfile();
        staff.setStaffId(staffId);
        staff.setUser(user);
        staff.setStaffType(staffType);
        staffProfileRepository.save(staff);

        return staff;
    }
}
```

---

## **Conclusion**
By implementing **RBAC** in our education management system, we ensure:
✅ **Separation of Concerns** – Staff Profile and Staff Type are distinct.  
✅ **Security** – Only authorized users can access certain functionalities.  
✅ **Scalability** – Easily add new roles and permissions.  

This setup ensures a **flexible, secure, and maintainable** user management system in Spring Boot. 🚀 Let me know if you have any questions!

