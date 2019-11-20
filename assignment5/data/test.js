
const mongoFunction = require('./db');
mongoFunction();
const universityDao = require('./daos/university.dao.server');
const finderDao = require('./daos/finder.dao.server');
const assert = require('assert');




//universityDao.populateDatabase().then((res) => console.log(res));


//universityDao.truncateDatabase().then((res) => console.log(res));
//finderDao.findAllStudents().then((res) => console.log(res));
//finderDao.findAllAnswers().then((res) => console.log(res));


//finderDao.findAllQuestions().then((res) => console.log(res));

testStudentsInitialCount = () => {
	finderDao.findAllStudents().
	then((students) => {
		assert(students.length === 2, "Student Test Failed");
		console.log("Passed Student Test");
	});
}

testQuestionsInitialCount = () => {
	finderDao.findAllQuestions().
	then((questions) => {
		assert(questions.length === 4, "Question Test Failed");
		console.log("Passed Questions Test");
	});
}

testAnswersInitialCount = () => {
	finderDao.findAllAnswers().
	then((answers) => {
		assert(answers.length === 8, "Answers Test Failed");
		console.log("Passed Answers Test");
	});
}

testDeleteAnswer = () => {
	universityDao.deleteAnswer(890).
	then(() => finderDao.findAllAnswers()).
	then((answers) => {
		assert(answers.length === 7, "Delete Answers Test Failed");
		console.log("Passed Delete Answer Test");
	}).
	then(() => findAnswersByStudent(234)).
	then((bobAnswers) => {
		assert(bobAnswers.length === 3, "Bob Answers Test Failed");
		console.log("Passed Bob Delete Answer Test");
	} );
}

testDeleteQuestion = () => {
	universityDao.deleteQuestion(321).
	then(() => finderDao.findAllQuestions()).
	then((questions) => {
		assert(questions.length === 3, "Delete Question Test Failed");
		console.log("Passed Delete Questions Test");
	});;
}

testDeleteStudent = () => {
	universityDao.deleteStudent(234).
	then(() => finderDao.findAllStudents()).
	then((students) => {
		assert(students.length === 1, "Delete Student Test Failed");
		console.log("Passed Delete Student Test");
	});
}

universityDao.truncateDatabase().
then(() => universityDao.populateDatabase()).
then(() => testStudentsInitialCount()).
then(() => testQuestionsInitialCount()).
then(() => testAnswersInitialCount()).
then(() => testDeleteAnswer()).
then(() => testDeleteQuestion()).
then(() => testDeleteStudent())
