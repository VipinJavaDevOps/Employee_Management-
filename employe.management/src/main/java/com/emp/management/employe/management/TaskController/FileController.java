package com.emp.management.employe.management.TaskController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	// Uploading a file 
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String filePath=System.getProperty("user.dir")+"/Uploads" + File.separator + file.getOriginalFilename();
		String fileUploadStatus;
		try {
			//Creating an Object of FileOutputStream class
			FileOutputStream fout = new FileOutputStream(filePath);
			fout.write(file.getBytes());
			//Closing the Connection
			fout.close();
			fileUploadStatus ="File Uploaded Successfully";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fileUploadStatus="Error in Uploading File...";
		}
		return fileUploadStatus;
		
	}
	
	//Getting the List of filenames that have been Uploaded 
	@RequestMapping(value="/getfiles",method=RequestMethod.GET)
	public String []getFiles(){
		String folderPath=System.getProperty("user.dir") + "/Uploads";
		//creating a new File Instance
		File directory=new File(folderPath);
		//list method return an array of string 
		//naming the files and directories
		//in the directory denoted by this abstract pathname
		String[]filenames=directory.list();
		return filenames;
	}
	
	
	//Downloading a File 
	@RequestMapping(value="/download/{path:.+}",method=RequestMethod.GET)
	public ResponseEntity downloadFile(@PathVariable("path") String filename)throws FileNotFoundException{
		//checking whether the file requested for download exists or not
		String fileUploadpath=System.getProperty("user.dir")+"/Uploads";
		String[]filenames=this.getFiles();
		boolean contains=Arrays.asList(filenames).contains(filenames);
		if(!contains) {
			return new ResponseEntity("File Not Found",HttpStatus.NOT_FOUND);
		}
		
		//setting up the filepath
		String filePath=fileUploadpath+File.separator+filename;
		
		// Creating New file instance
		File file=new File(filePath);
		//creating a new InputStreamResource object
		InputStreamResource resource=new InputStreamResource(new FileInputStream(file));
		//Creating a new instance of HttpHeaders Object
		HttpHeaders headers=new HttpHeaders();
		//Setting up value for contentType and Headervalue
		String contentType="aplication/octet-stream";
		String headerValue="attachment;filename=\""+resource.getFilename()+"\"";
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
				.body(resource);
		
		
	}
	

}
