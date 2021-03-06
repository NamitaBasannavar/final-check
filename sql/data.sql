-- Include table data insertion, updation, deletion and select scripts

-- ------------------------------------------------------------------
-- - Ading Movie List to  Movie Cruiser Table
--  ------------------------------------------------------------------


insert into movie_list
values
(1, 'Avatar', 2787965087, 'Yes', '2017-03-15', 'Science Fiction','Yes'),
(2, 'The Avengers', 1518812988, 'Yes','2017/12/23', 'Superhero','No'),
(3, 'Titanic', 2187463944, 'Yes', '2017-08-21', 'Romance', 'No'),
(4, 'Jurassic World', 1671713208, 'No', '2017-07-02','Science Fiction', 'Yes'),
(5, 'Avatar', 2750760348, 'Yes','2022-11-02', 'Superhero', 'Yes');

select * from movie_list;
---------------------------------------------------------------------
-- Displaying  Movie List
---------------------------------------------------------------------
select  me_id AS "Id" ,me_title AS "Title",  me_boxOffice AS "boxOffice", me_active  AS "active" ,me_date_of_launch As "date_of_launch" , me_genre AS  "genre" ,  me_hasteaser  AS  "hasteaser"  from movie_list;


-------------------------------------------------------------------
-- updateing movie list in movie_list table
-------------------------------------------------------------------

update movie_list
set me_title='Kgf'
where me_id=1;


-- ---------------------------------------------------------
-- Displaying updated Movie list in Movie Cruiser Table
-- -----------------------------------------------------------------

select  me_id AS "Id" ,me_title AS "Title",  me_boxOffice AS "boxOffice", me_active  AS "active" ,me_date_of_launch As "date_of_launch" , me_genre AS  "genre" ,  me_hasteaser  AS  "hasteaser"  from movie_list;

--------------------------------------------------------------
-- creating User
-------------------------------------------------------------
insert into user values(1,'Namita'),
(2,'Hradini');

select  us_id AS "Id", us_name AS "Name" from user;

select * from user;

--------------------------------------------------------------
-- Displaying customer List
-- ----------------------------------------------------------
select me_title,me_boxOffice,me_genre,me_hasteaser
from movie_list
where me_active='Yes' 
and me_date_of_launch <= current_date();

-- ---------------------------------------------------------
-- Add to Favorite
-- -----------------------------------------------------------------
insert into favorite (ft_us_id,ft_pr_id) values(2,1),(2,2);

 select * from favorite;
-- delete from favorite;
-- ---------------------------------------------------------
-- Show Favorite
-- -----------------------------------------------------------------
select  ft_id As "Id", ft_us_id As "us_id" ,ft_pr_id AS "pr_id" from favorite;


- ---------------------------------------------------------
-- View Favorite 
-- -----------------------------------------------------------------
select me_title,me_boxOffice, me_genre
from movie_list
inner join favorite
on ft_pr_id=me_id
where ft_us_id=2; 

-- -----------------------------------------------------------
-- Show Total
--------------------------------------------------------------
select count(me_boxOffice)
 as Total
 from movie_list
inner join favorite
 on ft_pr_id=me_id
where ft_us_id=2;

---------------------------------------------------------------
-- Display Favorite
-----------------------------------------------------------------
select ft_id As "Id", ft_us_id As "us_id" ,ft_pr_id AS "pr_id" from favorite;

- ---------------------------------------------------------
-- Remove from favorite
-- -----------------------------------------------------------------

delete from favorite where ft_us_id=2 and ft_pr_id=2 limit 1; 


- ---------------------------------------------------------
-- Display favorite
-- -----------------------------------------------------------------
select ft_id As "Id", ft_us_id As "us_id" ,ft_pr_id AS "pr_id" from favorite;


-- ---------------------------------------------------------
-- To View Favorite after deleting
-- -----------------------------------------------------------------

select me_title,me_boxOffice, me_genre
from movie_list
inner join favorite
on ft_pr_id=me_id
where ft_us_id=2; 

------------------------------------------------------------------- 
-- Show Total
------------------------------------------------------------------
select count(me_boxOffice) 
as Total
from movie_list
inner join favorite 
on ft_pr_id=me_id
where ft_us_id=2; 

 

