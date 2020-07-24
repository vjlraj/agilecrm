/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static void main ( String[] args )
    {
       try
        {
            Path readCSV = Paths.get ( "data.csv" );
            Path WriteCSV = Paths.get ( "output.csv" );
            try (
                    final BufferedReader CSVData = Files.newBufferedReader ( readCSV , StandardCharsets.UTF_8 ) ;
                    final CSVPrinter priceData = CSVFormat.RFC4180.withHeader ( "Price"  ).print ( WriteCSV , StandardCharsets.UTF_8 ) ;
            )
            {
                Iterable < CSVDateDetails > details = CSVFormat.RFC4180.withFirstRecordAsHeader ().parse ( CSVData );
                // We expect these headers: ID,name1,name2,name3
                for ( CSVDateDetails record : details )
                {
                    String Price = record.get ( "Price" );
                    System.out.println ( "Price: "+ Price  );
                    priceData.printRecord ( Price );
                }
            }
        } catch ( InvalidPathException e )
        {
            e.printStackTrace ();
        } catch ( IOException e )
        {
            e.printStackTrace ();
        }
    }
}