DELIMITER ;;
CREATE DEFINER=`navyasaiporanki`@`%` PROCEDURE `getUnansweredQuestions`()
BEGIN
    select count(text) as questionCount, text, m.moduleName from 
(select count(text) as questionCount, text, module from question q join answer a 
on q.id = a.questionId where correctAnswer = 0 group by questionId) as questionList
join module m on
m.moduleId = module
group by module having Max(questionCount);
END 