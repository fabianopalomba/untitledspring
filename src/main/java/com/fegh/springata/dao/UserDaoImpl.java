package com.fegh.springata.dao;

import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

    @Override
    public User userByEmail(String email) {
        User user = new User("","","","","");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> queryDefinition = cb.createQuery(User.class);

        Root<User> recordset = queryDefinition.from(User.class);

        queryDefinition.select(recordset).
                where(cb.equal(recordset.get("email"), email));
        try {
            user = entityManager.createQuery(queryDefinition).getSingleResult();
        }
        catch (NoResultException e){

        }

        entityManager.clear();

        return user;
    }


    @Override
    public boolean validate(String email, String password) {
        User user = userByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            entityManager.clear();
            return true;
        }
        entityManager.clear();
        return false;
    }

    @Override
    public void Insert(User user) {
        super.Insert(user);
    }

    @Override
    public void Update(User user) {
        super.Update(user);
    }

    @Override
    public void Delete(User entity) {
        super.Delete(entity);
    }

    @Override
    public void DeleteByEmail(String email) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<User> query = builder.createCriteriaDelete(User.class);

        entityManager.createQuery(
                query.where(
                        builder.equal(
                                query.from(User.class)
                                        .get("email"), email)
                )).executeUpdate();
        entityManager.flush();
        entityManager.clear();
    }
    @Override
    public List<Rent> rentByEmail(String email) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> query = builder.createQuery(Rent.class);
        return this.entityManager.createQuery(query.where(builder.equal(query.from(Rent.class).get("user"),userByEmail(email)))).getResultList();

    }


}
