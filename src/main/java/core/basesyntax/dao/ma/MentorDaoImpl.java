package core.basesyntax.dao.ma;

import core.basesyntax.model.ma.Mentor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MentorDaoImpl extends PersonDaoImpl implements MentorDao {
    public MentorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Mentor> findByAgeGreaterThan(int age) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Mentor> query = cb.createQuery(Mentor.class);
            Root<Mentor> mentorRoot = query.from(Mentor.class);
            Predicate agePredicate = cb.greaterThan(mentorRoot.get("age"), age);
            query.where(agePredicate);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't find mentor with age greater than "
                    + age + " years", e);
        }
    }
}
