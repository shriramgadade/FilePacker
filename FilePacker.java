import java.util.*;
import java.io.*;
public class FilePacker
{
    public static void main(String Arg[])throws Exception
    {
        System.out.println("----------------------------Project-------------------------------");
        System.out.println("-----------------Marvellous Packer And UnPacker-------------------");
        System.out.println("-------------------------Shriram Gadade---------------------------");

        Scanner sobj = new Scanner(System.in);
        boolean bret = false;

        System.out.println("Enter The Name Of Directory which contains all files that you want to pack : --");
        String DirectoryName = sobj.nextLine();

        System.out.println("Enter The Name of packed file that you want to create");
        String PackedFile = sobj.nextLine();

        File fobjpack = new File(PackedFile);

        bret = fobjpack.createNewFile();
        if(bret==false)
        {
            System.out.println("Unable to create file:--");
            return;

        }
        System.out.println("Packed file gets succesfully create that current directory");

        File fobj = new File(DirectoryName);
        bret=fobj.isDirectory();
        if(bret==true)
        {
            File Arr[] =fobj.listFiles();
            System.out.println("Number OF files in the directory are:--"+Arr.length);

            String Header = null;

            //to write the data into packedfile
            FileOutputStream fcombine = new FileOutputStream(PackedFile);

            int iRet = 0;
            byte Buffer[] = new byte[1024]; // dout******

            System.out.println("Packing Activity start");
             // Travel Directory
             for(int i =0;i<Arr.length;i++)
             {
                // create header
                Header = Arr[i].getName()+" "+Arr[i].length();

                System.out.println("File Packed With The Name :"+Arr[i].getName());
             

             // Add Extra White Space at the end of header
             for(int j = Header.length();j<100;j++)
             {
                Header = Header+" ";

             }

             // Convert String Header into byte
             byte hArr[] = Header.getBytes();
             
             //Write Header into packed file
             fcombine.write(hArr,0,100);

             // To read the from directory
             FileInputStream fiobj = new FileInputStream(Arr[i]);

             //Write The data into file after header
             while((iRet = fiobj.read(Buffer)) != -1)
             {
                fcombine.write(Buffer,0,iRet);
             }
             fiobj.close();
             }

             System.out.println("Packing Activity completed..");

             System.out.println("Total File Packed succesfully: "+Arr.length);

             System.out.println("-------------Thanks For Use File Packer Activity-----------------");



        }

    }

}