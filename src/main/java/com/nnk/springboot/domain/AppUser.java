package com.nnk.springboot.domain;

import com.nnk.springboot.utils.ErrorMessageConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = ErrorMessageConstants.USER_NAME_IS_NULL_OR_BLANK)
    private String username;
    @NotBlank(message = ErrorMessageConstants.PASSWORD_IS_NULL_OR_BLANK)
    private String password;
    @NotBlank(message = ErrorMessageConstants.FULL_NAME_IS_NULL_OR_BLANK)
    private String fullname;
    @NotBlank(message = ErrorMessageConstants.ROLE_NAME_IS_NULL_OR_BLANK)
    private String role;

}
