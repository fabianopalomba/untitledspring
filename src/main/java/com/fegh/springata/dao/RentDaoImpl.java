package com.fegh.springata.dao;

import com.fegh.springata.entity.Car;
import com.fegh.springata.entity.Rent;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class RentDaoImpl extends AbstractDao<Rent,Integer> implements RentDao{
    @Override
    public List<Rent> rentByEmail(String email) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> query = builder.createQuery(Rent.class);
        return this.entityManager.createQuery(query.where(builder.equal(query.from(Rent.class).get("email"),email))).getResultList();

    }

    @Override
    public void Inserisci(Rent entity) {
        super.Inserisci(entity);
    }
}
