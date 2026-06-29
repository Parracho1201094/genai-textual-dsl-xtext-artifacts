package org.enorm.lts.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.enorm.lts.lts.LtsPackage
import org.enorm.lts.lts.Process
import org.enorm.lts.validation.LtsValidator
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(LtsInjectorProvider)
class ValidationTest {
    @Inject extension ParseHelper<Process>
    @Inject extension ValidationTestHelper

    @Test def void duplicateTableIsRejected() {
        val model = '''
            process Bad {
              load employee from csv "a.csv" header true columns { id: int }
              create employee columns { id: int }
            }
        '''.parse
        model.assertError(LtsPackage.eINSTANCE.tableProducingStatement, LtsValidator.DUPLICATE_TABLE)
    }

    @Test def void invalidCsvExtensionIsRejected() {
        val model = '''
            process Bad {
              load employee from csv "a.txt" header true columns { id: int }
            }
        '''.parse
        model.assertError(LtsPackage.eINSTANCE.csvSource, LtsValidator.INVALID_CSV)
    }
}
