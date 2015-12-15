package org.chpl.etl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;

public class TxtFileProcessor {

	private File csvFile;
	private File csvHashFile;
	private String delimiter = "^";

	public TxtFileProcessor() {
	}

	public TxtFileProcessor(String csvName) {
		csvFile = new File(csvName);		
	}
	
	public void calculateHash() {
		FileInputStream fIn = null;
		FileOutputStream fOut = null;
		BufferedReader bIn = null;
		BufferedWriter bOut = null;
		String line, hash;
		
		try {
			fIn = new FileInputStream(csvFile);
			fOut = new FileOutputStream(csvHashFile);
			bIn = new BufferedReader(new InputStreamReader(fIn, "UTF8"));
			bOut = new BufferedWriter(new OutputStreamWriter(fOut, "UTF8"));
			
			line = bIn.readLine();
			while (line != null) {
				hash = hashString(line);
				bOut.write(line);
				bOut.write(delimiter);
				bOut.write(hash);
				bOut.newLine();
				line = bIn.readLine();
			}
		} catch (IOException e) {
			Logger.getLogger(TxtFileProcessor.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				bIn.close();
				bOut.close();
				fIn.close();
				fOut.close();
			} catch (IOException e) {
				Logger.getLogger(TxtFileProcessor.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
	
	private String hashString(String l) {
		return(DigestUtils.sha1Hex(l));
	}
	
	public void setCsv(String csvName) {
		csvFile = new File(csvName);
	}
	
	public void setCsvHash(String csvHashName) {
		csvHashFile = new File(csvHashName);
	}
	
	public void setDelimeter(String delimeter) {
		this.delimiter = delimeter;
	}
	
	public String getDelimeter() {
		return this.delimiter;
	}
}
