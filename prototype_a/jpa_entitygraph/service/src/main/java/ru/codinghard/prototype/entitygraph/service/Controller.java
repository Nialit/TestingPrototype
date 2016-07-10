package ru.codinghard.prototype.entitygraph.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.codinghard.prototype.entitygraph.dal.dao.ChildDao;
import ru.codinghard.prototype.entitygraph.dal.dao.ParentDao;
import ru.codinghard.prototype.entitygraph.dal.model.Child;
import ru.codinghard.prototype.entitygraph.dal.model.Parent;

import java.util.List;

@RestController
@Slf4j
public class Controller {
    @Autowired
    ParentDao parentDao;
    @Autowired
    ChildDao childDao;

    boolean init = false;

    @Transactional(propagation = Propagation.REQUIRED)
    private void init() {
        if (!init) {
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
        init = true;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    public void test() {
//        init();System.out.println(parentDao.findAll().size());
        parentDao.findAll().forEach(p -> p.getChildren().forEach(c -> System.out.println(c)));
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    public void test2() {
//        System.out.println(parentDao.findAllWithChildren().size());
        parentDao.findAllWithChildren().forEach(p -> p.getChildren().forEach(c -> System.out.println(c)));
    }

}
