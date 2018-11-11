package org.netbeans.validation.api.builtin.stringvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 * Validates Spanish phone numbers (9 digits).
 * Be careful, this validator is not fully implemented so not every possible combination is valid in a real-case scenario.
 * @author Alejandro Martínez Remis
 */
public class SpanishPhoneNumberValidator extends StringValidator{

    @Override
    public void validate(Problems prblms, String string, String t) {
        Pattern pattern = Pattern.compile("[0-9]{9}");
        Matcher matcher = pattern.matcher(t);
        if(!matcher.find())
            addProblem(prblms, string);
        else{
            if(matcher.start() != 0 || matcher.end() != t.length())
                addProblem(prblms, string);
        }
    }
 
    private void addProblem(Problems problems, String componentName){
        problems.add(NbBundle.getMessage(getClass(), "MAY_BE_SPANISH_NUMBER", componentName));
    }
}
