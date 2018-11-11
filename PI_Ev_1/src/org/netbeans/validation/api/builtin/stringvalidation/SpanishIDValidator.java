package org.netbeans.validation.api.builtin.stringvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 * Validates Spanish IDs. It may follow 'A-0123456-Z' for foreigners and '12345678-A' for nationals (any number and any letter).
 * Be careful, this validator is not fully implemented so not every possible combination is valid in a real-case scenario.
 * @author Alejandro Martínez Remis
 */
public class SpanishIDValidator extends StringValidator{

    @Override
    public void validate(Problems prblms, String string, String t) {
        Pattern pattern = Pattern.compile(" (([X-Z]{1})([-]?)(\\d{7})([-]?)([A-Z]{1}))|((\\d{8})([-]?)([A-Z]{1}))");
        Matcher matcher = pattern.matcher(t);
        if(!matcher.find())
            addProblem(prblms, string);
        else{
            if(matcher.start() != 0 || matcher.end() != t.length())
                addProblem(prblms, string);
        }
    }
    
    private void addProblem(Problems problems, String componentName){
        problems.add(NbBundle.getMessage(getClass(), "MAY_BE_DNI_OR_NIE", componentName));
    }
}
