package com.momo.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.momo.domain.TaskDo;
@EnableTransactionManagement
@Repository
@Component
@Qualifier("taskDao")
public class TaskDao{
	private EntityManager em=null;
    /**
     * Sets the entity manager. 
     * Inject em via @PersistentContext is called container-manage
     * Create em via EntityManagerFactory called application-manage
     * @default context type is TRANSACTION (another is EXTENDED) 
     */
    @PersistenceContext(type=javax.persistence.PersistenceContextType.TRANSACTION)
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	public List<TaskDo> getAllTasks() {
		return em.createQuery("Select t from TaskDo t").getResultList();
	}

	@Transactional
	public void addTask(TaskDo task) {
		//em.getTransaction().begin();
		em.persist(task);
		//em.getTransaction().commit();
	}

	@Transactional
	public void changeStatus(int taskId, String taskStatus) {
		//em.getTransaction().begin();
		TaskDo task= em.find(TaskDo.class,taskId);
		task.setTaskStatus(taskStatus);
		em.merge(task);
		//em.getTransaction().commit();
	}

	@Transactional
	public void archive(int[] taskIds) {
		em.getTransaction().begin();
		for (int taskId: taskIds){
			TaskDo task= em.find(TaskDo.class,taskId);
			em.remove(task);
		}
		em.getTransaction().commit();
	}
}
