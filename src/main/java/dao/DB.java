package dao;

import org.sql2o.Sql2o;

public class DB {

        public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-3-224-125-117.compute-1.amazonaws.com", "kcqsakoerchzvc", "4f2e567b9a112224eda9ae3025fefb8053087ab5f823d9e5e5dbeb91ff0840f9");

}
