package org.cpputest.plugin;

import org.cpputest.codeGenerator.CompactCppCodeFormater;
import org.cpputest.codeGenerator.CppStubber;
import org.cpputest.codeGenerator.CppUTestCodeGenerator;
import org.cpputest.parser.CppSourceCodeReader;
import org.cpputest.plugin.actions.CppUTestEclipsePlatform;
import org.eclipse.ui.IWorkbenchWindow;

public class CppUTestFactory {
	static public CppUTestActionRunner createCppUTestCodeGeneratorActions(IWorkbenchWindow window) {
		CppSourceCodeReader reader = new CppSourceCodeReader();
		CppStubber stubber = new CppStubber();
		CppUTestEclipsePlatform platform = new CppUTestEclipsePlatform(window);
		CppUTestCodeGenerator codeGenerator = new CppUTestCodeGenerator(reader, stubber);
		CompactCppCodeFormater formater = new CompactCppCodeFormater();
		return new CppUTestActionRunner(new CppUTestActions(platform, codeGenerator, formater));
	}

}