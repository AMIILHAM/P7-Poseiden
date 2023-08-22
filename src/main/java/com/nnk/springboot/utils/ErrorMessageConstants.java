package com.nnk.springboot.utils;

public class ErrorMessageConstants {

    private ErrorMessageConstants(){}

    //========== User Entity =============//
    public static final String USER_NAME_IS_NULL_OR_BLANK = "Username should not be null or blank";
    public static final String PASSWORD_IS_NULL_OR_BLANK = "Username should not be null or blank";
    public static final String FULL_NAME_IS_NULL_OR_BLANK = "Username should not be null or blank";
    public static final String ROLE_NAME_IS_NULL_OR_BLANK = "Username should not be null or blank";

    public static final String UsernameNotFoundExceptionMessage = "Username or password incorrect";
    public static final String UserNotFoundExceptionMessage = "User id not found";
    public static final String UsernameAlreadyExist = "Username already exist in database";

    //========== CurvePoint Entity =============//

    public static final String CurvePointIdNotFound = "CurvePoint is not found";

}
