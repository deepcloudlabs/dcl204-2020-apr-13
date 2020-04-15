package com.example.banking;

import com.example.banking.domain.AccountStatus;

public class StudyEnum {
    public static void main(String[] args) {
        for (AccountStatus as : AccountStatus.values()){
            System.out.println(as.getCode()+" : "+as.name());
        }
    }
}
