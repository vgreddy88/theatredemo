DROP TABLE IF EXISTS movie;
   CREATE TABLE movie (
     movieid int NOT NULL,
     name varchar(45) NOT NULL,
     PRIMARY KEY (movieid)
   ) ;

 DROP TABLE IF EXISTS screen;
 CREATE TABLE screen (
   screenid int NOT NULL,
   screennum int NOT NULL,
   capacity int NOT NULL,
   PRIMARY KEY (screenid)
 ) ;

 DROP TABLE IF EXISTS theatre;
    CREATE TABLE theatre (
      theatreid int NOT NULL,
      theatrename varchar(45) NOT NULL,
      city varchar(45) NOT NULL,
      pincode varchar(45) NOT NULL,
      area varchar(45) NOT NULL,
      PRIMARY KEY (theatreid)
    ) ;

     DROP TABLE IF EXISTS shows;
        CREATE TABLE shows (
          showid int NOT NULL,
           theatreid int NOT NULL,
            screenid int NOT NULL,
             movieid int NOT NULL,
          showtimings varchar(45) NOT NULL,
           showdate varchar(45) NOT NULL,
          PRIMARY KEY (showid)
        ) ;
