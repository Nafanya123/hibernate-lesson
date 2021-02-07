package com.example.demo.configs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class SessionProvider {

    private static final ThreadLocal<Session> SESSION_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Session> PUBLIC_SESSION_THREAD_LOCAL = new ThreadLocal<>();

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    public static void closeSession() {
        closeTenantSession();
        closePublicSession();
    }

    public static void closePublicSession() {
        Session session = PUBLIC_SESSION_THREAD_LOCAL.get();
        if (session != null) {
            session.close();
            PUBLIC_SESSION_THREAD_LOCAL.remove();
        }
    }

    private static void closeTenantSession() {
        Session session = SESSION_THREAD_LOCAL.get();
        if (session != null) {
            session.close();
            SESSION_THREAD_LOCAL.remove();
        }
    }

    public Session getPublicSession() {
        Session session = PUBLIC_SESSION_THREAD_LOCAL.get();
        if (session == null) {
            session = entityManagerFactory.unwrap(SessionFactory.class)
                    .withOptions()
                    .connectionHandlingMode(PhysicalConnectionHandlingMode.IMMEDIATE_ACQUISITION_AND_HOLD)
                    .openSession();
            PUBLIC_SESSION_THREAD_LOCAL.set(session);
        }
        return session;
    }
}
