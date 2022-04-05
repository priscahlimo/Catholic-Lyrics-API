package dao;

import org.sql2o.Sql2o;

public class DB {

        public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-3-230-122-20.compute-1.amazonaws.com", "wuzfaxmdgxbuwo", "0f64121e86ab0ad43b7abfddbfb88a462e102efb2901aa2791354a99c5a86966");

}
