DELIMITER ;;
CREATE DEFINER=`navyasaiporanki`@`%` PROCEDURE `endorsedUsersForWeek`(in start_date date, in end_date date )
BEGIN
select answerList.user_id, first_name,email, last_name,total_count from
(select u.id as user_id, first_name ,email, last_name,count(*) as total_count from answer a
join user u on u.id =  a.postedBy
join person p on p.id =u.id
where correctAnswer = 1
and postedOn between start_date and end_date
group by postedBy
order by total_count desc) as answerList
order by first_name desc
Limit 5;
END ;;
DELIMITER ;