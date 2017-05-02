package dima;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    private double input;
    private double result;
    private String status;

    public void setStatus(String status) {

        this.status = status;
    }

    public void setResult(double result) {

        this.result = result;
    }

    public void setInput(double input) {

        this.input = input;
    }

    public double getInput() {
        return input;
    }

    public double getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public HomePage(final PageParameters parameters) {

        Form<?> form = new Form("form");
        final TextField<Double> inputValue = new TextField<Double>("inputField", new Model<Double>());
        inputValue.setType(Double.class);
        final TextField<Double> outputValue = new TextField<Double>("answer", new Model<Double>());
        inputValue.setType(Double.class);
        final TextField<String> errorInfo = new TextField<String>("error", new Model<String>());
        inputValue.setType(Double.class);
        setResult(0.0);
        setStatus("plus");

        form.add(new Button("calculate") {
            public void onSubmit() {
                setInput(inputValue.getModelObject());
                Calculation.calculation(HomePage.this, errorInfo, outputValue);
                inputValue.setModelObject(0.0);
            }
        });
        form.add(new Button("plus") {
            public void onSubmit() {
                setInput(inputValue.getModelObject());
                Calculation.calculation(HomePage.this, errorInfo, outputValue);
                setStatus("plus");
                condition(outputValue, inputValue);
            }
        });
        form.add(new Button("minus") {
            public void onSubmit() {
                setInput(inputValue.getModelObject());
                Calculation.calculation(HomePage.this, errorInfo, outputValue);
                setStatus("minus");
                condition(outputValue, inputValue);
            }
        });
        form.add(new Button("divide") {
            public void onSubmit() {
                setInput(inputValue.getModelObject());
                Calculation.calculation(HomePage.this, errorInfo, outputValue);
                setStatus("divide");
                condition(outputValue, inputValue);
            }
        });
        form.add(new Button("multiply") {
            public void onSubmit() {
                setInput(inputValue.getModelObject());
                Calculation.calculation(HomePage.this, errorInfo, outputValue);
                setStatus("multiply");
                condition(outputValue, inputValue);
            }
        });
        form.add(new Button("clear") {
            public void onSubmit() {
                setAllZero(inputValue, outputValue, errorInfo);
            }
        });
        form.add(inputValue);
        form.add(outputValue);
        form.add(errorInfo);
        add(form);
    }

    private void setAllZero(TextField<Double> inputValue, TextField<Double> outputValue, TextField<String> errorInfo) {
        inputValue.setModelObject(0.0);
        outputValue.setModelObject(0.0);
        errorInfo.setModelObject("");
        setStatus("plus");
        setResult(0.0);
    }

    private void condition(TextField<Double> outputValue, TextField<Double> inputValue) {
        try {
            if (result == 0) {
                setResult(input);
                outputValue.setModelObject(result);
                inputValue.setModelObject(0.0);
            } else if (result != 0) {
                setResult(result);
                outputValue.setModelObject(result);
                inputValue.setModelObject(0.0);
            }
        } catch (Exception e) {
            LOG.error("condition ERROR: " + e.getMessage());
        }

    }
}
