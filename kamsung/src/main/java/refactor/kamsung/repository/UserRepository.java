package refactor.kamsung.repository;

import org.springframework.stereotype.Repository;
import refactor.kamsung.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {  // 코사인유사도 계산할때 사용
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByName(String nickname) {
        return em.createQuery("select m from User m where m.nickname = :nickname",
                        User.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

}