package inst.conditionals;

import inst.assignments.Term;
import elements.LexicalParser;

public class ConditionParser {
	
	public ConditionParser(){
		
	}
	private final static Condition[] conditions = {new Less(), new LessEq(), new Equal(), new NotEqual()};
	
	public static Condition parse(String t1, String op, String t2, LexicalParser parser){
		Condition tm;
		for (Condition t : conditions) {
			tm = t.parse(t1, op, t2, parser);
			if (tm != null)
				return tm;
		}
		return null;
	}
		
	}


