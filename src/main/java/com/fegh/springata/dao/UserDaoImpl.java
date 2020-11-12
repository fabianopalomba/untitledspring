package com.fegh.springata.dao;

import com.fegh.springata.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

    @Override
    public User userByEmail(String email) {
        User user;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> queryDefinition = cb.createQuery(User.class);

        Root<User> recordset = queryDefinition.from(User.class);

        queryDefinition.select(recordset).
                where(cb.equal(recordset.get("email"), email));

        user = entityManager.createQuery(queryDefinition).getSingleResult();

        entityManager.clear();

        return user;
    }


    @Override
    public boolean validate(String userName, String password) {
        User user;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> queryDefinition = cb.createQuery(User.class);

        Root<User> recordset = queryDefinition.from(User.class);

        queryDefinition.select(recordset).
                where(cb.equal(recordset.get("email"), userName));

        user = entityManager.createQuery(queryDefinition).getSingleResult();

        if (user != null && user.getPassword().equals(password)) {
            entityManager.clear();
            return true;
        }
        entityManager.clear();
        return false;
    }

    @Override
    public void Inserisci(User user) {
        super.Inserisci(user);
    }

    @Override
    public void Aggiorna(User user) {
        super.Aggiorna(user);
    }

    @Override
    public void Elimina(User entity) {
        super.Elimina(entity);
    }

    @Override
    public void eliminaByEmail(String email) {
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

}
