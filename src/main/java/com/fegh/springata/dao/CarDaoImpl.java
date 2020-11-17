package com.fegh.springata.dao;

import com.fegh.springata.entity.Car;
import com.fegh.springata.entity.Rent;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao<Car, Integer> implements CarDao{
    @Override
    public List<Car> SelCarsByDate(Date dateinit, Date datefini) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Rent.class);
        criteria.add(Restrictions.and(Restrictions.le("initDate",dateinit),Restrictions.ge("finDate",dateinit)));
        criteria.setProjection(Projections.distinct(Projections.property("car")));
        Criteria criteria1 = session.createCriteria(Rent.class);
        criteria1.add(Restrictions.and(Restrictions.le("initDate",datefini),Restrictions.ge("finDate",datefini)));
        criteria1.setProjection(Projections.distinct(Projections.property("car")));
        List<Car> list1 = criteria.list();
        list1.addAll(criteria1.list());
        List<Car> list2 = session.createCriteria(Rent.class).setProjection(Projections.distinct(Projections.property("car"))).list();
        list2.removeAll(list1);
        System.out.println(list2);
        session.close();
        return list2;
    }

    @Override
    public List<Car> SelCarsByBrand(String brand) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = builder.createQuery(Car.class);
        return this.entityManager.createQuery(query.where(builder.equal(query.from(Car.class).get("brand"),brand))).getResultList();
    }

    @Override
    public List<Car> GetEvery() {
        return super.GetEvery();
    }

    @Override
    public Car SelById(Integer integer) {
        return super.SelById(integer);
    }
}
