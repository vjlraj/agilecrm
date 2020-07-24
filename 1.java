import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class CompareFilesData
{   
    public static void main(String[] args) throws IOException
    {   
        BufferedReader file1reader1 = new BufferedReader(new FileReader("file1.txt"));
         
        BufferedReader file2reader2 = new BufferedReader(new FileReader("file2.txt"));
         
        String line1 = file1reader1.readLine();
         
        String line2 = file1reader1.readLine();
         
             int lineNum = 1;
         
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
            System.out.println("  No rows ");
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                System.out.println("File1 has "+line1);
            }
             else if( line1.equalsIgnoreCase(line2))
            {
              System.out.println("File1 has "+line1);
            }
             
            line1 = file1reader1.readLine();
             
            line2 = file2reader2.readLine();
             
            lineNum++;
        }
         
       
         
        file1reader1.close();
         
          file2reader2.close();
    }
}
