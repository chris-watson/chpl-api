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

    //private static final String csvRawFileName = "./src/main/resources/chpl-raw.txt";
    private static final String csvChecksummedFileName = "./src/main/resources/chpl-wChecksum.txt";

    public static void main( String[] args ) {
        String singleFile;
        String pluginsDir;
        if (args.length > 0) {
            singleFile = args[0];
            pluginsDir = args[1];
        } else {
            singleFile = "./src/main/resources/chpl-raw.txt";
            pluginsDir = "./src/main/resources/plugins";
        }

        convertFile(singleFile);
        parseFile(singleFile, pluginsDir);
    }

    public static void convertFile(String filename) {
    	TxtFileProcessor fileProcessor = new TxtFileProcessor(filename);
        //excelConverter.convert();
        fileProcessor.setCsvHash(csvChecksummedFileName);
        fileProcessor.calculateHash();
    }

    public static void parseFile(String filename, String pluginsDir) {
        EtlGraph etlGraph = null;
        try {
            etlGraph = new EtlGraph(pluginsDir);
        } catch (URISyntaxException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }

        etlGraph.setGraph("/graphs/openchpl_etl.grf");
        etlGraph.execute();

//        etlGraph.setGraph("/graphs/openchpl_checksum_analysis.grf");
//        etlGraph.execute();
//        etlGraph.setGraph("/graphs/openchpl_insert_vendor_and_product.grf");
//        etlGraph.execute();
//        etlGraph.setGraph("/graphs/openchpl_insert_certified_product.grf");
//        etlGraph.execute();
    }
}
