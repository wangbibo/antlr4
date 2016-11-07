/* This file is generated by TestGenerator, any edits will be overwritten by the next generation. */
package org.antlr.v4.test.runtime.cpp;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SuppressWarnings("unused")
public class TestVisitors extends BaseCppTest {

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testBasic() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(231);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : INT INT\n");
		grammarBuilder.append("  | ID\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1 2";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a 1 2)\n" +
			"[ '1', '2' ]\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testLR() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(246);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("	: r=e ;\n");
		grammarBuilder.append("e : e op='*' e\n");
		grammarBuilder.append("	| e op='+' e\n");
		grammarBuilder.append("	| INT\n");
		grammarBuilder.append("	;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1+2*3";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(e (e 1) + (e (e 2) * (e 3)))\n" +
			"1,,2,,32 3 21 2 1\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testLRWithLabels() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(286);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=e ;\n");
		grammarBuilder.append("e : e '(' eList ')' # Call\n");
		grammarBuilder.append("  | INT             # Int\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("eList : e (',' e)* ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1(2,3)";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(e (e 1) ( (eList (e 2) , (e 3)) ))\n" +
			"1,,2,,3,1 [13 6]\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testRuleGetters_1() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(273);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : b b		// forces list\n");
		grammarBuilder.append("  | b		// a list still\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("b : ID | INT;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1 2";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a (b 1) (b 2))\n" +
			",1 2 1\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testRuleGetters_2() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(273);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : b b		// forces list\n");
		grammarBuilder.append("  | b		// a list still\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("b : ID | INT;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="abc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a (b abc))\n" +
			"abc\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testTokenGetters_1() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(231);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : INT INT\n");
		grammarBuilder.append("  | ID\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="1 2";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a 1 2)\n" +
			",1 2 [1, 2]\n", found);
		assertNull(this.stderrDuringParse);

	}

	/* This file and method are generated by TestGenerator, any edits will be overwritten by the next generation. */
	@Test
	@Ignore("true")
	public void testTokenGetters_2() throws Exception {
		mkdir(tmpdir);

		StringBuilder grammarBuilder = new StringBuilder(231);
		grammarBuilder.append("grammar T;\n");
		grammarBuilder.append("@parser::header {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("@parser::members {\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("\n");
		grammarBuilder.append("s\n");
		grammarBuilder.append("@after {\n");
		grammarBuilder.append("std::cout << $ctx.r->toStringTree(this) << std::endl;\n");
		grammarBuilder.append("}\n");
		grammarBuilder.append("  : r=a ;\n");
		grammarBuilder.append("a : INT INT\n");
		grammarBuilder.append("  | ID\n");
		grammarBuilder.append("  ;\n");
		grammarBuilder.append("MULT: '*' ;\n");
		grammarBuilder.append("ADD : '+' ;\n");
		grammarBuilder.append("INT : [0-9]+ ;\n");
		grammarBuilder.append("ID  : [a-z]+ ;\n");
		grammarBuilder.append("WS : [ \\t\\n]+ -> skip ;");
		String grammar = grammarBuilder.toString();


		String input ="abc";
		String found = execParser("T.g4", grammar, "TParser", "TLexer", "TListener", "TVisitor", "s", input, false);

		assertEquals(
			"(a abc)\n" +
			"[@0,0:2='abc',<4>,1:0]\n", found);
		assertNull(this.stderrDuringParse);

	}


}
