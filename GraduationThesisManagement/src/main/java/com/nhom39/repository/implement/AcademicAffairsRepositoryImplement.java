package com.nhom39.repository.implement;

import com.nhom39.constants.SystemConstant;
import com.nhom39.pojo.AcademicAffairs;
import com.nhom39.pojo.User;
import com.nhom39.repository.AcademicAffairsRepository;
import com.nhom39.repository.RoleRepository;
import com.nhom39.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class AcademicAffairsRepositoryImplement implements AcademicAffairsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean checkUniqueAcademicAffairsEmail(String manageEmail) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        String sql = "SELECT COUNT(id) FROM Manage WHERE email=:email";
        Query query = session.createQuery(sql);
        query.setParameter("email", manageEmail.trim());

        return (long)query.getSingleResult() > 0;
    }

    @Override
    public boolean checkUniqueAcademicAffairsPhone(String managePhone) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        String sql = "SELECT COUNT(id) FROM Manage WHERE phone=:phone";
        Query query = session.createQuery(sql);
        query.setParameter("phone", managePhone.trim());

        return (long)query.getSingleResult() > 0;
    }

    @Override
    public List<AcademicAffairs> getAcademicAffairs(Map<String, String> params) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AcademicAffairs> query = builder.createQuery(AcademicAffairs.class);
        Root<AcademicAffairs> manageRoot = query.from(AcademicAffairs.class);
        Root<User> userRoot = query.from(User.class);
        query.select(manageRoot);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(manageRoot.get("user"), userRoot.get("id")));

        if (params.containsKey("kw") && !params.get("kw").isEmpty()) {
            String kw = params.get("kw");

            Predicate predicate1 = builder.like(manageRoot.get("fullName").as(String.class), String.format("%%%s%%", kw));
            Predicate predicate2 = builder.like(manageRoot.get("email").as(String.class), String.format("%%%s%%", kw));
            Predicate predicate3 = builder.like(manageRoot.get("phone").as(String.class), String.format("%%%s%%", kw));
            Predicate predicate4 = builder.like(userRoot.get("username").as(String.class), String.format("%%%s%%", kw));

            predicates.add(builder.or(predicate1, predicate2, predicate3, predicate4));
        }

        if (params.containsKey("active") && !params.get("active").isEmpty()) {
            boolean active = Boolean.parseBoolean(params.get("active"));

            predicates.add(builder.equal(userRoot.get("active").as(Boolean.class), active));
        }

        query.where(predicates.toArray(new Predicate[]{}));
        query.orderBy(builder.desc(manageRoot.get("id")));

        Query q = session.createQuery(query);

        int page = 1;
        int pageSize = SystemConstant.PAGE_SIZE;
        if (params.containsKey("page") && !params.get("page").isEmpty()) page = Integer.parseInt(params.get("page"));

        int startPage = (page - 1) * pageSize;
        q.setMaxResults(pageSize);
        q.setFirstResult(startPage);

        return q.getResultList();
    }

    @Override
    public long countAcademicAffairs(Map<String, String> params) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<AcademicAffairs> manageRoot = query.from(AcademicAffairs.class);
        Root<User> userRoot = query.from(User.class);
        query.multiselect(builder.count(manageRoot.get("id")));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(manageRoot.get("user"), userRoot.get("id")));

        if (params.containsKey("kw") && !params.get("kw").isEmpty()) {
            String kw = params.get("kw");

            Predicate predicate1 = builder.like(manageRoot.get("fullName").as(String.class), String.format("%%%s%%", kw));
            Predicate predicate2 = builder.like(manageRoot.get("email").as(String.class), String.format("%%%s%%", kw));
            Predicate predicate3 = builder.like(manageRoot.get("phone").as(String.class), String.format("%%%s%%", kw));
            Predicate predicate4 = builder.like(userRoot.get("username").as(String.class), String.format("%%%s%%", kw));

            predicates.add(builder.or(predicate1, predicate2, predicate3, predicate4));
        }

        if (params.containsKey("active") && !params.get("active").isEmpty()) {
            boolean active = Boolean.parseBoolean(params.get("active"));

            predicates.add(builder.equal(userRoot.get("active").as(Boolean.class), active));
        }

        query.where(predicates.toArray(new Predicate[]{}));

        Query q = session.createQuery(query);
        Object result = q.getSingleResult();

        return (long) result;
    }

    @Override
    public boolean addAcademicAffairs(AcademicAffairs manage) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            User user = manage.getUser();
            if (this.userRepository.addUser(user)) {
                user.setRole(this.roleRepository.getRoleByRoleName("ADMIN"));
                session.update(user);
                session.save(manage);
            }
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public AcademicAffairs getAcademicAffairsById(int manageId) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<AcademicAffairs> query = builder.createQuery(AcademicAffairs.class);
            Root<AcademicAffairs> root = query.from(AcademicAffairs.class);
            query.select(root);
            query.where(builder.equal(root.get("id").as(Integer.class), manageId));
            return session.createQuery(query).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAcademicAffairs(int manageId, AcademicAffairs manage) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        try {
            AcademicAffairs objManage = session.get(AcademicAffairs.class, manageId);
            objManage.setFullName(manage.getFullName());
            objManage.setEmail(manage.getEmail());
            objManage.setPhone(manage.getPhone());

            User objUser = session.get(User.class, objManage.getUser().getId());
            objUser.setUsername(manage.getUser().getUsername());
            if (manage.getUser().getAvatar() != null)
                objUser.setAvatar(manage.getUser().getAvatar());
            objUser.setActive(manage.getUser().getActive());

            session.update(objUser);
            session.update(objManage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAcademicAffairs(int manageId) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        try {
            AcademicAffairs objManage = session.get(AcademicAffairs.class, manageId);
            User objUser = session.get(User.class, objManage.getUser().getId());

            session.delete(objManage);
            session.delete(objUser);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
