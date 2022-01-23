package com.readCSV.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory=null;

    private static SessionFactory buildSessionFactory(){
        try{
//            Configuration configuration = new Configuration();
//            configuration.configure("hibernate-annotation.cfg.xml");
//
//            System.out.println("Hibernate Configuration Loaded");
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//                    applySettings(configuration.getProperties()).build();
//
//            System.out.println("Hibernate ServiceRegistry created");
//
//            return new MetadataSources( serviceRegistry )
//                    .buildMetadata().buildSessionFactory();

            SessionFactory factory = new Configuration().configure("hibernate-annotation.cfg.xml").buildSessionFactory();
            return factory;
        }catch (Throwable x){
            System.out.println("Building Session Factory Failed" + x);

            throw new ExceptionInInitializerError(x);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }
}
