package Operation2;

import domain.Student;
import domain2.AcadmicDetails;
import domain2.AddressDetails;
import domain2.StudentDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    static Configuration cfg;
    static Scanner sc=new Scanner(System.in);
    static SessionFactory factory;
    static Session ses;
    static Transaction tx;
    static
    {
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(StudentDetails.class);
        cfg.addAnnotatedClass(AddressDetails.class);
        cfg.addAnnotatedClass(AcadmicDetails.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

    }
    public static void main(String[] args)
    {


        boolean status=true;
        int c=0;
         while (status){
             System.out.println("select your choice\n1.Add Student\n2.Display One Record\n3.Display All Record\n4.Delete One Record\n5.Delete All Record\n6.Exit");
             String choice=sc.next();
             while (!(choice.equals("1")|| (choice.equals("2") || (choice.equals("3") || (choice.equals("4") ||(choice.equals("5") || (choice.equals("6"))))))))
             {
                 System.out.println("Please Enter Correct input");
                 choice=sc.next();

             }
             switch (choice)
             {
                 case "1":{
                     addStudent();
                 }break;
                 case "2":{
                     displayOneRecord();
                 }break;
                 case "3":{
                     displayAllRecord();
                 }break;
                 case "4":{
                     deleteOneRecord();
                 }break;
                 case "5":{
                     deleteAllRecord();
                 }break;
                 case "6":{
                     status=false;
                 }break;
             }
             
         }

    }

    private static void deleteOneRecord()
    {
        System.out.println("Enter the id:");
        int id=sc.nextInt();
        StudentDetails s1=ses.get(StudentDetails.class,id);
        tx=ses.beginTransaction();
        ses.delete(s1);
        tx.commit();
    }

    private static void deleteAllRecord()
    {


    }

    private static void displayAllRecord()
    {
        Criteria crt=ses.createCriteria(StudentDetails.class);
        List<StudentDetails> data= crt.list();

        for (StudentDetails s1: data)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("STUDENT ID"+s1.getId());
            System.out.println("STUDENT NAME"+s1.getsName());
            System.out.println("EMAIL ID"+s1.getEmail());
            System.out.println("ACADMIC ID"+s1.getAcadmicRef().getAcdId());
            System.out.println("10th PER"+s1.getAcadmicRef().getTeenthPer());
            System.out.println("12th PER"+s1.getAcadmicRef().getTwelevePer());
            System.out.println("DEGREE PER:"+s1.getAcadmicRef().getDegreePer());
            System.out.println("STREAM:"+s1.getAcadmicRef().getStream());
            System.out.println("ADDRESS ID:"+s1.getAcadmicRef().getAddressRef().getAddId());
            System.out.println("CITY:"+s1.getAcadmicRef().getAddressRef().getCity());
            System.out.println("STATE:"+s1.getAcadmicRef().getAddressRef().getState());
            System.out.println("COUNTRY:"+s1.getAcadmicRef().getAddressRef().getCountry());
            System.out.println("------------------------------------------------");


        }
    }

    private static void displayOneRecord()
    {
        System.out.println("ENTER STUDENT ID:");
        int studentId= sc.nextInt();
        StudentDetails s1=ses.get(StudentDetails.class,studentId);
        System.out.println("-----------------------------------------------");
        System.out.println("STUDENT ID"+s1.getId());
        System.out.println("STUDENT NAME"+s1.getsName());
        System.out.println("EMAIL ID"+s1.getEmail());
        System.out.println("ACADMIC ID"+s1.getAcadmicRef().getAcdId());
        System.out.println("10th PER"+s1.getAcadmicRef().getTeenthPer());
        System.out.println("12th PER"+s1.getAcadmicRef().getTwelevePer());
        System.out.println("DEGREE PER:"+s1.getAcadmicRef().getDegreePer());
        System.out.println("STREAM:"+s1.getAcadmicRef().getStream());
        System.out.println("ADDRESS ID:"+s1.getAcadmicRef().getAddressRef().getAddId());
        System.out.println("CITY:"+s1.getAcadmicRef().getAddressRef().getCity());
        System.out.println("STATE:"+s1.getAcadmicRef().getAddressRef().getState());
        System.out.println("COUNTRY:"+s1.getAcadmicRef().getAddressRef().getCountry());
        System.out.println("------------------------------------------------");

    }

    private static void addStudent()
    {
        System.out.println("Enter Student Name:");
        String sName=sc.next();
        System.out.println("Enter Student Email:");
        String emailId= sc.next();
        System.out.println("Enter 10th Percentage:");
        double teenthPer= sc.nextDouble();
        System.out.println("Enter 12th Percetage:");
        double twelevePer= sc.nextDouble();
        System.out.println("enter student stream");
        String stream=sc.next();
        System.out.println("Enter Degree Percentage:");
        double degreePer= sc.nextDouble();

        System.out.println("enter student city");
        String city=sc.next();
        System.out.println("enter student state");
        String state=sc.next();
        System.out.println("enter student country");
        String country=sc.next();


        StudentDetails st=new StudentDetails();
        st.setsName(sName);
        st.setEmail(emailId);

        AcadmicDetails ac=new AcadmicDetails();
        ac.setTeenthPer(teenthPer);
        ac.setTwelevePer(twelevePer);
        ac.setDegreePer(degreePer);
        ac.setStream(stream);

        AddressDetails ad=new AddressDetails();
        ad.setCity(city);
        ad.setState(state);
        ad.setCountry(country);

        st.setAcadmicRef(ac);
        ac.setAddressRef(ad);

        tx=ses.beginTransaction();
        ses.save(st);
        tx.commit();
        System.out.println("Record inserted sucesfully!!!");


    }
}
