package com.example.conmancontactmanager;

import android.content.Context;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileIOService implements DataAccessService {

	Context context;
	ObjectMapper om = new ObjectMapper();

	public FileIOService(Context context){this.context = context;}



	@Override
	public boolean writeAllData(BusinessService contactApp, String filename) {

		File path = context.getExternalFilesDir(null);
		File file = new File(path, filename);
		
		try {
			om.writerWithDefaultPrettyPrinter().writeValue(file, contactApp);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public BusinessService readAllData(String filename) {
		File path = context.getExternalFilesDir(null);
		File file = new File(path, filename);
		BusinessService bs = new BusinessService();


		try {
			bs = om.readValue(file, BusinessService.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bs;
	}
	


}
