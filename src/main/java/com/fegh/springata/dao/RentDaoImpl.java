package com.fegh.springata.dao;

import com.fegh.springata.entity.Rent;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class RentDaoImpl extends AbstractDao<Rent,Integer> implements RentDao{
    @Override
    public void Insert(Rent entity) {
        super.Insert(entity);
    }
}
