package org.chpl.etl;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App
{

    private static final String csvRawFileName = "./src/main/resources/chpl-raw.csv";
    private static final String csvChecksummedFileName = "./src/main/resources/chpl-wChecksum.csv";
    private static final String defaultPluginsDir = "./src/main/resources/plugins";
    
    private static final int minColumns = 271;
    
    public static void main( String[] args ) {

    	String singleFile;
    	String pluginsDir;
    	
        if (args.length > 0) {
        	
        	if (args[0].equals("fix-chars")){
        		
        		if (args.length > 1){
                    singleFile = args[1];
                    pluginsDir = args[2];
                    runFixCharsETL(singleFile, pluginsDir);
        		} else {
        			runFixCharsETL();
        		}
        		
        	} else {
                singleFile = args[0];
                pluginsDir = args[1];
                runNormalETL(singleFile, pluginsDir);
        	}
        } else {
        	runNormalETL();
        }
    	
    }
    
    public static void runNormalETL(){
    	
    	String singleFile = "./src/main/resources/chpl-large.xlsx";
        convertFile(singleFile);
        parseFile(defaultPluginsDir);
    }
    
    public static void runNormalETL(String singleFile, String pluginsDir){
    	
        convertFile(singleFile);
        parseFile(pluginsDir);
    }
    
    
    public static void runFixCharsETL(){
    	
     	String singleFile = "./src/main/resources/chpl-large.txt";
     	runFixCharsETL(singleFile, defaultPluginsDir);
     	
    }
    
    
    public static void runFixCharsETL(String singleFile, String pluginsDir){
    	
    	convertFileFixChars(singleFile);
        parseFile(pluginsDir);
    }
    
    public static void convertFile(String filename) {
        ExcelConverter excelConverter = new ExcelConverter(filename, csvRawFileName, minColumns);
        excelConverter.convert();
        excelConverter.setCsvHash(csvChecksummedFileName);
        excelConverter.calculateHash();
    }
    
    public static void convertFileFixChars(String filename) {
    	TxtFileProcessor fileProcessor = new TxtFileProcessor(filename);
        fileProcessor.setCsvHash(csvChecksummedFileName);
        fileProcessor.calculateHash();
    }

    public static void parseFile(String pluginsDir) {
        EtlGraph etlGraph = null;
        try {
            etlGraph = new EtlGraph(pluginsDir);
        } catch (URISyntaxException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }

        etlGraph.setGraph("/graphs/openchpl_etl.grf");
        etlGraph.execute();
        
    }
}
