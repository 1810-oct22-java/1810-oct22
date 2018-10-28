import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revature.questionfifteen.QuestionFifteenTest;
import com.revature.questionfour.QuestionFourTest;
import com.revature.questionsix.QuestionSixTest;
import com.revature.questionsixteen.QuestionSixteenTest;
import com.revature.questionthree.QuestionThreeTest;

import junit.framework.Test;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	QuestionThreeTest.class,
	QuestionFifteenTest.class,
	QuestionFourTest.class,
	QuestionSixTest.class,
	QuestionSixteenTest.class,
	
})
public class AllTests {

}
