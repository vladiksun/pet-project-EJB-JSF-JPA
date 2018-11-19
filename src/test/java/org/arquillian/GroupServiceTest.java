package org.arquillian;

import com.testTask.entity.Groups;
import com.testTask.service.TableService;
import com.testTask.service.impl.AbstractService;
import com.testTask.utils.TestDataGenerator;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GroupServiceTest {
    @Inject
    private TableService tableService;
    
    @PersistenceContext
    EntityManager em;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Groups.class.getPackage())
                .addPackage(AbstractService.class.getPackage())
                .addPackage(TableService.class.getPackage())
                .addPackage(TestDataGenerator.class.getPackage())
                .addClass(TestDataGenerator.class)
                .addAsManifestResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }

    @Test
    public void testIsDeployed() {
        Assert.assertNotNull(tableService);
    }

   
}
