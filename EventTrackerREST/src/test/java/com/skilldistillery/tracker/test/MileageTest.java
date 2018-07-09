package com.skilldistillery.tracker.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.tracker.data.MileageDAO;
import com.skilldistillery.tracker.data.MileageDAOImpl;
import com.skilldistillery.tracker.entities.Mileage;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MileageTest {
	
	private static MileageDAO mileageDAO;
	private static EntityManagerFactory emf;
	
	@PersistenceContext
	private EntityManager em;
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("trackerdb");
		mileageDAO = new MileageDAOImpl();

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		em.close();
	}
	
	@AfterAll
	public static void tearAllDown() throws Exception{
		emf.close();
		
	}
	
	@Test
	public void test_list_return() {
		assertEquals(3, mileageDAO.getMileageRecords().size());
	}

	

}
