package org.enorm.lts.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.enorm.lts.lts.Process
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(LtsInjectorProvider)
class ParsingTest {
    @Inject extension ParseHelper<Process>
    @Inject extension ValidationTestHelper

    @Test def void miniModelParses() {
        val model = '''
            process Mini {
              load employee from csv "employees.csv" header true columns {
                id: int
                name: string
              }
              save employee to csv "out.csv" header true
              save log to "out.log"
            }
        '''.parse
        model.assertNoErrors
    }
}
