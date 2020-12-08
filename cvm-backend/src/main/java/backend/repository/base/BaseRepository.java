package backend.repository.base;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

public class BaseRepository<T> {

    @Inject
    protected Connection connection;

    private static EntityManagerFactory EM_FACTORY;
    protected EntityManager em;
    private Class<T> persistentClass;

    public EntityManager getEntityManager() {
        this.closeConnectionHibernate();

        if (EM_FACTORY == null) {
            EM_FACTORY = Persistence.createEntityManagerFactory("primary");
        }

        return EM_FACTORY.createEntityManager();
    }


    private void closeConnectionHibernate() {
        if (EM_FACTORY != null) {
            EM_FACTORY.close();
            EM_FACTORY = null;
        }
    }


    @SuppressWarnings("unchecked")
    protected void init() {
        this.em = this.getEntityManager();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        persistentClass = (Class<T>) pt.getActualTypeArguments()[0];
    }


    protected boolean inserir(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return true;
    }


    protected boolean atualizar(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return true;
    }


    protected boolean remover(int id) {
        em.getTransaction().begin();
        T t = (T) this.em.getReference(this.persistentClass, id);
        em.remove(t);
        em.getTransaction().commit();
        return true;
    }


    protected T consultarPorId(Integer id) {
        return this.em.find(this.persistentClass, id);
    }


    @SuppressWarnings("unchecked")
    protected T consultar(String sql) {
        Query query = this.em.createQuery(sql);
        List<T> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }


    @SuppressWarnings("unchecked")
    protected List<T> pesquisar(String sql) {
        Query query = this.em.createQuery(sql);
        return query.getResultList();
    }

}
