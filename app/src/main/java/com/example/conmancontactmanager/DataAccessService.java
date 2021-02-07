package com.example.conmancontactmanager;

public interface DataAccessService {

	public BusinessService readAllData(String filename);

	boolean writeAllData(BusinessService contactApp, String filename);

}
