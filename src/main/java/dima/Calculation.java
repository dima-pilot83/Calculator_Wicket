package dima;

import org.apache.wicket.markup.html.form.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dima on 30.04.17.
 */
public class Calculation {

    private static final Logger LOG = LoggerFactory.getLogger(Calculation.class);

    protected static void calculation(HomePage components, TextField<String> errorInfo, TextField<Double> outputValue) {
        try {
            if (components.getStatus().equals("plus"))
                components.setResult(Action.add(components.getResult(), components.getInput()));
            if (components.getStatus().equals("minus"))
                components.setResult(Action.sub(components.getResult(), components.getInput()));
            if (components.getStatus().equals("multiply"))
                components.setResult(Action.mul(components.getResult(), components.getInput()));
            if (components.getStatus().equals("divide"))
                components.setResult(Action.div(components.getResult(), components.getInput()));
        } catch (IllegalArgumentException ex) {
            errorInfo.setModelObject("Error, division by zero! ");
            LOG.error("division by zero ERROR: " + ex.getMessage());
        } catch (Exception e) {
            LOG.error("ERROR: " + e.getMessage());
        }
        outputValue.setModelObject(components.getResult());
    }
}
