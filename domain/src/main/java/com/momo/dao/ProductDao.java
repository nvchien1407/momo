package com.momo.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.momo.domain.ProductDo;
@Repository
@Component
@Qualifier("productDao")
public class ProductDao{
	private EntityManager em=null;
    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	public List<ProductDo> getAllProducts() {
		return em.createQuery("Select p from ProductDo p").getResultList();
	}
	
}
