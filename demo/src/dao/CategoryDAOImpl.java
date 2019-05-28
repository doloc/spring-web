package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.CategoryInfo;

public class CategoryDAOImpl implements CategoryDAO {

	public static CategoryDAOImpl instant = new CategoryDAOImpl();

	@Override
	public List<CategoryInfo> getAllCategory() {
		Session currentSession = getSessionFactory().getCurrentSession();
		List<CategoryInfo> result = null;
		try {
			currentSession.beginTransaction();
			Criteria cr = currentSession.createCriteria(CategoryInfo.class);
			result = cr.list();
			// session.save(st);
			// session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			currentSession.close();
		}

		return result;
	}

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(CategoryInfo.class).buildSessionFactory();
		return sessionFactory;
	}

}
