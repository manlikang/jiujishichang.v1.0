package com.fuhan.account.dto;

public interface ResultCode {
    Integer SUCCESS = 200;
    Integer USERBASECODE=1000;





    Integer USERISEXIST =USERBASECODE+1;
    Integer PHONEISEXIST=USERBASECODE+2;
    Integer PASSWORDERROR =USERBASECODE+3 ;
    Integer ACCOUNTNOTEXIST = USERBASECODE+4;
}
