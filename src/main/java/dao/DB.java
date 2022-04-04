package dao;

import org.sql2o.Sql2o;

public class DB {

        public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-52-73-155-171.compute-1.amazonaws.com", "dkecmhiasjboxr", "ba42acde677a488b468cd5b1cddbbbfdb5b2171051d460bf7a87cc75d28e5a87");

}
