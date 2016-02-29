package com.test;

import java.io.*;

/**
 * Created by dynam on 2016/2/27.
 */
public class SerializeTest {

//    public long objectTOLong(Object longObj){
//        return Long
//    }


    public static void main(String[] args) throws Exception {

        testB();
    }

    public static void testB() throws Exception {
        //This is the object we're going to serialize
        Company xxxCompany = new Company();
        xxxCompany.account = "xxxBank";
        xxxCompany.saleVolume = 100;
        xxxCompany.profit = 5000;
        System.out.println("User-definedn\n"
                +"account:"+xxxCompany.account+"\n"
                +"salesVolume:"+xxxCompany.saleVolume+"\n"
                +"profit:"+xxxCompany.profit+"\n");
        //write the serialized data to a file "object.ser"
        FileOutputStream fos = new FileOutputStream("object.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(xxxCompany);
        os.close();

        //read the serialized data back
        FileInputStream fis = new FileInputStream("object.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        //read the object from the data stream , and convert it back to a String
        Company objectFromDisk = (Company) ois.readObject();
        System.out.println("User-definedn\n"
                +"accountFromDisk:"+objectFromDisk.account+"\n"
                +"salesVolumeFromDisk:"+objectFromDisk.saleVolume+"\n"
                +"profitFromDisk:"+objectFromDisk.profit+"\n");
        ois.close();
    }

    private static void testA() throws Exception {
        String account = "xxxBank";
        int salesVolume = 100;
        long profit = 5000;

        FileOutputStream fos = new FileOutputStream("name.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(account);
        os.writeObject(salesVolume);
        os.writeObject(profit);
        os.close();

        FileInputStream fis = new FileInputStream("name.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        String accountFromDisk = (String)ois.readObject();
        int salesVolumeFromDisk = (Integer) ois.readObject();
        long profitFromDisk = (Long) ois.readObject();


        System.out.println("User-definedn\n"
                +"accountFromDisk:"+accountFromDisk+"\n"
                +"salesVolumeFromDisk:"+salesVolumeFromDisk+"\n"
                +"profitFromDisk:"+profitFromDisk+"\n");
        ois.close();
    }

    static class Company implements Serializable{
        public String account;

        public int saleVolume;

        public long profit;

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.account = "xxxBank";
            this.saleVolume = 0;
            this.profit = 0;
        }
    }

}
