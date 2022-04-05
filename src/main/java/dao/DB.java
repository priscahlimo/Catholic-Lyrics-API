package dao;

import org.sql2o.Sql2o;

public class DB {

        public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-52-73-155-171.compute-1.amazonaws.com", "adflnffstgxosc", "dea8c6b82f62fc967f9cdadb1cc74a7a877398bf489ff4f736d194f77db8bbe5");

}
