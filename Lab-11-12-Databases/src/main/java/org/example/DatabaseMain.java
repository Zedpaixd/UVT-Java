/*
*  For this course you will not be forced to use
*  a database that we name. Instead, you are
*  welcome to use any kind of database you
*  desire. Which type of database are you
*  thinking of using?
*   (A) Relational databases (MySQL, PostgreSQL, etc.)
*   + Strong security, versatile and widely used
*   - Less efficient for large data and complex queries have a long runtime
*
*   (B) NoSQL databases (MongoDB, Cassandra)
*   + Highly scalable and good data management
*   - Needs a lot of standardization
*
*   (C) In-memory databases (SQLite, Redis)
*   + Fastest type of database and easiest to implement for prototyping
*   - It's stored locally.
*
*   (D?)  Graph Databases (Neo4J, Amazon Neptune)
*   (E??) Document-Oriented Databases (CouchDB)
*
*/


package org.example;


public class DatabaseMain {

    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        DatabaseSample app = new DatabaseSample();
        app.createNewTable();

        System.out.println("Adding salt...");
        app.insert("Salt", 123.45);
        app.printAllContent();

        System.out.println("Adding water...");
        app.insert("Water", 22);
        app.printAllContent();

        System.out.println("Correcting mistake: Should be Himalayan Salt.");
        app.update(1, "Himalayan Salt", 543.21);
        app.printAllContent();

        System.out.println("Deleting the Himalayan Salt...");
        app.delete(1);
        app.printAllContent();

        System.out.println(RED + "\nResetting the database..." + RESET);
        app.executeCustomQuery("DELETE from Warehouse;");
    }
}