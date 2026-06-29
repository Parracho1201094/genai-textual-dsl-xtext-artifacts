package org.enorm.lts.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.enorm.lts.lts.Process
import org.enorm.lts.lts.Statement
import org.enorm.lts.lts.TableProducingStatement

/**
 * Minimal custom scope: table references only see tables declared earlier in the same process.
 * Column references are parsed as IDs and validated semantically.
 */
class LtsScopeProvider extends AbstractLtsScopeProvider {

    override IScope getScope(EObject context, EReference reference) {
        if (reference.EReferenceType.name == 'TableProducingStatement') {
            val process = context.containerOfType(Process)
            val currentStatement = context.containerOfType(Statement)
            if (process !== null && currentStatement !== null) {
                val visible = newArrayList
                for (s : process.statements) {
                    if (s === currentStatement) return Scopes.scopeFor(visible)
                    if (s instanceof TableProducingStatement) visible.add(s)
                }
                return Scopes.scopeFor(visible)
            }
        }
        super.getScope(context, reference)
    }

    private def <T> T containerOfType(EObject object, Class<T> type) {
        var cur = object
        while (cur !== null) {
            if (type.isInstance(cur)) return type.cast(cur)
            cur = cur.eContainer
        }
        null
    }
}
