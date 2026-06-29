package org.enorm.lts.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.generator.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(LtsInjectorProvider)
class GenerationTest {
    @Inject extension CompilationTestHelper

    @Test def void miniModelGeneratesJava() {
        '''
            process Mini {
              load employee from csv "employees.csv" header true columns { id: int }
              save employee to csv "out.csv" header true
              save log to "out.log"
            }
        '''.compile [
            assertTrue(allGeneratedResources.exists[it.endsWith("MiniProcess.java")])
        ]
    }
}
