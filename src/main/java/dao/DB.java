package dao;

import org.sql2o.Sql2o;

public class DB {

        public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-52-54-212-232.compute-1.amazonaws.com", "jxttyafuhwfjzo", "fe01ad6a945c7ba61e410351b7d559fba8af17440f69591b3cd65d495f57f20e");

}
