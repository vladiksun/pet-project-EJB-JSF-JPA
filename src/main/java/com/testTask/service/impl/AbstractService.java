package com.testTask.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for service implementations.
 * 
 * @author Vladislav Bondarchuk
 * 
 */
public abstract class AbstractService {

	@PersistenceContext(unitName = "hbm")
	protected EntityManager em;

	protected Logger logger = LoggerFactory.getLogger(getClass());

        
}
