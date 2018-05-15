import java.io.IOException;
import java.io.RandomAccessFile;

public class hashquery {



    // initialize
    public static void main(String args[])
    {
        
        hashquery query = new hashquery();
        // calculate query time
        long startTime = System.currentTimeMillis();
        
        query.readArguments(args);
        long endTime = System.currentTimeMillis();

        System.out.println("Query time: " + (endTime - startTime) + "ms");
    }


    // reading command line arguments
    public  void readArguments(String args[])
    {
        if (args.length == 2)
        {
            readHash(args[0]);

        }
        else
        {
            System.out.println("Error: only pass in two arguments");
        }
    }

    public  void readHash(String x){



        try{
            RandomAccessFile raf = new RandomAccessFile("test.txt", "r");

            int bucket = (x.hashCode() & 0xfffffff) % 4000000;
            byte BUCKET_SIZE = (byte) 300;
            int offset = bucket * BUCKET_SIZE;


            //if (BN_NAME.toLowerCase().contains(input.toLowerCase()))
            //{
            //  System.out.println(BN_NAME);
            //}

	

            raf.seek(offset);
            System.out.println(raf.read());



        }catch(IOException ex){

        }






    }


}
