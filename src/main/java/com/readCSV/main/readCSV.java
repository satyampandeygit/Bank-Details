package com.readCSV.main;

import com.readCSV.Util.HibernateUtil;
import com.readCSV.model.TableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class readCSV {
    public static void main(String[] args) {
        File file = new File("/Users/satyampandey/Desktop/repos/readCSV/bank_branches.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int i=0;

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            while((st=br.readLine()) != null){

                System.out.println(st);

                if(i<5){
                    i++;
                    continue;
                }

                String[] fieldsValues = st.split(",");
                System.out.println("IFSC Code: " + fieldsValues[0]);
                int indexFromLast = fieldsValues.length-1;

                TableModel newBankDetails = new TableModel();
                
                newBankDetails.setIfsc_code(fieldsValues[0]);

                Integer bank_id = Integer.parseInt(fieldsValues[1]);
                System.out.println(fieldsValues[1]);
                newBankDetails.setBank_id(bank_id);

                newBankDetails.setBranch(fieldsValues[2]);

                String address = "";

                int index =3;
                while(index<indexFromLast-3){
                    address = address + fieldsValues[index];
                    if(index!=indexFromLast-4){
                        address += ",";
                    }
                    index++;
                }
                newBankDetails.setAddress(address);
                System.out.println("Address: "+address);

                newBankDetails.setCity(fieldsValues[indexFromLast-3]);
                System.out.println("City: " + fieldsValues[indexFromLast-3]);

                newBankDetails.setDistrict(fieldsValues[indexFromLast-2]);
                System.out.println( "District:" + fieldsValues[indexFromLast-2]);

                newBankDetails.setState(fieldsValues[indexFromLast-1]);
                System.out.println("State: " + fieldsValues[indexFromLast-1]);

                newBankDetails.setBank_name(fieldsValues[indexFromLast]);
                System.out.println( "Bank Name: " + fieldsValues[indexFromLast]);

                session.save(newBankDetails);
                i++;
            }

            session.getTransaction().commit();
            System.out.println("Transaction Done.");

            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
