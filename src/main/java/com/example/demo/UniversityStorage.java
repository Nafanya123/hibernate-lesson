package com.example.demo;

import com.example.demo.configs.SessionProvider;
import com.example.demo.entity.University;
import com.example.demo.repository.UniversityStorageI;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UniversityStorage implements UniversityStorageI {

    @Autowired
    private SessionProvider sessionProvider;

    @Override
    public void insertUniversity(University university) {
        Session session = sessionProvider.getPublicSession();
        session.getTransaction().begin();
        session.save(university);
        session.getTransaction().commit();
    }

    @Override
    public List<University> findAll() {
        Session session = sessionProvider.getPublicSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();;
        CriteriaQuery<University> query = criteriaBuilder.createQuery(University.class);
        Root<University> university = query.from(University.class);
        query.select(university);
        List<University> universityObject = session.createQuery(query).getResultList();
        SessionProvider.closePublicSession();
        return universityObject;
    }

    public void delete(University university) {
        Session session = sessionProvider.getPublicSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();;
        CriteriaDelete<University> query = criteriaBuilder.createCriteriaDelete(University.class);
        Root<University> rootUniversity = query.from(University.class);
        query.where(criteriaBuilder.equal(rootUniversity.get("id"), university.getId()));
        session.getTransaction().begin();
        Query queryDel = session.createQuery(query);
        queryDel.executeUpdate();
        session.getTransaction().commit();
        SessionProvider.closePublicSession();
    }

    @Override
    public University findUniversityById(Integer id) {
        Session session = sessionProvider.getPublicSession();
        NativeQuery<University> nativeQuery = session
                .createNativeQuery("select * from university where id = :id", University.class)
                .setParameter("id", id);
        return nativeQuery.getSingleResult();
    }

}
