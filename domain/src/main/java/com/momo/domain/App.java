package com.momo.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	private static final String PERSISTENCE_UNIT_NAME = "product";
	private static EntityManagerFactory factory;
	private static EntityManager em;

	public static void main(String[] args) {
		initEntityManager();
		testCreateProduct();
		testGetAllProducts();
		closeEntityManager();
	}
	private static void initEntityManager() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }
	

    private static void closeEntityManager() {
        em.close();
        factory.close();
    }
	private static void testCreateProduct() {
		em.getTransaction().begin();
		ProductDo product = new ProductDo();
		product.setProductName("JPA 2.1 Book");
		product.setProductDescription("This is the latest book on JPA 2.1");
		product.setStockQty(100.00);
		product.setPrice(95.99);
		em.persist(product);
		em.getTransaction().commit();
	}

	private static void testGetAllProducts() {
		List<ProductDo> list = em.createQuery("Select p from ProductDo p")
				.getResultList();
		for (ProductDo p : list) {
			System.out.println(p);
		}
	}
}
