package com.ex.dao;



import com.ex.models.Post;
import com.ex.util.ConnectionUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostDao{
    static ConnectionUtil util = ConnectionUtil.getInstance();

    public Post save(Post p){
        Session s = util.getSession();
        try{
            Transaction tx = s.beginTransaction();
            int pID = (int) s.save(p);
            p.setId(pId);
            tx.commit();
        }finally{
            s.close();
        }
    }
}