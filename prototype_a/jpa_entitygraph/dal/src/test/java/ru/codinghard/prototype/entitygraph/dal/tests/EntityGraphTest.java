package ru.codinghard.prototype.entitygraph.dal.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.codinghard.prototype.entitygraph.dal.ModuleConfiguration;
import ru.codinghard.prototype.entitygraph.dal.dao.ChildDao;
import ru.codinghard.prototype.entitygraph.dal.dao.ParentDao;
import ru.codinghard.prototype.entitygraph.dal.model.Child;
import ru.codinghard.prototype.entitygraph.dal.model.Parent;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ModuleConfiguration.class)
@Component
@Ignore
public class EntityGraphTest {

    @Autowired
    ParentDao parentDao;
    @Autowired
    ChildDao childDao;

    @Before
    @Commit
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void init() {
        List<Parent> p = parentDao.findAll();
        Parent pr = null;
        if (p.size() == 0) {
            pr = parentDao.save(new Parent("parent"));
        } else pr = p.get(0);
        if (pr.getChildren().size() == 0) {
            Child c = new Child();
            c.setName("child");
            c.setParent(pr);
            childDao.save(c);
        }
    }

    @Commit
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Test
    public void getChildrenN1() {
        parentDao.findAll().get(0).getChildren();
    }

}
