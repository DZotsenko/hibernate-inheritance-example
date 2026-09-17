package core.basesyntax.dao.ma;

import core.basesyntax.model.ma.Coach;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CoachDaoImpl extends PersonDaoImpl implements CoachDao {
    public CoachDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Coach> findByExperienceGreaterThan(int years) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Coach> query = cb.createQuery(Coach.class);
            Root<Coach> coachRoot = query.from(Coach.class);
            Predicate experiencePredicate = cb.greaterThan(coachRoot.get("experience"), years);
            query.where(experiencePredicate);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't find coach with experience greater than "
                    + years + " years", e);
        }
    }
}
