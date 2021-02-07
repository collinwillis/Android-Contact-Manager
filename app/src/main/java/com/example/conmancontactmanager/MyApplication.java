package com.example.conmancontactmanager;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

     Context context;

     public BusinessService businessService = new BusinessService();

     public BusinessService getBusinessService(){
          return businessService;
     }

     public void setBusinessService(BusinessService businessService)
     {
          this.businessService = businessService;
     }
}
