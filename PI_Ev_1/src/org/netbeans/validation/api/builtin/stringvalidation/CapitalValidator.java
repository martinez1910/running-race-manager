package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 * Validates that the given string is capitalized.
 * @author Alejandro Martínez Remis
 */
public class CapitalValidator extends StringValidator{

    @Override
    public void validate(Problems prblms, String string, String t) {
        if(!t.equals("") && !Character.isUpperCase(t.charAt(0)))
            prblms.add(NbBundle.getMessage(getClass(), "MAY_BE_CAPITALIZED", string));
    }
    
}
